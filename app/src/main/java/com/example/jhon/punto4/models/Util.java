package com.example.jhon.punto4.models;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jhon on 10/09/16.
 */
public class Util {
    private static List<Producto> producto;
    public static List<Producto>  getProducto(){
        if (producto == null){
            producto = new ArrayList<>();
        }
        return producto;
    }
}
