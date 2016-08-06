package com.example.actionbarexample;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.internal.view.SupportMenuItem;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.SearchView;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

public class TwoMenu extends ActionBarActivity {
	private ActionBar mActionBar;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_two);
		mActionBar = getSupportActionBar();

		mActionBar.setTitle("主标题");// 设置主标题
		mActionBar.setSubtitle("子标题");// 设置子标题
		mActionBar.setIcon(R.drawable.ic_action_star);//
		mActionBar.setLogo(R.drawable.ic_launcher);
		mActionBar.setDisplayUseLogoEnabled(true);// 设置是否显示Logo优先

		mActionBar.setDisplayShowTitleEnabled(true);// 设置菜单 标题是否可见
		mActionBar.setDisplayShowHomeEnabled(true);// 设置应用图标是否
		mActionBar.setDisplayHomeAsUpEnabled(true);// 设置back按钮是否可见
		
	}
	public void clicl(View view){
		startActivity(new Intent(this,DaoActivity.class));
	}
	@Override
	public boolean onCreateOptionsMenu(Menu menu)
	{
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		int id = item.getItemId();

		SupportMenuItem smi = (SupportMenuItem) item;

		switch (id)
		{
			case R.id.action_settings:
				// 业务逻辑
				Toast.makeText(this, "xxxx", Toast.LENGTH_SHORT).show();
				break;
			case R.id.action_search:
				SearchView searchView = (SearchView) smi.getActionView();

				// 设置adapter
				searchView.setSuggestionsAdapter(null);

				break;
			default:
				break;
		}

		return super.onOptionsItemSelected(item);
	}
}
