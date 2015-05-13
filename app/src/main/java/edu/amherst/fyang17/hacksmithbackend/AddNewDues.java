package edu.amherst.fyang17.hacksmithbackend;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;

import java.util.List;


public class AddNewDues extends ActionBarActivity implements AdapterView.OnItemSelectedListener {

    public static List<Persons> people;
    public static boolean[] memberList;
    public static String selectedCurrency;
    public static String payer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_new_dues);
        people = Persons.listAll(Persons.class);
        memberList = new boolean[people.size()];
        //The following creates the spinner for the currency
        Spinner spinner = (Spinner) findViewById(R.id.currency_spinner);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,R.array.currency_list, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);
        //The following creates the spinner for the payer
        Spinner spinner2 = (Spinner) findViewById(R.id.select_payer);
        ArrayAdapter adapter2 = new ArrayAdapter(this,android.R.layout.simple_spinner_item,people);
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner2.setAdapter(adapter2);
        spinner2.setOnItemSelectedListener(this);
    }

    public void memberCheckboxing(View view){

        Intent intent = new Intent(this, memberCheckboxingActivity.class);
        startActivity(intent);
    }



    public void onItemSelected(AdapterView<?> parent, View view,int pos, long id) {
        Spinner spinner = (Spinner) parent;
        //distinguish which spinner is selected
        if(spinner.getId() == R.id.currency_spinner)
        {
            //assign value to  selectedCurrency based on what is selected in the currency spinner
            String currency = parent.getItemAtPosition(pos).toString();
            switch (currency){
                case "US Dollars":
                    selectedCurrency = "USD";
                    break;
                case "Chinese Yuan":
                    selectedCurrency = "CNY";
                    break;
                case "Nuevos Soles":
                    selectedCurrency = "PEN";
                    break;
                default: selectedCurrency = "USD";
            }
        }
        else if(spinner.getId() == R.id.select_payer)
        {
            //assign value to payer based on what is selected in the select payer spinner
            payer = parent.getItemAtPosition(pos).toString();
        }
    }

    public void onNothingSelected(AdapterView<?> parent) {
        //this does nothing
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_add_new_dues, menu);
        return true;
    }

    public void returnToList(View view){
        EditText editText1 = (EditText) findViewById(R.id.title);
        String message1 = editText1.getText().toString();
        EditText editText2 = (EditText) findViewById(R.id.amount);
        String message2 = editText2.getText().toString();
        String listOfPayee = "";
        for (int i=0;i<people.size();i++){
            if (memberList[i]==true){
                if (listOfPayee.equals("")) {
                    listOfPayee = listOfPayee + people.get(i).name;
                }
                else listOfPayee = listOfPayee + "," + people.get(i).name;
            }
        }

        ImportantFunctions.addTransaction(payer,listOfPayee,Float.parseFloat(message2),message1,selectedCurrency);
        memberList = new boolean[people.size()];
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
