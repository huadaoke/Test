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
	String[] titles=new String[]{"����֧��","��������","�ҵ�֧��","�ҵ�����","���ݹ���","ϵͳ����","��֧��ǩ","�˳�"};
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
							intent=new Intent(MainActivity.this,AddOutaccount.class);//��AddOutaccount
							startActivity(intent);
							break;
						case 1:
							intent=new Intent(MainActivity.this,AddInaccount.class);//��AddInaccount
							startActivity(intent);
							break;
						case 2:
							intent=new Intent(MainActivity.this,Outaccountinfo.class);//��Outaccountinfo
							startActivity(intent);
							break;
						case 3:
							intent=new Intent(MainActivity.this,Inaccountinfo.class);//��Inaccountinfo
							startActivity(intent);
							break;
						case 4:
							intent=new Intent(MainActivity.this,Showinfo.class);//��showInfo
							startActivity(intent);//��Sysset  
							break;
						case 5:
							intent=new Intent(MainActivity.this,Sysset.class);//ʹ��Sysset���ڳ�ʼ��Intent
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
