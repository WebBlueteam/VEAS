package com.ailab.veas;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.ailab.veas.util.Utils;

public class Login extends Activity implements OnClickListener {
	private TextView mLogin_slogan_tv, mLogin_register_tv;
	private EditText mLogin_acc_et, mlogin_pass_et;
	private Button mLogin_button_login;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		init();
	}
	private void init(){
		mLogin_slogan_tv = (TextView)findViewById(R.id.login_slogan_id);
		mLogin_acc_et = (EditText)findViewById(R.id.login_acc_id);
		mlogin_pass_et = (EditText)findViewById(R.id.login_pass_id);
		mLogin_button_login = (Button)findViewById(R.id.login_button_id);
		mLogin_register_tv = (TextView)findViewById(R.id.login_register_id);
		Utils.setTypefaceRoboto(getApplicationContext(), mLogin_slogan_tv, mLogin_acc_et, mlogin_pass_et, mLogin_button_login, mLogin_register_tv);
		mLogin_register_tv.setOnClickListener(this);
		mLogin_button_login.setOnClickListener(this);
	}
	
	
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		int id = v.getId();
		switch (id) {
		case R.id.login_button_id:
			
			Intent in = new Intent(getApplicationContext(), MainActivity.class);
			startActivity(in);
			break;
		case R.id.login_register_id:
			Intent i = new Intent(getApplicationContext(), RegisterFragment.class);
			startActivity(i);
			break;
		default:
			break;
		}
	}
	
	
}
