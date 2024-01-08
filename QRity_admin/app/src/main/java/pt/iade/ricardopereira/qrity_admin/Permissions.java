package pt.iade.ricardopereira.qrity_admin;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import pt.iade.ricardopereira.qrity_admin.adapters.PermissionsAdapter;
import pt.iade.ricardopereira.qrity_admin.adapters.PermissionsAreasAdapter;
import pt.iade.ricardopereira.qrity_admin.models.PermissionAreasItem;
import pt.iade.ricardopereira.qrity_admin.models.PermissionItem;

public class Permissions extends AppCompatActivity {
    private static final int EDITOR_ACTIVITY_RETURN_ID = 1;

    protected RecyclerView itemsListView;
    protected PermissionsAdapter itemRowAdapter;

    protected ArrayList<PermissionItem> itemsList;

    protected PermissionAreasItem area;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_permissions);

        // Setup the ActionBar.
        setSupportActionBar(findViewById(R.id.toolbar_permissions));
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Intent intent = getIntent();
        area = (PermissionAreasItem) intent.getSerializableExtra("item");

        // Initialize the itemsList.
        itemsList = new ArrayList<>();

        // Set up the items recycler view.
        itemsListView = findViewById(R.id.recyclerViewPermission);
        itemsListView.setLayoutManager(new LinearLayoutManager(this));

        // Initialize the adapter only if it's not already set
        if (itemRowAdapter == null) {
            itemRowAdapter = new PermissionsAdapter(this, itemsList);
            itemRowAdapter.setOnClickListener(new PermissionsAdapter.ItemClickListener() {
                @Override
                public void onItemClick(View view, int position) {
                    Intent intent = new Intent(Permissions.this, Workers.class);
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
        PermissionItem.List(area.getId(), new PermissionItem.ListResponse() {
            @Override
            public void response(ArrayList<PermissionItem> items) {
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