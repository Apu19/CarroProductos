package com.example.carroproductos.helpers;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class ProductosDBOpenHelper extends SQLiteOpenHelper {
    private final String sqlCreate ="CREATE TABLE productos("+"id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,"+
            "precio INTEGER,"+
            "nombre TEXT," +
            "foto TEXT," +
            "descripcion TEXT)";
    public ProductosDBOpenHelper(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(this.sqlCreate);
        sqLiteDatabase.execSQL("INSERT INTO productos(precio,nombre,foto,descripcion)"+
                "VALUES (1000"+
                ",'Coca Cola cirou'" +
                ",'https://jumbo.vteximg.com.br/arquivos/ids/222681/1259964.jpg?v=636548056172700000'"+
                ",'Descripción de pana')");
        sqLiteDatabase.execSQL("INSERT INTO productos(precio,nombre,foto,descripcion)"+
                "VALUES (500"+
                ",'Mantecolin'" +
                ",'https://www.confiterialamundial.cl/media/confiteria-la-mundial-mantecol-110-gr.jpg'"+
                ",'Descripción de pana')");
        sqLiteDatabase.execSQL("INSERT INTO productos(precio,nombre,foto,descripcion)"+
                "VALUES (800"+
                ",'Galletitas Ricochoc'" +
                ",'https://jumbo.vteximg.com.br/arquivos/ids/174186/462227.jpg?v=636376973472130000'"+
                ",'Descripción de pana')");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS productos");
        sqLiteDatabase.execSQL(sqlCreate);
    }
}
