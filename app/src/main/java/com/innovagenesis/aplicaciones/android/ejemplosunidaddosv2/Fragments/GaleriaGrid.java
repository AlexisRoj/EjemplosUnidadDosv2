package com.innovagenesis.aplicaciones.android.ejemplosunidaddosv2.Fragments;


import android.content.res.TypedArray;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

import com.innovagenesis.aplicaciones.android.ejemplosunidaddosv2.R;
import com.innovagenesis.aplicaciones.android.ejemplosunidaddosv2.adapters.GaleriaAdapter;
import com.innovagenesis.aplicaciones.android.ejemplosunidaddosv2.contenedores.Galeria;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class GaleriaGrid extends Fragment {

    private GridView gridView;
    private View view;

    public GaleriaGrid() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        view = inflater.inflate(R.layout.fragment_galeria_grid, container, false);

        GaleriaAdapter adapter = new GaleriaAdapter(getContext(),contenidoGrid());

        GridView gridView = (GridView)view.findViewById(R.id.gridGalery);
        gridView.setAdapter(adapter);

        return view;
    }

    private ArrayList<Galeria> contenidoGrid() {

        String[] descImgG = getResources().getStringArray(R.array.descGaleria);
        TypedArray imgGaleria = getResources().obtainTypedArray(R.array.imgGaleria);
        TypedArray imgFrameG = getResources().obtainTypedArray(R.array.frameGaleria);

        ArrayList<Galeria> lista = new ArrayList<>();

        for (int i = 0; i < descImgG.length; i++){

            lista.add(new Galeria(descImgG[i],imgGaleria.getResourceId(i,0),imgFrameG.getResourceId(i,0)));
        }

        return lista;
    }


}
