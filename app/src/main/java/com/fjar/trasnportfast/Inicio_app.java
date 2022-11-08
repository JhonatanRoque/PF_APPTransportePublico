package com.fjar.trasnportfast;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Inicio_app extends AppCompatActivity {
    private Button btnEmpresa, btnUsuario;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inicio_app);
        btnEmpresa = (Button) findViewById(R.id.btnempresa);
        btnUsuario = (Button) findViewById(R.id.btnUsuario);

        btnEmpresa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Tipo.class);
                startActivity(intent);
            }
        });

    }
}