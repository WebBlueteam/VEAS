package com.ailab.veas;

import java.util.ArrayList;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;

import com.ailab.veas.adapter.CommentAdapter;
import com.ailab.veas.object.CommentObject;

public class Comment extends Activity {
	private CommentAdapter adapter;
	private ArrayList<CommentObject> mListData;
	private ListView mList;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.comment_lay);
		init();
	}
	private void init(){
		mList = (ListView)findViewById(R.id.comment_list_comment);
		adapter = new CommentAdapter(getApplicationContext(), getContent());
		mList.setAdapter(adapter);
	}
	
	private ArrayList<CommentObject> getContent(){
		mListData = new ArrayList<CommentObject>();
		CommentObject object = new CommentObject();
		object.setmName("Mai Anh Ha");
		object.setmComment("Cái này thật bổ ích, tôi thích !");
		object.setmDate("4 day ago");
		mListData.add(object);
		
		object.setmName("Doan Ngoc Chau");
		object.setmComment("Cái này thật bổ ích, cảm ơn bạn!");
		object.setmDate("3 day ago");
		mListData.add(object);
		
		return mListData;
	}
	
	
}
