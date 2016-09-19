package com.innovagenesis.aplicaciones.android.ejemplosunidaddosv2;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

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

        String [] titleMenu = getActivity().getResources().getStringArray(R.array.menuTitleString);
        String [] descrMenu = getActivity().getResources().getStringArray(R.array.descrMenuString);

        ArrayList<CapturaDatos> lista = new ArrayList<> ();

        for (int i = 0; i < titleMenu.length; i ++){

            lista.add(new CapturaDatos(titleMenu[i], descrMenu[i]));
        }

        CustomMenuListview adapter = new CustomMenuListview(getActivity(),lista);

        ListView listView = (ListView)view.findViewById(R.id.menu_listView);
        listView.setAdapter(adapter);

        return view;
    }

}
