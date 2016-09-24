package com.innovagenesis.aplicaciones.android.ejemplosunidaddosv2.utilsHome;

import android.content.Context;
import android.content.res.TypedArray;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

import com.innovagenesis.aplicaciones.android.ejemplosunidaddosv2.R;
import com.innovagenesis.aplicaciones.android.ejemplosunidaddosv2.adapters.CustomMenuGridAdapter;
import com.innovagenesis.aplicaciones.android.ejemplosunidaddosv2.contenedores.CapturaDatosGrid;

import java.util.ArrayList;

public class MenuHomeGrid extends Fragment {

    private GridView gridView;
    private View view;

    public MenuHomeGrid() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.fragment_menu_home_grid, container, false);

        CustomMenuGridAdapter adapter = new CustomMenuGridAdapter(getContext(),listaDatos());

        gridView = (GridView)view.findViewById(R.id.menuGrid);
        gridView.setAdapter(adapter);

        ActionBar actionBar = getS

        return view;

    }

    private ArrayList<CapturaDatosGrid> listaDatos() {

        String[] descrMenu = getResources().getStringArray(R.array.descrMenuString);
        TypedArray imagenes = getResources().obtainTypedArray(R.array.imagenTitulo);
        String[] numImage = getResources().getStringArray(R.array.numeroImagen);
        String[] textMenu = getResources().getStringArray(R.array.menuTitleString);

        ArrayList<CapturaDatosGrid> lista = new ArrayList<>();

        for (int i = 0; i< descrMenu.length; i++){

            lista.add(new CapturaDatosGrid(
            /** Campos que llenan el grid*/
                    descrMenu[i],
                    imagenes.getResourceId(i,0),
                    numImage[i],
                    textMenu[i]
            ));
        }
        return lista;
    }

}
