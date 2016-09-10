package com.example.jhon.punto4;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import com.example.jhon.punto4.databinding.ActivityDetailListBinding;
import com.example.jhon.punto4.models.Producto;
import com.example.jhon.punto4.models.Util;


public class DetailListActivity extends AppCompatActivity {

    Bundle bundle;
    Producto producto;
    int index;
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityDetailListBinding binding = DataBindingUtil.setContentView(this,R.layout.activity_detail_list);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Detalle");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        bundle = getIntent().getExtras();
        index = bundle.getInt("index");
        producto = Util.getProducto().get(index);
        binding.setProduct(producto);
        overridePendingTransition(R.animator.slide_in, R.animator.slide_out);

    }
    @Override
    public void onBackPressed() {
        super.onBackPressed();
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
