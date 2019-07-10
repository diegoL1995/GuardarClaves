package com.example.guardarclaves;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class IngresoClaves extends AppCompatActivity {

    private EditText etTitulo, etContraseña, etClaveSeguridad;
    private Button btnGuardar, btnVolver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ingreso_claves);

        etTitulo = findViewById(R.id.etTitulo);
        etContraseña = findViewById(R.id.etContraseña);
        etClaveSeguridad = findViewById(R.id.etClaveSeguridad);
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
}
