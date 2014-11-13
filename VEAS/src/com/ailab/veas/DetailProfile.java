package com.ailab.veas;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Toast;

public class DetailProfile extends Activity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.profile_detail);
		Bundle extras = getIntent().getExtras();
		if (extras != null) {
		    int value = extras.getInt("ENTRY_ID");
		    Toast.makeText(this,value+"", Toast.LENGTH_LONG).show();
		}
	}
}
