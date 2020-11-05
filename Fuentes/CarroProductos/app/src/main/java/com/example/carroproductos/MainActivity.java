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
import com.example.carroproductos.dao.ProductosDAODB;
import com.example.carroproductos.dao.ProductosDAOLista;
import com.example.carroproductos.dto.Producto;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    private FloatingActionButton agregarBtn;
    private List<Producto> productos;
    private ProductosDAO productosDAO = new ProductosDAODB(this);
    private ListView productosLv;
    private ProductosListAdapter adapter;
    protected void onResume(){
        super.onResume();
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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.setSupportActionBar((Toolbar) findViewById(R.id.toolbar));
        this.agregarBtn = findViewById(R.id.btn_am);
        this.agregarBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, CrearProductoActivity.class);
                startActivity(intent);

            }
        });
    }
}