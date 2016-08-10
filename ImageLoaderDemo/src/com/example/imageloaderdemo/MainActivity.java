package com.example.imageloaderdemo;

import java.util.ArrayList;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.RelativeLayout;

public class MainActivity extends Activity {
	private ViewPager viewPager;
	private ArrayList<String> list = new ArrayList<String>();
	private Handler handler = new Handler(){
		public void handleMessage(android.os.Message msg) {
			viewPager.setCurrentItem(viewPager.getCurrentItem()+1);

			handler.sendEmptyMessageDelayed(0, 2015);
		};
	};
	private RelativeLayout rl;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		list.add("http://192.168.2.148:8080/images/1.jpg");
		list.add("http://192.168.2.148:8080/images/2.jpg");
		list.add("http://192.168.2.148:8080/images/3.jpg");
		list.add("http://192.168.2.148:8080/images/4.jpg");
		list.add("http://192.168.2.148:8080/images/5.jpg");
		View headerView = View.inflate(this, R.layout.layout_home_header, null);
		viewPager = (ViewPager) headerView.findViewById(R.id.homePager);
		//1.动态根据图片的宽高比设置viewPager的高度
		int width = this.getWindowManager().getDefaultDisplay().getWidth();
		//根据宽高比计算出高度，2.65=width/height
		float height = width/2.65f;
		LayoutParams params = viewPager.getLayoutParams();
		params.height = (int) height;
		params.width = width;
		viewPager.setLayoutParams(params);
		CommonUtil.runOnUIThread(new Runnable() {
			@Override
			public void run() {
				//表明有轮播大图的数据
				HomeHeaderAdapter headerAdapter = new HomeHeaderAdapter(list);
				viewPager.setAdapter(headerAdapter);//给ViewPager设置Adapter
				//					headerAdapter.notifyDataSetChanged()://注意，此方法无效
				//默认给ViewPager选中比较大的item
				viewPager.setCurrentItem(list.size()*100000);



			}
		});
		rl = (RelativeLayout) findViewById(R.id.rl);
		rl.addView(headerView);
	}

	@Override
	public void onResume() {
		super.onResume();
		handler.sendEmptyMessageDelayed(0, 2015);//延时发送消息
	}

	@Override
	protected void onDestroy() {
		// TODO Auto-generated method stub
		super.onDestroy();
		handler.removeCallbacksAndMessages(null);
	}
}
