package pt.iade.ricardopereira.qrity_admin;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import pt.iade.ricardopereira.qrity_admin.adapters.PermissionsAreasAdapter;
import pt.iade.ricardopereira.qrity_admin.models.PermissionAreasItem;

public class PermissionsAreas extends AppCompatActivity {
    private static final int EDITOR_ACTIVITY_RETURN_ID = 1;

    protected RecyclerView itemsListView;
    protected PermissionsAreasAdapter itemRowAdapter;

    protected ArrayList<PermissionAreasItem> itemsList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_permissions_areas);

        // Setup the ActionBar.
        setSupportActionBar(findViewById(R.id.toolbar_permissionsareas));
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        // Initialize the itemsList.
        itemsList = new ArrayList<>();

        // Set up the items recycler view.
        itemsListView = findViewById(R.id.recyclerViewPermissionAreas);
        itemsListView.setLayoutManager(new LinearLayoutManager(this));

        // Initialize the adapter only if it's not already set
        if (itemRowAdapter == null) {
            itemRowAdapter = new PermissionsAreasAdapter(this, itemsList);
            itemRowAdapter.setOnClickListener(new PermissionsAreasAdapter.ItemClickListener() {
                @Override
                public void onItemClick(View view, int position) {
                    Intent intent = new Intent(PermissionsAreas.this, Permissions.class);
                    intent.putExtra("position", position);
                    intent.putExtra("item", itemsList.get(position));
                    startActivityForResult(intent, EDITOR_ACTIVITY_RETURN_ID);
                }
            });

            // Set the adapter to the RecyclerView
            itemsListView.setAdapter(itemRowAdapter);
        }

        // Call the method to fetch data from the server.
        fetchDataFromServer();
    }

    private void fetchDataFromServer() {
        PermissionAreasItem.List(new PermissionAreasItem.ListResponse() {
            @Override
            public void response(ArrayList<PermissionAreasItem> items) {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        // Update the itemsList with server response.
                        itemsList.clear();
                        itemsList.addAll(items);

                        // Update the data in the adapter
                        itemRowAdapter.notifyDataSetChanged();
                    }
                });
            }
        });
    }

    // Rest of your code...
}