package com.ailab.veas;
import java.util.ArrayList;

import com.ailab.showgallery.Custom_gallery;
import com.ailab.showgallery.gallery;
import com.ailab.veas.map.DangeGer;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class NewPost extends Activity {
	TextView addlocation;
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
		ImageView btnshowcamera=(ImageView)findViewById(R.id.camera);
		btnshowcamera.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
				startActivityForResult(intent,0);
			}
		});
		addlocation= (TextView) findViewById(R.id.map);
		addlocation.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent i = new Intent(NewPost.this,DangeGer.class);
				startActivityForResult(i,100);
			}
		});
		ImageView adds =(ImageView)findViewById(R.id.post);
		adds.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				final ProgressDialog progress = ProgressDialog.show(v.getContext(), "UpLoad",
						  "Uploading...", true);

						new Thread(new Runnable() {
						  @Override
						  public void run()
						  {
							  SystemClock.sleep(3000);
						    // do the thing that takes a long time

						    runOnUiThread(new Runnable() {
						      @Override
						      public void run()
						      {
						        progress.dismiss();
						      }
						    });
						  }
						}).start();
			}
		});
		
	}
	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		super.onActivityResult(requestCode, resultCode, data);

	 if (requestCode == 200 && resultCode == Activity.RESULT_OK) {
			String[] all_path = data.getStringArrayExtra("all_path");

			ArrayList<Custom_gallery> dataT = new ArrayList<Custom_gallery>();

			for (String string : all_path) {
				Custom_gallery item = new Custom_gallery();
				item.sdcardPath = string;
				item.isSeleted=true;
				item.ischoose=true;
				dataT.add(item);
			}
			Toast.makeText(NewPost.this,"Bạn đã thêm" +dataT.size()+" ảnh",Toast.LENGTH_LONG).show();
		}
	 if (requestCode == 100 && resultCode == Activity.RESULT_OK) {
		 addlocation.setText(data.getStringExtra("latlon"));
	 }
	}
}
