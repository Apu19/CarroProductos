package com.example.carroproductos;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.carroproductos.dto.Producto;
import com.squareup.picasso.Picasso;

public class    ProductoViewActivity extends AppCompatActivity {
    TextView nombreProdTv;
    TextView descProdTv;
    ImageView imgProd;
    TextView precioProdTv;
    Producto producto;
    Toolbar toolbar;

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_producto_view);
        //referencia del toolbar
        this.toolbar = findViewById(R.id.toolbar);
        this.setSupportActionBar(this.toolbar);
        this.getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        this.getSupportActionBar().setDisplayShowHomeEnabled(true);
        this.nombreProdTv = findViewById(R.id.nombre_prod_view_txt);
        this.imgProd = findViewById(R.id.img_prod_view);
        this.descProdTv = findViewById(R.id.desc_prod_view);
        this.precioProdTv = findViewById(R.id.precio_prod_view);
        if (getIntent().getExtras() != null) {
            //El pasaje de avión venia con yapa
            //Me enviaron algo en el intent
            this.producto = (Producto) getIntent().getSerializableExtra("producto");
            this.nombreProdTv.setText(producto.getNombre());
            Picasso.get().load(this.producto.getFoto()).resize(500,500).centerCrop().into(this.imgProd);
            this.descProdTv.setText(this.producto.getDescripcion());
            this.precioProdTv.setText("$" + this.producto.getPrecio());
        }
    }
}