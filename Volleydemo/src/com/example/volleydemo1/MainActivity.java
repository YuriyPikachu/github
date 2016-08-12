package com.example.volleydemo1;

import com.android.volley.Request;
import com.android.volley.Response.ErrorListener;
import com.android.volley.Response.Listener;
import com.android.volley.VolleyError;
import com.example.volleydemo1.VolleyRequest.MyStringRequest;

import com.google.gson.Gson;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;

public class MainActivity extends Activity {
	private static final String TAG = "Volley";
	private TextView tv;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		tv = (TextView) findViewById(R.id.tv);
		findViewById(R.id.bt_button).setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				String url = "http://192.168.2.132/kpApp/news/picture";
				MyStringRequest myStringRequest = new MyStringRequest(
						Request.Method.GET, url, new Listener<String>() {

							@Override
							public void onResponse(String response) {
								// TODO Auto-generated method stub
								
								tv.setText(response);
								System.out.println(response);
							}
						}, new ErrorListener() {

							@Override
							public void onErrorResponse(VolleyError error) {
								Log.i("error>", error.toString());

							}
						});
//				myStringRequest.headers.put("apikey",
//						"6ee217488609aa62972663f6eefe6644");
				MyApplication.getHttpQueues().add(myStringRequest);
			}
		});
	}
//	public void processData(String response){
//		Gson gson = new Gson();
//		NewsTopBean newsTopBean = gson.fromJson(response.toString(), NewsTopBean.class);
//		
//	}

}
