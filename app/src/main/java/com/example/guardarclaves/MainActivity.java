package com.example.guardarclaves;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Map;

public class MainActivity extends AppCompatActivity {

    private EditText etUsuario, etClave;
    private Button btnIngresar, btnRegistroL;
    Usuario usuario;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etUsuario = findViewById(R.id.etUsuario);
        etClave = findViewById(R.id.etClave);
        btnIngresar = findViewById(R.id.btnIngresar);
        btnRegistroL = findViewById(R.id.btnRegistrarL);
        SharedPreferences incorporar = getSharedPreferences("chao", Context.MODE_PRIVATE);

        ponerNombre();


        btnIngresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                if (validarLogin()) {

                    Intent menuAPP = new Intent(MainActivity.this, Menu.class);
                    startActivity(menuAPP);
                }else{
                    Toast.makeText(MainActivity.this, "Contraseña Incorrecta", Toast.LENGTH_SHORT).show();
                }
                

            }
        });
        btnRegistroL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent registrar = new Intent(MainActivity.this, Registro.class);
                startActivity(registrar);
            }
        });


    }
    private boolean validarLogin() {
        String usu, clave,claveSegura;
        String[] arreglo;//esta variable es un arreglo simple.
        SharedPreferences preferences = getSharedPreferences("chao", Context.MODE_PRIVATE);
        Map<String, ?> keys = preferences.getAll();
        for (Map.Entry<String, ?> item : keys.entrySet()) {
            arreglo = item.getValue().toString().split(";");
            usu = item.getKey();
            clave = arreglo[0];
            claveSegura = arreglo[1];
            usuario = new Usuario(usu,clave,claveSegura);
            if(etClave.getText().toString().equals(usuario.getClave())){
                
                return  true;
                
            }
            
        }
        return  false;
    }
    public boolean ponerNombre(){
       if (validarLogin()){
           etUsuario.setText(usuario.getNombre());
           return true;
       }
       return  false;

    }
}
