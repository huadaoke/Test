package com.xiaoke.accountms.activity;
import com.xiaoke.accountms.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.GridView;

public class MainActivity extends Activity
{

	GridView gvInfo;
	String[] titles=new String[]{"新增支出","新增收入","我的支出","我的收入","数据管理","系统设置","收支便签","退出"};
	int[] images=new int[]{R.drawable.addoutaccount,R.drawable.addinaccount,R.drawable.outaccountinfo,R.drawable.inaccountinfo
			,R.drawable.showinfo,R.drawable.sysset,R.drawable.accountflag,R.drawable.exit};
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		gvInfo=(GridView)findViewById(R.id.gvInfo);
		pictureAdapter adapter=new pictureAdapter(titles,images,this);
		gvInfo.setAdapter(adapter);
		gvInfo.setOnItemClickListener(new OnItemClickListener()
				{

					@Override
					public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
						// TODO Auto-generated method stub
						Intent intent=null;
						switch(arg2)
						{
						case 0:
							intent=new Intent(MainActivity.this,AddOutaccount.class);//打开AddOutaccount
							startActivity(intent);
							break;
						case 1:
							intent=new Intent(MainActivity.this,AddInaccount.class);//打开AddInaccount
							startActivity(intent);
							break;
						case 2:
							intent=new Intent(MainActivity.this,Outaccountinfo.class);//打开Outaccountinfo
							startActivity(intent);
							break;
						case 3:
							intent=new Intent(MainActivity.this,Inaccountinfo.class);//打开Inaccountinfo
							startActivity(intent);
							break;
						case 4:
							intent=new Intent(MainActivity.this,Showinfo.class);//打开showInfo
							startActivity(intent);//打开Sysset  
							break;
						case 5:
							intent=new Intent(MainActivity.this,Sysset.class);//使用Sysset窗口初始化Intent
							startActivity(intent);
							break;					
						case 6:
							intent =new Intent(MainActivity.this,Accountflag.class);
							startActivity(intent);
							break;
						case 7:
							finish();
						}
					}
			
				});
	}

}
