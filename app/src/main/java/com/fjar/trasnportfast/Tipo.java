package com.fjar.trasnportfast;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.fjar.trasnportfast.ui.Login;

public class Tipo extends AppCompatActivity {
    private Button btnAdministrador, btnConductor;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tipo);
        btnAdministrador = (Button) findViewById(R.id.btnadministrador);
        btnConductor = (Button) findViewById(R.id.btnConductor);
        btnAdministrador.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Login.class);
                startActivity(intent);
            }
        });
    }
}