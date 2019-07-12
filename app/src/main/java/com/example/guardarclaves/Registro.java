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

public class Registro extends AppCompatActivity {

    private EditText etCorreo, etClave, etClaveDos;
    private Button btnRegistro, btnVolver;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);

        etCorreo = findViewById(R.id.etCorreo);
        etClave = findViewById(R.id.etClave);
        etClaveDos = findViewById(R.id.etClaveDos);
        btnRegistro = findViewById(R.id.btnRegistro);
        btnVolver = findViewById(R.id.btnVolver);

        btnVolver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent Login = new Intent(Registro.this, MainActivity.class);
                startActivity(Login);
            }
        });
        btnRegistro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Agregar(etCorreo.getText().toString(),etClave.getText().toString(),etClaveDos.getText().toString());
                Intent Login = new Intent(Registro.this, MainActivity.class);
                startActivity(Login);
            }
        });

    }
    private Boolean Validar(String correo, String clave, String claveDos) {
        String errores="";
        if (etCorreo.getText().toString().isEmpty() ) {
            errores = "debe de ingresar un correo";
        }
        if(etClave.getText().toString().isEmpty()){
            errores +="debe de ingresar una clave";

        }
        if(etClaveDos.getText().toString().isEmpty()){
            errores+= "debe de ingresar la segunda clave de seguridad";

        }
        if(errores.isEmpty()){
            return true;
        }else{
            return false;
        }




    }
    private void Agregar( String correo, String clave, String claveDos) {
        if (Validar(correo, clave, claveDos)) {
            SharedPreferences preferences = getSharedPreferences("chao", Context.MODE_PRIVATE);
            SharedPreferences.Editor editorPreference = preferences.edit();
            editorPreference.putString(correo, clave + ";" + claveDos);
            editorPreference.commit();
            Toast.makeText(this, "Usuario Ingresado", Toast.LENGTH_SHORT).show();
            etCorreo.setText("");
            etClave.setText("");
            etClaveDos.setText("");
            //
        }

}
}
