package com.example.patri.appbolaoprojeto.CustomAdapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;


import com.example.patri.appbolaoprojeto.Entity.JogoRodada;
import com.example.patri.appbolaoprojeto.R;
import com.example.patri.appbolaoprojeto.WS.WSGetEquipe;

import java.util.List;

public class ArrayAdapterJogoRodada extends ArrayAdapter<JogoRodada> {

    private List<JogoRodada> list;
    private Context context;

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View linha = layoutInflater.inflate(R.layout.layout_item_list_palpite, parent, false);
        TextView tvTime1 = linha.findViewById(R.id.tvTime1);
        TextView tvTime2 = linha.findViewById(R.id.tvTime2);

        tvTime1.setText(WSGetEquipe.getNmComumEquipe(Integer.parseInt(list.get(position).getCdEquipe1())));
        tvTime2.setText(WSGetEquipe.getNmComumEquipe(Integer.parseInt(list.get(position).getCdEquipe2())));

        return linha;
    }

    @Override
    public void setDropDownViewResource(int resource) {
        super.setDropDownViewResource(resource);
    }

    public ArrayAdapterJogoRodada(@NonNull Context context, int resource, List<JogoRodada> list) {
        super(context, resource);
        this.list = list;
        this.context = context;
    }

    @Override
    public int getPosition(@Nullable JogoRodada item) {
        return super.getPosition(item);
    }

   @Nullable
    @Override
    public JogoRodada getItem(int position) {
        return list.get(position);
    }
}
