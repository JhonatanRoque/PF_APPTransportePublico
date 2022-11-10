package com.fjar.trasnportfast.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import com.fjar.trasnportfast.MainActivity;
import com.fjar.trasnportfast.R;
import com.fjar.trasnportfast.ui.empresa.dto_empresa;
import com.fjar.trasnportfast.ui.empresa.empresaCRUD;


public class Login extends AppCompatActivity {
    private Button  btnIniciar;
    private TextView btnRegistrar;
    private EditText Nempresa, contrasena;
    private Switch holdSession;
    private dto_empresa empresa = new dto_empresa();
    private empresaCRUD CRUD = new empresaCRUD();

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super
                .onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        empresa = new dto_empresa();
        //Instanciamos nuestros componentes
        Nempresa = (EditText) findViewById(R.id.etuser);
        contrasena = (EditText) findViewById(R.id.etclave);
        holdSession = (Switch) findViewById(R.id.mantener);
        btnRegistrar = (TextView) findViewById(R.id.btnRegistrarEmp);
        btnIniciar = (Button) findViewById(R.id.btn_log);




        //Funcion de los botones
        btnRegistrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent cambiarVista = new Intent(Login.this, Registrar.class);
                startActivity(cambiarVista);
            }
        });
        btnIniciar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String usu = Nempresa.getText().toString();
                String contra = contrasena.getText().toString();

                if(usu.length() == 0){
                    Nempresa.setError("Campo obligatorio");
                }else if(contra.length() == 0){
                    contrasena.setError("Campo obligatorio");
                }else{
                    empresa.setNombre(usu);
                }
                empresa.setClave(contra);

                CRUD.IniciarSesionemp(Login.this, empresa, holdSession);

                Intent nueva = new Intent(Login.this, MainActivity.class);
                startActivity(nueva);
            }


        });
    }
}