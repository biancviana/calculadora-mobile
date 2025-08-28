package com.example.calculadora;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        Button btEntrar = findViewById(R.id.btEntrar);
        btEntrar.setOnClickListener(this);

        Button btViagem = findViewById(R.id.btViagem);
        btViagem.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        // assim que o botão de entrar for clicado, vai abrir a tela home
        if (v.getId() == R.id.btEntrar) {
            Intent home = new Intent(MainActivity.this, HomeActivity.class); //intent são ações
            startActivity(home);
        } else if (v.getId() == R.id.btViagem) {
            Intent travel = new Intent(MainActivity.this, TravelActivity.class);
            startActivity(travel);
        }
    }
}