package pt.iade.ricardopereira.qrity_admin;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import java.lang.reflect.Array;
import java.util.ArrayList;

import pt.iade.ricardopereira.qrity_admin.models.DoorItem;

public class Permissions extends AppCompatActivity {
    ArrayList<DoorItem> itemsList;

    protected DoorItem item;

    protected int listPosition;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_permissions);

        //get items from the server
        itemsList = DoorItem.arrayList();
    }
}