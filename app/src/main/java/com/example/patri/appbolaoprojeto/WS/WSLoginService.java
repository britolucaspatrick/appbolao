package com.example.patri.appbolaoprojeto.WS;

import com.example.patri.appbolaoprojeto.Async.AsyncUsuario;
import com.example.patri.appbolaoprojeto.Validation.LoginValidation;

/**
 * Created by Diogo Souza on 10/11/2015.
 */
public class WSLoginService {

    public void validarCamposLogin(LoginValidation validation) {
        boolean resultado = true;
        if (validation.getLogin() == null || "".equals(validation.getLogin())) {
            validation.getEdtLogin().setError("Campo obrigatório!");
            resultado = false;
        } else if (validation.getLogin().length() < 2) {
            validation.getEdtLogin().setError("Campo deve ter no mínimo 3 caracteres!");
        }

        if (validation.getSenha() == null || "".equals(validation.getSenha())) {
            validation.getEdtSenha().setError("Campo obrigatório!");
            resultado = false;
        }

        if (resultado) {
            new AsyncUsuario(validation).execute(WSConstantes.URL_WS_LOGIN);
        }
    }

    public void deslogar() {

    }

}
