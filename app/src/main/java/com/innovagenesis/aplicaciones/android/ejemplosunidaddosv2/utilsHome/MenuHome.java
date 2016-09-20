package com.innovagenesis.aplicaciones.android.ejemplosunidaddosv2.utilsHome;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.innovagenesis.aplicaciones.android.ejemplosunidaddosv2.Fragments.CustomListView;
import com.innovagenesis.aplicaciones.android.ejemplosunidaddosv2.Fragments.SimpleSpinner;
import com.innovagenesis.aplicaciones.android.ejemplosunidaddosv2.MiscelaneosFragment;
import com.innovagenesis.aplicaciones.android.ejemplosunidaddosv2.R;
import com.innovagenesis.aplicaciones.android.ejemplosunidaddosv2.Fragments.SimpleListView;
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

        final String [] titleMenu = getActivity().getResources().getStringArray(R.array.menuTitleString);
        String [] descrMenu = getActivity().getResources().getStringArray(R.array.descrMenuString);

        ArrayList<CapturaDatos> lista = new ArrayList<> ();

        for (int i = 0; i < titleMenu.length; i ++){

            lista.add(new CapturaDatos(titleMenu[i], descrMenu[i]));
        }

        CustomMenuListview adapter = new CustomMenuListview(getActivity(),lista);

        ListView listView = (ListView)view.findViewById(R.id.menu_listView);
        listView.setAdapter(adapter);


        /** Se implementa el onItemClick para ejecutar los diferentes Fragments**/


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                MiscelaneosFragment cambiar = new MiscelaneosFragment();
                Fragment fragment;

                /** Lanza el activity de acuerdo al selecionado **/

               switch (position){

                   case 0:{
                       /** Ejecuta el ejemplo de un ListView simple **/
                       fragment = new SimpleListView();
                       cambiar.remplazarFragment(fragment,getActivity()).commit();
                       break;
                   }
                   case 1: {
                       /** Ejecuta el ejemplo de un ListView custom **/
                       fragment = new CustomListView();
                       cambiar.remplazarFragment(fragment,getActivity()).commit();
                       break;
                   }
                   case 2: {
                       /** Ejecuta el ejemplo de un ListView custom **/
                       fragment = new SimpleSpinner();
                       cambiar.remplazarFragment(fragment,getActivity()).commit();
                       break;
                   }


               }



            }
        });

        return view;
    }

}
