package edu.amherst.fyang17.hacksmithbackend;

import android.app.ActionBar;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AbsoluteLayout;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Toast;


public class AddNewGroupActivity extends ActionBarActivity {
    public final static String EXTRA_MESSAGE="com.example.sally_000.mybudgapplication";
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_new_group);
    }

    public void returnToMain(View view){
        EditText editText1 = (EditText) findViewById(R.id.group);
        String message1 = editText1.getText().toString();
        Intent intent = new Intent(this,MainActivity.class);
        intent.putExtra(EXTRA_MESSAGE,message1);
        EditText editText2 = (EditText) findViewById(R.id.name);
        String message2 = editText2.getText().toString();
        String[] people = message2.split(",");
        ImportantFunctions.buildPersonList(people);
        EditText editText3 = (EditText) findViewById(R.id.description);
        String message3 = editText3.getText().toString();

        //finish();
        ImportantFunctions.buildRelationTable();
        startActivity(intent);

        //Intent intent = new Intent(this, MainActivity.class);
       // intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
       // startActivity(intent);
    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_add_new_group, menu);
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
