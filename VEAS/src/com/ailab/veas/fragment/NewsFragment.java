package com.ailab.veas.fragment;

import globle_variable.globle_variable;
import interfaces.entry_interface;

import java.util.ArrayList;
import java.util.List;

import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.Toast;

import com.ailab.veas.R;
import com.ailab.veas.adapter.Adapter_main;
import com.ailab.veas.adapter.Item_main_listview;

import db.com.entry_info_class;
import db.com.getentry;
import db.com.entry_info_class.entryinfo;

public class NewsFragment extends Fragment {
	ListView listView;
	int start = 1;
	int end = 5;
	boolean loadmore = false;
	ArrayList<Item_main_listview> Item3;
	static Adapter_main adapter3;
	ProgressDialog dialog;
	// api
	entry_interface api;
	List<entryinfo> listentry = new ArrayList<entryinfo>();
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		
		View rootView = inflater.inflate(R.layout.fragment_news, container, false);
		
		init(rootView);
		return rootView;
	}
	@SuppressLint("NewApi") 
	private void init(View v){
		dialog = ProgressDialog.show(getActivity(), "Loading...", "Please wait...", true);
		Item3 = new ArrayList<Item_main_listview>();
		listView = (ListView) v.findViewById(R.id.main_list_new);
		adapter3 = new Adapter_main(this.getActivity(), Item3);
		listView.setAdapter(adapter3);
		listView.setOnScrollListener(new OnScrollListener() {

			@Override
			public void onScrollStateChanged(AbsListView view, int scrollState) {
				// TODO Auto-generated method stub
				int threshold = 1;
				int count = listView.getCount();

				if (scrollState == SCROLL_STATE_IDLE) {
					if (listView.getLastVisiblePosition() >= count - threshold) {

						getlist_entry(start, end);	
					}	
				}
			}

			@Override
			public void onScroll(AbsListView view, int firstVisibleItem,
					int visibleItemCount, int totalItemCount) {
				}
		});
		getlist_entry(start, end);
	}
	public entry_interface getApi() {
		if (api == null) {
			api = getentry.getService();
		}
		return api;
	}
	public void getlist_entry(final int s, final int e) {
		dialog.show();
		Log.d("chay vo day", "s=" + s + " e=" + e);
		ArrayList<Integer> lid = new ArrayList<Integer>();
		lid.add(s);
		lid.add(e);
		getApi().post_entry_info(lid, new Callback<entry_info_class>() {

			@Override
			public void success(entry_info_class arg0, Response arg1) {
				
				if (arg0.reponse.equals("true")) {
					listentry = arg0.entryinfo;
					Log.d("chay vo day", "s=" + s + " eaaa=" + listentry.size());
					if (listentry.size() >0) {
						for (int i = 0; i < listentry.size(); i++) 
						{
							Item3.add(new Item_main_listview(
									listentry.get(i).E_id,
									listentry.get(i).E_avatar,"http://a8.vietbao.vn/images/vn801/the-gioi/11057822-9.jpg", listentry
											.get(i).E_username, listentry
											.get(i).E_content, "aaa",listentry.get(i).E_date,listentry.get(i).E_view,listentry.get(i).E_sumcomment));
							
							
						}
						adapter3.notifyDataSetChanged();
						start=end+1;
						end+=5;
					}
					
				}
				dialog.dismiss();
			}
			@Override
			public void failure(RetrofitError arg0) {
				dialog.dismiss();
				Toast.makeText(getActivity(), "Kết nối server thất bại",Toast.LENGTH_LONG).show();
				Log.w("Ket noi that bai","W");
			}

		});
	
	}
//	@Override
//	public void onClick(View v) {
//		int id=v.getId();
//		if(id==R.id.testclickfragment)
//		{
//			Toast.makeText(v.getContext(),"AAa",Toast.LENGTH_LONG).show();
//		}
//		// TODO Auto-generated method stub
////		int id = v.getId();
////		switch (id) {
////		case R.id.detail_comment_id:
////			Intent i = new Intent(getActivity(), Comment.class);
////			startActivity(i);
////			break;
////		case R.id.detail_see_more_id:
////			Intent in = new Intent(getActivity(), ViewMore.class);
////			startActivity(in);
////			break;
////		default:
////			break;
////		}
//	}
	
}
