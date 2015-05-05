package edu.amherst.fyang17.hacksmithbackend;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;


public class AddNewDues extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_new_dues);


    }

    public void memberCheckboxing(View view){
        Intent intent = new Intent(this, memberCheckboxingActivity.class);
        startActivity(intent);

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_add_new_dues, menu);
        return true;
    }

    public void returnToList(View view){
        String entry="";
        EditText editText1 = (EditText) findViewById(R.id.title);
        String message1 = editText1.getText().toString();
        EditText editText2 = (EditText) findViewById(R.id.amount);
        String message2 = editText2.getText().toString();
        EditText editText3 = (EditText) findViewById(R.id.payer);
        String message3 = editText3.getText().toString();
        System.out.println(memberCheckboxingActivity.memberList);
        ImportantFunctions.addTransaction(message3,memberCheckboxingActivity.memberList,Float.parseFloat(message2),message1);
        Intent intent = new Intent(this,TransactionList.class);
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
