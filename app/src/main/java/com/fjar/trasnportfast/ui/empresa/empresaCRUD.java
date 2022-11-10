package com.fjar.trasnportfast.ui.empresa;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;
import android.widget.Switch;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.fjar.trasnportfast.MySingleton;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class empresaCRUD {
    public void registrarUsuario(final Context context, dto_empresa empresa) {
        String url = "https://franciscowebtw.000webhostapp.com/transporte2022/registrarEmpresa.php";
        StringRequest request = new StringRequest(Request.Method.POST,url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONObject requestJSON = new JSONObject(response.toString());
                    String estado = requestJSON.getString("estado");
                    String mensaje = requestJSON.getString("mensaje");
                    if(estado.equals("1")){
                        Toast.makeText(context, mensaje, Toast.LENGTH_SHORT).show();
                        //Toast.makeText(context, "Registro almacenado en MySQL.", Toast.LENGTH_SHORT).show();
                    }else{
                        Toast.makeText(context, "Error: "+mensaje, Toast.LENGTH_SHORT).show();
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError volleyError) {
                Toast.makeText(context, "No se pudo registrar. \n" +"Intentelo más tarde.", Toast.LENGTH_SHORT).show();
            }
        }) {
            protected Map<String, String> getParams() throws AuthFailureError {
                //En este método se colocan o se setean los valores a recibir por el fichero *.php
                Map<String, String> map = new HashMap<>();
                map.put("Content-Type", "application/json; charset=utf-8");
                map.put("Accept", "application/json");
                map.put("nombres", empresa.getNombre());
                map.put("telefono", empresa.getTelefono());
                map.put("correo", empresa.getCorreo());
                map.put("direccion", empresa.getDireccion());
                map.put("codigoPostal", String.valueOf(empresa.getCodigo_postal()));
                map.put("contrasena", empresa.getClave());

                return map;
            }
        };
        Log.e("URL", request.getUrl().toString());
        MySingleton.getInstance(context).addToRequestQueue(request);
    }
    //Método par inicar sesion
    public void IniciarSesionemp(final Context context, dto_empresa empresa, Switch mantener) {
        String url = "https://franciscowebtw.000webhostapp.com/transporte2022/iniciarSesionEmpresa.php";
        StringRequest request = new StringRequest(Request.Method.POST,url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONObject requestJSON = new JSONObject(response.toString());
                    if(requestJSON.has("mensaje") == false){
                        String id = requestJSON.getString("id");
                        String empresa = requestJSON.getString("empresa");


                        if(id.length() > 0){
                            Toast.makeText(context, "¡Bienvenido!", Toast.LENGTH_SHORT).show();
                            SharedPreferences spUsuario = context.getSharedPreferences("login", context.MODE_PRIVATE);
                            String estado = "logON";
                            SharedPreferences.Editor editor = spUsuario.edit();
                            editor.putString("estado", estado);
                            //Si se establecio la opcion de mantener iniciada sesion
                            if(mantener.isChecked()){

                                editor.putString("id", id);


                            }
                            editor.putString("nombre", empresa);
                            editor.commit();

                        }else {
                            Toast.makeText(context, "Usuario o contraseña incorrectos", Toast.LENGTH_SHORT).show();
                        }
                    }else{
                        String mensaje = requestJSON.getString("mensaje");
                        Toast.makeText(context, "" + mensaje, Toast.LENGTH_SHORT).show();

                    }


                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError volleyError) {
                Toast.makeText(context, "No se pudo iniciar session. \n" +"Intentelo más tarde." + volleyError.toString(), Toast.LENGTH_SHORT).show();
            }
        }) {
            protected Map<String, String> getParams() throws AuthFailureError {
                //En este método se colocan o se setean los valores a recibir por el fichero *.php
                Map<String, String> map = new HashMap<>();
                if(empresa.getNombre() != null){
                    map.put("Content-Type", "application/json; charset=utf-8");
                    map.put("Accept", "application/json");
                    map.put("empresa", empresa.getNombre());
                    map.put("contrasena", empresa.getClave());
                }

                return map;
            }
        };
        Log.e("URL", request.getUrl().toString());
        MySingleton.getInstance(context).addToRequestQueue(request);
    }
}
