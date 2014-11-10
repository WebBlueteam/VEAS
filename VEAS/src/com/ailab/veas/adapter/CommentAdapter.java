package com.ailab.veas.adapter;

import java.util.ArrayList;

import com.ailab.veas.R;
import com.ailab.veas.object.CommentObject;
import com.ailab.veas.util.Utils;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class CommentAdapter extends BaseAdapter {

	private Context mContext;
	private ArrayList<CommentObject> mListComment;
	
	public ArrayList<CommentObject> getListComment(){
		return mListComment;
	}
	
	public void ArrayListData(ArrayList<CommentObject> listData){
		this.mListComment = listData;
	}
	
	public CommentAdapter(Context context, ArrayList<CommentObject> listData){
		this.mContext = context;
		mListComment = listData;
	}
	
	
	
	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return mListComment.size();
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return mListComment.get(position);
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		if(convertView == null){
			LayoutInflater inflater = (LayoutInflater)mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			convertView = inflater.inflate(R.layout.comment_item_lay, parent, false);
		}
		TextView name = (TextView)convertView.findViewById(R.id.comment_name_id);
		TextView comment = (TextView)convertView.findViewById(R.id.comment_name_id);
		TextView date = (TextView)convertView.findViewById(R.id.comment_name_id);
		Utils.setTypefaceRoboto(mContext, name, comment, date);
		return convertView;
	}
	
	
	
}
