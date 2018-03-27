package com.example.patri.appbolaoprojeto.WS;

import android.content.Context;
import android.support.annotation.NonNull;

import com.example.patri.appbolaoprojeto.CustomAdapter.ArrayAdapterEquipe;
import com.example.patri.appbolaoprojeto.Entity.Classificacao;
import com.example.patri.appbolaoprojeto.Entity.Equipe;
import com.google.gson.Gson;

import org.json.JSONArray;
import org.ksoap2.SoapEnvelope;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapPrimitive;
import org.ksoap2.serialization.SoapSerializationEnvelope;
import org.ksoap2.transport.HttpTransportSE;

import java.util.List;

import static com.example.patri.appbolaoprojeto.WS.WSConstantes.NAMESPACE;
import static com.example.patri.appbolaoprojeto.WS.WSConstantes.SOAP_ACTION;
import static com.example.patri.appbolaoprojeto.WS.WSConstantes.URL;
import static com.example.patri.appbolaoprojeto.WS.WSConstantes.URL_LIST_CLASSIFICACAO;
import static com.example.patri.appbolaoprojeto.WS.WSConstantes.URL_LIST_EQUIPE;

/**
 * Created by DevTecnoAliance on 26/03/2018.
 */

public class WSEquipe {

    public Equipe equipe;

    public void loadEquipe(){
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
                    equipe = new Gson().fromJson(jsonArray.get(i).toString(), Equipe.class); //banco
                    equipe.save(); //persistindo
                };
            } catch (Exception e) {
                e.printStackTrace();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
