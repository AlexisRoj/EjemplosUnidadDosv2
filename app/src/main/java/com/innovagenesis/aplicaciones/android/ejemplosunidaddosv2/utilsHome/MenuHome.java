package com.innovagenesis.aplicaciones.android.ejemplosunidaddosv2.utilsHome;


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.innovagenesis.aplicaciones.android.ejemplosunidaddosv2.Fragments.CustomGrid;
import com.innovagenesis.aplicaciones.android.ejemplosunidaddosv2.Fragments.CustomSpinner;
import com.innovagenesis.aplicaciones.android.ejemplosunidaddosv2.Fragments.CustomListView;
import com.innovagenesis.aplicaciones.android.ejemplosunidaddosv2.Fragments.SimpleSpinner;
import com.innovagenesis.aplicaciones.android.ejemplosunidaddosv2.MainActivity;
import com.innovagenesis.aplicaciones.android.ejemplosunidaddosv2.MiscelaneosFragment;
import com.innovagenesis.aplicaciones.android.ejemplosunidaddosv2.R;
import com.innovagenesis.aplicaciones.android.ejemplosunidaddosv2.Fragments.SimpleListView;
import com.innovagenesis.aplicaciones.android.ejemplosunidaddosv2.SegundaActivity;
import com.innovagenesis.aplicaciones.android.ejemplosunidaddosv2.adapters.CustomMenuListview;
import com.innovagenesis.aplicaciones.android.ejemplosunidaddosv2.contenedores.CapturaDatos;

import java.util.ArrayList;

public class MenuHome extends Fragment {


    public MenuHome() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_menu_home, container, false);

        /** Objetos que llenan el menu**/
        final String[] titleMenu = getActivity().getResources().getStringArray(R.array.menuTitleString);
        String[] descrMenu = getActivity().getResources().getStringArray(R.array.descrMenuString);


        ArrayList<CapturaDatos> lista = new ArrayList<>();

        for (int i = 0; i < titleMenu.length; i++) {
            /** llenado del listview del menu*/
            lista.add(new CapturaDatos(titleMenu[i], descrMenu[i]));
        }

        CustomMenuListview adapter = new CustomMenuListview(getActivity(), lista);

        ListView listView = (ListView) view.findViewById(R.id.menu_listView);
        listView.setAdapter(adapter);

        /** Se implementa el onItemClick para ejecutar los diferentes Fragments**/

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                MiscelaneosFragment cambiar = new MiscelaneosFragment();
                Fragment fragment;
                Intent intent;

                /** Lanza el activity de acuerdo al selecionado **/

                switch (position) {

                    case 0: {
                        /** Ejecuta el ejemplo de un ListView simple **/
                        fragment = new SimpleListView();
                        cambiar.remplazarFragment(fragment, getActivity()).commit();
                        break;
                    }
                    case 1: {
                        /** Ejecuta el ejemplo de un ListView custom **/
                        fragment = new CustomListView();
                        cambiar.remplazarFragment(fragment, getActivity()).commit();
                        break;
                    }
                    case 2: {
                        /** Ejecuta el ejemplo de un Spinner simple **/
                        fragment = new SimpleSpinner();
                        cambiar.remplazarFragment(fragment, getActivity()).commit();
                        break;
                    }
                    case 3: {
                        /** Ejecuta el ejemplo de un Spinner custom **/
                        fragment = new CustomSpinner();
                        cambiar.remplazarFragment(fragment, getActivity()).commit();
                        break;
                    }

                    case 4: {
                        /** Ejecuta el ejemplo de un Grid custom **/
                        fragment = new CustomGrid();
                        cambiar.remplazarFragment(fragment, getActivity()).commit();
                        break;
                    }

                    case 5: {
                        /** Ejecuta el ejemplo de un Lanzar una segunda activity **/
                        intent = new Intent(getActivity(),SegundaActivity.class);
                        startActivity(intent);
                        break;
                    }

                    case 6: {
                        /** Ejecuta un intent hacia una url **/
                        intent = new Intent(Intent.ACTION_VIEW, Uri.parse("wwww.google.com"));
                        startActivity(intent);
                        break;
                    }

                }
            }
        });
        return view;
    }
}
