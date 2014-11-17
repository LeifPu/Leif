package com.example.helloworld;

import android.app.Activity;
import android.app.ActionBar;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.Fragment;
import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.os.Build;

public class MainActivity extends Activity {
	
	
	private Button exitButton = null;
	private static final String TAG = "MainActivity";
	private EditText mEditText;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		/**
		 * customer code begin
		 */
//		this.exitButton = (Button) super.findViewById(R.id.action_exit);
//		this.exitButton.setOnClickListener(new OnClickListenerImpl());
		mEditText = (EditText)super.findViewById(R.id.CityInput);
		

		if (savedInstanceState == null) {
			getFragmentManager().beginTransaction()
					.add(R.id.container, new PlaceholderFragment()).commit();
		}
		
		Log.e(TAG, "start onCreate.....");
	}
	
	public class OnClickListenerImpl implements OnClickListener {

		@Override
		public void onClick(View view) {
			// TODO Auto-generated method stub
			MainActivity.this.exitDialog();
		}
		
	}

	
	public void exitDialog(){
		Dialog dialog =new AlertDialog.Builder(MainActivity.this).setTitle("�뿪").setMessage("����ô�ɰ�,�����������Ҷ�ȥ��")
				.setPositiveButton("ͷҲ���ص��뿪", new DialogInterface.OnClickListener() {
					
					@Override
					public void onClick(DialogInterface dialog, int which) {
						// TODO Auto-generated method stub
						MainActivity.this.finish();
					}
				})
				.setNegativeButton("�ð�,�һ����᲻����", new DialogInterface.OnClickListener() {
					
					@Override
					public void onClick(DialogInterface dialog, int which) {
						// TODO Auto-generated method stub
						
					}
				})
				.create();
		dialog.show();
	}
	
	
	public void hardDialog(){
		Dialog dialog =new AlertDialog.Builder(MainActivity.this).setTitle("����").setMessage("�⺢������Ϊ��Ϸ������,�ﻹ�ǲ���")
				.setPositiveButton("�϶���������������ѽ", new DialogInterface.OnClickListener() {
					
					@Override
					public void onClick(DialogInterface dialog, int which) {
						// TODO Auto-generated method stub
						MainActivity.this.finish();
					}
				})
				.setNegativeButton("��ѽ,���ǲ�����", new DialogInterface.OnClickListener() {
					
					@Override
					public void onClick(DialogInterface dialog, int which) {
						// TODO Auto-generated method stub
						
					}
				})
				.create();
		dialog.show();
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {

		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		if(id == R.id.action_exit){
			this.exitDialog();
		}
		
		if(id == R.id.action_zier){
			this.hardDialog();
		}
		
		return super.onOptionsItemSelected(item);
	}

	/**
	 * A placeholder fragment containing a simple view.
	 */
	public static class PlaceholderFragment extends Fragment {

		public PlaceholderFragment() {
		}

		@Override
		public View onCreateView(LayoutInflater inflater, ViewGroup container,
				Bundle savedInstanceState) {
			View rootView = inflater.inflate(R.layout.fragment_main, container,
					false);
			return rootView;
		}
	}


	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
		Log.e(TAG, "start onPause.....");
	}


	@Override
	protected void onRestart() {
		// TODO Auto-generated method stub
		super.onRestart();
		Log.e(TAG, "start onRestart.....");
	}


	@Override
	protected void onStart() {
		// TODO Auto-generated method stub
		super.onStart();
		Log.e(TAG, "start onStart.....");
	}


	@Override
	protected void onStop() {
		// TODO Auto-generated method stub
		super.onStop();
		Log.e(TAG, "start onStop.....");
	}


	@Override
	protected void onDestroy() {
		// TODO Auto-generated method stub
		super.onDestroy();
		Log.e(TAG, "start onDestroy.....");
	}


	@Override
	protected void onResume() {
		// TODO Auto-generated method stub
		super.onResume();
		Log.e(TAG, "start onResume.....");
	}
	
	
	
	

}
