package com.example.patri.appbolaoprojeto.Activity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.patri.appbolaoprojeto.R;
import com.example.patri.appbolaoprojeto.Validation.LoginValidation;
import com.example.patri.appbolaoprojeto.WS.WSLoginService;

public class LoginActivity extends AppCompatActivity {

    private EditText edtLogin;
    private EditText edtSenha;

    private Button btnLogar;

    private SharedPreferences preferences;

    private WSLoginService WSLoginService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        WSLoginService = new WSLoginService();

        preferences = getSharedPreferences("pref", Context.MODE_PRIVATE);
        String login = preferences.getString("login", null);
        String senha = preferences.getString("senha", null);
        if (login != null && senha != null) {
            Intent i = new Intent(LoginActivity.this, MainActivity.class);
            startActivity(i);
            finish();
        }

        edtLogin = (EditText) findViewById(R.id.etUserLogin);
        edtSenha = (EditText) findViewById(R.id.etPasswordLogin);

        btnLogar = (Button) findViewById(R.id.btEnviar);

        btnLogar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String login = edtLogin.getText().toString();
                String senha = edtSenha.getText().toString();

                LoginValidation validation = new LoginValidation();
                validation.setActivity(LoginActivity.this);
                validation.setEdtLogin(edtLogin);
                validation.setEdtSenha(edtSenha);
                validation.setLogin(login);
                validation.setSenha(senha);
                WSLoginService.validarCamposLogin(validation);
            }
        });
    }


}
