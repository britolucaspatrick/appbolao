package com.example.patri.appbolaoprojeto.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

import com.example.patri.appbolaoprojeto.R;

public class RegisterActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);

    }

    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home:
                startActivity(new Intent(this, RegisterActivity.class));
                finishAffinity();
                break;
            default:break;
        }
        return true;
    }

    public void onBackPressed() {
        startActivity(new Intent(this, LoginActivity.class));
        finishAffinity();
        return;
    }

}
