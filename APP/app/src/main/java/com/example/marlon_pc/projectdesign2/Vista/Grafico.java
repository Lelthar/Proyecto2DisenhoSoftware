package com.example.marlon_pc.projectdesign2.Vista;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.marlon_pc.projectdesign2.Controlador.DTOConsulta;
import com.example.marlon_pc.projectdesign2.Modelo.Estadistica;
import com.example.marlon_pc.projectdesign2.Modelo.Periodo;
import com.example.marlon_pc.projectdesign2.Modelo.ResultadoConsultaComportamiento;
import com.example.marlon_pc.projectdesign2.Modelo.ResultadoConsultaVacaciones;
import com.example.marlon_pc.projectdesign2.R;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.formatter.PercentFormatter;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;
import java.util.List;

public class Grafico extends AppCompatActivity {

    private int tipo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grafico);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        tipo = getIntent().getIntExtra("NUMERO",0);

        if (tipo == 1) {
            getSupportActionBar().setTitle("Grafico comportamiento");

            DTOConsulta dtoConsulta = ComportamientoFragment.dtoConsulta_actual;

            showChartComportamiento((ResultadoConsultaComportamiento) dtoConsulta.getResultado());
        } else if(tipo == 2) {
            getSupportActionBar().setTitle("Grafico vacaciones");

            DTOConsulta dtoConsulta = VacacionesFragment.dtoConsulta_actual;

            showChartVacaciones((ResultadoConsultaVacaciones) dtoConsulta.getResultado());
        }

    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }

    private void showChartComportamiento(ResultadoConsultaComportamiento resultadoConsultaComportamiento) {
        List<PieEntry> pieEntryList = new ArrayList<>();

        ArrayList<Estadistica> lista_estadistica = resultadoConsultaComportamiento.getEstadisticas();

        Estadistica estadistica;

        for( int i = 0; i < lista_estadistica.size(); i++) {
            estadistica = lista_estadistica.get(i);
            pieEntryList.add(new PieEntry(estadistica.getCantidad(),estadistica.getIdentificador()));
        }

        PieDataSet pieDataSet = new PieDataSet(pieEntryList,"Grafico");

        int[] colors = new int[] {
                                     Color.parseColor("#454046"),
                                     Color.parseColor("#575957"),
                                     Color.parseColor("#97A590"),
                                     Color.parseColor("#C2C1A0"),
                                     Color.parseColor("#C4AC80"),
                                     Color.parseColor("#342E38"),
                                     Color.parseColor("#525061"),
                                     Color.parseColor("#87899C"),
                                     Color.parseColor("#C0CFC7"),
                                     Color.parseColor("#AEB59B"),//
                                     Color.parseColor("#1E575E"),
                                     Color.parseColor("#306E87"),
                                     Color.parseColor("#84E1EB"),
                                     Color.parseColor("#D2E6C9"),
                                     Color.parseColor("#FDFEFB")};

        pieDataSet.setColors(colors);


        PieData data = new PieData(pieDataSet);

        data.setValueFormatter(new PercentFormatter());

        data.setValueTextSize(15f);

        data.setValueTextColor(Color.WHITE);


        PieChart pieChart = findViewById(R.id.chart);

        pieChart.setData(data);

        pieChart.animateY(1000);

        pieChart.setUsePercentValues(true);

        pieChart.setBackgroundColor(Color.parseColor("#fceed3"));

        pieChart.getLegend().setEnabled(false);

        pieChart.getDescription().setEnabled(false);

        pieChart.invalidate();

    }

    private void showChartVacaciones(ResultadoConsultaVacaciones resultadoConsultaComportamiento) {
        List<PieEntry> pieEntryList = new ArrayList<>();

        ArrayList<Periodo> lista_periodos = resultadoConsultaComportamiento.getPeriodos();

        Periodo periodo;

        for( int i = 0; i < lista_periodos.size(); i++) {
            periodo = lista_periodos.get(i);
            pieEntryList.add(new PieEntry(periodo.getCantidad(),periodo.getNombre()));
        }

        PieDataSet pieDataSet = new PieDataSet(pieEntryList,"Grafico");

        int[] colors = new int[] {
                Color.parseColor("#454046"),
                Color.parseColor("#575957"),
                Color.parseColor("#97A590"),
                Color.parseColor("#C2C1A0"),
                Color.parseColor("#C4AC80"),
                Color.parseColor("#342E38"),
                Color.parseColor("#525061"),
                Color.parseColor("#87899C"),
                Color.parseColor("#C0CFC7"),
                Color.parseColor("#AEB59B"),//
                Color.parseColor("#1E575E"),
                Color.parseColor("#306E87"),
                Color.parseColor("#84E1EB"),
                Color.parseColor("#D2E6C9"),
                Color.parseColor("#FDFEFB")};

        pieDataSet.setColors(colors);


        PieData data = new PieData(pieDataSet);

        data.setValueFormatter(new PercentFormatter());

        data.setValueTextSize(15f);

        data.setValueTextColor(Color.WHITE);


        PieChart pieChart = findViewById(R.id.chart);

        pieChart.setData(data);

        pieChart.animateY(1000);

        pieChart.setUsePercentValues(true);

        pieChart.setBackgroundColor(Color.parseColor("#fceed3"));

        pieChart.getLegend().setEnabled(false);

        pieChart.getDescription().setEnabled(false);

        pieChart.invalidate();


    }
}
