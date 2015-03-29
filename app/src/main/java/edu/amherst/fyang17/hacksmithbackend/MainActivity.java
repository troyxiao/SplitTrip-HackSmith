package edu.amherst.fyang17.hacksmithbackend;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import java.util.*;


public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void makePeople(View view){
        String[] list = {"Hui","Fanhao","Sally","Angelina"};
        ImportantFunctions.buildPersonList(list);
        List<Persons> people = Persons.listAll(Persons.class);
        for (int i=0;i<people.size();i++){
            System.out.println(people.get(i).name);
        }
    }

    public void initializeTable(View view){
        ImportantFunctions.buildRelationTable();
        //List<Persons> a = Persons.find(Persons.class,"name=?","Angelina");
        //List<RelationTable> b = RelationTable.find(RelationTable.class,"p1=?",a.get(0).name);
        //for (int i=0;i<b.size();i++){
        //    System.out.println(b.get(i).p2+" owes "+b.get(i).p1+" "+b.get(i).amount+" dollars");
        //}
    }

    public void addEntry(View view){
        String payees = "Angelina,Hui,Fanhao";
        ImportantFunctions.addTransaction("Hui",payees,15,"food");
    }

    public void showList(View view){
        ImportantFunctions.returnList();
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
