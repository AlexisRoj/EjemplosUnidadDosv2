package com.innovagenesis.aplicaciones.android.ejemplosunidaddosv2;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;


public class MiscelaneosFragment {

    public MiscelaneosFragment() {
    }

    public FragmentTransaction remplazarFragment(Fragment fragment, FragmentActivity activity) {

        /** Encargada de cambiar los fragments en el contenedor **/

        FragmentManager fm = activity.getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.replace(R.id.fragment_contenedor,fragment);
        return ft;
    }

}
