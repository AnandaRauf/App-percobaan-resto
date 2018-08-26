package com.kulibet.resto;

import android.app.*;
import android.os.*;
import android.view.*;
import android.view.View.*;
import android.widget.*;
import android.content.*;
import android.graphics.*;
import android.media.*;
import android.net.*;
import android.text.*;
import android.util.*;
import android.webkit.*;
import android.animation.*;
import android.view.animation.*;
import java.util.*;
import java.text.*;
import android.app.Activity;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.EditText;
import android.widget.Button;
import android.content.Intent;
import android.net.Uri;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import android.view.View;

public class DaftarActivity extends Activity {
	
	
	private LinearLayout linear1;
	private LinearLayout linear2;
	private TextView textview2;
	private EditText edittext1;
	private TextView textview3;
	private EditText edittext2;
	private Button daftar;
	private Button halamanutama;
	
	private Intent daftar_ = new Intent();
	private FirebaseAuth firebaseregister;
	private OnCompleteListener<AuthResult> _firebaseregister_create_user_listener;
	private OnCompleteListener<AuthResult> _firebaseregister_sign_in_listener;
	private OnCompleteListener<Void> _firebaseregister_reset_password_listener;
	@Override
	protected void onCreate(Bundle _savedInstanceState) {
		super.onCreate(_savedInstanceState);
		setContentView(R.layout.daftar);
		initialize();
		initializeLogic();
	}
	
	private void initialize() {
		
		linear1 = (LinearLayout) findViewById(R.id.linear1);
		linear2 = (LinearLayout) findViewById(R.id.linear2);
		textview2 = (TextView) findViewById(R.id.textview2);
		edittext1 = (EditText) findViewById(R.id.edittext1);
		textview3 = (TextView) findViewById(R.id.textview3);
		edittext2 = (EditText) findViewById(R.id.edittext2);
		daftar = (Button) findViewById(R.id.daftar);
		halamanutama = (Button) findViewById(R.id.halamanutama);
		firebaseregister = FirebaseAuth.getInstance();
		
		daftar.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				if (edittext1.getText().toString().equals("") || edittext2.getText().toString().equals("")) {
					SketchwareUtil.showMessage(getApplicationContext(), "Maaf data kosong");
				}
				else {
					firebaseregister.createUserWithEmailAndPassword(edittext1.getText().toString(), edittext2.getText().toString()).addOnCompleteListener(DaftarActivity.this, _firebaseregister_create_user_listener);
					daftar_.setClass(getApplicationContext(), MasukActivity.class);
					SketchwareUtil.showMessage(getApplicationContext(), "Selamat anda berhasil mendaftar");
					SketchwareUtil.showMessage(getApplicationContext(), "Selamat datang admin ^_^");
					startActivity(daftar_);
					finish();
				}
			}
		});
		
		halamanutama.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				daftar_.setClass(getApplicationContext(), MainActivity.class);
				daftar_.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
				startActivity(daftar_);
			}
		});
		
		_firebaseregister_create_user_listener = new OnCompleteListener<AuthResult>() {
			@Override
			public void onComplete(Task<AuthResult> _param1) {
				final boolean _success = _param1.isSuccessful();
				final String _errorMessage = _param1.getException() != null ? _param1.getException().getMessage() : "";
				
			}
		};
		
		_firebaseregister_sign_in_listener = new OnCompleteListener<AuthResult>() {
			@Override
			public void onComplete(Task<AuthResult> _param1) {
				final boolean _success = _param1.isSuccessful();
				final String _errorMessage = _param1.getException() != null ? _param1.getException().getMessage() : "";
				
			}
		};
		
		_firebaseregister_reset_password_listener = new OnCompleteListener<Void>() {
			@Override
			public void onComplete(Task<Void> _param1) {
				final boolean _success = _param1.isSuccessful();
				
			}
		};
	}
	private void initializeLogic() {
	}
	
	@Override
	protected void onActivityResult(int _requestCode, int _resultCode, Intent _data) {
		super.onActivityResult(_requestCode, _resultCode, _data);
		
		switch (_requestCode) {
			
			default:
			break;
		}
	}
	
	@Deprecated
	public void showMessage(String _s) {
		Toast.makeText(getApplicationContext(), _s, Toast.LENGTH_SHORT).show();
	}
	
	@Deprecated
	public int getLocationX(View _v) {
		int _location[] = new int[2];
		_v.getLocationInWindow(_location);
		return _location[0];
	}
	
	@Deprecated
	public int getLocationY(View _v) {
		int _location[] = new int[2];
		_v.getLocationInWindow(_location);
		return _location[1];
	}
	
	@Deprecated
	public int getRandom(int _min, int _max) {
		Random random = new Random();
		return random.nextInt(_max - _min + 1) + _min;
	}
	
	@Deprecated
	public ArrayList<Double> getCheckedItemPositionsToArray(ListView _list) {
		ArrayList<Double> _result = new ArrayList<Double>();
		SparseBooleanArray _arr = _list.getCheckedItemPositions();
		for (int _iIdx = 0; _iIdx < _arr.size(); _iIdx++) {
			if (_arr.valueAt(_iIdx))
			_result.add((double)_arr.keyAt(_iIdx));
		}
		return _result;
	}
	
	@Deprecated
	public float getDip(int _input){
		return TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, _input, getResources().getDisplayMetrics());
	}
	
	@Deprecated
	public int getDisplayWidthPixels(){
		return getResources().getDisplayMetrics().widthPixels;
	}
	
	@Deprecated
	public int getDisplayHeightPixels(){
		return getResources().getDisplayMetrics().heightPixels;
	}
	
}
