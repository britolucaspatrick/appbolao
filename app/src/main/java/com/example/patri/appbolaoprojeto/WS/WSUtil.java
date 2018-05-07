package com.example.patri.appbolaoprojeto.WS;

import com.example.patri.appbolaoprojeto.Entity.Classificacao;
import com.google.gson.Gson;

import org.json.JSONArray;
import org.ksoap2.SoapEnvelope;
import org.ksoap2.serialization.PropertyInfo;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapPrimitive;
import org.ksoap2.serialization.SoapSerializationEnvelope;

import java.util.List;

import static com.example.patri.appbolaoprojeto.WS.WSConstantes.NAMESPACE;
import static com.example.patri.appbolaoprojeto.WS.WSConstantes.URL_LIST_CLASSIFICACAO;

public class WSUtil {

    public static String consomeWS(String metodo, List<PropertyInfo> parametros) {
        String dados = "";
        try {
            SoapObject request = new SoapObject(NAMESPACE, URL_LIST_CLASSIFICACAO);
            if (parametros != null)
            for (PropertyInfo prop : parametros)
                request.addProperty(prop);
            SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
            envelope.setOutputSoapObject(request);
            try {
                SoapPrimitive resultsRequestSOAP = (SoapPrimitive) envelope.getResponse();
                dados = resultsRequestSOAP.toString();

            } catch (Exception e) {
                e.printStackTrace();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return dados;
    }
}
