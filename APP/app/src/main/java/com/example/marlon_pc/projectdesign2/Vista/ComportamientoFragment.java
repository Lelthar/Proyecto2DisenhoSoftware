package com.example.marlon_pc.projectdesign2.Vista;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.marlon_pc.projectdesign2.R;

public class ComportamientoFragment extends Fragment {
    private View rootView;
    private static final String[] categorias = {"Provincias", "Cantones", "Distritos"};
    private Spinner spinner;
    private Button button;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_comportamiento, container,false);

        ((AppCompatActivity)getActivity()).getSupportActionBar().setTitle("Comportamiento");

        spinner = rootView.findViewById(R.id.spinner_comportamiento);

        button = rootView.findViewById(R.id.botonComportamiento);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this.getActivity(), R.layout.spinner_item, categorias);
        adapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);

        spinner.setAdapter(adapter);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                
            }
        });

        return rootView;
    }




    }
