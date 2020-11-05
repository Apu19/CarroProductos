package com.example.carroproductos.adapters;

import android.app.Activity;
import android.content.Context;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.carroproductos.R;

import com.example.carroproductos.dto.Producto;
import com.squareup.picasso.Picasso;

import java.util.List;

public class ProductosListAdapter extends ArrayAdapter<Producto> {
    private List<Producto> productos;
    private Activity activity;

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = this.activity.getLayoutInflater();
        View fila = inflater.inflate(R.layout.productos_list, null, true);
        //cargar contenido del layout personalizado
        TextView nombreTv = fila.findViewById(R.id.nombre_prod_pl);
        ImageView imageProd = fila.findViewById(R.id.img_prod_pl);
        Producto actual = productos.get(position);
        nombreTv.setText(actual.getNombre());
        Picasso.get().load(actual.getFoto()).resize(300, 300).centerCrop().into(imageProd);
        return fila;
    }

    public ProductosListAdapter(@NonNull Activity context, int resource, @NonNull List<Producto> objects) {
        super(context, resource, objects);
        this.productos = objects;
        this.activity = context;
    }
}
