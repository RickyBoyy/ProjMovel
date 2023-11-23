package pt.iade.ricardopereira.qrity_admin;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;


import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;

public class Menu extends AppCompatActivity {
    DrawerLayout drawerLayout;
    NavigationView navigationView;
    ActionBarDrawerToggle drawerToggle;




    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (drawerToggle.onOptionsItemSelected(item)) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        drawerLayout = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.nav_view);
        drawerToggle = new ActionBarDrawerToggle(this, drawerLayout, R.string.open, R.string.close);
        drawerLayout.addDrawerListener(drawerToggle);
        drawerToggle.syncState();
        setSupportActionBar(findViewById(R.id.toolbar));
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int id = item.getItemId();

                if (id == R.id.statistics) {
                    Toast.makeText(Menu.this, "Statistics selected", Toast.LENGTH_SHORT).show();
                } else if (id == R.id.workerlog) {
                    //printing a table
                    Toast.makeText(Menu.this, "WorkerLog selected", Toast.LENGTH_SHORT).show();
                } else if (id == R.id.notifications) {
                    Toast.makeText(Menu.this, "notifications selected", Toast.LENGTH_SHORT).show();
                } else if (id == R.id.scan) {
                    Toast.makeText(Menu.this, "Scan selected", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(Menu.this, CameraScan.class);
                    startActivity(intent);
                } else if (id == R.id.permission) {
                    Toast.makeText(Menu.this, "Permission selected", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(Menu.this, Permissions.class);
                    startActivity(intent);

                }

                return false;
            }
        });
    }





    @Override
    public void onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }


}









