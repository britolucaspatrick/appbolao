package com.example.patri.appbolaoprojeto.WS;

import com.example.patri.appbolaoprojeto.Entity.Classificacao;
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

/**
 * Created by Bruno on 29/03/2018.
 */

public class WSGetClassificacao {

    public static List<Classificacao> listClassificacao = new ArrayList<>();;

    public static List<Classificacao> getListClassificacao() {
        try {
            SoapObject request = new SoapObject(NAMESPACE, URL_LIST_CLASSIFICACAO);
            SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
            envelope.setOutputSoapObject(request);
            try {
                SoapPrimitive resultsRequestSOAP = (SoapPrimitive) envelope.getResponse();
                final String dados = resultsRequestSOAP.toString();
                JSONArray jsonArray = new JSONArray(dados);
                for (int i = 0; i < jsonArray.length(); i++) {
                    listClassificacao.add(new Gson().fromJson(jsonArray.get(i).toString(), Classificacao.class));
                }
                ;
            } catch (Exception e) {
                e.printStackTrace();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listClassificacao;
    }

}
