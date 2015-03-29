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

    public static void returnList(){
        List<TransactionTable> list = TransactionTable.listAll(TransactionTable.class);
        for (int i=0;i<list.size();i++){
            String[] payees = list.get(i).payees.split(" ");
            String toPrint = list.get(i).payer+" ";
            for (int j=0;j<payees.length;j++){
                toPrint = toPrint+payees[j]+" ";
            }
            toPrint = toPrint+list.get(i).amount+" "+list.get(i).description;
            System.out.println(toPrint);
        }
    }
}
