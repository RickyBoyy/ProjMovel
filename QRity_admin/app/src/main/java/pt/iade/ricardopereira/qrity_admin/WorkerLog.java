package pt.iade.ricardopereira.qrity_admin;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import pt.iade.ricardopereira.qrity_admin.utilities.WebRequest;
import java.util.ArrayList;
import java.util.List;

import pt.iade.ricardopereira.qrity_admin.adapters.LogHistoryAdapter;
import pt.iade.ricardopereira.qrity_admin.models.LogHistoryItem;

public class WorkerLog extends AppCompatActivity {
    protected LogHistoryAdapter logHistoryAdapter;
    protected RecyclerView recyclerView;
    protected ArrayList<LogHistoryItem> itemsList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_worker_log);
        setupComponentsLog();
    }


    private void setupComponentsLog(){
        setSupportActionBar(findViewById(R.id.log_recycler));

        LogHistoryItem.List(new LogHistoryItem.ListResponse() {
            @Override
            public void response(ArrayList<LogHistoryItem> items) {
                itemsList = items;
                logHistoryAdapter = new LogHistoryAdapter(itemsList, WorkerLog.this);
                recyclerView = (RecyclerView) findViewById(R.id.log_recycler);
                recyclerView.setLayoutManager(new LinearLayoutManager(WorkerLog.this));
                recyclerView.setAdapter(logHistoryAdapter);

            }
        });




    }

}
