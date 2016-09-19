package com.innovagenesis.aplicaciones.android.ejemplosunidaddosv2;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.innovagenesis.aplicaciones.android.ejemplosunidaddosv2.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class SimpleListView extends Fragment {


    public SimpleListView() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_simple_list_view, container, false);
    }

}
