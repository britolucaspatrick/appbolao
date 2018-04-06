package com.example.patri.appbolaoprojeto.WS;

import android.content.Context;
import android.support.annotation.NonNull;

import com.example.patri.appbolaoprojeto.CustomAdapter.ArrayAdapterEquipe;
import com.example.patri.appbolaoprojeto.Entity.Classificacao;
import com.example.patri.appbolaoprojeto.Entity.Equipe;
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
import static com.example.patri.appbolaoprojeto.WS.WSConstantes.URL_EQUIPE;
import static com.example.patri.appbolaoprojeto.WS.WSConstantes.URL_LIST_CLASSIFICACAO;
import static com.example.patri.appbolaoprojeto.WS.WSConstantes.URL_LIST_EQUIPE;
import static com.example.patri.appbolaoprojeto.WS.WSConstantes.URL_LIST_JOGO_RODADA;

/**
 * Created by DevTecnoAliance on 26/03/2018.
 */

public class WSGetEquipe {

    public static String getNmComumEquipe(final int cdEquipe){
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    try  {
                        SoapObject request = new SoapObject(NAMESPACE,URL_EQUIPE);
                        request.addProperty("nrRodada", cdEquipe);//parâmetro
                        SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
                        envelope.setOutputSoapObject(request);
                        HttpTransportSE androidHttpTransport = new HttpTransportSE(URL);
                        try {
                            androidHttpTransport.call(SOAP_ACTION + URL_EQUIPE, envelope);
                            SoapPrimitive resultsRequestSOAP = (SoapPrimitive) envelope.getResponse();
                            final String docsaida = resultsRequestSOAP.toString();
                            JSONArray jsonArray = new JSONArray(docsaida);
                            for (int y=0; y < jsonArray.length(); y++) {
                                Equipe equipe = new Gson().fromJson(jsonArray.get(y).toString(), Equipe.class);
                                //retorno o nome da equipe com base no cd informado por paramentro
                            };
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        thread.start();
        return "";
    }

    //não implementado funcionalmente
    public static void getEquipeList(){
        try  {
            SoapObject request = new SoapObject(NAMESPACE,URL_LIST_EQUIPE);
            SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
            envelope.setOutputSoapObject(request);
            HttpTransportSE androidHttpTransport = new HttpTransportSE(URL);
            try {
                androidHttpTransport.call(SOAP_ACTION + URL_LIST_EQUIPE, envelope);
                SoapPrimitive resultsRequestSOAP = (SoapPrimitive) envelope.getResponse();
                final String docsaida = resultsRequestSOAP.toString();
                JSONArray jsonArray = new JSONArray(docsaida);
                for (int i=0; i < jsonArray.length(); i++) {
                    Equipe equipe = new Gson().fromJson(jsonArray.get(i).toString(), Equipe.class); //banco
                };
            } catch (Exception e) {
                e.printStackTrace();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
