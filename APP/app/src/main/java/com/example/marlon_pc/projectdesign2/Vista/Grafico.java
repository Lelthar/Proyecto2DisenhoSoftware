package com.example.marlon_pc.projectdesign2.Vista;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.marlon_pc.projectdesign2.Modelo.Estadistica;
import com.example.marlon_pc.projectdesign2.Modelo.ResultadoConsultaComportamiento;
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

    private float valoresList[] = {95.8f,12.6f,19.4f,80.2f,80f,71.6f,12.6f};

    private String nombreAtributos[] = {"Atributo1", "Atributo2", "Atributo3","Atributo4", "Atributo5", "Atributo6", "Atributo7"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grafico);

        //showChart();
    }

    private void showChart(ResultadoConsultaComportamiento resultadoConsultaComportamiento) {
        List<PieEntry> pieEntryList = new ArrayList<>();

        ArrayList<Estadistica> lista_estadistica = resultadoConsultaComportamiento.getEstadisticas();

        Estadistica estadistica;

        for( int i = 0; i < lista_estadistica.size(); i++) {
            estadistica = lista_estadistica.get(i);
            pieEntryList.add(new PieEntry(estadistica.getCantidad(),estadistica.getIdentificador()));
        }

        PieDataSet pieDataSet = new PieDataSet(pieEntryList,"Grafico");

        pieDataSet.setColors(ColorTemplate.MATERIAL_COLORS);

        PieData data = new PieData(pieDataSet);

        data.setValueFormatter(new PercentFormatter());

        data.setValueTextSize(15f);

        data.setValueTextColor(Color.WHITE);

        PieChart pieChart = findViewById(R.id.chart);

        pieChart.setData(data);

        pieChart.animateY(1000);

        pieChart.setUsePercentValues(true);

        pieChart.setBackgroundColor(Color.parseColor("#fceed3"));

        pieChart.invalidate();


    }
}
