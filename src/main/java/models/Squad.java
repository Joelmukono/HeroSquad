package models;


import java.util.Objects;

public class Squad {

    private int maxsize;
    private String name;
    private String cause;
    private int id;
    private boolean isAdded;

    public Squad(String name,int id){
        this.name = name;
        this.id = id;
        this.isAdded = false;

    }





    public int getMaxsize(){
        return maxsize;

    }
    public String getName(){
        return name;
    }

    public String getCause(){
        return cause;
    }

    public int getId(){
        return id;
    }

    public void setId(int id){
        this.id = id;

    }

}