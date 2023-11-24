package pt.iade.ricardopereira.qrity_admin;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;


import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;

import pt.iade.ricardopereira.qrity_admin.Notifications;
import pt.iade.ricardopereira.qrity_admin.Permissions;
import pt.iade.ricardopereira.qrity_admin.R;
import pt.iade.ricardopereira.qrity_admin.WorkerLog;

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


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        drawerLayout = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.nav_view);
        drawerToggle= new ActionBarDrawerToggle(this,drawerLayout,R.string.open,R.string.close);
        drawerLayout.addDrawerListener(drawerToggle);
        drawerToggle.syncState();
        setSupportActionBar(findViewById(R.id.toolbar));
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int id = item.getItemId();

                if (id == R.id.statistics) {
                    Toast.makeText(Menu.this,"Statistics selected",Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(Menu.this, Statistics.class);
                    startActivity(intent);

                } else if (id == R.id.workerlog) {
                    Toast.makeText(Menu.this,"WorkerLog selected",Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(Menu.this, WorkerLog.class);
                    startActivity(intent);


                } else if (id == R.id.notifications) {
                    Toast.makeText(Menu.this,"Notification selected",Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(Menu.this, Notifications.class);
                    startActivity(intent);


                } else if (id == R.id.scan) {
                    Toast.makeText(Menu.this,"Scan selected",Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(Menu.this, Scan_screen.class);
                    startActivity(intent);


                }
                else if (id == R.id.permission)

                {
                    Toast.makeText(Menu.this, "Permission selected", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(Menu.this, Permissions.class);
                    startActivity(intent);


                }

                return false;
            }
        });

    }



}