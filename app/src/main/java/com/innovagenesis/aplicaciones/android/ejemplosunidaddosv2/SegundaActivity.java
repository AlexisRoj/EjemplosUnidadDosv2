package com.innovagenesis.aplicaciones.android.ejemplosunidaddosv2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class SegundaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_segunda);

        Bundle datos = this.getIntent().getExtras();

        String frase = datos.getString("variableString");
        int numero = datos.getInt("variableInt");

        /** Carga el recurso**/
        TextView textView1 = (TextView) findViewById(R.id.textInfo1);
        TextView textView2 = (TextView) findViewById(R.id.textInfo2);

        /** Asigna lo que le envio la primera actividad*/
        assert textView1 != null;
        textView1.setText(frase);

        assert textView2 != null;
        textView2.setText(String.valueOf(numero)); // Se envia como un texto
    }
}
