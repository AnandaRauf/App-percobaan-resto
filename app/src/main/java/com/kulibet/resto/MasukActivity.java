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
import java.util.HashMap;
import java.util.ArrayList;
import android.widget.LinearLayout;
import android.widget.Button;
import android.widget.TextView;
import android.widget.EditText;
import android.content.Intent;
import android.net.Uri;
import android.view.View;
import com.google.gson.Gson;

public class MasukActivity extends Activity {
	
	
	private HashMap<String, Object> map = new HashMap<>();
	private double total__pembayaran = 0;
	private double uang__pembeli = 0;
	private double stokmakanan = 0;
	
	private ArrayList<String> barang = new ArrayList<>();
	private ArrayList<HashMap<String, Object>> barangbanyak = new ArrayList<>();
	
	private LinearLayout linear2;
	private Button halamanutama;
	private TextView namamakanan;
	private EditText masukkannamamakanan;
	private TextView namaminuman;
	private EditText masukkannamaminuman;
	private TextView hargamakanan;
	private EditText harga_makanan;
	private TextView hargaminuman;
	private EditText harga_minuman;
	private TextView jmlhporsimakanan;
	private EditText jumlahporsimakanan;
	private TextView jmlhporsiminuman;
	private EditText jumlahporsiminuman;
	private TextView totalpembayaran;
	private EditText total_pembayaran;
	private TextView uangpembeli;
	private EditText uang_pembeli;
	private Button print;
	private Button gudang;
	
	private Intent gudang_ = new Intent();
	@Override
	protected void onCreate(Bundle _savedInstanceState) {
		super.onCreate(_savedInstanceState);
		setContentView(R.layout.masuk);
		initialize();
		initializeLogic();
	}
	
	private void initialize() {
		
		linear2 = (LinearLayout) findViewById(R.id.linear2);
		halamanutama = (Button) findViewById(R.id.halamanutama);
		namamakanan = (TextView) findViewById(R.id.namamakanan);
		masukkannamamakanan = (EditText) findViewById(R.id.masukkannamamakanan);
		namaminuman = (TextView) findViewById(R.id.namaminuman);
		masukkannamaminuman = (EditText) findViewById(R.id.masukkannamaminuman);
		hargamakanan = (TextView) findViewById(R.id.hargamakanan);
		harga_makanan = (EditText) findViewById(R.id.harga_makanan);
		hargaminuman = (TextView) findViewById(R.id.hargaminuman);
		harga_minuman = (EditText) findViewById(R.id.harga_minuman);
		jmlhporsimakanan = (TextView) findViewById(R.id.jmlhporsimakanan);
		jumlahporsimakanan = (EditText) findViewById(R.id.jumlahporsimakanan);
		jmlhporsiminuman = (TextView) findViewById(R.id.jmlhporsiminuman);
		jumlahporsiminuman = (EditText) findViewById(R.id.jumlahporsiminuman);
		totalpembayaran = (TextView) findViewById(R.id.totalpembayaran);
		total_pembayaran = (EditText) findViewById(R.id.total_pembayaran);
		uangpembeli = (TextView) findViewById(R.id.uangpembeli);
		uang_pembeli = (EditText) findViewById(R.id.uang_pembeli);
		print = (Button) findViewById(R.id.print);
		gudang = (Button) findViewById(R.id.gudang);
		
		halamanutama.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				gudang_.setClass(getApplicationContext(), MainActivity.class);
				gudang_.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
				startActivity(gudang_);
			}
		});
		
		print.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				map = new HashMap<>();
				map.put("Nama makanan", masukkannamamakanan.getText().toString());
				map.put("Nama minuman", masukkannamaminuman.getText().toString());
				map.put("Harga makanan", harga_makanan.getText().toString());
				map.put("Harga minuman", harga_minuman.getText().toString());
				map.put("Total pembayaran", total_pembayaran.getText().toString());
				map.put("Uang pembeli", uang_pembeli.getText().toString());
				FileUtil.writeFile("path", new Gson().toJson(barangbanyak));
				total__pembayaran = Double.parseDouble(harga_makanan.getText().toString()) + Double.parseDouble(harga_minuman.getText().toString());
				uang__pembeli = Double.parseDouble(uang_pembeli.getText().toString()) - total__pembayaran;
				stokmakanan = Double.parseDouble(jumlahporsimakanan.getText().toString()) - barang.indexOf(jumlahporsimakanan.getText().toString());
				stokmakanan = Double.parseDouble(jumlahporsiminuman.getText().toString()) - barang.indexOf(jumlahporsiminuman.getText().toString());
			}
		});
		
		gudang.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				gudang_.setClass(getApplicationContext(), GudangActivity.class);
				SketchwareUtil.showMessage(getApplicationContext(), "Halaman gudang stok barang");
				startActivity(gudang_);
				finish();
			}
		});
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
