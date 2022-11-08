package com.fjar.trasnportfast.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.fjar.trasnportfast.R;
import com.fjar.trasnportfast.Tipo;

public class Login extends AppCompatActivity {
    private TextView tvRegistrarse;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        tvRegistrarse = (TextView) findViewById(R.id.btnRegistrarEmpresa);

        tvRegistrarse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Registrar.class);
                startActivity(intent);
            }
        });
    }
}