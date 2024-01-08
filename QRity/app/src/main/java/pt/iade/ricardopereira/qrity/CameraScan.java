package pt.iade.ricardopereira.qrity;

import android.os.Bundle;

import androidx.activity.result.ActivityResultLauncher;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonSyntaxException;
import com.journeyapps.barcodescanner.ScanContract;
import com.journeyapps.barcodescanner.ScanOptions;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.HashMap;

import pt.iade.ricardopereira.qrity.utilities.WebRequest;

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

        if (contents.equalsIgnoreCase("unauthorized")) {
            // Extract username from the contents (you may need to adjust this based on your response format)
            String username = extractUsername(contents);

            builder.setMessage("Unauthorized access for user: " + username);
            builder.setPositiveButton("OK", (dialogInterface, i) -> {
                dialogInterface.dismiss();
                try {
                    sendUnauthorizedNotification(username);
                } catch (MalformedURLException e) {
                    throw new RuntimeException(e);
                }
            }).show();
        } else {
            builder.setMessage(contents);
            builder.setPositiveButton("Authorized", (dialogInterface, i) -> {
                dialogInterface.dismiss();
            }).show();
        }
    }

    private String extractUsername(String contents) {
        // Implement logic to extract the username from the response (adjust based on your response format)
        // For example, if the response is JSON, you might use a JSON library to parse it.
        // Modify this method according to your server's response format.

        // Sample logic (modify as needed):
        try {
            Gson gson = new Gson();
            JsonObject jsonObject = gson.fromJson(contents, JsonObject.class);
            if (jsonObject.has("username")) {
                return jsonObject.get("username").getAsString();
            }
        } catch (JsonSyntaxException e) {
            e.printStackTrace();
        }

        return "UnknownUser";
    }

    private void sendUnauthorizedNotification(String username) throws MalformedURLException {
        // Implement the logic to send a notification to the web server indicating unauthorized access for the given username.
        // You can use the WebRequest class to perform a POST request with the necessary information.

        // Sample logic (modify as needed):
        WebRequest webRequest = new WebRequest(new URL(WebRequest.LOCALHOST + "/api/notifications/unauthorized-access"));
        HashMap<String, String> params = new HashMap<>();
        params.put("username", username);

        try {
            webRequest.performPostRequest(params, null, "application/x-www-form-urlencoded");
        } catch (IOException | URISyntaxException e) {
            e.printStackTrace();
        }
    }
}