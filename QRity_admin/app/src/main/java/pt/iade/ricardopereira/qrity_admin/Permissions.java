package pt.iade.ricardopereira.qrity_admin;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.widget.Toolbar;

import java.util.ArrayList;
import java.util.List;

import pt.iade.ricardopereira.qrity_admin.adapters.PermissionsAdapter;
import pt.iade.ricardopereira.qrity_admin.models.NotificationItem;
import pt.iade.ricardopereira.qrity_admin.models.PermissionItem;

public class Permissions extends AppCompatActivity {

    private RecyclerView recyclerView;

    private PermissionsAdapter permissionsAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_permissions);

        androidx.appcompat.widget.Toolbar toolbar = findViewById(R.id.toolbar_permissions);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Permissions");

        recyclerView = findViewById(R.id.recyclerViewPermission);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        List<PermissionItem> permissionItemList = getSamplePermissions();

        permissionsAdapter = new PermissionsAdapter(this, getSamplePermissions());
        recyclerView.setAdapter(permissionsAdapter);
        permissionsAdapter.setOnClickListener(new PermissionsAdapter.ItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                Intent intent = new Intent(Permissions.this, Workers.class);
                intent.putExtra("selectedDoor", permissionItemList.get(position));
                startActivity(intent);
            }
        });


        //get items from the server
    }

    private List<PermissionItem> getSamplePermissions() {
        List<PermissionItem> permissionItemList = new ArrayList<>();
        permissionItemList.add(new PermissionItem("Server Room", "Tech Floor", 1));
        permissionItemList.add(new PermissionItem("Rooftop", "6th floor", 2));
        permissionItemList.add(new PermissionItem("Basement", "Main Lobby", 3));
        permissionItemList.add(new PermissionItem("Classroom A", "1st floor", 4));
        permissionItemList.add(new PermissionItem("Kitchen", "Main Lobby", 5));
        permissionItemList.add(new PermissionItem("Photography Room", "Basement", 6));
        permissionItemList.add(new PermissionItem("Archive Room", "5th floor", 7));


        return permissionItemList;
    }
}


