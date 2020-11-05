package com.example.carroproductos.dao;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.carroproductos.dto.Producto;
import com.example.carroproductos.helpers.ProductosDBOpenHelper;

import java.util.ArrayList;
import java.util.List;

public class ProductosDAODB implements ProductosDAO {
    private ProductosDBOpenHelper db;

    public ProductosDAODB(Context contexto) {
        this.db = new ProductosDBOpenHelper(contexto, "DBProductos", null, 1);
    }

    @Override
    public Producto add(Producto p) {
        SQLiteDatabase writer = this.db.getWritableDatabase();
        String sql = String.format("INSERT INTO productos(" + "precio,nombre,foto,descripcion) VALUES(%d,'%s','%s','%s')", p.getPrecio(), p.getNombre(), p.getFoto(), p.getDescripcion());
        writer.execSQL(sql);
        writer.close();
        return p;
    }

    @Override
    public List<Producto> getAll() {
        SQLiteDatabase reader = this.db.getReadableDatabase();
        List<Producto> productos = new ArrayList<>();
        try {
            if (reader != null) {
                Cursor c = reader.rawQuery("SELECT id,precio,nombre,foto" +
                        ",descripcion FROM productos", null);
                if (c.moveToFirst()) {
                    do {
                        Producto p = new Producto();
                        p.setId(c.getInt(0));
                        p.setPrecio(c.getInt(1));
                        p.setNombre(c.getString(2));
                        p.setFoto(c.getString(3));
                        p.setDescripcion(c.getString(4));
                        productos.add(p);
                    } while (c.moveToNext());
                }
                reader.close();
            }

        } catch (Exception ex) {
            productos = null;
        }
        return productos;
    }
}
