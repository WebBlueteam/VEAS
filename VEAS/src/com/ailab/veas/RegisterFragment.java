package com.ailab.veas;

import com.ailab.veas.util.Utils;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

@SuppressLint("NewApi") 
public class RegisterFragment extends Activity {
	private TextView mTitleBar, mTextView;
	private TextView mAcc, mPass1, mPass2;
	private Button mCancel, mYes;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.login_register_lay);
		init();
	}
	private void init(){
		mTitleBar = (TextView)findViewById(R.id.register_title_id);
		mTextView = (TextView)findViewById(R.id.textview1);
		
		mAcc = (TextView)findViewById(R.id.register_acc_id);
		mPass1 = (TextView)findViewById(R.id.register_pass1_id);
		mPass2 = (TextView)findViewById(R.id.register_pass2_id);
		mCancel = (Button)findViewById(R.id.register_cancel_btn_id);
		mYes = (Button)findViewById(R.id.register_ok_btn_id);
		Utils.setTypefaceRoboto(getApplicationContext(), mTitleBar, mTextView, mAcc, mPass1, mPass2, mCancel, mYes);
	}
}
