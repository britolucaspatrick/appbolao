package com.example.patri.appbolaoprojeto.WS;
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
    private static List<JogoRodada> listJogoRodada;
    public static List<JogoRodada> getJogoRodadaList(final int param) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                        try  {
                            SoapObject request = new SoapObject(NAMESPACE,URL_LIST_JOGO_RODADA);
                            request.addProperty("nrRodada", param);
                            SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
                            envelope.setOutputSoapObject(request);
                            HttpTransportSE androidHttpTransport = new HttpTransportSE(URL);
                            try {
                                androidHttpTransport.call(SOAP_ACTION + URL_LIST_JOGO_RODADA, envelope);
                                SoapPrimitive resultsRequestSOAP = (SoapPrimitive) envelope.getResponse();
                                final String docsaida = resultsRequestSOAP.toString();
                                JSONArray jsonArray = new JSONArray(docsaida);
                                listJogoRodada = new ArrayList<>();
                                for (int y=0; y < jsonArray.length(); y++) {
                                    JogoRodada jogoRodada = new Gson().fromJson(jsonArray.get(y).toString(), JogoRodada.class);
                                    listJogoRodada.add(jogoRodada);
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
        }).start();
        return listJogoRodada;
    }
}
