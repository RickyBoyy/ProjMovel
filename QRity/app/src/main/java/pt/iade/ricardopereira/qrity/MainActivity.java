package pt.iade.ricardopereira.qrity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    EditText username;
    EditText password;

    Button loginButton;

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
            if(username.getText().toString().equals("worker_name") && password.getText().toString().equals("worker_password")){
                Toast.makeText(MainActivity.this, "Login Sucessful", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(MainActivity.this,CameraScan.class);
                startActivity(intent);
            }else{
                Toast.makeText(MainActivity.this, "Login Failed", Toast.LENGTH_SHORT).show();
                username.setText("");
                password.setText("");
            }
        }
    });
    }
}