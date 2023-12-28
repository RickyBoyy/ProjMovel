package pt.iade.ricardopereira.qrity_admin;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.util.DisplayMetrics;
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

import java.util.ArrayList;
import java.util.List;

import pt.iade.ricardopereira.qrity_admin.adapters.WorkersAdapter;
import pt.iade.ricardopereira.qrity_admin.models.WorkersItem;

public class Workers extends AppCompatActivity {

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

        List<WorkersItem> workersItemList = getSampleWorkers();
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
            setupPopUpCustom(findViewById(R.id.addWorker));
            return true;


        }

        return super.onOptionsItemSelected(item);
    }
    private List<WorkersItem> getSampleWorkers() {

        List<WorkersItem> workersItemList = new ArrayList<>();
        workersItemList.add(new WorkersItem("João Silva", "Professor", 1));
        workersItemList.add(new WorkersItem("Maria Santos", "Coordenador", 2));
        workersItemList.add(new WorkersItem("Pedro Oliveira", "Assistente", 3));
        workersItemList.add(new WorkersItem("Ana Costa", "Técnico", 4));
        workersItemList.add(new WorkersItem("Miguel Ferreira", "Pesquisador", 5));
        workersItemList.add(new WorkersItem("Sofia Rocha", "Analista", 6));
        workersItemList.add(new WorkersItem("Carlos Pereira", "Engenheiro", 7));

        return workersItemList;
    }

    public void setupPopUpCustom(View anchorview){

        PopupWindow popupWindow = new PopupWindow(this);
        View popupView = LayoutInflater.from(this).inflate(R.layout.popup_search, null);
        popupWindow.setContentView(popupView);
        DisplayMetrics displayMetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        int screenWidth = displayMetrics.widthPixels;
        int screenHeight = displayMetrics.heightPixels;
        popupWindow.setWidth(screenWidth);
        popupWindow.setHeight(screenHeight);
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


    }

}

