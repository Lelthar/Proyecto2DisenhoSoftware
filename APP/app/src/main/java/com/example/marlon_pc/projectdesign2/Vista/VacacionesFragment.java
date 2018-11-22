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
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.marlon_pc.projectdesign2.Controlador.Controlador;
import com.example.marlon_pc.projectdesign2.Controlador.DTOConsulta;
import com.example.marlon_pc.projectdesign2.Modelo.*;
import com.example.marlon_pc.projectdesign2.R;

public class VacacionesFragment extends Fragment  {

    private View rootView;

    private static final String[] periodos = {"Verano","Mediados","SemanaSanta"};
    private static final String[] anhos = {"2012", "2013", "2014"};
    private Spinner spinner_periodos;
    private Spinner spinner_anhos;
    private Controlador controlador;
    private Sujeto sujeto ;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {



        rootView = inflater.inflate(R.layout.fragment_vacaciones, container,false);
        ((AppCompatActivity)getActivity()).getSupportActionBar().setTitle("Vacaciones");
        this.sujeto = new Sujeto();
        this.controlador = new Controlador();



        // Boton de consulta
        final Button button = (Button) rootView.findViewById(R.id.buttonConsultaVacaciones);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {


                System.out.println("Ejecutar Consulta Vacaciones");
                sujeto.Imprimir();
                

                Controlador controlador = new Controlador();
                DTOConsulta dtoConsulta = new DTOConsulta("Vacaciones", "valores", null);
                dtoConsulta.setSujeto(sujeto);
                controlador.enviarConsulta(dtoConsulta);


            }
        });


        // Manejo de CheckBox
        CheckBox checkBox2012 = ( CheckBox ) rootView.findViewById( R.id.checkBox2012 );
        CheckBox checkBox2013= ( CheckBox ) rootView.findViewById( R.id.checkBox2013 );
        CheckBox checkBox2014 = ( CheckBox ) rootView.findViewById( R.id.checkBox2014 );
        CheckBox checkBoxMediados = ( CheckBox ) rootView.findViewById( R.id.checkBoxMediados );
        CheckBox checkBoxVerano = ( CheckBox ) rootView.findViewById( R.id.checkBoxVerano );
        CheckBox checkBoxSemanaSanta= ( CheckBox ) rootView.findViewById( R.id.checkBoxSemanaSanta );

        // Listeners
        checkBox2012.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener()
        {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked)
            {
                if ( isChecked )
                {
                    System.out.println("Chequeado 2012");
                    new Observer2012(sujeto);

                }
                else{

                    System.out.println("DesChequeado 2012");
                    sujeto.eliminarObservador(Observer2012.class);

                }

            }
        });

        checkBox2013.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener()
        {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked)
            {
                if ( isChecked )
                {
                    System.out.println("Chequeado 2013");
                    new Observer2013(sujeto);

                }
                else{

                    System.out.println("DesChequeado 2013");
                    sujeto.eliminarObservador(Observer2013.class);

                }

            }
        });

        checkBox2014.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener()
        {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked)
            {
                if ( isChecked )
                {
                    System.out.println("Chequeado 2014");
                    new Observer2014(sujeto);

                }
                else{

                    System.out.println("DesChequeado 2014");
                    sujeto.eliminarObservador(Observer2014.class);

                }

            }
        });

        checkBoxMediados.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener()
        {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked)
            {
                if ( isChecked )
                {
                    System.out.println("Chequeado Mediados");
                    new ObserverMediados(sujeto);

                }
                else{

                    System.out.println("DesChequeado Mediados");
                    sujeto.eliminarObservador(ObserverMediados.class);

                }

            }
        });

        checkBoxSemanaSanta.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener()
        {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked)
            {
                if ( isChecked )
                {
                    System.out.println("Chequeado Semana Santa");
                    new ObserverSemanaSanta(sujeto);

                }
                else{

                    System.out.println("DesChequeado Semana Santa");
                    sujeto.eliminarObservador(ObserverSemanaSanta.class);

                }

            }
        });

        checkBoxVerano.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener()
        {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked)
            {
                if ( isChecked )
                {
                    System.out.println("Chequeado 2012");
                    new ObserverVerano(sujeto);

                }
                else{

                    System.out.println("DesChequeado 2012");
                    sujeto.eliminarObservador(ObserverVerano.class);

                }

            }
        });



        return rootView;
    }
}
















