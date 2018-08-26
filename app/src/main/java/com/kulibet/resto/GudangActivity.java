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
import android.widget.EditText;
import android.widget.ListView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.content.Intent;
import android.net.Uri;
import android.view.View;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class GudangActivity extends Activity {
	
	
	private String search = "";
	private String var = "";
	private HashMap<String, Object> map = new HashMap<>();
	private double stok = 0;
	
	private ArrayList<HashMap<String, Object>> barangbanyak = new ArrayList<>();
	private ArrayList<String> stoks = new ArrayList<>();
	
	private LinearLayout linear1;
	private Button halamanprint;
	private Button refresh;
	private Button caribarang;
	private EditText cari_barang;
	private ListView listview1;
	private ListView listview2;
	private EditText namastokbarang;
	private EditText hargabarang;
	private EditText jumlahstokbarang;
	private Button tambahkanstokbarang;
	private Button tambahkanbarang;
	private Button tambahkanharga;
	private Button button1;
	
	private Intent kembali = new Intent();
	@Override
	protected void onCreate(Bundle _savedInstanceState) {
		super.onCreate(_savedInstanceState);
		setContentView(R.layout.gudang);
		initialize();
		initializeLogic();
	}
	
	private void initialize() {
		
		linear1 = (LinearLayout) findViewById(R.id.linear1);
		halamanprint = (Button) findViewById(R.id.halamanprint);
		refresh = (Button) findViewById(R.id.refresh);
		caribarang = (Button) findViewById(R.id.caribarang);
		cari_barang = (EditText) findViewById(R.id.cari_barang);
		listview1 = (ListView) findViewById(R.id.listview1);
		listview2 = (ListView) findViewById(R.id.listview2);
		namastokbarang = (EditText) findViewById(R.id.namastokbarang);
		hargabarang = (EditText) findViewById(R.id.hargabarang);
		jumlahstokbarang = (EditText) findViewById(R.id.jumlahstokbarang);
		tambahkanstokbarang = (Button) findViewById(R.id.tambahkanstokbarang);
		tambahkanbarang = (Button) findViewById(R.id.tambahkanbarang);
		tambahkanharga = (Button) findViewById(R.id.tambahkanharga);
		button1 = (Button) findViewById(R.id.button1);
		
		halamanprint.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				kembali.setClass(getApplicationContext(), MasukActivity.class);
				kembali.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
				startActivity(kembali);
			}
		});
		
		refresh.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				((BaseAdapter)listview1.getAdapter()).notifyDataSetChanged();
			}
		});
		
		caribarang.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				listview1.smoothScrollToPosition((int)(Double.parseDouble(cari_barang.getText().toString())));
				listview2.smoothScrollToPosition((int)(Double.parseDouble(cari_barang.getText().toString())));
			}
		});
		
		tambahkanstokbarang.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				barangbanyak = new Gson().fromJson(map.get(jumlahstokbarang.getText().toString()).toString(), new TypeToken<ArrayList<HashMap<String, Object>>>(){}.getType());
				listview1.setAdapter(new Listview1Adapter(barangbanyak));
				stok = Double.parseDouble(jumlahstokbarang.getText().toString()) - stoks.indexOf(jumlahstokbarang.getText().toString());
				stok = Double.parseDouble(tambahkanstokbarang.getText().toString()) - stoks.indexOf(tambahkanstokbarang.getText().toString());
			}
		});
		
		tambahkanbarang.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				barangbanyak = new Gson().fromJson(map.get(namastokbarang.getText().toString()).toString(), new TypeToken<ArrayList<HashMap<String, Object>>>(){}.getType());
				listview1.setAdapter(new Listview1Adapter(barangbanyak));
			}
		});
		
		tambahkanharga.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				barangbanyak = new Gson().fromJson(map.get(hargabarang.getText().toString()).toString(), new TypeToken<ArrayList<HashMap<String, Object>>>(){}.getType());
				listview1.setAdapter(new Listview1Adapter(barangbanyak));
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
	
	private void _stokbarang (final String _stokbarang) {
		
	}
	
	
	public class Listview1Adapter extends BaseAdapter {
		ArrayList<HashMap<String, Object>> _data;
		public Listview1Adapter(ArrayList<HashMap<String, Object>> _arr) {
			_data = _arr;
		}
		
		@Override
		public int getCount() {
			return _data.size();
		}
		
		@Override
		public HashMap<String, Object> getItem(int _index) {
			return _data.get(_index);
		}
		
		@Override
		public long getItemId(int _index) {
			return _index;
		}
		@Override
		public View getView(final int _position, View _view, ViewGroup _viewGroup) {
			LayoutInflater _inflater = (LayoutInflater)getBaseContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			View _v = _view;
			if (_v == null) {
				_v = _inflater.inflate(R.layout.listmap1, null);
			}
			
			
			
			
			return _v;
		}
	}
	
	public class Listview2Adapter extends BaseAdapter {
		ArrayList<HashMap<String, Object>> _data;
		public Listview2Adapter(ArrayList<HashMap<String, Object>> _arr) {
			_data = _arr;
		}
		
		@Override
		public int getCount() {
			return _data.size();
		}
		
		@Override
		public HashMap<String, Object> getItem(int _index) {
			return _data.get(_index);
		}
		
		@Override
		public long getItemId(int _index) {
			return _index;
		}
		@Override
		public View getView(final int _position, View _view, ViewGroup _viewGroup) {
			LayoutInflater _inflater = (LayoutInflater)getBaseContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			View _v = _view;
			if (_v == null) {
				_v = _inflater.inflate(R.layout.listmap2, null);
			}
			
			
			
			
			return _v;
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
