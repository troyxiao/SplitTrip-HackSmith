package edu.amherst.fyang17.hacksmithbackend;

import com.orm.SugarRecord;

import java.util.*;

public class TransactionTable extends SugarRecord<TransactionTable>{

    String payer;
    String payees;
    float amount;
    String description;
    String currency;

    public TransactionTable(){

    }
    public TransactionTable(String payer, String payees, float amount, String description, String currency){
        this.payer = payer;
        this.payees = payees;
        this.amount = amount;
        this.description = description;
        this.currency = currency;
    }
}
