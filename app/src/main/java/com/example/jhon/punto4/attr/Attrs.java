package com.example.jhon.punto4.attr;

import android.databinding.BindingAdapter;
import android.net.Uri;
import android.widget.ImageView;
import android.widget.ListView;

import com.example.jhon.punto4.Adapters.ListAdapter;
import com.example.jhon.punto4.models.Producto;
import com.squareup.picasso.Picasso;

import java.util.List;


/**
 * Created by jhon on 8/09/16.
 */
public class Attrs {

    @BindingAdapter("app:loadImg")
    public static void loadImg(ImageView img, String url){
        Picasso.with(img.getContext()).load(Uri.parse(url)).into(img);
    }

    @BindingAdapter("bind:items")
    public static void bindList(ListView view, List<Producto> list){
        ListAdapter adapter = new ListAdapter(list);
        view.setAdapter(adapter);
    }
}
