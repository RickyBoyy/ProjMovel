package pt.iade.ricardopereira.qrity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.gson.Gson;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import pt.iade.ricardopereira.qrity.models.UserItem;

public class MainActivity extends AppCompatActivity {

    EditText username;
    EditText password;
    Button loginButton;
    public static final MediaType aaa = MediaType.parse("application/json; charset=utf-8");
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        username = findViewById(R.id.editTextUsername);
        password = findViewById(R.id.editTextPassword);
        loginButton = findViewById(R.id.loginButton);

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Perform login with OkHttp request
                performLogin(username.getText().toString(), password.getText().toString());
            }
        });
    }

    private void performLogin(String username, String password) {
        String url = "http://10.0.2.2:8080/api/user/login";

        UserItem login = new UserItem(0, username, password, 0);
        String json = new Gson().toJson(login);

        MediaType jsonMediaType = MediaType.parse("application/json; charset=utf-8");
        RequestBody requestBody = RequestBody.create(jsonMediaType, json);

        Request request = new Request.Builder()
                .url(url)
                .post(requestBody)
                .build();

        new OkHttpClient().newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        // Handle failure on the UI thread
                        Toast.makeText(MainActivity.this, "Login Failed. Exception: " + e.getMessage(), Toast.LENGTH_SHORT).show();
                        clearEditTexts();
                    }
                });
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                if (response.isSuccessful()) {
                    final String responseBody = response.body().string();
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            handleLoginResponse(responseBody);
                        }
                    });
                } else {
                    // Handle other scenarios (e.g., 401, other HTTP status codes)
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            Toast.makeText(MainActivity.this, "Login Failed. HTTP Status Code: " + response.code(), Toast.LENGTH_SHORT).show();
                            clearEditTexts();
                        }
                    });
                }
            }
        });
    }

    private void handleLoginResponse(String responseBody) {
        // TODO: Parse and handle the response as needed
        // For example, extract data from responseBody and start a new activity
        Intent intent = new Intent(MainActivity.this, CameraScan.class);
        // Set any necessary extras
        startActivity(intent);
        Toast.makeText(MainActivity.this, "Login Successful", Toast.LENGTH_SHORT).show();
        saveLoginState(username.getText().toString());
        clearEditTexts();
    }

    private void saveLoginState(String username) {
        SharedPreferences sharedPreferences = getSharedPreferences("MyAppPrefs", MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putBoolean("isLoggedIn", true);
        editor.putString("username", username);
        editor.apply();
    }

    private void clearEditTexts() {
        username.setText("");
        password.setText("");
    }
}
