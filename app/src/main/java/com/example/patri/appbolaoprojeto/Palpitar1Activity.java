package com.example.patri.appbolaoprojeto;

import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.patri.appbolaoprojeto.CustomAdapter.ArrayAdapterClassificacao;
import com.example.patri.appbolaoprojeto.CustomAdapter.ArrayAdapterJogoRodada;
import com.example.patri.appbolaoprojeto.DB.DBJogoRodada;
import com.example.patri.appbolaoprojeto.Entity.Classificacao;
import com.example.patri.appbolaoprojeto.Entity.Equipe;
import com.example.patri.appbolaoprojeto.Entity.JogoRodada;
import com.example.patri.appbolaoprojeto.WS.WSGetJogoRodada;
import com.google.gson.Gson;
import com.orm.SugarRecord;

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

public class Palpitar1Activity extends AppCompatActivity {

    public static List<JogoRodada> jogoRodadaList = new ArrayList<>();
    public ArrayAdapter<Classificacao> adapter;

    /**
     * The {@link android.support.v4.view.PagerAdapter} that will provide
     * fragments for each of the sections. We use a
     * {@link FragmentPagerAdapter} derivative, which will keep every
     * loaded fragment in memory. If this becomes too memory intensive, it
     * may be best to switch to a
     * {@link android.support.v4.app.FragmentStatePagerAdapter}.
     */
    private SectionsPagerAdapter mSectionsPagerAdapter;

    /**
     * The {@link ViewPager} that will host the section contents.
     */
    private ViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_palpitar1);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
        // Create the adapter that will return a fragment for each of the three
        // primary sections of the activity.
        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());
        // Set up the ViewPager with the sections adapter.
        mViewPager = (ViewPager) findViewById(R.id.container);
        mViewPager.setAdapter(mSectionsPagerAdapter);
        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);
        for (int i=0; i<38; i++){
            tabLayout.addTab(tabLayout.newTab().setText("Rodada "+(i+1)));
        }
        mViewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        tabLayout.addOnTabSelectedListener(new TabLayout.ViewPagerOnTabSelectedListener(mViewPager));
        WSGetJogoRodada.getJogoRodadaList();

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        switch (item.getItemId()){
            case android.R.id.home:
                startActivity(new Intent(this, MainActivity.class));
                finishAffinity();
                break;
            default:break;
        }
        return true;
    }

    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends Fragment {
        /**
         * The fragment argument representing the section number for this
         * fragment.
         */
        private static final String ARG_SECTION_NUMBER = "section_number";
        private ArrayAdapterJogoRodada adapter;

        public PlaceholderFragment() {
        }

        /**
         * Returns a new instance of this fragment for the given section
         * number.
         */
        public static PlaceholderFragment newInstance(int sectionNumber) {
            PlaceholderFragment fragment = new PlaceholderFragment();
            Bundle args = new Bundle();
            args.putInt(ARG_SECTION_NUMBER, sectionNumber);
            fragment.setArguments(args);
            return fragment;
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_palpitar1, container, false);
            int aux1 = getArguments().getInt(ARG_SECTION_NUMBER); // representa a rodada
            ListView listView = (ListView) rootView.findViewById(R.id.listPalpite);
            adapter = new ArrayAdapterJogoRodada(getContext(), R.layout.layout_item_list_palpite, (List<JogoRodada>) DBJogoRodada.dbJogoRodada.get(aux1));
            //dbjogorodada retorna por posição informada, uma lista com 10 jogos
            adapter.setDropDownViewResource(R.layout.layout_item_list_classificacao);
            listView.setAdapter(adapter);
            return rootView;
        }
    }

    /**
     * A {@link FragmentPagerAdapter} that returns a fragment corresponding to
     * one of the sections/tabs/pages.
     */
    public class SectionsPagerAdapter extends FragmentPagerAdapter {

        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            // getItem is called to instantiate the fragment for the given page.
            // Return a PlaceholderFragment (defined as a static inner class below).
            return PlaceholderFragment.newInstance(position + 1);
        }

        @Override
        public int getCount() {
            // Show 38 total pages.
            return 38;
        }
    }

    public void onBackPressed() {
        startActivity(new Intent(this,MainActivity.class));
        finishAffinity();
        return;
    }
}
