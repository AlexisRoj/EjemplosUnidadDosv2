package com.innovagenesis.aplicaciones.android.ejemplosunidaddosv2;

import android.content.Context;
import android.content.DialogInterface;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AlertDialog;
import android.util.Log;
import android.widget.Toast;


public class MiscelaneosFragment {

    Context conntext;
    private Boolean status;

    public MiscelaneosFragment(Context conntext) {
        this.conntext = conntext;
    }

 /*   public MiscelaneosFragment() {
    }*/

    public FragmentTransaction remplazarFragment(Fragment fragment, FragmentActivity activity) {

        /** Encargada de cambiar los fragments en el contenedor **/

        FragmentManager fm = activity.getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.addToBackStack(null).replace(R.id.fragment_contenedor, fragment);
        return ft;
    }

    public boolean confirmacionAccion(String title, String mensaje, Context context) {

        /**
         * Crea cuadro de alertas para aprobar ingreso de informacion
         * al sistema
         * */

        if (status == null) {
            status = false;
        }

        AlertDialog.Builder builder = new AlertDialog.Builder(context);

        builder.setTitle(title)
                .setMessage(mensaje)
                .setCancelable(false)
                .setPositiveButton(R.string.btnOk, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        status = true;
                    }
                })
                .setNegativeButton(R.string.btnCancel, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        status = false;
                    }
                });

        builder.show();
        Log.i("status: ", String.valueOf(status));

        return status;

    }


}
