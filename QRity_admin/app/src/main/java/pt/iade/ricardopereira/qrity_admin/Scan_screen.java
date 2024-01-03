package pt.iade.ricardopereira.qrity_admin;


import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import androidx.activity.result.ActivityResultLauncher;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.journeyapps.barcodescanner.ScanContract;
import com.journeyapps.barcodescanner.ScanOptions;

public class Scan_screen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        // Call scanCode method directly when the activity is created
        scanCode();

    }

    private void scanCode() {
        ScanOptions options = new ScanOptions();
        options.setPrompt("Volume up to flash");
        options.setBeepEnabled(true);
        options.setOrientationLocked(true);
        options.setCaptureActivity(CaptureAct.class);
        barLauncher.launch(options);


    }

    ActivityResultLauncher<ScanOptions> barLauncher = registerForActivityResult(new ScanContract(), result -> {
        if (result.getContents() != null) {
            showResultDialog(result.getContents());

        }

    });
    private void showResultDialog(String contents) {
        AlertDialog.Builder builder = new AlertDialog.Builder(Scan_screen.this);
        builder.setTitle("Result");
        builder.setMessage(contents);
        builder.setPositiveButton("Authorized", (dialogInterface, i) ->{

                
                dialogInterface.dismiss();
                finish();
        }).show();

    }


}