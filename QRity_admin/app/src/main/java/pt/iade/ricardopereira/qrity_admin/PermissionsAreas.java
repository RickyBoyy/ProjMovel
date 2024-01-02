package pt.iade.ricardopereira.qrity_admin;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

import pt.iade.ricardopereira.qrity_admin.adapters.PermissionsAdapter;
import pt.iade.ricardopereira.qrity_admin.adapters.PermissionsAreasAdapter;
import pt.iade.ricardopereira.qrity_admin.models.PermissionAreasItem;
import pt.iade.ricardopereira.qrity_admin.models.PermissionItem;

public class PermissionsAreas extends AppCompatActivity {
    private RecyclerView recyclerView;

    private PermissionsAreasAdapter permissionsAreasAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_permissions_areas);

        setupcomponentsPermissionsAreas();
    }
    private void setupcomponentsPermissionsAreas(){
        androidx.appcompat.widget.Toolbar toolbar = findViewById(R.id.toolbar_permissions);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Permissions");

        recyclerView = findViewById(R.id.recyclerViewPermissionAreas);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        ArrayList<PermissionAreasItem> permissionItemList = getSamplePermissionsAreas();

        permissionsAreasAdapter = new PermissionsAreasAdapter(this, getSamplePermissionsAreas());
        recyclerView.setAdapter(permissionsAreasAdapter);
        permissionsAreasAdapter.setOnClickListener(new PermissionsAreasAdapter.ItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                Intent intent = new Intent(PermissionsAreas.this, Permissions.class);
                intent.putExtra("selectedDoor", permissionItemList.get(position));
                startActivity(intent);
            }
        });

    }
    private ArrayList<PermissionAreasItem> getSamplePermissionsAreas() {
        ArrayList<PermissionAreasItem> permissionItemList = new ArrayList<>();
        permissionItemList.add(new PermissionAreasItem("Tech Floor", 1));
        permissionItemList.add(new PermissionAreasItem( "6th floor", 2));
        permissionItemList.add(new PermissionAreasItem( "Garden", 3));
        permissionItemList.add(new PermissionAreasItem( "1st floor", 4));
        permissionItemList.add(new PermissionAreasItem( "Main Lobby", 5));
        permissionItemList.add(new PermissionAreasItem( "Basement", 6));
        permissionItemList.add(new PermissionAreasItem( "5th floor", 7));


        return permissionItemList;
    }
}