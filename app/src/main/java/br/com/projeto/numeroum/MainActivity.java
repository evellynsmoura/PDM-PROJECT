package br.com.projeto.numeroum;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnIMC = findViewById(R.id.btnIMC);
        btnIMC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, CalculadoraIMCActivity.class);
                startActivity(intent);
            }
        });

        Button btnCombustivel = findViewById(R.id.btnCombustivel);
        btnCombustivel.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, CalculadoraDeCombustivelActivity.class);
            startActivity(intent);
        });


        Button btnApresentacao = findViewById(R.id.btnApresentacao);
        btnApresentacao.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, ApresentacaoActivity.class);
            startActivity(intent);
        });

        Button btnFechar = findViewById(R.id.btnFechar);
        btnFechar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish(); // Encerra a Activity atual
            }
        });
    }
}
