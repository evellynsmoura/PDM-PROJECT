package br.com.projeto.numeroum;


import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.text.DecimalFormat;

public class CalculadoraIMCActivity extends AppCompatActivity {



  @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculadora_imc_activity);


        Button btnFechaAba = findViewById(R.id.btnFechaAba);

        btnFechaAba.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }



    public void calcular (View view) {

        //Instanciamento dos elementos views do arquivo xml

        EditText campoNome = findViewById(R.id.editTextNome);
        EditText campoPeso = findViewById(R.id.editTextPeso);
        EditText campoAltura = findViewById(R.id.editTextAltura);

        TextView resultado = findViewById(R.id.textResultado);

        //Extrair os objetos, recuperando os conteudos (texto)

        String nome = campoNome.getText().toString();
        String peso = campoPeso.getText().toString();
        String altura = campoAltura.getText().toString();

        //Convertendo para numerico

        Double numPeso = Double.parseDouble(peso);
        Double numAltura = Double.parseDouble(altura);
        Double numIMC = numPeso / (numAltura * numAltura);

        //Convertendo o resultado IMC para String
        String imc = String.valueOf(numIMC);

        //formatação para apresentar resultado
        DecimalFormat df = new DecimalFormat("##.##");
        imc = df.format(numIMC);

        //Apresentando o resultado
        //resultado.setText("IMC: " + imc);

        if (peso.isEmpty() || altura.isEmpty()) {
            resultado.setText("Por favor, insira pelo menos dois valores.");
            return;
        }

        if (numIMC <= 16.9) {
            imc = ("Magreza grave, seu IMC é: " + imc);
            resultado.setText(imc);

        }
        if (numIMC >= 17 && numIMC <= 18.4) {
            imc = "Magreza moderada, seu IMC é: " + imc;
            resultado.setText(imc);

        }
        if (numIMC >= 18.5 && numIMC <= 24.9) {
            imc = "Peso normal, seu IMC é: " + imc;
            resultado.setText(imc);

        }
        if (numIMC >= 25 && numIMC <= 29.9) {
            imc = "Acima do peso, seu IMC é: " + imc;
            resultado.setText(imc);

        }
        if (numIMC >= 30 && numIMC <= 34.5) {
            imc = "Obesidade Grau I, seu IMC é: " + imc;
            resultado.setText(imc);

        }
        if (numIMC >= 35 && numIMC <= 40) {
            imc = "Obesidade Grau II, seu IMC é: " + imc;
            resultado.setText(imc);

        }
        if (numIMC >= 41) {
            imc = "Obesidade Grau III, seu IMC é: " + imc;
            resultado.setText(imc);
        }
    }

    public void limpar (View view){

        TextView resultado = findViewById(R.id.textResultado);
        TextView campoNome = findViewById(R.id.editTextNome);
        TextView campoPeso = findViewById(R.id.editTextPeso);
        TextView campoAltura = findViewById(R.id.editTextAltura);

        resultado.setText("----");
        campoNome.setText("");
        campoPeso.setText("");
        campoAltura.setText("");
    }

}

