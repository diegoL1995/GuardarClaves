package com.example.guardarclaves;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Menu extends AppCompatActivity {

    private Button btnIngresarC, btnBorrarU, btnImportar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        btnIngresarC = findViewById(R.id.btnIngresarC);
        btnBorrarU = findViewById(R.id.btnDestruccion);
        btnImportar = findViewById(R.id.btnImortar);

        btnIngresarC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent IngresarD = new Intent(Menu.this, IngresoClaves.class);
                startActivity(IngresarD);
            }
        });
        btnBorrarU.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent salir = new Intent(Menu.this, MainActivity.class);
                startActivity(salir);
            }
        });
        btnImportar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent recuperar = new Intent(Menu.this, ImportacionClaves.class);
                startActivity(recuperar);
            }
        });
    }
}
