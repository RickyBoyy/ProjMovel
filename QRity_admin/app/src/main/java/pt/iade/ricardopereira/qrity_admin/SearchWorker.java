package pt.iade.ricardopereira.qrity_admin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import androidx.appcompat.widget.SearchView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import pt.iade.ricardopereira.qrity_admin.adapters.PermissionsAdapter;
import pt.iade.ricardopereira.qrity_admin.adapters.SearchWorkerAdapter;
import pt.iade.ricardopereira.qrity_admin.adapters.WorkersAdapter;
import pt.iade.ricardopereira.qrity_admin.databinding.ActivityMainBinding;
import pt.iade.ricardopereira.qrity_admin.databinding.ActivitySearchWorkerBinding;
import pt.iade.ricardopereira.qrity_admin.models.WorkersItem;

import java.util.ArrayList;
import java.util.List;
public class SearchWorker extends AppCompatActivity {


    private ActivitySearchWorkerBinding binding;
    private RecyclerView recyclerView;
    private SearchWorkerAdapter searchWorkerAdapter;

    private ArrayList<WorkersItem> allWorkers;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_worker);
        setupComponents();
        allWorkers = (ArrayList<WorkersItem>) getSampleWorkers();
        initSearchView();
    }

    private void initSearchView() {
        androidx.appcompat.widget.SearchView searchView = findViewById(R.id.searchView);
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                filterWorkers(newText);
                return true;
            }
        });
    }

    private void filterWorkers(String query) {
        ArrayList<WorkersItem> filteredList = new ArrayList<>();

        for (WorkersItem worker : allWorkers) {
            if (TextUtils.isEmpty(query) ||
                    worker.getWorker_name().toLowerCase().contains(query.toLowerCase()) ||
                    worker.getRole().toLowerCase().contains(query.toLowerCase())) {
                filteredList.add(worker);
            }
        }

        searchWorkerAdapter.setSearchWorkersItemList(filteredList);
    }

    private void setupComponents() {
        recyclerView = findViewById(R.id.userList);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        searchWorkerAdapter = new SearchWorkerAdapter(this, getSampleWorkers());
        recyclerView.setAdapter(searchWorkerAdapter);
        searchWorkerAdapter.setOnClickListener(new SearchWorkerAdapter.ItemClickListener() {
            @Override
            public void onItemClick(View view, int position, WorkersItem selectedWorker) {
                Bundle bundle = new Bundle();
                bundle.putStringArray("arrayOfName", new String[]{selectedWorker.getWorker_name()});
                bundle.putStringArray("arrayOfCargos", new String[]{selectedWorker.getRole()});
                Intent resultIntent = new Intent();
                resultIntent.putExtras(bundle);
                setResult(RESULT_OK, resultIntent);
                finish();
            }
        });
    }

    private ArrayList<WorkersItem> getSampleWorkers() {
        ArrayList<WorkersItem> workersItemList = new ArrayList<>();
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

       /* searchWorkerAdapter.setOnClickListener(new SearchWorkerAdapter.ItemClickListener() {
            @Override
            public void onItemClick(View view, int position, WorkersItem selectedWorker) {
                addWorkertoPreviousActivity(selectedWorker);
            }


        });


        }
        private void addWorkertoPreviousActivity(WorkersItem workersItem){
            if(workersAdapter != null){
               workersAdapter.addItem(workersItem);
            }
        }

    }*/


