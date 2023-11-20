package pt.iade.ricardopereira.qrity_admin.models;

import java.io.Serializable;
import java.util.ArrayList;
public class WorkerItem {

    private int id;
    private String name;
    private String role;

    public WorkerItem() {
        this(0, "", "");
    }

    public  WorkerItem(int id, String name, String role){
        this.id = id;
        this.name = name;
        this.role = role;
    }

    public static ArrayList<WorkerItem> List(){
        ArrayList<WorkerItem> items = new ArrayList<>();

        //add a new worker

        return items;
    }

    public int getId() {
        return id;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}

