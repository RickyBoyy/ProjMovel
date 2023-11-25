package pt.iade.ricardopereira.qrity_admin;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Button;
import  androidx.appcompat.widget.Toolbar;

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


        notificationAdapter = new NotificationAdapter(this, getSampleNotifications());
        recyclerView.setAdapter(notificationAdapter);




    }
    private List<NotificationItem> getSampleNotifications() {
        List<NotificationItem> notificationItemList = new ArrayList<>();
        notificationItemList.add(new NotificationItem("José Pinto", "Server Room", 1));
        notificationItemList.add(new NotificationItem("Miguel Soares", "Rooftop", 2));
        notificationItemList.add(new NotificationItem("Gonçalo Santos", "Basement", 3));
        notificationItemList.add(new NotificationItem("Artur Morais", "Classroom A", 4));
        notificationItemList.add(new NotificationItem("Fernando Almeida", "Photography Room", 5));
        notificationItemList.add(new NotificationItem("Sandra Albuquerque", "Kitchen", 6));
        notificationItemList.add(new NotificationItem("Maria Portugal", "Kitchen", 7));

        return notificationItemList;
    }



}
