package edu.amherst.fyang17.hacksmithbackend;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.Toast;
import android.view.View.OnClickListener;


public class TransactionList2 extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transaction_list2);

        // 1. pass context and data to the custom adapter
        MyAdapter2 adapter = new MyAdapter2(this, ImportantFunctions.returnBalance());

        // 2. Get ListView from activity_main.xml
        ListView listView = (ListView) findViewById(R.id.listview);

        // 3. setListAdapter
        listView.setAdapter(adapter);

        Button button1 = (Button) findViewById(R.id.buttonx);
        button1.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(TransactionList2.this, Details.class);
                startActivity(intent);
            }
        });

    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_transaction_list2, menu);
        return true;
    }

    public void addNewListing(MenuItem menuItem){
        Intent intent = new Intent(this, AddNewDues.class);
        startActivity(intent);
    }

    public void showHist(MenuItem menuItem){
        Intent intent = new Intent(this, TransactionList.class);
        startActivity(intent);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }


        return super.onOptionsItemSelected(item);
    }
}