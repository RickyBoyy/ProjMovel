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

    private int area_id;

    private int door_level;

    private int id;

    public PermissionItem(String door_name, int id,int door_level){

        this.door_level=door_level;

        this.door_name = door_name;

        this.id = id;
    }

    public int getDoor_level() {
        return door_level;
    }

    public void setDoor_level(int door_level) {
        this.door_level = door_level;
    }

    public String getDoor_name() {
        return door_name;
    }

    public void setDoor_name(String door_name) {
        this.door_name = door_name;
    }

    public int getArea_id() {
        return area_id;
    }

    public void setArea_id(int area_id) {
        this.area_id = area_id;
    }

    public void setId(int id) {
        this.id = id;
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
        List(-1, response);
    }

    public static void List(int area_id,PermissionItem.ListResponse response){
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
                        if((area_id == -1)||(elem.area_id == area_id)) {

                            items.add(elem);
                        }
                    }

                    response.response(items);

                } catch (Exception e) {
                    Log.e("permissions", e.toString());
                }
            }
        });
        thread.start();
    }

}