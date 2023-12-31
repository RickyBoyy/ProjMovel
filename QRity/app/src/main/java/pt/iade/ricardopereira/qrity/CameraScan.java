package pt.iade.ricardopereira.qrity;

import android.os.Bundle;

import androidx.activity.result.ActivityResultLauncher;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.journeyapps.barcodescanner.ScanContract;
import com.journeyapps.barcodescanner.ScanOptions;

public class CameraScan extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
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
        AlertDialog.Builder builder = new AlertDialog.Builder(CameraScan.this);
        builder.setTitle("Result");
        builder.setMessage(contents);
        builder.setPositiveButton("Authorized", (dialogInterface, i) ->{


            dialogInterface.dismiss();

        }).show();

    }
}
