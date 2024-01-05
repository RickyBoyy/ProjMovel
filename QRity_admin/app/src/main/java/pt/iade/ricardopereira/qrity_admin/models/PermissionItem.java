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


    private int id;

    public PermissionItem(String door_name, int id){

        this.door_name = door_name;

        this.id = id;
    }


    public String getDoor_name() {
        return door_name;
    }

    public void setDoor_name(String door_name) {
        this.door_name = door_name;
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

    public static void List(PermissionItem.ListResponse response) {
        ArrayList<PermissionItem> permissionItemsList = new ArrayList<>();


        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    WebRequest request = new WebRequest(new URL(WebRequest.LOCALHOST + "/api/permissiondoor/list"));

                    //WebRequest requestState =   new WebRequest(new URL(WebRequest.LOCALHOST + "/api/userChallenge/completed/user/" + user.getId() ));

                    String resp = request.performGetRequest();

                    //requestState.performGetRequest();

                    Gson gson = new Gson();

                    PermissionItem[] array = gson.fromJson(resp, PermissionItem[].class);

                    //JsonObject json = new Gson().fromJson(resp,JsonObject.class);
                    //JsonArray array = json.getAsJsonArray("items");


                    ArrayList<PermissionItem> items = new ArrayList<>();


                    for (PermissionItem elem : array) {

                        items.add(elem);
                    }

                    response.response(items);

                } catch (Exception e) {
                    Log.e("permissions", e.toString());
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
