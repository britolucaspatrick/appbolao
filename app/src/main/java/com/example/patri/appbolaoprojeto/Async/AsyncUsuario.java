package com.example.patri.appbolaoprojeto.Async;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.widget.Toast;

import com.example.patri.appbolaoprojeto.Activity.MainActivity;
import com.example.patri.appbolaoprojeto.Validation.LoginValidation;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class AsyncUsuario extends AsyncTask<String, String, String> {

    private LoginValidation loginValidation;
    
    private Activity activity;

    public AsyncUsuario(LoginValidation loginValidation) {
        this.loginValidation = loginValidation;
        this.activity = loginValidation.getActivity();
    }

    @Override
    protected String doInBackground(String... url) {
        StringBuilder resultado = new StringBuilder("");
        try {
            String path = url[0];
            path += "?usuario=" + loginValidation.getLogin() + "&senha=" + loginValidation.getSenha();

            URL urlNet = new URL(path);
            HttpURLConnection con = (HttpURLConnection) urlNet.openConnection();
            con.setRequestMethod("POST");
            con.setDoInput(true);
            con.connect();

            InputStream inp = con.getInputStream();

            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inp));

            String linha = "";
            while ((linha = bufferedReader.readLine()) != null) {
                resultado.append(linha);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return resultado.toString();
    }

    @Override
    protected void onPostExecute(String resultado) {
        if (Boolean.valueOf(resultado)) {
            SharedPreferences.Editor editor = activity.getSharedPreferences("pref", Context.MODE_PRIVATE).edit();
            editor.putString("login", loginValidation.getLogin());
            editor.putString("senha", loginValidation.getSenha());
            editor.commit();

            Intent i = new Intent(activity, MainActivity.class);
            activity.startActivity(i);
            activity.finish();
        } else {
            //Util.showMsgToast(activity, "Login/Senha inválidos!");
            Toast.makeText(activity, "Login/senha invalidos", Toast.LENGTH_SHORT).show();
        }
    }
}
