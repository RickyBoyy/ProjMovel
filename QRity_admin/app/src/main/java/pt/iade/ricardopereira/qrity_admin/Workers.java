package pt.iade.ricardopereira.qrity_admin;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import androidx.appcompat.widget.Toolbar;

import java.util.ArrayList;
import java.util.List;

import pt.iade.ricardopereira.qrity_admin.adapters.WorkersAdapter;
import pt.iade.ricardopereira.qrity_admin.models.WorkersItem;

public class Workers extends AppCompatActivity {

    private RecyclerView recyclerView;

    private WorkersAdapter workersAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_workers);

        androidx.appcompat.widget.Toolbar toolbar = findViewById(R.id.toolbar_workers);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Workers");

        recyclerView = findViewById(R.id.recycleViewWorkers);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        List<WorkersItem> workersItemList = getSampleWorkers();
        workersAdapter = new WorkersAdapter(this, getSampleWorkers());
        recyclerView.setAdapter(workersAdapter);

    }

    private List<WorkersItem> getSampleWorkers() {

        List<WorkersItem> workersItemList = new ArrayList<>();
        workersItemList.add(new WorkersItem("Trabalhador 1", "Professor", 1));
        workersItemList.add(new WorkersItem("Trabalhador 2", "Coordenador", 2));

        return workersItemList;
    }

}

