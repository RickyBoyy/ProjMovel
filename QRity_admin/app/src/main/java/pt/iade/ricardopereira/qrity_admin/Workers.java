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
        workersItemList.add(new WorkersItem("João Silva", "Professor", 1));
        workersItemList.add(new WorkersItem("Maria Santos", "Coordenador", 2));
        workersItemList.add(new WorkersItem("Pedro Oliveira", "Assistente", 3));
        workersItemList.add(new WorkersItem("Ana Costa", "Técnico", 4));
        workersItemList.add(new WorkersItem("Miguel Ferreira", "Pesquisador", 5));
        workersItemList.add(new WorkersItem("Sofia Rocha", "Analista", 6));
        workersItemList.add(new WorkersItem("Carlos Pereira", "Engenheiro", 7));

        return workersItemList;
    }

}

