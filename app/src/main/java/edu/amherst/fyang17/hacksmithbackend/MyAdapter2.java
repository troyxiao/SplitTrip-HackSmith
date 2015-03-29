package edu.amherst.fyang17.hacksmithbackend;

import java.util.ArrayList;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

public class MyAdapter2 extends ArrayAdapter<Items2> {

    private final Context context;
    private final ArrayList<Items2> itemsArrayList;

    public MyAdapter2(Context context, ArrayList<Items2> itemsArrayList) {

        super(context, R.layout.row2, itemsArrayList);

        this.context = context;
        this.itemsArrayList = itemsArrayList;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        float y = Float.parseFloat(itemsArrayList.get(position).getMoney());
        // 1. Create inflater
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        // 2. Get rowView from inflater
        View rowView = inflater.inflate(R.layout.row2, parent, false);

        // 3. Get the two text view from the rowView
        TextView labelView = (TextView) rowView.findViewById(R.id.label);
        TextView valueView;
        if(y>=0){
            valueView = (TextView) rowView.findViewById(R.id.value);}
        else{
            valueView = (TextView) rowView.findViewById(R.id.value2);}
        // 4. Set the text for textView
        labelView.setText(itemsArrayList.get(position).getName());
        valueView.setText(itemsArrayList.get(position).getMoney());

        // 5. retrn rowView
        return rowView;
    }
}
