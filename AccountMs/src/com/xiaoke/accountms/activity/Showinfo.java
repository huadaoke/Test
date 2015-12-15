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
	Button btnoutinfo,btnininfo,btnflaginfo;//����3��Button����
	ListView lvinfo;
	String strType="";
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.showinfo);
		lvinfo = (ListView) findViewById(R.id.lvinfo);// ��ȡ�����ļ��е�ListView���
		btnoutinfo = (Button) findViewById(R.id.btnoutinfo);// ��ȡ�����ļ��е�֧����Ϣ��ť
		btnininfo = (Button) findViewById(R.id.btnininfo);// ��ȡ�����ļ��е�������Ϣ��ť
		btnflaginfo = (Button) findViewById(R.id.btnflaginfo);// ��ȡ�����ļ��еı�ǩ��Ϣ��ť
		ShowInfo(R.id.btnoutinfo);// Ĭ����ʾ֧����Ϣ
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
		if(intType==R.id.btnoutinfo) {// ��intTypeΪ���������ж�// �����btnoutinfo��ť
			strType="btnoutinfo";
			OutaccountDAO outaccountinfo=new OutaccountDAO(Showinfo.this);
			List<Tb_outaccount>listoutinfos=outaccountinfo.getScrollData(0, (int)outaccountinfo.getCount());
			strInfos=new String[listoutinfos.size()];
			int i=0;
			for(Tb_outaccount tb_outaccount:listoutinfos)
			{
				strInfos[i]=tb_outaccount.get_id()+"|"+tb_outaccount.getType()+" "+
						String.valueOf(tb_outaccount.getMoney())+"Ԫ"+tb_outaccount.getTime();
				i++;
			}
		}
		if( R.id.btnininfo==intType)
		{// �����btnininfo��ť
			strType = "btnininfo";// ΪstrType������ֵ
			InaccountDAO inaccountinfo = new InaccountDAO(Showinfo.this);// ����InaccountDAO����
			// ��ȡ����������Ϣ�����洢��List���ͼ�����
			List<Tb_inaccount> listinfos = inaccountinfo.getScrollData(0,
					(int) inaccountinfo.getCount());
			strInfos = new String[listinfos.size()];// �����ַ�������ĳ���
			int m = 0;// ����һ����ʼ��ʶ
			for (Tb_inaccount tb_inaccount : listinfos) {// ����List���ͼ���
				// �����������Ϣ��ϳ�һ���ַ������洢���ַ����������Ӧλ��
				strInfos[m] = tb_inaccount.getId() + "|"
						+ tb_inaccount.getType() + " "
						+ String.valueOf(tb_inaccount.getMoney()) + "Ԫ     "
						+ tb_inaccount.getTime();
				m++;// ��ʶ��1
			}
	}
		if(intType==R.id.btnflaginfo)
		{// �����btnflaginfo��ť
			strType = "btnflaginfo";// ΪstrType������ֵ
			FlagDAO flaginfo = new FlagDAO(Showinfo.this);// ����FlagDAO����
			// ��ȡ���б�ǩ��Ϣ�����洢��List���ͼ�����
			List<Tb_flag> listFlags = flaginfo.getScrollData(0,
					(int) flaginfo.getCount());
			strInfos = new String[listFlags.size()];// �����ַ�������ĳ���
			int n = 0;// ����һ����ʼ��ʶ
			for (Tb_flag tb_flag : listFlags) {// ����List���ͼ���
				// ����ǩ�����Ϣ��ϳ�һ���ַ������洢���ַ����������Ӧλ��
				strInfos[n] = tb_flag.get_id() + "|" + tb_flag.getFlag();
				if (strInfos[n].length() > 15)// �жϱ�ǩ��Ϣ�ĳ����Ƿ����15
					strInfos[n] = strInfos[n].substring(0, 15) + "����";// ��λ�ô���15֮����ַ����á�������
				n++;// ��ʶ��1
			}
		}
		arrayAdapter=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,strInfos);
		lvinfo.setAdapter(arrayAdapter);
	}
	@Override
	protected void onRestart() {
		// TODO Auto-generated method stub
		super.onRestart();
		ShowInfo(R.id.btnoutinfo);// ��ʾ֧����Ϣ
	}
}
