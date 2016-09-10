package com.example.jhon.punto4;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;


import com.example.jhon.punto4.databinding.ActivityMainBinding;
import com.example.jhon.punto4.models.ListProductos;
import com.example.jhon.punto4.models.Producto;
import com.example.jhon.punto4.models.Util;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {
    List<Producto> data;
    ListView list;
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityMainBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        list = (ListView) findViewById(R.id.list);
        overridePendingTransition(R.animator.slide_in, R.animator.slide_out);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Lista de productos");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        //region set Datos de prueba
        data = new ArrayList<>();
        Producto producto = new Producto();
        producto.setPrecio("2500");
        producto.setImagen("http://www.vanguardia.com/sites/default/files/imagecache/Noticia_600x400/foto_grandes_400x300_noticia/2016/04/23/el_carro_de_sus_suenos_a_un_clic_2.jpg");
        producto.setMarca("Mazda");
        producto.setNombre("Carro");

        data.add(producto);

        Producto producto1 = new Producto();
        producto1.setPrecio("1200");
        producto1.setImagen("http://cdn2.macworld.co.uk/cmsdata/features/3605337/MacBook_Air_2015_13inch_800home.jpg");
        producto1.setMarca("Aple");
        producto1.setNombre("Macbook");

        data.add(producto1);
        Producto producto2 = new Producto();
        producto2.setPrecio("1234");
        producto2.setImagen("https://s-media-cache-ak0.pinimg.com/564x/cb/ca/77/cbca77eff4a4e49b34e320315cc9c160.jpg");
        producto2.setMarca("Addidas");
        producto2.setNombre("zapatos");
        data.add(producto2);

        //endregion
        ListProductos listProductos = new ListProductos(data);
        Util.getProducto().addAll(data);
        binding.setProducts(listProductos);
        list.setOnItemClickListener(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
        overridePendingTransition(R.animator.slide_in, R.animator.slide_out);
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
       startActivity(new Intent(this,DetailListActivity.class).putExtra("index",i));
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home:
                onBackPressed();
                break;
        }
        return true;
    }
}

