package edu.amherst.fyang17.hacksmithbackend;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.LinearLayout;

import java.util.List;


public class memberCheckboxingActivity extends ActionBarActivity {
    LinearLayout linearMain;
    CheckBox checkBox;
    boolean[] checked;
    public static String memberList="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_member_checkboxing);
        List<Persons> people = Persons.listAll(Persons.class);
        String[] str = new String[people.size()];
        for (int i=0;i<people.size();i++){
            str[i] = people.get(i).name;
        }
        linearMain = (LinearLayout) findViewById(R.id.linearMain);
          checked = new boolean[str.length];

        memberList = "";

        for(int i = 0; i < str.length; i++){
            checkBox = new CheckBox(this);
            checkBox.setId(i);
            checkBox.setText(str[i]);
            checkBox.setOnClickListener(getOnClickDoSomething(checkBox, str[i]));
            linearMain.addView(checkBox);

        }

    }
    View.OnClickListener getOnClickDoSomething(final Button button,final String p) {
        return new View.OnClickListener() {
            public void onClick(View v) {
                memberList+=p + ",";
            }
        };
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_member_checkboxing, menu);
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
