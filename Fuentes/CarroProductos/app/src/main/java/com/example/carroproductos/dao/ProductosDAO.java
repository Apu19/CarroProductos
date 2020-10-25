package com.example.carroproductos.dao;

import com.example.carroproductos.dto.Producto;

import java.util.List;

public interface ProductosDAO {
    Producto add(Producto p);
    List<Producto> getAll();
}
