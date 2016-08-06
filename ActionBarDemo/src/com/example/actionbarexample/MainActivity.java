package com.example.actionbarexample;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.view.ActionMode;
import android.support.v7.view.ActionMode.Callback;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends ActionBarActivity implements Callback{

	private ActionBar mActionBar;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		//获取actionBar这个对象
		mActionBar = getSupportActionBar();
		mActionBar.setTitle("主页");
		mActionBar.setSubtitle("附页");
		mActionBar.setIcon(R.drawable.ic_action_star);
		mActionBar.setLogo(R.drawable.ic_launcher);
		mActionBar.setDisplayUseLogoEnabled(false);// 设置是否显示Logo优先

		mActionBar.setDisplayShowTitleEnabled(true);// 设置菜单 标题是否可见
		mActionBar.setDisplayShowHomeEnabled(true);// 设置应用图标是否
		mActionBar.setDisplayHomeAsUpEnabled(true);// 设置back按钮是否可见
	}
	public void click(View v){
		startSupportActionMode(this);
	}
	public void tiao(View v){
		startActivity(new Intent(this,TwoMenu.class));
	}
	//创建的时候会调用这个方法
	@Override
	public boolean onCreateActionMode(ActionMode mode, Menu menu) {
		getMenuInflater().inflate(R.menu.action_mode, menu);
		return true;
	}
	//还没创建之前执行的方法
	@Override
	public boolean onPrepareActionMode(ActionMode mode, Menu menu) {
		return false;
	}
	//item点击的时候做的处理
	@Override
	public boolean onActionItemClicked(ActionMode mode, MenuItem item) {
		int itemId = item.getItemId();
		Toast.makeText(getApplicationContext(), item.getTitle(), Toast.LENGTH_SHORT).show();
		//消失让子菜单
		mode.finish();
		return false;
	}
	//销毁的时候做的处理
	@Override
	public void onDestroyActionMode(ActionMode mode) {
		
	}
}
