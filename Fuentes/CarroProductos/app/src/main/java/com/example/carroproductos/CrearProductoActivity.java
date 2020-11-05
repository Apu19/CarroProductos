package com.example.carroproductos;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.carroproductos.dao.ProductosDAO;
import com.example.carroproductos.dao.ProductosDAODB;
import com.example.carroproductos.dto.Producto;

public class CrearProductoActivity extends AppCompatActivity {
    private ProductosDAO productosDAO = new ProductosDAODB(this);
    private TextView nombreTxt, fotoTxt, descTxt, precioTxt;
    private Toolbar toolbar;
    private Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crear_producto);
        this.nombreTxt = findViewById(R.id.nombre_prod_acv);
        this.fotoTxt = findViewById(R.id.link_prod_acv);
        this.descTxt = findViewById(R.id.desc_prod_acv);
        this.precioTxt = findViewById(R.id.precio_prod_acv);
        this.button = findViewById(R.id.btn_prod_acv);
        this.toolbar = findViewById(R.id.toolbar);
        this.setSupportActionBar(this.toolbar);
        this.getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        this.getSupportActionBar().setDisplayShowHomeEnabled(true);
        this.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Producto p = new Producto();
                p.setNombre(nombreTxt.getText().toString());
                p.setPrecio(Integer.parseInt(precioTxt.getText().toString()));
                p.setDescripcion(descTxt.getText().toString());
                p.setFoto(fotoTxt.getText().toString());
                productosDAO.add(p);
                startActivity(new Intent(CrearProductoActivity.this,MainActivity.class));
            }
        });
    }
}