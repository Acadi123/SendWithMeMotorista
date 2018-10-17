package projetosendwithmemotorista.sendwithmemotorista.Activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.OnMapReadyCallback;

import projetosendwithmemotorista.sendwithmemotorista.R;

public class PrincipalActivity extends AppCompatActivity implements OnMapReadyCallback {

    GoogleMap googleMap;
    MapView mapView;
    View mVies;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {

    }
}
