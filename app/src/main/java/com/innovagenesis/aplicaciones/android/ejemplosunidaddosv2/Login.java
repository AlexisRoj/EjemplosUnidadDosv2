package com.innovagenesis.aplicaciones.android.ejemplosunidaddosv2;

import android.content.Intent;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

public class Login extends AppCompatActivity implements View.OnClickListener {

    /**
     * Clase encargada de la administracion del home
     */
    CheckBox checkBox;
    Boolean validar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Button btnLogin = (Button) findViewById(R.id.btn_login);
        Button btnLosePass = (Button) findViewById(R.id.btn_addUser);
        checkBox = (CheckBox) findViewById(R.id.lose_pass);

        /**Administra las propiedades de los elementos del login*/
        assert btnLogin != null;
        btnLogin.setText(R.string.btnLogin);
        btnLosePass.setText(R.string.btnAddCount);


        btnLogin.setOnClickListener(this);
        btnLosePass.setOnClickListener(this);
        checkBox.setOnClickListener(this);
    }

    MiscelaneosFragment util = new MiscelaneosFragment(this);

    @Override
    public void onClick(View v) {


        switch (v.getId()) {
            case R.id.btn_login: {
                lanzarActivity();
                break;
            }
            case R.id.lose_pass: {

                /** Inicializa elemento Booleando y lo compara en el metodo para verificar si se procede o no */

            Snackbar.make(v,"Atencion",Snackbar.LENGTH_SHORT)
                    .setAction("Precione aquí para continuar", new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            lanzarActivity();
                        }
                    })
                    .show();

                break;
            }
            case R.id.btn_addUser: {
                Toast.makeText(getApplicationContext(),
                        R.string.msgWorking, Toast.LENGTH_SHORT).show();
                break;
            }

        }


    }

    private void lanzarActivity() {
        /** Es el metodo que cambia de activity, el login se mata al finalizar, pero como es un layout
         * de incio siempre va a pedir la contraseña despues de q la app se va a pause*/
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();
    }
}
