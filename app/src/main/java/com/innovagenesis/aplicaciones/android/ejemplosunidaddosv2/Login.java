package com.innovagenesis.aplicaciones.android.ejemplosunidaddosv2;

import android.content.Intent;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

public class Login extends AppCompatActivity implements View.OnClickListener {

    CheckBox checkBox;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Button btnLogin = (Button) findViewById(R.id.btn_login);
        checkBox = (CheckBox) findViewById(R.id.lose_pass);

        assert btnLogin != null;
        btnLogin.setOnClickListener(this);
        checkBox.setOnClickListener(this);


    }

    protected void onPause(){
        super.onPause();
        finish();       //termina la actividad cuando hace login para ahorrar memoria
    }

    @Override
    public void onClick(View v) {


        switch (v.getId()){

            case R.id.btn_login:{
                break;
            }

            case R.id.lose_pass:{
                Snackbar snackbar = Snackbar.make(v,"Notificación",Snackbar.LENGTH_SHORT)
                        .setAction("Precionar para ingresar", new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                /** Ejecuta el MainActivity*/
                                Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                                startActivity(intent);
                            }
                        });
                snackbar.show();
                checkBox.setChecked(false);
                break;

            }

        }
    }
}
