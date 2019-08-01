package com.gwynbleidd.maplearning;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import com.google.maps.android.clustering.Cluster;
import com.google.maps.android.clustering.ClusterManager;
import com.gwynbleidd.maplearning.retro.ApiUtils;
import com.gwynbleidd.maplearning.retro.Pojo.MapDirObj;
import com.gwynbleidd.maplearning.retro.SOService;

//import net.sharewire.googlemapsclustering.Cluster;
//import net.sharewire.googlemapsclustering.ClusterItem;
//import net.sharewire.googlemapsclustering.ClusterManager;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MapsActivity extends AppCompatActivity implements OnMapReadyCallback {

    SOService soService;

    private GoogleMap mMap;

    private static final LatLng BRISBANE = new LatLng(-27.47093, 153.0235);

    private static final LatLng MELBOURNE = new LatLng(-37.81319, 144.96298);

    private static final LatLng DARWIN = new LatLng(-12.4634, 130.8456);

    private static final LatLng SYDNEY = new LatLng(-33.87365, 151.20689);

    private static final LatLng ADELAIDE = new LatLng(-34.92873, 138.59995);

    private static final LatLng PERTH = new LatLng(-31.952854, 115.857342);

    private static final LatLng ALICE_SPRINGS = new LatLng(-24.6980, 133.8807);

    private static final LatLngBounds NETHERLANDS = new LatLngBounds(
            new LatLng(50.77083, 3.57361), new LatLng(53.35917, 7.10833));


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }


    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;


        // Add a marker in Sydney and move the camera
//        mMap.addMarker(new MarkerOptions().position(NETHERLANDS).title("Marker in Sydney"));
//        mMap.animateCamera(CameraUpdateFactory.newLatLngBounds(NETHERLANDS,0));

        mMap.setOnMapLoadedCallback(new GoogleMap.OnMapLoadedCallback() {
            @Override
            public void onMapLoaded() {
                mMap.animateCamera(CameraUpdateFactory.newLatLngBounds(NETHERLANDS, 0));
            }
        });


        //////


        ClusterManager<MyClusterItem> clusterManager = new ClusterManager<>(this, mMap);

        clusterManager.setOnClusterClickListener(new ClusterManager.OnClusterClickListener<MyClusterItem>() {
            @Override
            public boolean onClusterClick(Cluster<MyClusterItem> cluster) {
                Log.d("CLUSTERMAP", "onClusterClick");
                return false;
            }
        });

        clusterManager.setOnClusterItemClickListener(new ClusterManager.OnClusterItemClickListener<MyClusterItem>() {
            @Override
            public boolean onClusterItemClick(MyClusterItem myClusterItem) {
                Log.d("CLUSTERMAP", "onClusterItemClick");
                return false;
            }

        });

        mMap.setOnCameraIdleListener(clusterManager);

        List<MyClusterItem> myClusterItemList = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            myClusterItemList.add(new MyClusterItem(RandomLocationGenerator.generate(NETHERLANDS)));
        }
        clusterManager.addItems(myClusterItemList);

        soService = ApiUtils.getSOService();

        soService.getDirections("Chicago,IL", "Los Angeles,CA", getResources().getString(R.string.maps_key)).enqueue(new Callback<MapDirObj>() {
            @Override
            public void onResponse(Call<MapDirObj> call, Response<MapDirObj> response) {
                Log.d("MAPDIR", "onResponse: " + response.body().getStatus());
                if (response.body().getStatus().equals("REQUEST_DENIED")) {
                    Log.d("MAPDIR", "onResponse: " + response.body().getError_message());
                } else {
                    Log.d("MAPDIR", "onResponse: " + response.body().getRoutes().size());
                }
            }

            @Override
            public void onFailure(Call<MapDirObj> call, Throwable t) {
                Log.d("MAPDIR", "onResponse: " + t.toString());
            }
        });


    }

}
