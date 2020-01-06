package models;


import java.util.Objects;
import java.util.ArrayList;
import java.util.List;

public class Squad {

    private int maxsize;
    private String name;
    private String cause;
    private int id;

    private static ArrayList<Squad> allSquads = new ArrayList<>();
    private List<Hero> heroesInSquad;

    public Squad(String name){
        this.name = name;
        allSquads.add(this);
        this.id = allSquads.size();
        this.heroesInSquad = new ArrayList<Hero>();

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