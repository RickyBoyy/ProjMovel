package pt.iade.ricardopereira.qrity_admin.models;

import android.util.Log;

import com.google.gson.Gson;

import java.net.URL;
import java.util.ArrayList;

import pt.iade.ricardopereira.qrity_admin.utilities.WebRequest;

public class WorkersItem {
    private String worker_name;
    private String role;

    private int id;

    public WorkersItem(String worker_name, String role, int id) {

        this.worker_name = worker_name;
        this.role = role;
        this.id = id;
    }


    public String getWorker_name() {
        return worker_name;
    }

    public void setWorker_name(String worker_name) {
        this.worker_name = worker_name;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public int getId() {
        return id;
    }
    public interface ListResponse {
        public void response(ArrayList<WorkersItem> items);
    }
    public interface GetByIdResponse {
        public void response(WorkersItem item);
    }


    public static void List(ListResponse response) {
        //Fetch a list of items from the web server and populate the list with them
        ArrayList<WorkersItem> items = new ArrayList<WorkersItem>();
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    WebRequest request = new WebRequest(new URL(WebRequest.LOCALHOST + "/permission/workers"));
                    String resp = request.performGetRequest();

                    //Get the array from the webserver's response
                    Gson gson = new Gson();
                    WorkersItem[] array = gson.fromJson(resp, WorkersItem[].class);
                    //JsonArray array = new Gson().fromJson(resp, JsonArray.class);
                    //Convert Json elements into NoteItem
                    ArrayList<WorkersItem> items = new ArrayList<WorkersItem>();
                    for (WorkersItem elem : array) {
                        items.add(elem);
                    }
                    response.response(items);

                } catch (Exception e) {
                    Log.e("LogItem", e.toString());
                }
            }
        });
        thread.start();
    }
    public static void GetById(int id, GetByIdResponse response) {
        // Fetch the item from the web server using its id and populate the object
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    WebRequest request = new WebRequest(new URL(WebRequest.LOCALHOST + "/permissions/" + id));
                    String resp = request.performGetRequest();

                    WorkersItem item = new Gson().fromJson(resp, WorkersItem.class);
                    response.response(item);

                } catch (Exception e) {
                    Log.e("WorkersItem", e.toString());
                }
            }
        });
        thread.start();
    }




}
