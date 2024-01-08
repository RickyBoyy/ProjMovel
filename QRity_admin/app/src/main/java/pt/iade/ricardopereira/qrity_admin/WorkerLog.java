package pt.iade.ricardopereira.qrity_admin;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Button;
import  androidx.appcompat.widget.Toolbar;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import pt.iade.ricardopereira.qrity_admin.adapters.LogHistoryAdapter;
import pt.iade.ricardopereira.qrity_admin.adapters.NotificationAdapter;
import pt.iade.ricardopereira.qrity_admin.models.LogHistoryItem;
import pt.iade.ricardopereira.qrity_admin.models.NotificationItem;

public class WorkerLog extends AppCompatActivity {

    private RecyclerView recyclerView;
    private LogHistoryAdapter logAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_worker_log);

        Toolbar toolbar = findViewById(R.id.log_toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Log History");

        recyclerView = findViewById(R.id.log_recycler);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));


        ArrayList<LogHistoryItem> logHistoryItems = getSampleNotifications();


        logAdapter = new LogHistoryAdapter(getSampleNotifications(), this);
        recyclerView.setAdapter(logAdapter);




    }

    private ArrayList<LogHistoryItem> getSampleNotifications() {
        ArrayList<LogHistoryItem> logHistoryItems = new ArrayList<>();

        Calendar calendar1 = Calendar.getInstance();
        calendar1.set(2023, Calendar.JANUARY, 15);

        Calendar calendar2 = Calendar.getInstance();
        calendar2.set(2023, Calendar.FEBRUARY, 28);

        Calendar calendar3 = Calendar.getInstance();
        calendar3.set(2023, Calendar.MARCH, 10);

        Calendar calendar4 = Calendar.getInstance();
        calendar4.set(2023, Calendar.APRIL, 5);

        Calendar calendar5 = Calendar.getInstance();
        calendar5.set(2023, Calendar.MAY, 20);

        Calendar calendar6 = Calendar.getInstance();
        calendar6.set(2023, Calendar.JUNE, 8);

        Calendar calendar7 = Calendar.getInstance();
        calendar7.set(2023, Calendar.JULY, 14);

        Calendar calendar8 = Calendar.getInstance();
        calendar8.set(2023, Calendar.AUGUST, 3);

        logHistoryItems.add(new LogHistoryItem(1, "José Pinto", "Door1", "Area1", calendar1));
        logHistoryItems.add(new LogHistoryItem(2, "Miguel Soares", "Door2", "Area2", calendar2));
        logHistoryItems.add(new LogHistoryItem(3, "Gonçalo Santos", "Door3", "Area3", calendar3));
        logHistoryItems.add(new LogHistoryItem(4, "Artur Morais", "Door4", "Area4", calendar4));
        logHistoryItems.add(new LogHistoryItem(5, "Fernando Almeida", "Door5", "Area5", calendar5));
        logHistoryItems.add(new LogHistoryItem(6, "Sandra Albuquerque", "Door6", "Area6", calendar6));
        logHistoryItems.add(new LogHistoryItem(7, "Maria Portugal", "Door7", "Area7", calendar7));
        logHistoryItems.add(new LogHistoryItem(8, "Carlos Silva", "Door8", "Area8", calendar8));

        return logHistoryItems;
    }



}