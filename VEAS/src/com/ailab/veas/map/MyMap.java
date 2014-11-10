package com.ailab.veas.map;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.SupportMapFragment;
import com.ailab.veas.*;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;

public class MyMap extends FragmentActivity{
	GoogleMap googleMap;
	SupportMapFragment fm;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.googlemap);
	}
}
