package com.example.guardarclaves;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class ImportacionClaves extends AppCompatActivity {

    private Button btnVolver, btnImportar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_importacion_claves);

        btnImportar = findViewById(R.id.btnImortar);
        btnVolver = findViewById(R.id.btnVolver);

        btnImportar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("TAG_", "Hola");
            }
        });
        btnVolver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("TAG_", "Hola Mundo");
            }
        });
    }

}
