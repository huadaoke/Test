package com.xiaoke.accountms.activity;

import java.util.List;

import com.xiaoke.accountms.R;
import com.xiaoke.accountsoft.dao.FlagDAO;
import com.xiaoke.accountsoft.dao.InaccountDAO;
import com.xiaoke.accountsoft.dao.OutaccountDAO;
import com.xiaoke.accountsoft.model.Tb_flag;
import com.xiaoke.accountsoft.model.Tb_inaccount;
import com.xiaoke.accountsoft.model.Tb_outaccount;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

public class Showinfo extends Activity 
{
	public static final String FLAG="id";
	Button btnoutinfo,btnininfo,btnflaginfo;//创建3个Button对象
	ListView lvinfo;
	String strType="";
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.showinfo);
		lvinfo = (ListView) findViewById(R.id.lvinfo);// 获取布局文件中的ListView组件
		btnoutinfo = (Button) findViewById(R.id.btnoutinfo);// 获取布局文件中的支出信息按钮
		btnininfo = (Button) findViewById(R.id.btnininfo);// 获取布局文件中的收入信息按钮
		btnflaginfo = (Button) findViewById(R.id.btnflaginfo);// 获取布局文件中的便签信息按钮
		ShowInfo(R.id.btnoutinfo);// 默认显示支出信息
		btnflaginfo.setOnClickListener(new OnClickListener() {

			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				ShowInfo(R.id.btnflaginfo);
				
			}
		});
		btnoutinfo.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				ShowInfo(R.id.btnoutinfo);
			}
		});
		btnininfo.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				ShowInfo(R.id.btnininfo);
			}
		});
		lvinfo.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View view, int arg2, long arg3) {
				// TODO Auto-generated method stub
				String strInfo=String.valueOf(((TextView)view).getText());
				String strid=strInfo.substring(0,strInfo.indexOf('|'));
				Intent intent=null;
				if(strType=="btnoutinfo"|strType=="btnininfo")
				{
					intent=new Intent(Showinfo.this,InfoManage.class);
					intent.putExtra(FLAG, new String[]{strid,strType});
				}else
					if(strType=="btnflaginfo")
					{
						intent=new Intent(Showinfo.this,FlagManage.class);
						intent.putExtra(FLAG, strid);
					}
				startActivity(intent);
			}
		});

	}
	private void ShowInfo(int intType)
	{
		String[] strInfos=null;
		ArrayAdapter<String>arrayAdapter=null;
		if(intType==R.id.btnoutinfo) {// 以intType为条件进行判断// 如果是btnoutinfo按钮
			strType="btnoutinfo";
			OutaccountDAO outaccountinfo=new OutaccountDAO(Showinfo.this);
			List<Tb_outaccount>listoutinfos=outaccountinfo.getScrollData(0, (int)outaccountinfo.getCount());
			strInfos=new String[listoutinfos.size()];
			int i=0;
			for(Tb_outaccount tb_outaccount:listoutinfos)
			{
				strInfos[i]=tb_outaccount.get_id()+"|"+tb_outaccount.getType()+" "+
						String.valueOf(tb_outaccount.getMoney())+"元"+tb_outaccount.getTime();
				i++;
			}
		}
		if( R.id.btnininfo==intType)
		{// 如果是btnininfo按钮
			strType = "btnininfo";// 为strType变量赋值
			InaccountDAO inaccountinfo = new InaccountDAO(Showinfo.this);// 创建InaccountDAO对象
			// 获取所有收入信息，并存储到List泛型集合中
			List<Tb_inaccount> listinfos = inaccountinfo.getScrollData(0,
					(int) inaccountinfo.getCount());
			strInfos = new String[listinfos.size()];// 设置字符串数组的长度
			int m = 0;// 定义一个开始标识
			for (Tb_inaccount tb_inaccount : listinfos) {// 遍历List泛型集合
				// 将收入相关信息组合成一个字符串，存储到字符串数组的相应位置
				strInfos[m] = tb_inaccount.getId() + "|"
						+ tb_inaccount.getType() + " "
						+ String.valueOf(tb_inaccount.getMoney()) + "元     "
						+ tb_inaccount.getTime();
				m++;// 标识加1
			}
	}
		if(intType==R.id.btnflaginfo)
		{// 如果是btnflaginfo按钮
			strType = "btnflaginfo";// 为strType变量赋值
			FlagDAO flaginfo = new FlagDAO(Showinfo.this);// 创建FlagDAO对象
			// 获取所有便签信息，并存储到List泛型集合中
			List<Tb_flag> listFlags = flaginfo.getScrollData(0,
					(int) flaginfo.getCount());
			strInfos = new String[listFlags.size()];// 设置字符串数组的长度
			int n = 0;// 定义一个开始标识
			for (Tb_flag tb_flag : listFlags) {// 遍历List泛型集合
				// 将便签相关信息组合成一个字符串，存储到字符串数组的相应位置
				strInfos[n] = tb_flag.get_id() + "|" + tb_flag.getFlag();
				if (strInfos[n].length() > 15)// 判断便签信息的长度是否大于15
					strInfos[n] = strInfos[n].substring(0, 15) + "……";// 将位置大于15之后的字符串用……代替
				n++;// 标识加1
			}
		}
		arrayAdapter=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,strInfos);
		lvinfo.setAdapter(arrayAdapter);
	}
	@Override
	protected void onRestart() {
		// TODO Auto-generated method stub
		super.onRestart();
		ShowInfo(R.id.btnoutinfo);// 显示支出信息
	}
}
