package pt.iade.ricardopereira.qrity_admin.models;

import android.util.Log;

import com.google.gson.Gson;

import java.net.URL;
import java.util.ArrayList;

import pt.iade.ricardopereira.qrity_admin.utilities.WebRequest;

public class LogHistoryItem {
    private String worker;

    private String door;

    private String area;

    private String timestamp;








    public LogHistoryItem(String worker, String door, String area, String timestamp){

        this.worker = worker;
        this.door = door;
        this.area = area;
        this.timestamp = timestamp;


    }

    public String getWorker() {
        return worker;
    }

    public void setWorker(String worker) {
        this.worker = worker;
    }

    public String getDoor() {
        return door;
    }

    public void setDoor(String door) {
        this.door = door;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }


    public interface ListResponse {
        public void response(ArrayList<LogHistoryItem> items);
    }
    public static void List(LogHistoryItem.ListResponse response) {
        //Fetch a list of items from the web server and populate the list with them
        ArrayList<LogHistoryItem> items = new ArrayList<LogHistoryItem>();
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    WebRequest request = new WebRequest(new URL(WebRequest.LOCALHOST + "/api/log"));
                    String resp = request.performGetRequest();

                    //Get the array from the webserver's response
                    Gson gson = new Gson();
                    LogHistoryItem[] array = gson.fromJson(resp, LogHistoryItem[].class);
                    //JsonArray array = new Gson().fromJson(resp, JsonArray.class);
                    //Convert Json elements into NoteItem
                    ArrayList<LogHistoryItem> items = new ArrayList<LogHistoryItem>();
                    for (LogHistoryItem elem : array) {
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

}

