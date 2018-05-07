package com.example.patri.appbolaoprojeto.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.patri.appbolaoprojeto.CustomAdapter.ArrayAdapterClassificacao;
import com.example.patri.appbolaoprojeto.Entity.Classificacao;
import com.example.patri.appbolaoprojeto.R;
import com.google.gson.Gson;

//import com.google.gson.Gson;
//import com.google.gson.JsonArray;
//import com.google.gson.JsonObject;
//import com.google.gson.reflect.TypeToken;

import org.json.JSONArray;
import org.ksoap2.SoapEnvelope;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapPrimitive;
import org.ksoap2.serialization.SoapSerializationEnvelope;
import org.ksoap2.transport.HttpTransportSE;

import java.util.ArrayList;
import java.util.List;

import static com.example.patri.appbolaoprojeto.WS.WSConstantes.*;


public class ClassbrasileiraoActivity extends AppCompatActivity implements Runnable{

    private ArrayAdapter<Classificacao> adapter;
    private ListView listClassificacao;
    public static List<Classificacao> lista = new ArrayList<>();;

    private RelativeLayout lyLoading;
    private TextView tvTime;
    private TextView tvJogoJogado;
    private TextView tvVitoria;
    private TextView tvDerota;
    private TextView tvEmpate;
    private TextView tvSaldoGol;
    private TextView tvPontos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_classbrasileirao);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
        findComponents();
        lyLoading.setVisibility(View.VISIBLE);
        new Thread(this).start();

    }

    @Override
    public void run() {
        getListClassificacao();
    }

    private void getListClassificacao() {
        SoapObject soap = new SoapObject(NAMESPACE, URL_LIST_CLASSIFICACAO);
        SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(
                SoapEnvelope.VER11);
        envelope.setOutputSoapObject(soap);
        HttpTransportSE httpTransport = new HttpTransportSE(URL);
        try {
            httpTransport.call(SOAP_ACTION+URL_LIST_CLASSIFICACAO, envelope);
            SoapPrimitive resultsRequestSOAP = (SoapPrimitive) envelope.getResponse();
            final String dados = resultsRequestSOAP.toString();
            JSONArray jsonArray = new JSONArray(dados);
            for (int i = 0; i < jsonArray.length(); i++) {
                lista.add(new Gson().fromJson(jsonArray.get(i).toString(), Classificacao.class));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        adapter = new ArrayAdapterClassificacao(this, R.layout.layout_item_list_classificacao, lista);
        adapter.setDropDownViewResource(R.layout.layout_item_list_classificacao);
        listClassificacao.setAdapter(adapter);
        lyLoading.setVisibility(View.GONE);
    }

    private void findComponents() {
        lyLoading = findViewById(R.id.lyLoading);
        listClassificacao = findViewById(R.id.listClassificacao);
        tvTime = (TextView) findViewById(R.id.tvTime);
        tvJogoJogado = (TextView) findViewById(R.id.tvJogoJogado);
        tvVitoria = (TextView) findViewById(R.id.tvVitoria);
        tvDerota = (TextView) findViewById(R.id.tvDerota);
        tvEmpate = (TextView) findViewById(R.id.tvEmpate);
        tvSaldoGol = (TextView) findViewById(R.id.tvSaldoGol);
        tvPontos = (TextView) findViewById(R.id.tvPontos);
    }
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home:
                startActivity(new Intent(this, MainActivity.class));
                finishAffinity();
                break;
            default:break;
        }
        return true;
    }

    public void onBackPressed() {
        startActivity(new Intent(this,MainActivity.class));
        finishAffinity();
        return;
    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }
}
