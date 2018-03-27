package com.example.patri.appbolaoprojeto;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.orm.SugarContext;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        SugarContext.init(this);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_logout) {
            return true;
        } else if (id == R.id.action_administrador) {
            Intent intent = new Intent(MainActivity.this, AdministerActivity.class);
            startActivity(intent);
        }
        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();
        Intent intent;
        if (id == R.id.nav_palpitar) {
            intent = new Intent(MainActivity.this, Palpitar1Activity.class);
            startActivity(intent);
        } else if (id == R.id.nav_class_brasileirao) {
            intent = new Intent(MainActivity.this, ClassbrasileiraoActivity.class);
            startActivity(intent);
        } else if (id == R.id.nav_class_bolao) {
            intent = new Intent(MainActivity.this, ClassbolaoActivity.class);
            startActivity(intent);
        } else if (id == R.id.nav_rod_pessoal) {
            intent = new Intent(MainActivity.this, RodadaspessoaisActivity.class);
            startActivity(intent);
        } else if (id == R.id.nav_est_jogadores) {
            intent = new Intent(MainActivity.this, EstjogadoresActivity.class);
            startActivity(intent);
        } else if (id == R.id.nav_est_pessoal) {
            intent = new Intent(MainActivity.this, EstpessoalActivity.class);
            startActivity(intent);
        } else if (id == R.id.nav_my_account) {
            intent = new Intent(MainActivity.this, MyaccountActivity.class);
            startActivity(intent);
        } else if (id == R.id.nav_pref) {
            intent = new Intent(MainActivity.this, PreferenciaActivity.class);
            startActivity(intent);
        } else if (id == R.id.nav_report_error) {
            intent = new Intent(MainActivity.this, ReporterrorActivity.class);
            startActivity(intent);
        } else if (id == R.id.nav_about_app) {
            intent = new Intent(MainActivity.this, AboutappActivity.class);
            startActivity(intent);
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
