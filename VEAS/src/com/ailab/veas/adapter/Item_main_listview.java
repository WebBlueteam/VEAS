package com.ailab.veas.adapter;

public class Item_main_listview {
	public int Id;
	public String Icon_user;
	public String Icon_main_picture;
	public String Username;
	public String Content;
	public String Link;
	public String DateTime;
	public int NumView;
	public int NumComment;
	public Item_main_listview(int id, String icon_user,String icon_main_pic, 
			String username,String content,String link,String date,int vie,int cm) {
 
		Id = id;
		Icon_user = icon_user;
		Icon_main_picture=icon_main_pic;
		Username=username;
		Content=content;
		Link=link;
		DateTime=date;
		NumView =vie;
		NumComment=cm;
		
	}
}
