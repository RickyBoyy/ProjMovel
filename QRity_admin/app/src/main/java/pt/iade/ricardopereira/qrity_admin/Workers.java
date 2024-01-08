package pt.iade.ricardopereira.qrity_admin;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.Menu;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import pt.iade.ricardopereira.qrity_admin.adapters.PermissionsAdapter;
import pt.iade.ricardopereira.qrity_admin.adapters.WorkersAdapter;
import pt.iade.ricardopereira.qrity_admin.models.PermissionItem;
import pt.iade.ricardopereira.qrity_admin.models.WorkersItem;

public class Workers extends AppCompatActivity {
    private static final int SEARCH_WORKER_ACTIVITY_RETURN_ID=1;

    protected RecyclerView itemsListView;
    protected WorkersAdapter itemRowAdapter;

    protected ArrayList<WorkersItem> itemsList;

    protected PermissionItem door_level;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_workers);

        // Setup the ActionBar.
        setSupportActionBar(findViewById(R.id.toolbar_workers));
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Intent intent = getIntent();
        door_level = (PermissionItem) intent.getSerializableExtra("item");



        // Initialize the itemsList.
        itemsList = new ArrayList<>();

        // Set up the items recycler view.
        itemsListView = findViewById(R.id.recycleViewWorkers);
        itemsListView.setLayoutManager(new LinearLayoutManager(this));

        // Initialize the adapter only if it's not already set
        if (itemRowAdapter == null) {
            itemRowAdapter = new WorkersAdapter(this, itemsList);

            // Set the adapter to the RecyclerView
            itemsListView.setAdapter(itemRowAdapter);
        }

        // Call the method to fetch data from the server.
        fetchDataFromServer();
    }

    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.worker_menu, menu);
        return super.onPrepareOptionsMenu( menu);
    }




    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            // Handle back button press
            onBackPressed();
            return true;
        }

        if (item.getItemId() == R.id.addWorker) {
            Intent intent = new Intent(Workers.this, SearchWorker.class);
            startActivityForResult(intent, SEARCH_WORKER_ACTIVITY_RETURN_ID);


            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {
        // Handle the back button press
        // You can add additional logic here if needed
        super.onBackPressed();
    }






    private void fetchDataFromServer() {
        WorkersItem.List(door_level.getDoor_level(), new WorkersItem.ListResponse() {
            @Override
            public void response(ArrayList<WorkersItem> items) {
                // Update the itemsList with server response.
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        itemsList.clear();
                        itemsList.addAll(items);

                        // Update the data in the adapter
                        itemRowAdapter.notifyDataSetChanged();
                    }
                });
            }
        });
    }
}