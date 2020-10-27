package com.example.carroproductos;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.carroproductos.adapters.ProductosListAdapter;
import com.example.carroproductos.dao.ProductosDAO;
import com.example.carroproductos.dao.ProductosDAOLista;
import com.example.carroproductos.dto.Producto;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    private List<Producto> productos;
    private ProductosDAO productosDAO = ProductosDAOLista.getInstance();
    private ListView productosLv;
    private ProductosListAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.setSupportActionBar((Toolbar) findViewById(R.id.toolbar));
        this.productos = this.productosDAO.getAll();
        this.productosLv = findViewById(R.id.productos_lv);
        this.adapter = new ProductosListAdapter(this,R.layout.productos_list,this.productos);
        this.productosLv.setAdapter(this.adapter);
        //Agregar un listener a los elementos de la lista
        this.productosLv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Producto producto = productos.get(i);
                Intent intent = new Intent(MainActivity.this,ProductoViewActivity.class);
                intent.putExtra("producto",producto);
                startActivity(intent);
            }
        });
    }
}