package com.ailab.veas.fragment;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.ailab.veas.DetailProfile;
import com.ailab.veas.R;

public class SettingFragment extends Fragment implements OnClickListener {
	private LinearLayout mProfile_lay;
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {

		View rootView = inflater.inflate(R.layout.fragment_info, container, false);
		init(rootView);
		return rootView;
	}
	private void init(View v){
		mProfile_lay = (LinearLayout)v.findViewById(R.id.detail_profile_id);
		mProfile_lay.setOnClickListener(this);
	}
	@SuppressLint({ "InlinedApi", "ResourceAsColor", "NewApi" }) 
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		int id = v.getId();
		switch (id) {
		case R.id.detail_profile_id:
			Intent i = new Intent(getActivity(), DetailProfile.class);
			startActivity(i);
			break;

		default:
			break;
		}
	}
	
	

}
