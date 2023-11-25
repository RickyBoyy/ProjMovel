package pt.iade.ricardopereira.qrity_admin.models;

import android.widget.TextView;

public class NotificationItem {

    private String request;

    private String door;

    private String area;

    private int id;






    public NotificationItem(String request, String door, String area, int id){

        this.request = request;
        this.door = door;
        this.area = area;
        this.id = id;
    }

    public String getTitle() {
        return request;
    }

    public void setTitle(String title) {
        this.request = request;
    }

    public String getDoor() {
        return door;
    }

    public void setDoor(String door) {
        this.door = door;
    }


    public int getId() {
        return id;
    }




    public void setId(int id) {
        this.id = id;
    }

    public String getRequest() {
        return request;
    }

    public void setRequest(String request) {
        this.request = request;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }
}
