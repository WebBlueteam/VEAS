package com.ailab.veas.map;

import android.app.Dialog;
import android.content.Intent;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationManager;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.widget.Toast;

import com.ailab.veas.R;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.GoogleMap.OnCameraChangeListener;
import com.google.android.gms.maps.GoogleMap.OnMapClickListener;
import com.google.android.gms.maps.GoogleMap.OnMyLocationChangeListener;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

public class DangeGer extends FragmentActivity implements
OnMyLocationChangeListener, OnCameraChangeListener{
	GoogleMap googleMap;
	SupportMapFragment fm;
	LatLng myPosition;
	@Override
	protected void onCreate(Bundle arg0) {
		// TODO Auto-generated method stub
		super.onCreate(arg0);
		setContentView(R.layout.chooselocation);
		fm = (SupportMapFragment) getSupportFragmentManager().findFragmentById(
				R.id.map_choose);
		int status = GooglePlayServicesUtil
				.isGooglePlayServicesAvailable(getBaseContext());
		if (status != ConnectionResult.SUCCESS) { // Google Play Services are
			// not available

			int requestCode = 10;
			Dialog dialog = GooglePlayServicesUtil.getErrorDialog(status, this,
					requestCode);
			dialog.show();

		}
		else
		{
			googleMap = fm.getMap();
			// Enabling MyLocation Layer of Google Map

			// getlist_entry();
			googleMap.setMyLocationEnabled(true);
			googleMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);
			LocationManager locationManager = (LocationManager) getSystemService(LOCATION_SERVICE);
			// Creating a criteria object to retrieve provider
			Criteria criteria = new Criteria();

			// Getting the name of the best provider
			String provider = locationManager.getBestProvider(criteria, true);

			// Getting Current Location
			Location location = locationManager.getLastKnownLocation(provider);
			if (location != null) {
				double latitude = location.getLatitude();
				double longitude = location.getLongitude();
				myPosition = new LatLng(latitude, longitude);

				// add maker for my location
				// set_up_maker_my_location();
				CameraPosition cameraPosition = new CameraPosition.Builder()
						.target(myPosition).zoom(15).build();
				googleMap.animateCamera(CameraUpdateFactory
						.newCameraPosition(cameraPosition));
				//
				googleMap.moveCamera(CameraUpdateFactory
						.newCameraPosition(cameraPosition));
				googleMap.setOnMyLocationChangeListener(this);
				googleMap.setOnCameraChangeListener(this);
				googleMap.setOnMapClickListener(new OnMapClickListener() {

					@Override
					public void onMapClick(LatLng arg0) {
						// TODO Auto-generated method stub
						MarkerOptions maker = new MarkerOptions()
								.position(arg0);

						Marker mk = googleMap.addMarker(maker);
						double lat=mk.getPosition().latitude;
						double lon=mk.getPosition().latitude;
						Toast.makeText(DangeGer.this,lat+".."+lon,Toast.LENGTH_LONG).show();
						String latlon=lat+" "+lon;
						Intent data = new Intent().putExtra("latlon", latlon);
						setResult(RESULT_OK, data);
						finish();
					}
				});
			}

		}
	}
	@Override
	public void onCameraChange(CameraPosition arg0){
		// TODO Auto-generated method stub
	}
	@Override
	public void onMyLocationChange(Location arg0) {
		// TODO Auto-generated method stub
	}
}