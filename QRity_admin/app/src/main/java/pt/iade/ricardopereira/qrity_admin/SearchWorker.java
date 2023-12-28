package pt.iade.ricardopereira.qrity_admin;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.widget.SearchView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import pt.iade.ricardopereira.qrity_admin.adapters.WorkersAdapter;
import pt.iade.ricardopereira.qrity_admin.databinding.ActivityMainBinding;
import pt.iade.ricardopereira.qrity_admin.databinding.ActivitySearchWorkerBinding;
import pt.iade.ricardopereira.qrity_admin.models.WorkersItem;

import java.util.ArrayList;
import java.util.List;
public class SearchWorker extends AppCompatActivity {


    private ActivitySearchWorkerBinding binding;
    private RecyclerView recyclerView;
    private WorkersAdapter workerAdapter;
    private ArrayList<WorkersItem> allWorkers;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_worker);
    }
    private void initSearchView() {
        SearchView searchView = findViewById(R.id.searchView);
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

        workerAdapter.setWorkersList(filteredList);
    }

    private void setupComponents(){
        recyclerView = findViewById(R.id.userList);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        workerAdapter = new WorkersAdapter(this, new ArrayList<>());
        recyclerView.setAdapter(workerAdapter);
    }

}
