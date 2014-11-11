package com.ailab.veas;
import com.ailab.showgallery.gallery;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;

public class NewPost extends Activity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.newpost_lay);
		ImageView addphoto=(ImageView)findViewById(R.id.photo);
		addphoto.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent i = new Intent(NewPost.this,gallery.class);
				startActivityForResult(i, 200);
			}
		});
	}
}
