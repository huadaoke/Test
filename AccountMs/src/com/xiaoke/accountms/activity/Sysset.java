package com.xiaoke.accountms.activity;
import com.xiaoke.accountms.R;
import com.xiaoke.accountsoft.dao.PwdDAO;
import com.xiaoke.accountsoft.model.Tb_pwd;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Sysset extends Activity {
	EditText txtpwd;
	Button btnSet,btnsetCancel;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.sysset);
		txtpwd=(EditText)findViewById(R.id.txtPwd);
		btnSet=(Button)findViewById(R.id.btnSet);
		btnsetCancel=(Button)findViewById(R.id.btnSetCancel);
		btnSet.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				PwdDAO pwdDAO=new PwdDAO(Sysset.this);
				Tb_pwd tb_pwd=new Tb_pwd(txtpwd.getText().toString());
				if(pwdDAO.getCount()==0)
				{
					pwdDAO.add(tb_pwd);
				}else
				{
					pwdDAO.update(tb_pwd);
				}
				Toast.makeText(Sysset.this, "°æ√‹¬Î°ø…Ë÷√≥…π¶", Toast.LENGTH_SHORT).show();
			}
		});
		btnsetCancel.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				txtpwd.setText("");
				txtpwd.setHint("«Î ‰»Î√‹¬Î");
			}
		});
	}
	

}
