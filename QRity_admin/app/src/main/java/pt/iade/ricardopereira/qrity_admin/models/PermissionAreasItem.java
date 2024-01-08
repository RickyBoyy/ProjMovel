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

    public static void List( PermissionAreasItem.ListResponse response) {

        ArrayList<PermissionAreasItem> permissionItemsList = new ArrayList<>();


        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    WebRequest request = new WebRequest(new URL(WebRequest.LOCALHOST + "/api/permissionarea/list"));

                    //WebRequest requestState =   new WebRequest(new URL(WebRequest.LOCALHOST + "/api/userChallenge/completed/user/" + user.getId() ));

                    String resp = request.performGetRequest();

                    //requestState.performGetRequest();

                    Gson gson = new Gson();

                    PermissionAreasItem[] array = gson.fromJson(resp, PermissionAreasItem[].class);

                    //JsonObject json = new Gson().fromJson(resp,JsonObject.class);
                    //JsonArray array = json.getAsJsonArray("items");


                    ArrayList<PermissionAreasItem> items = new ArrayList<>();


                    for (PermissionAreasItem elem : array) {

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
