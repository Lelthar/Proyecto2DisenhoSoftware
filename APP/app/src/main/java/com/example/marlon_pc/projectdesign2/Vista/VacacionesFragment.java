package com.example.marlon_pc.projectdesign2.Vista;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.example.marlon_pc.projectdesign2.R;

public class VacacionesFragment extends Fragment {
    private View rootView;
    private static final String[] periodos = {"Provincias", "Cantones", "Distritos"};
    private static final String[] anhos = {"2012", "2013", "2014"};
    private Spinner spinner_periodos;
    private Spinner spinner_anhos;

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

        return rootView;
    }




}
