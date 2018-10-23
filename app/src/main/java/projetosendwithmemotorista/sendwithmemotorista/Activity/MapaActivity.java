package projetosendwithmemotorista.sendwithmemotorista.Activity;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Criteria;
import android.location.LocationManager;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.util.Log;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import projetosendwithmemotorista.sendwithmemotorista.R;

public class MapaActivity extends SupportMapFragment implements OnMapReadyCallback, GoogleMap.OnMapClickListener {

        private GoogleMap mMap;
        private LocationManager locationManager;
        private static  final String TAG = "MapaActivity";
        private Context cont;
        private int REQUEST_LOCATION = 1;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        cont = getActivity();
        checkrequest();
        getMapAsync(this);

    }

    //checa se o aparelho permite acessar a localização, se não pede a permissão//
    private void checkrequest() {
        if (ContextCompat.checkSelfPermission(cont, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
                ActivityCompat.requestPermissions((Activity) cont, new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, REQUEST_LOCATION);
            }
            else {
            getMapAsync(this);
            Toast.makeText(cont,"Buscando localização atual", Toast.LENGTH_LONG).show();
        }
    }
    //lê o resultado da permissão//

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if(requestCode == REQUEST_LOCATION){
            if(grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED){
                Toast.makeText(cont,"Permissão concedida!",Toast.LENGTH_LONG);
            }
            else {
                Toast.makeText(cont,"Permissão não concedida! Não sera possível acessar sua localização!",Toast.LENGTH_LONG);
            }
        }
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {

        try {

            locationManager = (LocationManager) getActivity().getSystemService(Context.LOCATION_SERVICE);
            Criteria criteria = new Criteria();
            //Toast.makeText(getActivity(), "Provider" +provider, Toast.LENGTH_LONG).show();//
            mMap = googleMap;
            mMap.setOnMapClickListener(this);
            mMap.getUiSettings().setZoomControlsEnabled(true);


            // Add a marker in Sydney and move the camera
            // LatLng sydney = new LatLng(-34, 151);
            //mMap.addMarker(new MarkerOptions().position(sydney).title("Marker in Sydney"));
            // mMap.moveCamera(CameraUpdateFactory.newLatLng());
            mMap.setMyLocationEnabled(true);

        }catch (SecurityException ex){

            Log.e(TAG, "Error", ex);
        }
    }

    @Override
    public void onMapClick(LatLng latLng) {

    }

}
