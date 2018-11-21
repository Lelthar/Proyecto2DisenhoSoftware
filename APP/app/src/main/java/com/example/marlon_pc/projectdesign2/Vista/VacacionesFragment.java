package com.example.marlon_pc.projectdesign2.Vista;

import android.content.DialogInterface;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import com.example.marlon_pc.projectdesign2.Controlador.Controlador;
import com.example.marlon_pc.projectdesign2.R;

public class VacacionesFragment extends Fragment  {

    private View rootView;
<<<<<<< HEAD
    private static final String[] periodos = {"Verano","Mediados","SemanaSanta"};
=======
    private static final String[] periodos = {"Verano", "SemanaSanta", "Mediados"};
>>>>>>> a7d3a87ab8c633996c204ce9f437fb84cbb496d7
    private static final String[] anhos = {"2012", "2013", "2014"};
    private Spinner spinner_periodos;
    private Spinner spinner_anhos;
    private Controlador controlador;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        rootView = inflater.inflate(R.layout.fragment_vacaciones, container,false);

        ((AppCompatActivity)getActivity()).getSupportActionBar().setTitle("Vacaciones");

        spinner_periodos = rootView.findViewById(R.id.spinner_vacaciones);

        ArrayAdapter<String> adapter_periodos = new ArrayAdapter<>(this.getActivity(), R.layout.spinner_item, periodos);
        adapter_periodos.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
        spinner_periodos.setAdapter(adapter_periodos);

        spinner_anhos = rootView.findViewById(R.id.spinner_anho);

        ArrayAdapter<String> adapter_anhos = new ArrayAdapter<>(this.getActivity(), R.layout.spinner_item, anhos);
        adapter_anhos.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
        spinner_anhos.setAdapter(adapter_anhos);


        this.controlador = new Controlador();

        // Boton de consulta
        final Button button = (Button) rootView.findViewById(R.id.buttonConsultaVacaciones);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                /* Dialog
                String mensaje = "hola";
                String titulo = "Titulo de barra ";
                // 1. Instantiate an AlertDialog.Builder with its constructor
                AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                builder.setMessage(mensaje)
                        .setTitle(titulo);
                AlertDialog dialog = builder.create();
                dialog.show();

                */


                System.out.println("Hola");
                //controlador.enviarConsulta();





            }
        });



        return rootView;
    }











}
