package pt.iade.ricardopereira.qrity_admin;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.Toolbar;

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

        Toolbar toolbar =  findViewById(R.id.toolbar_permissions);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Permissions");

        recyclerView = findViewById(R.id.recyclerViewPermission);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        List<PermissionItem> permissionItemList = getSamplePermissions();

        permissionsAdapter = new PermissionsAdapter(this, getSamplePermissions());
        recyclerView.setAdapter(permissionsAdapter);






        //get items from the server
    }
    private List<PermissionItem> getSamplePermissions() {
        List<PermissionItem> permissionItemList = new ArrayList<>();
        permissionItemList.add(new PermissionItem("door_name", "area_name", 1));
        permissionItemList.add(new PermissionItem("door_name", "area_name", 2));

        return permissionItemList;
    }


    private void setSupportActionBar(Toolbar toolbar) {
    }
}