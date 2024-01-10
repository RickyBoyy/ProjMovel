package pt.iade.ricardopereira.qrity_admin;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import pt.iade.ricardopereira.qrity_admin.adapters.StatisticsAdapter;
import pt.iade.ricardopereira.qrity_admin.models.StatisticsItem;

public class Statistics extends AppCompatActivity {

    private static final String TAG = "Statistics";

    List<StatisticsItem> sectionList = new ArrayList<>();

    RecyclerView statisticsRecyclerView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_statistics);

        Toolbar toolbar = findViewById(R.id.toolbar_statistics);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Statistics");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        initData();

        statisticsRecyclerView = findViewById(R.id.mainRecyclerView);
        StatisticsAdapter mainRecyclerAdapter = new StatisticsAdapter(sectionList);
        statisticsRecyclerView.setAdapter(mainRecyclerAdapter);
        statisticsRecyclerView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));


    }

    private void initData() {

        String sectionOneName = "Most Used Door";
        List<String> sectionOneItems = new ArrayList<>();
        sectionOneItems.add("4");

        String sectionTwoName = "Less Used Door";
        List<String> sectionTwoItems = new ArrayList<>();
        sectionTwoItems.add("Sala de BlockChain");

        String sectionTreeName = "Role that opened more doors today";
        List<String> sectionTreeItems = new ArrayList<>();
        sectionTreeItems.add("Segurança");

        String sectionFourName = "Role that opened less doors today";
        List<String> sectionFourItems = new ArrayList<>();
        sectionFourItems.add("Administrador");

        String sectionFifthName = "Role that opened less doors today";
        List<String> sectionFifthItems = new ArrayList<>();
        sectionFifthItems.add("25");


        sectionList.add(new StatisticsItem(sectionOneName, sectionOneItems));
        sectionList.add(new StatisticsItem(sectionTwoName, sectionTwoItems));
        sectionList.add(new StatisticsItem(sectionTreeName, sectionTreeItems));
        sectionList.add(new StatisticsItem(sectionFourName, sectionFourItems));
        sectionList.add(new StatisticsItem(sectionFifthName, sectionFifthItems));

        Log.d(TAG, "initData: " + sectionList);

    }
}
