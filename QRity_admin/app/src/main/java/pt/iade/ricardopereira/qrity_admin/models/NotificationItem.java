package pt.iade.ricardopereira.qrity_admin.models;

import android.util.Log;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;
import java.lang.reflect.Type;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import pt.iade.ricardopereira.qrity_admin.utilities.WebRequest;

public class NotificationItem {

    private String request;
    private int id;

    public NotificationItem(String request, int id) {
        this.request = request;
        this.id = id;
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

    public void setId(int id) {
        this.id = id;
    }

    public interface ListResponse {
        void response(ArrayList<NotificationItem> items);
    }

    public static void getNotifications(NotificationItem.ListResponse response) {
        ArrayList<PermissionAreasItem> permissionItemsList = new ArrayList<>();


        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    WebRequest request = new WebRequest(new URL(WebRequest.LOCALHOST + "/api/notifications/getUnauthorizedAccessNotifications"));

                    //WebRequest requestState =   new WebRequest(new URL(WebRequest.LOCALHOST + "/api/userChallenge/completed/user/" + user.getId() ));

                    String resp = request.performGetRequest();

                    //requestState.performGetRequest();

                    Gson gson = new Gson();

                        NotificationItem[] array = gson.fromJson(resp, NotificationItem[].class);

                    //JsonObject json = new Gson().fromJson(resp,JsonObject.class);
                    //JsonArray array = json.getAsJsonArray("items");


                    ArrayList<NotificationItem> items = new ArrayList<>();


                    for (NotificationItem elem : array) {

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
    }

