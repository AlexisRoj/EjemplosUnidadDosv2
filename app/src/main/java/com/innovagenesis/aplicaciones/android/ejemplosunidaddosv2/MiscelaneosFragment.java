package com.innovagenesis.aplicaciones.android.ejemplosunidaddosv2;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;

/**
 * Created by Alexis on 19/9/2016.
 */
public class MiscelaneosFragment {

    public MiscelaneosFragment() {
    }

    public FragmentTransaction remplazarFragment(Fragment fragment, FragmentActivity activity) {

        FragmentManager fm = activity.getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.replace(R.id.fragment_contenedor,fragment);
        return ft;
    }

}
