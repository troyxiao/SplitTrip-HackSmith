package edu.amherst.fyang17.hacksmithbackend;

import com.orm.SugarRecord;

/**
 * Created by Administrator on 3/28/2015.
 */
public class RelationTable extends SugarRecord{
    String p1;
    String p2;
    float amount;

    public RelationTable(){

    }

    public RelationTable(String p1, String p2, float amount){
        this.p1 = p1;
        this.p2 = p2;
        this.amount = amount;
    }
}
