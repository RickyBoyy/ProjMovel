package pt.iade.ricardopereira.qrity_admin;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import pt.iade.ricardopereira.qrity_admin.adapters.LogHistoryAdapter;
import pt.iade.ricardopereira.qrity_admin.models.LogHistoryItem;

public class WorkerLog extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_worker_log);


        RecyclerView recyclerView = findViewById(R.id.log_recycler);

        // Set up the RecyclerView
        recyclerView.setLayoutManager(new LinearLayoutManager(this));


        List<LogHistoryItem> logHistoryItemList = getDummyData();

        // Create an instance of the adapter
        LogHistoryAdapter logHistoryAdapter = new LogHistoryAdapter(logHistoryItemList, this);

        // Set the adapter to the RecyclerView
        recyclerView.setAdapter(logHistoryAdapter);
    }

    private List<LogHistoryItem> getDummyData() {
        List<LogHistoryItem> dummyData = new ArrayList<>();

        // Add some dummy LogHistoryItems
        dummyData.add(new LogHistoryItem("John Doe", "Main Door", "Office Area", "2023-11-25 10:00 AM"));
        dummyData.add(new LogHistoryItem("Jane Smith", "Back Door", "Storage Area", "2023-11-25 11:30 AM"));
        // Add more items as needed

        return dummyData;
    }
}
