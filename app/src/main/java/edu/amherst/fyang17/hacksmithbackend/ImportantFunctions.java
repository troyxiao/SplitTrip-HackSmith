package edu.amherst.fyang17.hacksmithbackend;

/**
 * Created by Administrator on 3/28/2015.
 */
import java.util.*;
public class ImportantFunctions {
    public static void buildPersonList(String[] people){
        Persons.deleteAll(Persons.class);
        int n = people.length;
        for (int i=0;i<n;i++){
            Persons temp = new Persons(people[i]);
            temp.save();
        }
    }
    public static void buildRelationTable(int n){
        List<Persons> people = Persons.listAll(Persons.class);
    }
}
