package pt.iade.ricardopereira.qrity_admin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class SplashScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);


        if (getSupportActionBar() != null) {
        getSupportActionBar().hide();
    }


        new Handler().postDelayed(new Runnable() {
        @Override
        public void run() {
            Intent intent = new Intent(SplashScreen.this, MainActivity.class);
            startActivity(intent);
            finish(); // Finish the splash screen activity
        }
    }, 3000); // 3000 milliseconds (3 seconds)
}
}
