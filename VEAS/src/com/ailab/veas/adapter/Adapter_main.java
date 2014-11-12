package com.ailab.veas.adapter;

import java.util.ArrayList;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.ailab.veas.R;
import com.squareup.picasso.Picasso;

public class Adapter_main extends BaseAdapter{
	private Activity activity;
	private ArrayList<Item_main_listview> Items;
	private static LayoutInflater inflater=null;
	public Adapter_main(Activity a,ArrayList<Item_main_listview>d){
		activity =a;
		Items =d;
		inflater =(LayoutInflater)activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
	}
	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return Items.size();
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return position;
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return position;
	}

	@SuppressLint("ViewHolder") @Override
	public View getView(int position, View convertView, ViewGroup parent) {
		convertView = inflater.inflate(R.layout.detail_item, null);
		// anh avata
//        ImageView imv_image=(ImageView)convertView.findViewById(R.id.avata_user);
        //ten user
        TextView txt_title = (TextView)convertView.findViewById(R.id.detail_name_id);
        // anh chinh
        ImageView imv_nd=(ImageView)convertView.findViewById(R.id.idetail_image_content_id);
        // noi dung chinh
        TextView txt_content=(TextView)convertView.findViewById(R.id.detail_text_content_id);
        // link
        TextView chitiet=(TextView)convertView.findViewById(R.id.detail_see_more_id);
 
        final Item_main_listview item = Items.get(position);
        // avata 
        //Picasso.with(parent.getContext()).load(item.Icon_user).error(R.drawable.avata).into(imv_image);
        //
        txt_title.setText(item.Username);
        Picasso.with(parent.getContext()).load(item.Icon_main_picture).error(R.drawable.ic_error).into(imv_nd);
        txt_content.setText(item.Content);
       // chitiet.setOnClickListener(this);
        chitiet.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// Toast.makeText(main.this,item.Id+"", Toast.LENGTH_LONG).show();
//				Intent i=new Intent(v.getContext(),Detail_entry.class);
//				i.putExtra("ENTRY_ID", item.Id);
//	            activity.startActivity(i);
				
			}
		});
        return convertView;
	}

}
