package com.example.jhon.punto4.models;

import java.util.List;

/**
 * Created by jhon on 8/09/16.
 */
public class ListProductos {
    List<Producto> allProductos;
    public ListProductos(List<Producto> allProductos) {
        this.allProductos = allProductos;
    }
    public List<Producto> getAllProductos() {
        return allProductos;
    }
    public void setAllProductos(List<Producto> allProductos) {
        this.allProductos = allProductos;
    }
}
