package pt.iade.ricardopereira.qrity_admin;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.PopupWindow;
import android.widget.TextView;

import androidx.appcompat.widget.Toolbar;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import pt.iade.ricardopereira.qrity_admin.adapters.WorkersAdapter;
import pt.iade.ricardopereira.qrity_admin.models.WorkersItem;

public class Workers extends AppCompatActivity {
    private static final int SEARCH_WORKER_ACTIVITY_RETURN_ID = 1;
    private RecyclerView recyclerView;

    private WorkersAdapter workersAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_workers);

        androidx.appcompat.widget.Toolbar toolbar = findViewById(R.id.toolbar_workers);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Workers");

        recyclerView = findViewById(R.id.recycleViewWorkers);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        ArrayList<WorkersItem> workersItemList = getSampleWorkers();
        workersAdapter = new WorkersAdapter(this, getSampleWorkers());
        recyclerView.setAdapter(workersAdapter);


    }

    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.worker_menu, menu);
        return super.onPrepareOptionsMenu(menu);
    }


    public boolean onOptionsItemSelected(MenuItem item) {

        if (item.getItemId() == R.id.addWorker) {
            Log.d("WorkersActivity", "Add Worker clicked");

            Intent intent = new Intent(Workers.this, SearchWorker.class);
            startActivity(intent);
            return true;


        }

        return super.onOptionsItemSelected(item);
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


    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        // Must be called always and before everything.
        super.onActivityResult(requestCode, resultCode, data);

        // Check which activity returned to us.
        if (requestCode == SEARCH_WORKER_ACTIVITY_RETURN_ID) {
            // Check if the activity was successful.
            if (resultCode == AppCompatActivity.RESULT_OK && data != null) {
                // Get extras returned to us.
                String[] names = data.getStringArrayExtra("arrayOfName");
                String[] cargos = data.getStringArrayExtra("arrayOfCargos");

                // Use the data as needed
                // For example, you might add a new WorkerItem to the list
                if (names != null && cargos != null && names.length > 0 && cargos.length > 0) {
                    WorkersItem newWorker = new WorkersItem(names[0], cargos[0], 0); // You might want to provide a unique ID
                    workersAdapter.addItem(newWorker);
                }
            }
        }
    }


    /*public void setupPopUpCustom(View anchorview){

        PopupWindow popupWindow = new PopupWindow(this);
        View popupView = LayoutInflater.from(this).inflate(R.layout.popup_search, null);
        popupWindow.setContentView(popupView);
        int popupSize = getResources().getDimensionPixelSize(R.dimen.popup_size); // Define the size in resources
        popupWindow.setWidth(popupSize);
        popupWindow.setHeight(popupSize);


        popupWindow.setFocusable(true);
        popupWindow.setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

        TextView titleTextView = popupView.findViewById(R.id.popupTitle);
        titleTextView.setText("Search Worker");

        Button closeButton = popupView.findViewById(R.id.closeButton);
        closeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                popupWindow.dismiss();
            }
        });

        popupWindow.showAtLocation(anchorview, Gravity.CENTER, 0, 0);


    }*/

    }



