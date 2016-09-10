package com.example.jhon.punto4.Adapters;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.example.jhon.punto4.R;
import com.example.jhon.punto4.databinding.TemplateListBinding;
import com.example.jhon.punto4.models.Producto;

import java.util.List;

/**
 * Created by jhon on 10/09/16.
 */
public class ListAdapter extends BaseAdapter {
    List<Producto> data;
    LayoutInflater inflater;

    public ListAdapter(List<Producto> data) {
        this.data = data;
    }

    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public Object getItem(int i) {
        return data.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (inflater == null) {
            inflater = (LayoutInflater) viewGroup.getContext()
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        }

        TemplateListBinding binding = DataBindingUtil.inflate(inflater, R.layout.template_list, viewGroup, false);
        binding.setProduct(data.get(i));
        return binding.getRoot();
    }
}
