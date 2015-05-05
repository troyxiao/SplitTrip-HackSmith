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
    public static void buildRelationTable(){
        TransactionTable.deleteAll(TransactionTable.class);
        RelationTable.deleteAll(RelationTable.class);
        List<Persons> people = Persons.listAll(Persons.class);
        int k = people.size();
        for (int i=0;i<k;i++){
            for (int j=0;j<k;j++){
                if (i!=j){
                    RelationTable temp = new RelationTable(people.get(i).name,people.get(j).name,0);
                    temp.save();
                }
            }
        }
    }

    public static void addTransaction(String payer, String payee, float amount, String description){
        TransactionTable temp = new TransactionTable(payer,payee,amount,description);
        temp.save();
        String[] payees = payee.split(",");
        float fraction = amount/payees.length;
        List<Persons> a = Persons.find(Persons.class,"name=?",payer);
        List<RelationTable> b = RelationTable.find(RelationTable.class,"p1=?",a.get(0).name);
        for (int i=0;i<b.size();i++){
            boolean paid = false;
            for (int j=0;j<payees.length;j++){
                if (b.get(i).p2.equals(payees[j])){
                    paid = true;
                }
            }
            if (paid==true){
                b.get(i).amount = b.get(i).amount + fraction;
                b.get(i).save();
            }
        }
        for (int i=0;i<payees.length;i++) {
            List<Persons> c = Persons.find(Persons.class, "name=?", payees[i]);
            List<RelationTable> d = RelationTable.find(RelationTable.class, "p1=?", c.get(0).name);
            for (int j=0; j<d.size(); j++){
                if (d.get(j).p2.equals(payer)){
                    d.get(j).amount=d.get(j).amount-fraction;
                    d.get(j).save();
                    break;
                }
            }
        }
    }

    public static ArrayList<Items> returnList(){
        List<TransactionTable> list = TransactionTable.listAll(TransactionTable.class);
        ArrayList<Items> toReturn  = new ArrayList<>();
        for (int i=0;i<list.size();i++){
            String[] payees = list.get(i).payees.split(",");
            String s1 = list.get(i).payer;
            String s2 = "";
            for (int j=0;j<payees.length;j++){
                s2 = s2+payees[j]+", ";
            }
            s2 = s2+"$"+list.get(i).amount+" "+list.get(i).description;
            toReturn.add(new Items(s1,s2));
        }
        return toReturn;
    }

    public static ArrayList<Items2> returnBalance(){
        ArrayList<Items2> toReturn = new ArrayList<>();
        List<Persons> people = Persons.listAll(Persons.class);
        int n = people.size();
        for (int i=0;i<n;i++) {
            List<RelationTable> list = RelationTable.find(RelationTable.class,"p1=?",people.get(i).name);
            float sum = 0;
            for (int j=0;j<n-1;j++){
                sum = sum + list.get(j).amount;
            }
            toReturn.add(new Items2(people.get(i).name,String.format("%.2f",sum)));
        }
        return toReturn;
    }

    public static ArrayList<Items> returnDetail(){
        ArrayList<Items> toReturn = new ArrayList<>();
        List<Persons> people = Persons.listAll(Persons.class);
        int n = people.size();
        for (int i=0;i<n;i++){
            List<RelationTable> list = RelationTable.find(RelationTable.class,"p1=?",people.get(i).name);
            String payee = "";
            for (int j=0;j<n-1;j++){
                payee=payee+list.get(j).p2+": "+String.format("%.2f",list.get(j).amount)+", ";
            }
            toReturn.add(new Items(people.get(i).name,payee));
        }
        return toReturn;
    }
}
