package com.example.actionbarexample;

import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBar.Tab;
import android.support.v7.app.ActionBar.TabListener;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.widget.Toast;

public class DaoActivity extends ActionBarActivity {
	private ActionBar mActionBar;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_dao);
		mActionBar = getSupportActionBar();

		mActionBar.setTitle("������");// ����������
		mActionBar.setSubtitle("�ӱ���");// �����ӱ���
		mActionBar.setIcon(R.drawable.ic_action_star);//
		mActionBar.setLogo(R.drawable.ic_launcher);

		mActionBar.setDisplayUseLogoEnabled(false);// �����Ƿ���ʾLogo����

		mActionBar.setDisplayShowTitleEnabled(true);// ���ò˵� �����Ƿ�ɼ�
		mActionBar.setDisplayShowHomeEnabled(true);// ����Ӧ��ͼ���Ƿ�
		mActionBar.setDisplayHomeAsUpEnabled(true);// ����back��ť�Ƿ�ɼ�
		//����ģʽ-->list
//		mActionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_LIST);// list
//
//		final List<String> objects = new ArrayList<String>();
//		objects.add("��ҳ");
//		objects.add("����");
//		objects.add("����");
//
//		// ��Ҫ����adapter
//		mActionBar.setListNavigationCallbacks(new ArrayAdapter<String>(this,
//				android.R.layout.simple_list_item_1, objects), new
//				OnNavigationListener() {
//
//			@Override
//			public boolean onNavigationItemSelected(int itemPosition, long
//					itemId)
//			{
//				Toast.makeText(getApplicationContext(), objects.get(itemPosition) +
//						"ѡ����", Toast.LENGTH_SHORT).show();
//
//				return false;
//			}
//		});
		// ����ģʽ-->Tabs
				mActionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);

				for (int i = 0; i < 4; i++)
				{
					// ����tab
					Tab tab = mActionBar.newTab();

					tab.setText("Tab" + i);
					tab.setIcon(R.drawable.ic_action_star);

					tab.setTabListener(new TabListener() {

						@Override
						public void onTabUnselected(Tab tab, FragmentTransaction ft)
						{
							// TODO Auto-generated method stub

						}

						@Override
						public void onTabSelected(Tab tab, FragmentTransaction ft)
						{
							Toast.makeText(getApplicationContext(), tab.getText() +
																	"ѡ����", Toast.LENGTH_SHORT).show();
						}

						@Override
						public void onTabReselected(Tab tab, FragmentTransaction ft)
						{
							// TODO Auto-generated method stub

						}
					});

					mActionBar.addTab(tab);
				}
	}
	@Override
	public boolean onCreateOptionsMenu(Menu menu)
	{
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
}
