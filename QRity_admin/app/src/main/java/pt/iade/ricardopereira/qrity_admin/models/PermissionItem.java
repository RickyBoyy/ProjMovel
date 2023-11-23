package pt.iade.ricardopereira.qrity_admin.models;

import android.widget.TextView;

public class PermissionItem {


    private String door_name;
    private String area;

    private int id;

    public PermissionItem(String door_name, String area, int id){

        this.door_name = door_name;
        this.area = area;
        this.id = id;
    }


    public String getDoor_name() {
        return door_name;
    }

    public void setDoor_name(String door_name) {
        this.door_name = door_name;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public int getId() {
        return id;
    }


}
