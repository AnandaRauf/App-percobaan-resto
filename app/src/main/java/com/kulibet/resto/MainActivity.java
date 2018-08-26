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
import android.content.SharedPreferences;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import android.view.View;

public class MainActivity extends Activity {
	
	
	private LinearLayout linear2;
	private TextView textview2;
	private TextView emailadmin;
	private EditText email_admin_edittxt;
	private TextView passwordadmin;
	private EditText paswordadmin_edittxt;
	private Button masuk;
	private Button daftar;
	private Button lupapassword;
	private TextView textview3;
	private TextView textview4;
	
	private Intent msk = new Intent();
	private SharedPreferences useradmin;
	private FirebaseAuth kulibetresto;
	private OnCompleteListener<AuthResult> _kulibetresto_create_user_listener;
	private OnCompleteListener<AuthResult> _kulibetresto_sign_in_listener;
	private OnCompleteListener<Void> _kulibetresto_reset_password_listener;
	@Override
	protected void onCreate(Bundle _savedInstanceState) {
		super.onCreate(_savedInstanceState);
		setContentView(R.layout.main);
		initialize();
		initializeLogic();
	}
	
	private void initialize() {
		
		linear2 = (LinearLayout) findViewById(R.id.linear2);
		textview2 = (TextView) findViewById(R.id.textview2);
		emailadmin = (TextView) findViewById(R.id.emailadmin);
		email_admin_edittxt = (EditText) findViewById(R.id.email_admin_edittxt);
		passwordadmin = (TextView) findViewById(R.id.passwordadmin);
		paswordadmin_edittxt = (EditText) findViewById(R.id.paswordadmin_edittxt);
		masuk = (Button) findViewById(R.id.masuk);
		daftar = (Button) findViewById(R.id.daftar);
		lupapassword = (Button) findViewById(R.id.lupapassword);
		textview3 = (TextView) findViewById(R.id.textview3);
		textview4 = (TextView) findViewById(R.id.textview4);
		useradmin = getSharedPreferences("admin", Activity.MODE_PRIVATE);
		kulibetresto = FirebaseAuth.getInstance();
		
		masuk.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				if (email_admin_edittxt.getText().toString().equals("") || paswordadmin_edittxt.getText().toString().equals("")) {
					SketchwareUtil.showMessage(getApplicationContext(), "Maaf data kosong");
				}
				else {
					kulibetresto.signInWithEmailAndPassword(email_admin_edittxt.getText().toString(), paswordadmin_edittxt.getText().toString()).addOnCompleteListener(MainActivity.this, _kulibetresto_sign_in_listener);
					msk.setClass(getApplicationContext(), MasukActivity.class);
					SketchwareUtil.showMessage(getApplicationContext(), "Selamat datang 😊");
					startActivity(msk);
					finish();
				}
			}
		});
		
		daftar.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				msk.setClass(getApplicationContext(), DaftarActivity.class);
				startActivity(msk);
				finish();
			}
		});
		
		lupapassword.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				msk.setClass(getApplicationContext(), LupapasswordActivity.class);
				startActivity(msk);
				finish();
			}
		});
		
		_kulibetresto_create_user_listener = new OnCompleteListener<AuthResult>() {
			@Override
			public void onComplete(Task<AuthResult> _param1) {
				final boolean _success = _param1.isSuccessful();
				final String _errorMessage = _param1.getException() != null ? _param1.getException().getMessage() : "";
				
			}
		};
		
		_kulibetresto_sign_in_listener = new OnCompleteListener<AuthResult>() {
			@Override
			public void onComplete(Task<AuthResult> _param1) {
				final boolean _success = _param1.isSuccessful();
				final String _errorMessage = _param1.getException() != null ? _param1.getException().getMessage() : "";
				
			}
		};
		
		_kulibetresto_reset_password_listener = new OnCompleteListener<Void>() {
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
