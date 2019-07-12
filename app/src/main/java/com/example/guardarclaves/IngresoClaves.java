package com.example.guardarclaves;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.Map;

public class IngresoClaves extends AppCompatActivity {

    private EditText etTitulo, etContraseña, etUrl, etDescripcion;
    private Button btnGuardar, btnVolver;
    private Contrasenas guardar ;
    private int idMayor=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ingreso_claves);

        etTitulo = findViewById(R.id.etTitulo);
        etContraseña = findViewById(R.id.etContraseña);
        etUrl = findViewById(R.id.etUrl);
        etDescripcion = findViewById(R.id.etDescripcion);
        btnGuardar = findViewById(R.id.btnGuardar);
        btnVolver = findViewById(R.id.btnVolver);

        btnGuardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


            }
        });
        btnVolver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent menuV = new Intent(IngresoClaves.this, Menu.class);
                startActivity(menuV);

            }
        });
    }
    public void registrar (View v){
        AdministradorBaseDatos adm = new AdministradorBaseDatos(this,"administracion",null,1);
        SQLiteDatabase BaseDatos = adm.getWritableDatabase();
        Buscar(v);
        String usu, clave,claveSegura;
        String[] arreglo;//esta variable es un arreglo simple.
        Usuario usua=null;
        SharedPreferences preferences = getSharedPreferences("chao", Context.MODE_PRIVATE);
        Map<String, ?> keys = preferences.getAll();
        for (Map.Entry<String, ?> item : keys.entrySet()) {
            arreglo = item.getValue().toString().split(";");
            usu = item.getKey();
            clave = arreglo[0];
            claveSegura = arreglo[1];
            usua = new Usuario(usu, clave, claveSegura);
        }

            String codigo = String.valueOf(idMayor + 1);
            String nombre = etTitulo.getText().toString();
            String usuario = usua.getNombre();
            String claveS = etContraseña.getText().toString();
            String url = etUrl.getText().toString();
            String descripcion = etDescripcion.getText().toString();
            Contrasenas crear = new Contrasenas(Integer.parseInt(codigo),nombre,usuario,claveS);
            crear.setUrl(url);
            crear.setDescripcion(descripcion);
            ContentValues reg = new ContentValues();
            reg.put("codigo", String.valueOf(crear.getId()));
            reg.put("nombreCuenta", crear.getNombreCuenta());
            reg.put("usuario", usuario);
            reg.put("clave", crear.getContrasena());
            reg.put("url", crear.getUrl());
            reg.put("descripcion", crear.getDescripcion());
            BaseDatos.insert("Claves", null, reg);
            BaseDatos.close();
            Log.d("TAG_", "Ingresado");

    }
    public void Buscar(View view){
        AdministradorBaseDatos adm = new AdministradorBaseDatos (this,"administracion",null,1);
        SQLiteDatabase BaseDatos = adm.getWritableDatabase();
        Cursor fila = BaseDatos.rawQuery("select * from Claves",null);
        if(fila.moveToFirst()){
            do {
                if(Integer.parseInt(fila.getString(0))> idMayor){
                    idMayor = Integer.parseInt(fila.getString(0));
                }
                Log.d("TAG_",fila.getString(0));
                Log.d("TAG_",fila.getString(1));
            }while (fila.moveToNext());
            BaseDatos.close();
        }else {
            Log.d("TAG_","Tabla vacia");
            BaseDatos.close();
        }
    }
    public void Eliminar(View view){
        AdministradorBaseDatos  adm = new AdministradorBaseDatos (this,"administracion",null,1);
        SQLiteDatabase BaseDatos = adm.getWritableDatabase();
        int cantidad = BaseDatos.delete("Claves","codigo>=1",null);
        if(cantidad > 0){
            Log.d("TAG_","Elementos Eliminados: "+cantidad);
            idMayor = 0;
            Buscar(view);
        }else {
            Log.d("TAG_","Eliminados: "+cantidad);
        }
        BaseDatos.close();
    }
    public void Actualizar(View view) {
        SQLiteDatabase BaseDatos;
        AdministradorBaseDatos  adm = new AdministradorBaseDatos (this,"administracion",null,1);
        BaseDatos = adm.getWritableDatabase();
        try{
            String descripcion = "Hola mundo";
            String precio = "150";
            ContentValues reg = new ContentValues();
            reg.put("descripcion",descripcion);
            reg.put("precio",precio);
            int cantidad = BaseDatos.update("Claves",reg,"codigo=4",null);
            BaseDatos.close();
            if(cantidad >0){
                Log.d("TAG_","Datos Modificados: "+cantidad);
            }else {
                Log.d("TAG_","No se modifico ningun dato");
            }
        }catch (Exception exeption){
            Log.d("TAG_",exeption.toString());
        }
    }
}
