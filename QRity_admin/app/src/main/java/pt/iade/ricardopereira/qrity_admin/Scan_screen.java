package pt.iade.ricardopereira.qrity_admin;

import android.os.Bundle;


import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;

import androidx.annotation.Nullable;

import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;

public class Scan_screen extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Inicia o scanner
        new IntentIntegrator(this).initiateScan();
    }

    // Método chamado após o resultado do scan
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        IntentResult result = IntentIntegrator.parseActivityResult(requestCode, resultCode, data);
        if (result != null) {
            if (result.getContents() != null) {
                // O resultado do scan está em result.getContents()
                String scannedData = result.getContents();
                // Faça o que você precisa com os dados escaneados
            } else {
                // Se o usuário cancelar o scan
                // Faça algo aqui, se necessário
            }
            finish(); // Encerra a atividade após o scan
        }
    }
}
