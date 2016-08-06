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
		//��ȡactionBar�������
		mActionBar = getSupportActionBar();
		mActionBar.setTitle("��ҳ");
		mActionBar.setSubtitle("��ҳ");
		mActionBar.setIcon(R.drawable.ic_action_star);
		mActionBar.setLogo(R.drawable.ic_launcher);
		mActionBar.setDisplayUseLogoEnabled(false);// �����Ƿ���ʾLogo����

		mActionBar.setDisplayShowTitleEnabled(true);// ���ò˵� �����Ƿ�ɼ�
		mActionBar.setDisplayShowHomeEnabled(true);// ����Ӧ��ͼ���Ƿ�
		mActionBar.setDisplayHomeAsUpEnabled(true);// ����back��ť�Ƿ�ɼ�
	}
	public void click(View v){
		startSupportActionMode(this);
	}
	public void tiao(View v){
		startActivity(new Intent(this,TwoMenu.class));
	}
	//������ʱ�������������
	@Override
	public boolean onCreateActionMode(ActionMode mode, Menu menu) {
		getMenuInflater().inflate(R.menu.action_mode, menu);
		return true;
	}
	//��û����֮ǰִ�еķ���
	@Override
	public boolean onPrepareActionMode(ActionMode mode, Menu menu) {
		return false;
	}
	//item�����ʱ�����Ĵ���
	@Override
	public boolean onActionItemClicked(ActionMode mode, MenuItem item) {
		int itemId = item.getItemId();
		Toast.makeText(getApplicationContext(), item.getTitle(), Toast.LENGTH_SHORT).show();
		//��ʧ���Ӳ˵�
		mode.finish();
		return false;
	}
	//���ٵ�ʱ�����Ĵ���
	@Override
	public void onDestroyActionMode(ActionMode mode) {
		
	}
}
