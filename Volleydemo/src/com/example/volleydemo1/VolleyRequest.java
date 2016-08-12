package com.example.volleydemo1;

import java.util.HashMap;
import java.util.Map;

import android.content.Context;

import com.android.volley.AuthFailureError;
import com.android.volley.Response.ErrorListener;
import com.android.volley.Response.Listener;
import com.android.volley.toolbox.StringRequest;

public class VolleyRequest {
	public static StringRequest stringRequest;
	public Context context;

	static class MyStringRequest extends StringRequest {
		public Map<String, String> headers = new HashMap<String, String>();

		public MyStringRequest(int method, String url,
				Listener<String> listener, ErrorListener errorListener) {
			super(method, url, listener, errorListener);
			// TODO Auto-generated constructor stub
		}

		@Override
		public Map<String, String> getHeaders() throws AuthFailureError {
			// TODO Auto-generated method stub
			return headers;
		}

	}

}
