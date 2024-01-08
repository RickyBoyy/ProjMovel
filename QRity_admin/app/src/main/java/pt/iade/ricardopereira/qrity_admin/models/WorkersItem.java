package pt.iade.ricardopereira.qrity_admin.models;

import android.util.Log;
import android.widget.Toast;

import com.google.gson.Gson;

import java.io.Serializable;
import java.net.URL;
import java.util.ArrayList;

import pt.iade.ricardopereira.qrity_admin.utilities.WebRequest;

public class WorkersItem implements Serializable {
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

    public void save() {
        // Send the object's data to our web server and update the database there.
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    try {
                        if (id == 0) {
                            // This is a brand new object and must be a INSERT in the database.
                            WebRequest req = new WebRequest(new URL(
                                    WebRequest.LOCALHOST + "/api/workerdoor/new"));
                            String response = req.performPostRequest(WorkersItem.this);

                            // Get the new ID from the server's response.
                            WorkersItem respItem = new Gson().fromJson(response, WorkersItem.class);
                            id = respItem.getId();
                        } else {
                            // This is an update to an existing object and must use UPDATE in the database.
                            WebRequest req = new WebRequest(new URL(
                                    WebRequest.LOCALHOST + "/api/workers/" + id));
                            req.performPostRequest(WorkersItem.this);
                        }
                    } catch (Exception e) {
                        Toast.makeText(null, "Web request failed: " + e.toString(),
                                Toast.LENGTH_LONG).show();
                        Log.e("WorkerItem", e.toString());
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        thread.start();
    }


    public static void List(int doorLevel, ListResponse response) {
        ArrayList<WorkersItem> workersItemsItemsList = new ArrayList<>();


        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    WebRequest request = new WebRequest(new URL(WebRequest.LOCALHOST + "/api/workers/list"));

                    //WebRequest requestState =   new WebRequest(new URL(WebRequest.LOCALHOST + "/api/userChallenge/completed/user/" + user.getId() ));

                    String resp = request.performGetRequest();

                    //requestState.performGetRequest();

                    Gson gson = new Gson();

                    WorkersItem[] array = gson.fromJson(resp, WorkersItem[].class);

                    //JsonObject json = new Gson().fromJson(resp,JsonObject.class);
                    //JsonArray array = json.getAsJsonArray("items");


                    ArrayList<WorkersItem> items = new ArrayList<>();


                    for (WorkersItem elem : array) {
                        items.add(elem);
                    }

                    response.response(items);

                } catch (Exception e) {
                    Log.e("workers", e.toString());
                }
            }
        });
        thread.start();
    }
}




