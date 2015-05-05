package edu.amherst.fyang17.hacksmithbackend;

/**
 * Created by Administrator on 3/28/2015.
 */

public class Items {

    public String title;
    public String description;

    public Items(String title, String description) {
        super();
        this.title = title;
        this.description = description;
    }
    public String getTitle(){
        return title;
    }
    public String getDescription(){
        return description;
    }
}