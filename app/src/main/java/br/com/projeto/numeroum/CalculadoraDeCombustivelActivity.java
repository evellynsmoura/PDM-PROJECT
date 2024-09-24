package br.com.projeto.numeroum;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class CalculadoraDeCombustivelActivity extends AppCompatActivity {

    private EditText editGasolina, editAlcool;
    private RadioGroup radioGroup;
    private TextView textResultadoCombus;
    private Button btnCombustivel;
    public Button btnFecharAba;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculadora_de_combustivel);

        // declarando as variaveis e botões
        editGasolina = findViewById(R.id.editGasolina);
        editAlcool = findViewById(R.id.editAlcool);
        radioGroup = findViewById(R.id.radioGroup);
        textResultadoCombus = findViewById(R.id.textResultadoCombus);
        btnCombustivel = findViewById(R.id.btnCombustivel);
        btnFecharAba = findViewById(R.id.btnFecharAba);

        //setando para calcular
        btnCombustivel.setOnClickListener(v -> calcularValor());

        //fechando a aba da activity
        btnFecharAba.setOnClickListener(v -> finish());

        radioGroup.setOnCheckedChangeListener((group, checkedId) -> calcularValor());
    }

    private void calcularValor() {
        String gasolinaStr = editGasolina.getText().toString();
        String alcoolStr = editAlcool.getText().toString();

        if (gasolinaStr.isEmpty() || alcoolStr.isEmpty()) {
            textResultadoCombus.setText("Por favor, insira ambos os valores.");
            return;
        }

        double gasolina = Double.parseDouble(gasolinaStr);
        double alcool = Double.parseDouble(alcoolStr);

        double valorReferencia = gasolina * 0.7;

        String combustivelEscolhido = "Gasolina"; // Padrão
        double diferenca = 0;

        // Verificar o tipo de combustível selecionado
        int selectedId = radioGroup.getCheckedRadioButtonId();
        RadioButton radioButton = findViewById(selectedId);

        if (radioButton != null) {
            combustivelEscolhido = radioButton.getText().toString();
            if (combustivelEscolhido.equals("Álcool")) {
                diferenca = (alcool - valorReferencia) / valorReferencia * 100; // percentual
            } else {
                diferenca = (gasolina - valorReferencia) / valorReferencia * 100; // percentual
            }
        }

        String mensagem = String.format("Escolha: %s\nDiferença: %.2f%% acima de 70%%", combustivelEscolhido, diferenca);
        textResultadoCombus.setText(mensagem);
    }
}
