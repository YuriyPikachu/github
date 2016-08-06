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

		mActionBar.setTitle("������");// ����������
		mActionBar.setSubtitle("�ӱ���");// �����ӱ���
		mActionBar.setIcon(R.drawable.ic_action_star);//
		mActionBar.setLogo(R.drawable.ic_launcher);
		mActionBar.setDisplayUseLogoEnabled(true);// �����Ƿ���ʾLogo����

		mActionBar.setDisplayShowTitleEnabled(true);// ���ò˵� �����Ƿ�ɼ�
		mActionBar.setDisplayShowHomeEnabled(true);// ����Ӧ��ͼ���Ƿ�
		mActionBar.setDisplayHomeAsUpEnabled(true);// ����back��ť�Ƿ�ɼ�
		
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
				// ҵ���߼�
				Toast.makeText(this, "xxxx", Toast.LENGTH_SHORT).show();
				break;
			case R.id.action_search:
				SearchView searchView = (SearchView) smi.getActionView();

				// ����adapter
				searchView.setSuggestionsAdapter(null);

				break;
			default:
				break;
		}

		return super.onOptionsItemSelected(item);
	}
}
