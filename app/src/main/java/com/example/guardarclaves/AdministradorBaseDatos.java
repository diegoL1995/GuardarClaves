package com.example.guardarclaves;


import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class AdministradorBaseDatos extends SQLiteOpenHelper {


        public AdministradorBaseDatos(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
            super(context, name, factory, version);
        }

        @Override
        public void onCreate(SQLiteDatabase db) {
            db.execSQL("create table Claves (codigo integer primary key, nombreCuenta text, usuario text, clave text, url text, descripcion text  )");
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        }

    }

