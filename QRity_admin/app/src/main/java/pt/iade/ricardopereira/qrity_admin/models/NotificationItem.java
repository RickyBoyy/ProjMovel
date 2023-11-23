package pt.iade.ricardopereira.qrity_admin.models;

import android.widget.TextView;

public class NotificationItem {

    private String request;

    private String door;

    private int id;






    public NotificationItem(String request, String door, int id){

        this.request = request;
        this.door = door;
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
}
