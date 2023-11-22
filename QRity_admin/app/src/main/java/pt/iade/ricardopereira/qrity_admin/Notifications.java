package pt.iade.ricardopereira.qrity_admin;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toolbar;

import java.util.ArrayList;
import java.util.List;

import pt.iade.ricardopereira.qrity_admin.adapters.NotificationAdapter;
import pt.iade.ricardopereira.qrity_admin.models.NotificationItem;

public class Notifications extends AppCompatActivity {

    private RecyclerView recyclerView;
    private NotificationAdapter notificationAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notifications);

        Toolbar toolbar = findViewById(R.id.toolbar_notifications);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Notifications");

        recyclerView = findViewById(R.id.recyclerViewNotifications);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));


        List<NotificationItem> notificationItemList = getSampleNotifications();


        notificationAdapter = new NotificationAdapter(notificationItemList);
        recyclerView.setAdapter(notificationAdapter);




        }
        private List<NotificationItem> getSampleNotifications() {
            List<NotificationItem> notificationItemList = new ArrayList<>();
            notificationItemList.add(new NotificationItem("worker_name", "door_name"));
            notificationItemList.add(new NotificationItem("worker_name", "door_name"));

            return notificationItemList;
    }

    private void setSupportActionBar(Toolbar toolbar) {
    }

}