package com.example.marlon_pc.projectdesign2.Vista;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.marlon_pc.projectdesign2.R;

public class DinamicaFragment extends Fragment {
    private View rootView;
    private TextView toolbar;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_dinamica, container,false);

        ((AppCompatActivity)getActivity()).getSupportActionBar().setTitle("Dinámica");

        return rootView;
    }


}
