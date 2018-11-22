package com.example.marlon_pc.projectdesign2.Vista;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.marlon_pc.projectdesign2.Controlador.Controlador;
import com.example.marlon_pc.projectdesign2.Controlador.DTOConsulta;
import com.example.marlon_pc.projectdesign2.Menu_Principal;
import com.example.marlon_pc.projectdesign2.R;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailability;

import java.io.Serializable;

public class DinamicaFragment extends Fragment {
    private View rootView;
    private TextView toolbar;
    private Button button;
    private EditText editText;
    public static DTOConsulta dtoConsulta;

    private static final String TAG = "MapActivity";
    private static final int ERROR_DIALOG_REQUEST = 9001;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_dinamica, container,false);

        ((AppCompatActivity)getActivity()).getSupportActionBar().setTitle("Dinámica");

        button = rootView.findViewById(R.id.botonDinamica);
        editText = rootView.findViewById(R.id.editTextDinamica);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String entrada = "";
                entrada += editText.getText();
                if(!entrada.equals("")){
                    //String p = "Por ejemplo, se podría seleccionar Cartago y Heredia como provincia, donde interesa Cartago y Acosta y estar interesado en ver los accidentes de tránsito que involucraron peatones en el rol de afectado que salieron ilesos en el tipo de lesión y que fueron mujeres en el indicador de sexo para el año 2012, con una edades de 12, 17, y 18.";
                    //p = p.replaceAll(" ","%20");
                    entrada = entrada.replaceAll(" ","%20");
                    System.out.println(entrada);
                    DTOConsulta dto = new DTOConsulta("Dinamica",entrada,null);
                    Controlador controlador = new Controlador();
                    controlador.enviarConsulta(dto);

                    dtoConsulta = dto;

                    Intent intent = new Intent(getActivity(),MapaConsultaDinamica.class);

                    startActivity(intent);
                }else{
                    Toast.makeText(getActivity(),"Ingrese la consulta.",Toast.LENGTH_LONG);
                }

            }
        });

        return rootView;
    }


    public boolean isServiceOK() {
        Log.d(TAG, "isServiceOK: checking google services version");

        int available = GoogleApiAvailability.getInstance().isGooglePlayServicesAvailable(getActivity());

        if (available == ConnectionResult.SUCCESS) {
            Log.d(TAG, "isServiceOK: Google services is working");
            return true;
        } else if( GoogleApiAvailability.getInstance().isUserResolvableError(available) ) {
            Log.d(TAG, "isServiceOK: an errror occured but we can fix it");
            Dialog dialog = GoogleApiAvailability.getInstance().getErrorDialog(getActivity(),available,ERROR_DIALOG_REQUEST);
            dialog.show();
        } else {
            Log.d(TAG, "isServiceOK: checking google services version");
        }

        return false;
    }


}
