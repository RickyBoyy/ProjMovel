package pt.iade.ricardopereira.qrity_admin;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import java.util.ArrayList;

import pt.iade.ricardopereira.qrity_admin.models.WorkerItem;

public class ItemEditorActivity extends AppCompatActivity {

    ArrayList<WorkerItem> workerList;
    protected WorkerItem item;
    protected int listPosition;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_editor);



        Intent intent = getIntent();
        listPosition = intent.getIntExtra("position", -1);


        item = (WorkerItem) intent.getIntExtra("door_name", );//falta busca do id da porta?

        setupComponents();
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId() == R.id.action_new_item){
            //acrescentar um worker ha porta
            //fzr uma nova janela com o search e a seta com opções de cargo
            finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }



    private void setupComponents() {

        setSupportActionBar(findViewById(R.id.toolbar_workers));

        //setup components da widget


        //populate views
    }
    protected void populateView(){

    }
}