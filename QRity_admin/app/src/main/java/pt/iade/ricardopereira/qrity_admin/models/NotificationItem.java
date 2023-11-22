package pt.iade.ricardopereira.qrity_admin.models;

import android.widget.Button;
import android.widget.ImageView;

public class NotificationItem {

    private String request;

    private String door;

    private int id;

    private Button check_button;

    private Button cross_button;




    public NotificationItem(String request, String door, int id, Button check_button, Button cross_button){

        this.request = request;
        this.door = door;
        this.check_button = check_button;
        this.cross_button = cross_button;
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

    public String getRequest() {
        return request;
    }

    public void setRequest(String request) {
        this.request = request;
    }

    public int getId() {
        return id;
    }

    public Button getCheck_button() {
        return check_button;
    }

    public void setCheck_button(Button check_button) {
        this.check_button = check_button;
    }

    public Button getCross_button() {
        return cross_button;
    }

    public void setCross_button(Button cross_button) {
        this.cross_button = cross_button;
    }
}
