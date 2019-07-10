package com.example.guardarclaves;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private EditText etUsuario, etClave;
    private Button btnIngresar, btnRegistroL;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etUsuario = findViewById(R.id.etUsuario);
        etClave = findViewById(R.id.etClave);
        btnIngresar = findViewById(R.id.btnIngresar);
        btnRegistroL = findViewById(R.id.btnRegistrarL);

        btnIngresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //if(){

                    Intent menuAPP = new Intent(MainActivity.this, Menu.class);
                    startActivity(menuAPP);
               // }

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

   /* private Boolean Validar() {


    }*/
}
