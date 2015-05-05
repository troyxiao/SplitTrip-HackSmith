package edu.amherst.fyang17.hacksmithbackend;

import com.orm.SugarRecord;

import java.util.*;
/**
 * Created by Administrator on 3/28/2015.
 */
public class TransactionTable extends SugarRecord{
    static int count = 0;
    int number;
    String payer;
    String payees;
    float amount;
    String description;

    public TransactionTable(){

    }
    public TransactionTable(String payer, String payees, float amount, String description){
        //this.number = count+1;
        //count++;
        this.payer = payer;
        this.payees = payees;
        this.amount = amount;
        this.description = description;
    }
}
