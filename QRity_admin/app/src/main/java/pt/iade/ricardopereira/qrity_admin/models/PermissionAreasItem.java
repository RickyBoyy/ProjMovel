package pt.iade.ricardopereira.qrity_admin.models;

import android.util.Log;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import java.io.Serializable;
import java.net.URL;
import java.util.ArrayList;

import pt.iade.ricardopereira.qrity_admin.utilities.WebRequest;

public class PermissionAreasItem implements Serializable {



    private String area;

    private int id;

    public PermissionAreasItem( String area, int id){


        this.area = area;
        this.id = id;
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
        public void response(PermissionAreasItem item);
    }
    public interface ListResponse {
        public void response(ArrayList<PermissionAreasItem> items);
    }
    public static void List(ListResponse response) {
        ArrayList<PermissionAreasItem> items = new ArrayList<PermissionAreasItem>();

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
                        ArrayList<PermissionAreasItem> items = new ArrayList<PermissionAreasItem>();
                        for (JsonElement elem : arr) {
                            items.add(new Gson().fromJson(elem, PermissionAreasItem.class));
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

                        response.response(new Gson().fromJson(resp, PermissionAreasItem.class));
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
