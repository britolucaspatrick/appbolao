package com.example.patri.appbolaoprojeto;

import android.app.DownloadManager;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.patri.appbolaoprojeto.CustomAdapter.ArrayAdapterClassificacao;
import com.example.patri.appbolaoprojeto.CustomAdapter.ArrayAdapterEquipe;
import com.example.patri.appbolaoprojeto.Entity.Classificacao;
import com.example.patri.appbolaoprojeto.Entity.Equipe;
import com.example.patri.appbolaoprojeto.WS.WSEquipe;
import com.example.patri.appbolaoprojeto.WS.WSGetClassificacao;
import com.google.gson.Gson;
import com.orm.SugarContext;
import com.orm.util.QueryBuilder;

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


public class ClassbrasileiraoActivity extends AppCompatActivity{

    //private Handler handler = new Handler();
    //private ProgressBar progressBar;

    private ArrayAdapter<Classificacao> adapter;
    private ListView listClassificacao;
    WSEquipe wsEquipe = new WSEquipe();

    private Classificacao classificacao;

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

        //carrega list de equipes para banco local
        WSGetClassificacao.getClassificacaoList();
        loadList.start();
    }
    private void carregarLista() {
        //passando context, layout e banco
        adapter = new ArrayAdapterClassificacao(this, R.layout.layout_item_list_classificacao, Classificacao.listAll(Classificacao.class,"pontosGanhos"));
        adapter.setDropDownViewResource(R.layout.layout_item_list_classificacao);
        listClassificacao.setAdapter(adapter);
    }
    private void findComponentes() {
        listClassificacao = findViewById(R.id.listClassificacao);
        tvTime = (TextView) findViewById(R.id.tvTime);
        tvJogoJogado = (TextView) findViewById(R.id.tvJogoJogado);
        tvVitoria = (TextView) findViewById(R.id.tvVitoria);
        tvDerota = (TextView) findViewById(R.id.tvDerota);
        tvEmpate = (TextView) findViewById(R.id.tvEmpate);
        tvSaldoGol = (TextView) findViewById(R.id.tvSaldoGol);
        tvPontos = (TextView) findViewById(R.id.tvPontos);
    }
    Thread loadList = new Thread( new Runnable() {
        @Override
        public void run() {
            try  {
                findComponentes();
                SoapObject request = new SoapObject(NAMESPACE,URL_LIST_CLASSIFICACAO);
                SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
                envelope.setOutputSoapObject(request);
                HttpTransportSE androidHttpTransport = new HttpTransportSE(URL);
                try {
                    androidHttpTransport.call(SOAP_ACTION + URL_LIST_CLASSIFICACAO, envelope);
                    SoapPrimitive resultsRequestSOAP = (SoapPrimitive) envelope.getResponse();
                    final String docsaida = resultsRequestSOAP.toString();
                    JSONArray jsonArray = new JSONArray(docsaida);
                    for (int i=0; i < jsonArray.length(); i++) {
                        Classificacao aux = new Gson().fromJson(jsonArray.get(i).toString(), Classificacao.class);
                        classificacao = new Classificacao(aux.getCdEquipe(),aux.getGolsPro(),aux.getGolsContra(),
                                aux.getSaldoGols(),aux.getPos(),aux.getGanhoPos(),
                                aux.getPontosGanhos(),
                                aux.getJogos(),
                                aux.getVitoria(),aux.getEmpate(),aux.getDerrota(),aux.getAproveitamento());
                        classificacao.save();
                    };
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            carregarLista();
                        }
                    });
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    });

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

}
