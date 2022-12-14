package com.fjar.trasnportfast.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.fjar.trasnportfast.R;
import com.fjar.trasnportfast.ui.empresa.dto_empresa;
import com.fjar.trasnportfast.ui.empresa.empresaCRUD;

public class Registrar extends AppCompatActivity {
    private Button btnRegistrar;
    private TextView login;
    private EditText nombre, telefono, correo, direccion, CP, clave;
    private empresaCRUD CRUD = new empresaCRUD();
    private dto_empresa dtoEmpresa = new dto_empresa();

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrar);
        nombre = (EditText) findViewById(R.id.edt_NomEmp);
        telefono = (EditText) findViewById(R.id.edt_NumEmp);
        correo = (EditText) findViewById(R.id.edt_correoEmp);
        direccion = (EditText) findViewById(R.id.edt_direccionEmp);

        CP = (EditText) findViewById(R.id.edt_codigoP);
        clave = (EditText) findViewById(R.id.edt_claveEmp);
        btnRegistrar = (Button) findViewById(R.id.btn_registrar);
        login = (TextView) findViewById(R.id.btn_Login);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), Login.class);
                startActivity(intent);
            }
        });




        btnRegistrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Pasar datos de los edit text a variables String
                dtoEmpresa.setNombre(nombre.getText().toString());
                dtoEmpresa.setTelefono(telefono.getText().toString());
                dtoEmpresa.setCorreo(correo.getText().toString());
                dtoEmpresa.setDireccion(direccion.getText().toString());
                dtoEmpresa.setCodigo_postal(CP.getText().length());
                dtoEmpresa.setClave(clave.getText().toString());
                if(dtoEmpresa.getNombre().length() == 0){
                    nombre.setError("Campo obligatorio.");
                }else if(dtoEmpresa.getTelefono().length() == 0){
                    telefono.setError("Campo obligatorio.");
                }else if(dtoEmpresa.getCorreo().length() == 0){
                    correo.setError("Campo obligatorio.");
                }else if(dtoEmpresa.getDireccion().length() == 0){
                    direccion.setError("Campo obligatorio.");
                }else if(dtoEmpresa.getCodigo_postal() == 0){
                    CP.setError("Campo obligatorio.");
                }else if(dtoEmpresa.getClave().length() == 0){
                    clave.setError("Campo obligatorio.");
                }else{
                    CRUD.registrarUsuario(Registrar.this, dtoEmpresa);
                }
            }
        });
    }
}