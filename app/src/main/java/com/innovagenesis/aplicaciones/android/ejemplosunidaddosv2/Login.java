package com.innovagenesis.aplicaciones.android.ejemplosunidaddosv2;

import android.content.Intent;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

public class Login extends AppCompatActivity implements View.OnClickListener {

    /** Clase encargada de la administracion del home*/
    CheckBox checkBox;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Button btnLogin = (Button) findViewById(R.id.btn_login);
        checkBox = (CheckBox) findViewById(R.id.lose_pass);

        /**Administra las propiedades de los elementos del login*/
        assert btnLogin != null;
        btnLogin.setText(R.string.btnLogin);
        btnLogin.setOnClickListener(this);
        checkBox.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.btn_login: {
                lanzarActivity();
                break;
            }
            case R.id.lose_pass: {
                Snackbar snackbar = Snackbar.make(v, "Notificación", Snackbar.LENGTH_SHORT)
                        .setAction("Precionar para ingresar", new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                /** Ejecuta el MainActivity y envia un mensaje*/
                                Toast.makeText(getApplicationContext(),
                                        R.string.toastLogin, Toast.LENGTH_SHORT).show();
                                lanzarActivity();
                            }
                        });
                snackbar.show();
                checkBox.setChecked(false);
                break;
            }

        }
    }

    private void lanzarActivity() {
        /** Es el metodo que cambia de activity, el login se mata al finalizar, pero como es un layout
         * de incio siempre va a pedir la contraseña despues de q la app se va a pause*/
        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
        startActivity(intent);
        finish();
    }
}
