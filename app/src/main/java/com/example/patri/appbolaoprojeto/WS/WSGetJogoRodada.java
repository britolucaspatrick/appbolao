package com.example.patri.appbolaoprojeto.WS;

import android.os.AsyncTask;

import com.example.patri.appbolaoprojeto.Async.AsyncGetJogoRodada;
import com.example.patri.appbolaoprojeto.DB.DBJogoRodada;
import com.example.patri.appbolaoprojeto.Entity.JogoRodada;
import com.google.gson.Gson;

import org.json.JSONArray;
import org.ksoap2.SoapEnvelope;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapPrimitive;
import org.ksoap2.serialization.SoapSerializationEnvelope;
import org.ksoap2.transport.HttpTransportSE;

import java.util.ArrayList;
import java.util.List;

import static com.example.patri.appbolaoprojeto.WS.WSConstantes.NAMESPACE;
import static com.example.patri.appbolaoprojeto.WS.WSConstantes.SOAP_ACTION;
import static com.example.patri.appbolaoprojeto.WS.WSConstantes.URL;
import static com.example.patri.appbolaoprojeto.WS.WSConstantes.URL_LIST_JOGO_RODADA;

public class WSGetJogoRodada {

    private static List<JogoRodada> listJogoRodada = new ArrayList<>();

    public static void getJogoRodadaList() {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    for (int i=1; i<=38; i++) {
                        try  {
                            SoapObject request = new SoapObject(NAMESPACE,URL_LIST_JOGO_RODADA);
                            request.addProperty("nrRodada", i);//parâmetro
                            SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
                            envelope.setOutputSoapObject(request);
                            HttpTransportSE androidHttpTransport = new HttpTransportSE(URL);
                            try {
                                androidHttpTransport.call(SOAP_ACTION + URL_LIST_JOGO_RODADA, envelope);
                                SoapPrimitive resultsRequestSOAP = (SoapPrimitive) envelope.getResponse();
                                final String docsaida = resultsRequestSOAP.toString();
                                JSONArray jsonArray = new JSONArray(docsaida);
                                for (int y=0; y < jsonArray.length(); y++) {
                                    JogoRodada jogoRodada = new Gson().fromJson(jsonArray.get(y).toString(), JogoRodada.class);
                                    listJogoRodada.add(jogoRodada); //quando rodada(i=1) é 1, haverá 10 (y=10) objetos em listJogoRodada
                                };
                                DBJogoRodada.dbJogoRodada.add(listJogoRodada);
                                //adicionando uma rodada ao banco local
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        thread.start();
    }
}
