package com.example.calculadora;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class TravelActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_travel);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        Button btVoltar = findViewById(R.id.btVoltarViagem);
        btVoltar.setOnClickListener(this);

        Button btCalcular = findViewById(R.id.btCalcularViagem);
        btCalcular.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btVoltarViagem) {
            finish();
        } else if (v.getId() == R.id.btCalcularViagem) {
            calculate();
        }
    }

    private void calculate() {
        EditText etDistancia = findViewById(R.id.etDistancia);
        EditText etLitro = findViewById(R.id.etLitro);
        EditText etQuilometros = findViewById(R.id.etQuilometros);

        String distanciaStr = etDistancia.getText().toString().trim();
        String valorLitroStr = etLitro.getText().toString().trim();
        String consumoStr = etQuilometros.getText().toString().trim();

        if (distanciaStr.isEmpty() || valorLitroStr.isEmpty() || consumoStr.isEmpty()) {
            Toast.makeText(
                    TravelActivity.this,
                    "Preencha todos os campos antes de calcular!",
                    Toast.LENGTH_SHORT
            ).show();
            return;
        }

        int distancia = Integer.parseInt(distanciaStr);
        int valorLitro = Integer.parseInt(valorLitroStr);
        int consumo = Integer.parseInt(consumoStr);

        int litrosNecessarios = distancia / consumo;
        int custo = litrosNecessarios * valorLitro;

        Toast.makeText(TravelActivity.this,
                        "O custo da sua viagem é: R$".concat(String.valueOf(custo)),
                        Toast.LENGTH_LONG).show();
    }
}