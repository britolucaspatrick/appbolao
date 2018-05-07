package com.example.patri.appbolaoprojeto.Async;

import android.os.AsyncTask;

import com.example.patri.appbolaoprojeto.WS.WSUtil;

import java.util.ArrayList;

public class AsyncEquipeList extends AsyncTask<String, String, ArrayList<String>> {

    public AsyncEquipeList(){

    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    @Override
    protected ArrayList<String> doInBackground(String... strings) {
        String equipes = WSUtil.consomeWS("", null);
        return null;
    }

    @Override
    protected void onProgressUpdate(String... values) {
        super.onProgressUpdate(values);
    }

    @Override
    protected void onPostExecute(ArrayList<String> strings) {
        super.onPostExecute(strings);
    }

}
