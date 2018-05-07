package com.example.patri.appbolaoprojeto.CustomAdapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.patri.appbolaoprojeto.R;
import com.example.patri.appbolaoprojeto.Entity.Classificacao;

import java.util.List;

import static com.orm.SugarRecord.find;
import static com.orm.SugarRecord.listAll;

/**
 * Created by patri on 24/03/2018.
 */

public class ArrayAdapterClassificacao extends ArrayAdapter<Classificacao>{

    private List<Classificacao> list;
    private Context context;

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View linha = layoutInflater.inflate(R.layout.layout_item_list_classificacao, parent, false);

        TextView tvTime = linha.findViewById(R.id.tvTime);
        TextView tvJogoJgado = linha.findViewById(R.id.tvJogoJogado);
        TextView tvVitoria = linha.findViewById(R.id.tvVitoria);
        TextView tvDerota = linha.findViewById(R.id.tvDerota);
        TextView tvEmpate = linha.findViewById(R.id.tvEmpate);
        TextView tvSaldoGol = linha.findViewById(R.id.tvSaldoGol);
        TextView tvPontos = linha.findViewById(R.id.tvPontos);

        //em dev
        //tvTime.setText(WSGetEquipe.getNmComumEquipe(Integer.parseInt(list.get(position).getCdEquipe())));
        tvTime.setText("");
        tvJogoJgado.setText(list.get(position).getJogos().getQtTotal().toString());
        tvVitoria.setText(list.get(position).getVitoria().getQtTotal().toString());
        tvDerota.setText(list.get(position).getDerrota().getQtTotal().toString());
        tvEmpate.setText(list.get(position).getEmpate().getQtTotal().toString());
        tvSaldoGol.setText(list.get(position).getSaldoGols().toString());
        tvPontos.setText(list.get(position).getPontosGanhos().getQtTotal().toString());

        return linha;
    }

    @Override
    public void setDropDownViewResource(int resource) {
        super.setDropDownViewResource(resource);
    }

    public ArrayAdapterClassificacao(@NonNull Runnable context, int resource, List<Classificacao> list) {
        super((Context) context, resource);
        this.list = list;
        this.context = (Context) context;
    }

    @Override
    public int getPosition(@Nullable Classificacao item) {
        return super.getPosition(item);
    }

    @Nullable
    @Override
    public Classificacao getItem(int position) {
        return list.get(position);
    }

}
