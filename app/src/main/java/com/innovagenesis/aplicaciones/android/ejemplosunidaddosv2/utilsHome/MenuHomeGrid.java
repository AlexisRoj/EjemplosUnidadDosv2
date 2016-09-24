package com.innovagenesis.aplicaciones.android.ejemplosunidaddosv2.utilsHome;

/** Esta es la clase encargada de aministrar el menuGrid y cada uno de sus botones*/

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.NotificationCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import com.innovagenesis.aplicaciones.android.ejemplosunidaddosv2.Fragments.CustomGrid;
import com.innovagenesis.aplicaciones.android.ejemplosunidaddosv2.Fragments.CustomListView;
import com.innovagenesis.aplicaciones.android.ejemplosunidaddosv2.Fragments.CustomSpinner;
import com.innovagenesis.aplicaciones.android.ejemplosunidaddosv2.Fragments.SimpleListView;
import com.innovagenesis.aplicaciones.android.ejemplosunidaddosv2.Fragments.SimpleSpinner;
import com.innovagenesis.aplicaciones.android.ejemplosunidaddosv2.MiscelaneosFragment;
import com.innovagenesis.aplicaciones.android.ejemplosunidaddosv2.R;
import com.innovagenesis.aplicaciones.android.ejemplosunidaddosv2.SegundaActivity;
import com.innovagenesis.aplicaciones.android.ejemplosunidaddosv2.adapters.CustomMenuGridAdapter;
import com.innovagenesis.aplicaciones.android.ejemplosunidaddosv2.contenedores.CapturaDatosGrid;

import java.util.ArrayList;

public class MenuHomeGrid extends Fragment {

    private GridView gridView;
    private View view;

    int ID = 1;

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

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
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
                        /** Ejecuta el ejemplo de un Lanzar una segunda activity  y pasa datos**/

                        Snackbar snackbar = Snackbar.make(view, "Notificacion", Snackbar.LENGTH_SHORT)
                                .setAction("Precionar para ejecutar Activity", new View.OnClickListener() {
                                    @Override
                                    public void onClick(View v) {

                                        /** Estas dos variables corresponden a los dos datos enviados
                                         * al segundo activity mediante el Bundle**/
                                        String variableString = getString(R.string.variableString);
                                        int variableNumerica = 10;

                                        Intent intent2 = new Intent(getContext(), SegundaActivity.class);
                                        ejecutarActividad(intent2, variableString, variableNumerica);
                                    }
                                });
                        snackbar.setActionTextColor(Color.GREEN);
                        View snackView = snackbar.getView();
                        snackView.setBackgroundColor(Color.BLUE);
                        snackbar.show();

                      /*  startActivity(intent); se utiliza cuando se quiere llamar una actividad*/
                        break;
                    }
                    case 6: {
                        /** Ejecuta un intent hacia una url **/
                        intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://wwww.google.com"));
                        startActivity(intent);
                        break;
                    }
                    case 7: {
                        /** Ejecuta un intent llamada **/
                        intent = new Intent(Intent.ACTION_DIAL);
                        startActivity(intent);
                        break;
                    }

                }
            }
        });

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

    private void ejecutarActividad(Intent intent, String variableString, int variableNumerica) {

        /***************************************************************************
         *                                                                         *
         *                    EJECUTA ACTIVITY Y INICIA NOTIFICACION               *
         *                                                                         *
         ****************************************************************************/

        /**Ejecuta la actividad y crea una notificacion, se separa para mantener orden
         *  y sea mas simple crear mensajes y validaciones                             */

        intent.putExtra("variableString", variableString);
        intent.putExtra("variableInt", variableNumerica);

        /** Se crea la notificacion cuando se carga el segundo activity*/
        intent.putExtra("notificacion", ID);
        PendingIntent pendingIntent = PendingIntent.getActivity(getContext(), 0, intent, 0);
        NotificationManager nm = (NotificationManager) getContext()
                .getSystemService(Context.NOTIFICATION_SERVICE);
        Uri sonido = RingtoneManager
                .getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
        Notification n = new NotificationCompat.Builder(getContext())
                .setContentIntent(pendingIntent)
                .setTicker("Click aqui")
                .setContentTitle("Notificacion nueva")
                .setContentText("Contenido de la notificacion")
                .setSubText("Subtexto")
                .setSmallIcon(R.mipmap.ic_launcher)
                .addAction(R.mipmap.ic_launcher, "Click aqui", pendingIntent)
                .addAction(android.R.drawable.ic_menu_share, "Compartir", pendingIntent)
                .setVibrate(new long[]{50, 500, 100, 50})
                .setPriority(Notification.PRIORITY_MAX)
                .setSound(sonido)
                .setLights(Color.BLUE, 1, 0)
                .build();
        nm.notify(ID, n);

    }

}
