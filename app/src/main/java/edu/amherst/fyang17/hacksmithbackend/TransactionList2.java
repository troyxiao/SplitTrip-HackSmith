package edu.amherst.fyang17.hacksmithbackend;
import android.app.Activity;
import android.content.ClipData;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import android.view.View.OnClickListener;


public class TransactionList2 extends ActionBarActivity {
    public final static String EXTRA_MESSAGE = "edu.amherst.fyang17.fyang17.MESSAGE";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transaction_list2);
        final Activity activity = this;

        final MyAdapter2 adapter = new MyAdapter2(this, ImportantFunctions.returnBalance());
        ListView listView = (ListView) findViewById(R.id.listview);
        listView.setAdapter(adapter);
        //Make the lists clickable
        AdapterView.OnItemClickListener mMessageClickedHandler = new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView parent, View v, int position, long id) {
                Intent intent = new Intent(activity,PersonalDues.class);
                String personName = adapter.getItem(position).getName();
                intent.putExtra(EXTRA_MESSAGE,personName);
                startActivity(intent);
            }
        };

        listView.setOnItemClickListener(mMessageClickedHandler);

        //Now commenting out the detail button
        /*Button button1 = (Button) findViewById(R.id.buttonx);
        button1.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(TransactionList2.this, Details.class);
                startActivity(intent);
            }
        });*/

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