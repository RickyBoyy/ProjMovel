package pt.iade.ricardopereira.qrity_admin.models;

import android.util.Log;
import android.widget.Toast;

import com.google.gson.Gson;

import java.net.URL;
import java.util.ArrayList;
import java.util.Calendar;

import pt.iade.ricardopereira.qrity_admin.utilities.WebRequest;

public class LogHistoryItem {
    private int id;
    private String worker;

    private String door;

    private String area;

    private Calendar timestamp;


    public LogHistoryItem(int id, String worker, String door, String area, Calendar timestamp) {


        this.id = id;
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

    public Calendar getTimestamp() {
        return timestamp;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTimestamp(Calendar timestamp) {
        this.timestamp = timestamp;
    }


    public interface ListResponse {
        public void response(ArrayList<LogHistoryItem> items);
    }
    public interface GetByIdResponse {
        public void response(LogHistoryItem item);
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

    public static void GetById(int id, GetByIdResponse response) {
        // Fetch the item from the web server using its id and populate the object.
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    try {
                        WebRequest req = new WebRequest(new URL(
                                WebRequest.LOCALHOST + "/loghistory/" + id));
                        String resp = req.performGetRequest();

                        response.response(new Gson().fromJson(resp, LogHistoryItem.class));
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

