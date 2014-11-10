package com.ailab.veas.fragment;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.TextureView;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.ailab.veas.Comment;
import com.ailab.veas.R;
import com.ailab.veas.ViewMore;

public class NewsFragment extends Fragment implements OnClickListener {
	private ImageView mComment_iv;
	private TextView mViewMore_tv;
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {

		View rootView = inflater.inflate(R.layout.fragment_news, container, false);
		init(rootView);
		return rootView;
	}
	@SuppressLint("NewApi") 
	private void init(View v){
		mComment_iv = (ImageView)v.findViewById(R.id.detail_comment_id);
		mViewMore_tv = (TextView)v.findViewById(R.id.detail_see_more_id);
		mComment_iv.setOnClickListener(this);
		mViewMore_tv.setOnClickListener(this);
	}
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		int id = v.getId();
		switch (id) {
		case R.id.detail_comment_id:
			Intent i = new Intent(getActivity(), Comment.class);
			startActivity(i);
			break;
		case R.id.detail_see_more_id:
			Intent in = new Intent(getActivity(), ViewMore.class);
			startActivity(in);
			break;
		default:
			break;
		}
	}
	
}
