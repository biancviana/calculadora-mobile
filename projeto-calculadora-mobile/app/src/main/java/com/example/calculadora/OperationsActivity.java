package com.example.calculadora;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class OperationsActivity extends AppCompatActivity implements View.OnClickListener {

    private String operation = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_operations);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        Button btVoltar = findViewById(R.id.btVoltar);
        btVoltar.setOnClickListener(this);

        Button btCalcular = findViewById(R.id.btCalcular);
        btCalcular.setOnClickListener(this);

        TextView tvTitulo = findViewById(R.id.tvTitulo);

        String titulo = getIntent().getStringExtra("operacao");
        operation = titulo;
        tvTitulo.setText(titulo.concat(" números"));

    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btVoltar) {
            finish();
        } else if (v.getId() == R.id.btCalcular) {
            calculate();
        }
    }

    private void calculate() {
        EditText etNumero1 = findViewById(R.id.etNumero1);
        EditText etNumero2 = findViewById(R.id.etNumero2);

        int n1 = Integer.parseInt(etNumero1.getText().toString());
        int n2 = Integer.parseInt(etNumero2.getText().toString());

        int result = 0;

        switch (operation) {
            case "Somar":
                result = n1 + n2;
                break;
            case "Subtrair":
                result = n1 - n2;
                break;
            case "Multiplicar":
                result = n1 * n2;
                break;
            case "Dividir":
                result = n1 / n2;
                break;
        }

        Toast.makeText(OperationsActivity.this,
                "Resultado: ".concat(String.valueOf(result)),
                Toast.LENGTH_LONG)
                .show();
    }
}