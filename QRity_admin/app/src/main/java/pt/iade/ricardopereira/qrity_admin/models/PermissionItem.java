package pt.iade.ricardopereira.qrity_admin.models;

import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import java.io.Serializable;
import java.net.URL;
import java.util.ArrayList;

import pt.iade.ricardopereira.qrity_admin.utilities.WebRequest;

public class PermissionItem implements Serializable {


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

    public interface GetByIdResponse {
        public void response(PermissionItem item);
    }
    public interface ListResponse {
        public void response(ArrayList<PermissionItem> items);
    }
    public static void List(ListResponse response) {
        ArrayList<PermissionItem> items = new ArrayList<PermissionItem>();

        // Fetch a list of items from the web server and populate the list with them.
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    try {
                        WebRequest req = new WebRequest(new URL(
                                WebRequest.LOCALHOST + "/permissionList"));
                        String resp = req.performGetRequest();

                        // Get the array from the response.
                        JsonObject json = new Gson().fromJson(resp, JsonObject.class);
                        JsonArray arr = json.getAsJsonArray("items");
                        ArrayList<PermissionItem> items = new ArrayList<PermissionItem>();
                        for (JsonElement elem : arr) {
                            items.add(new Gson().fromJson(elem, PermissionItem.class));
                        }

                        response.response(items);
                    } catch (Exception e) {
                        Toast.makeText(null, "Web request failed: " + e.toString(),
                                Toast.LENGTH_LONG).show();
                        Log.e("PermissionItem", e.toString());
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        thread.start();
    }
    public static void GetById(int id, GetByIdResponse response) {
        // Fetch the item from the web server using its id and populate the object.
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    try {
                        WebRequest req = new WebRequest(new URL(
                                WebRequest.LOCALHOST + "/permission/" + id));
                        String resp = req.performGetRequest();

                        response.response(new Gson().fromJson(resp, PermissionItem.class));
                    } catch (Exception e) {
                        Toast.makeText(null, "Web request failed: " + e.toString(),
                                Toast.LENGTH_LONG).show();
                        Log.e("TodoItem", e.toString());
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        thread.start();
    }
}
