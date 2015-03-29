package edu.amherst.fyang17.hacksmithbackend;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;

import java.util.*;


public class MainActivity extends ActionBarActivity {
    public static final String PREFS_NAME = "MyPrefsFile";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Intent intent = getIntent();
        String message = intent.getStringExtra(AddNewGroupActivity.EXTRA_MESSAGE);
        if (message!=null){
            SharedPreferences group = getSharedPreferences(PREFS_NAME,0);
            SharedPreferences.Editor editor = group.edit();
            editor.putString("groupName",message);
            editor.commit();
        }
        SharedPreferences group = getSharedPreferences(PREFS_NAME,0);
        String groupName = group.getString("groupName","You should now create a new group");
        Button myButton = new Button(this);
        myButton.setText(groupName);
        RelativeLayout ll = (RelativeLayout) findViewById(R.id.relative_layout_id);
        RelativeLayout.LayoutParams lp = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
        ll.addView(myButton, lp);
        myButton.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Intent intent = new Intent(MainActivity.this,TransactionList2.class);
                startActivity(intent);
            }
        });
    }

    public void addGroup(View view){
        Intent intent = new Intent(this, AddNewGroupActivity.class);
        startActivity(intent);

    }


    public void addEntry(View view){
        String payees = "Angelina Guan,Hui Xu,Fanhao Yang,Sally Yuen";
        ImportantFunctions.addTransaction("Fanhao Yang",payees,100,"renxing");
    }

    public void showList(View view){
        Intent intent = new Intent(this, TransactionList.class);
        startActivity(intent);
    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
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
