package com.example.patri.appbolaoprojeto.CustomAdapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import com.example.patri.appbolaoprojeto.Entity.Equipe;

import java.util.List;

/**
 * Created by DevTecnoAliance on 26/03/2018.
 */

public class ArrayAdapterEquipe extends ArrayAdapter {

    public List<Equipe> list;
    private Context context;

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        return super.getView(position, convertView, parent);
    }

    public ArrayAdapterEquipe(@NonNull Context context, int resource, List<Equipe> list) {
        super (context, resource);
        this.context = context;
        this.list = list;
    }

    @Override
    public void setDropDownViewResource(int resource) {
        super.setDropDownViewResource(resource);
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public int getPosition(@Nullable Object item) {
        return super.getPosition(item);
    }

    @Nullable
    @Override
    public Object getItem(int position) {
        return super.getItem(position);
    }

}
