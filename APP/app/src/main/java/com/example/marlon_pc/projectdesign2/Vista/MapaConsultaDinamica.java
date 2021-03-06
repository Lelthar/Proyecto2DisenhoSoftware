package com.example.marlon_pc.projectdesign2.Vista;

import android.Manifest;
import android.app.Dialog;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.media.AudioRecord;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.example.marlon_pc.projectdesign2.Controlador.DTOConsulta;
import com.example.marlon_pc.projectdesign2.Modelo.ResultadoConsultaDinamica;
import com.example.marlon_pc.projectdesign2.Modelo.Ubicacion;
import com.example.marlon_pc.projectdesign2.R;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MapaConsultaDinamica extends AppCompatActivity implements  OnMapReadyCallback{

    private static final String TAG = "MapActivity";
    private static final String FINE_LOCATION = Manifest.permission.ACCESS_FINE_LOCATION;
    private static final String COURSE_LOCATION = Manifest.permission.ACCESS_COARSE_LOCATION;
    private static final int LOCATION_PERMISSION_REQUEST_CODE = 1234;
    private static final float DEFAULT_ZOOM = 15f;

    private FusedLocationProviderClient fusedLocationProviderCliente;

    private boolean mLocationPermissionsGranted = false;
    private GoogleMap mMap;

    private ResultadoConsultaDinamica resultadoConsultaDinamica;

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        if (mLocationPermissionsGranted) {
            getDeviceLocation();

            if (ActivityCompat.checkSelfPermission(this,Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
                return;
            }
            mMap.setMyLocationEnabled(true);

            //geoLocate();

            if (resultadoConsultaDinamica != null) {
                ponerMarcas(resultadoConsultaDinamica);
            } else {
                Toast.makeText(this,"Error: No se pudo mostrar los datos.",Toast.LENGTH_LONG).show();
            }



            //mMap.getUiSettings().setMyLocationButtonEnabled(false);

        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mapa_consulta_dinamica);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        DTOConsulta dtoConsulta = DinamicaFragment.dtoConsulta;

        if (dtoConsulta != null) {
            resultadoConsultaDinamica = (ResultadoConsultaDinamica) dtoConsulta.getResultado();
        }

        getLocationPermission();


    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }

    private Address obtenerLocalizacion(Ubicacion direccion) {

        Geocoder geocoder = new Geocoder(MapaConsultaDinamica.this);
        List<Address> list = new ArrayList<>();;

        try{
            list = geocoder.getFromLocationName(direccion.getDireccion(),1);

        }catch (IOException e){
            list = null;
        }

        if (list.size() > 0) {
            Address address = list.get(0);

            return address;

        }
        return null;
    }

    private void agregarMarcaMapa (LatLng latLng, String title) {

        MarkerOptions options = new MarkerOptions().position(latLng).title(title);

        mMap.addMarker(options);

    }

    private void ponerMarcas(ResultadoConsultaDinamica resultadoConsultaDinamica) {


        for (int i = 0; i < resultadoConsultaDinamica.getUbicaciones().size(); i++) {
            Ubicacion ubicacion = resultadoConsultaDinamica.getUbicaciones().get(i);
            Address address = obtenerLocalizacion(ubicacion);
            String titulo = "Cantidad de accidentes: "+Integer.toString(ubicacion.getCantidad());
            Log.d(TAG, ubicacion.getDireccion());
            agregarMarcaMapa(new LatLng(address.getLatitude(),address.getLongitude()),titulo);

        }
    }



    private void geoLocate() {
        String direccion = "Cachi,Cartago,Costa Rica";

        Geocoder geocoder = new Geocoder(MapaConsultaDinamica.this);
        List<Address> list = new ArrayList<>();;

        try{
            list = geocoder.getFromLocationName(direccion,1);

        }catch (IOException e){

        }

        if (list.size() > 0) {
            Address address = list.get(0);

            // Toast.makeText(this,address.toString(),Toast.LENGTH_LONG).show();
            Log.d(TAG, address.toString());
            moveCamera(new LatLng(address.getLatitude(),address.getLongitude()),DEFAULT_ZOOM,address.getAddressLine(0),false);
        }
    }

    private void getDeviceLocation() {
        fusedLocationProviderCliente = LocationServices.getFusedLocationProviderClient(this);

        try {
            if (mLocationPermissionsGranted) {
                final Task location = fusedLocationProviderCliente.getLastLocation();
               location.addOnCompleteListener(new OnCompleteListener() {
                   @Override
                   public void onComplete(@NonNull Task task) {
                       if (task.isSuccessful()) {
                           Location currentLocation = (Location) task.getResult();
                           moveCamera(new LatLng(currentLocation.getLatitude(),currentLocation.getLongitude()),DEFAULT_ZOOM ,"Actual posicion",true);
                       } else {

                       }
                   }
               });
            }
        }catch (SecurityException e){

        }
    }

    private void moveCamera (LatLng latLng, float zoom, String title,boolean actualPosition) {
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(latLng,zoom));

        if(!actualPosition) {
            MarkerOptions options = new MarkerOptions().position(latLng).title(title);

            mMap.addMarker(options);
        }

;    }

    public void initMap() {
        SupportMapFragment mapFragment = (SupportMapFragment)getSupportFragmentManager().findFragmentById(R.id.map);

        mapFragment.getMapAsync(MapaConsultaDinamica.this);
    }

    private void getLocationPermission() {
        String[] permissions = {Manifest.permission.ACCESS_FINE_LOCATION,Manifest.permission.ACCESS_COARSE_LOCATION};

        if (ContextCompat.checkSelfPermission(this.getApplicationContext(),FINE_LOCATION) == PackageManager.PERMISSION_GRANTED) {
            if (ContextCompat.checkSelfPermission(this.getApplicationContext(),COURSE_LOCATION) == PackageManager.PERMISSION_GRANTED) {
                mLocationPermissionsGranted = true;
                initMap();
            } else {
                ActivityCompat.requestPermissions(this,permissions,LOCATION_PERMISSION_REQUEST_CODE);
            }
        }else {
            ActivityCompat.requestPermissions(this,permissions,LOCATION_PERMISSION_REQUEST_CODE);
        }
    }




    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        mLocationPermissionsGranted  = false;

        switch (requestCode) {
            case LOCATION_PERMISSION_REQUEST_CODE: {
                if (grantResults.length > 0) {
                    for (int i = 0; i < grantResults.length; i++) {
                        if ( grantResults[i] != PackageManager.PERMISSION_GRANTED ) {
                            mLocationPermissionsGranted = false;
                            return;
                        }
                    }
                    mLocationPermissionsGranted = true;

                    initMap();
                }
            }
        }
    }


}
