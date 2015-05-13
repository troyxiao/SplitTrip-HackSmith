package edu.amherst.fyang17.hacksmithbackend;

import com.orm.SugarRecord;

/**
 * Created by Administrator on 3/28/2015.
 */
public class Persons extends SugarRecord<Persons>{
    String name;
    public Persons(){

    }
    public Persons(String name){
        this.name = name;
    }

    public String toString(){
        return name;
    }
}
