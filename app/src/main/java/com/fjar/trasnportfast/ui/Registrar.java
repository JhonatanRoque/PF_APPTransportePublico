package com.fjar.trasnportfast.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import com.fjar.trasnportfast.R;

public class Registrar extends AppCompatActivity {
    private EditText nombre, telefono, correo, direccion, codigoPostal, contrasena;
    private Button btnRegistrar, btnvolver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrar);
        nombre = (EditText) findViewById(R.id.edt_NomEmp);
        telefono = (EditText) findViewById(R.id.edt_NumEmp);
        correo = (EditText) findViewById(R.id.edt_correoEmp);
        direccion = (EditText) findViewById(R.id.edt_direccionEmp);
        codigoPostal = (EditText) findViewById(R.id.edt_codigoP);
        contrasena = (EditText) findViewById(R.id.edt_claveEmp);


    }
}