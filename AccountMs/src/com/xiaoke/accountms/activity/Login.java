package com.xiaoke.accountms.activity;

import com.xiaoke.accountms.R;
import com.xiaoke.accountsoft.dao.PwdDAO;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Login extends Activity {
	EditText txtlogin ;
	Button btnlogin,btnclose;
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.login);

		txtlogin = (EditText)findViewById(R.id.txtLogin);
		btnlogin=(Button)findViewById(R.id.btnLogin);
		btnclose = (Button) findViewById(R.id.btnClose);
		btnlogin.setOnClickListener(new OnClickListener() {
					
					@SuppressLint("NewApi")
					public void onClick(View arg0) {
						// TODO Auto-generated method stub
						Intent intent =new Intent(Login.this,MainActivity.class);
						PwdDAO pwdDAO=new PwdDAO(Login.this);
						if((pwdDAO.getCount()==0|| pwdDAO.find().getPwd().isEmpty())&&txtlogin.getText().toString().isEmpty())
						{
							startActivity(intent);
						}
						else
						{
							if(pwdDAO.find().getPwd().equals(txtlogin.getText().toString()))
							{
								startActivity(intent);
							}
							else
							{
								Toast.makeText(Login.this, "«Î ‰»Î√‹¬Î", Toast.LENGTH_LONG).show();
							}
						}
						txtlogin.setText("");
					}
				});
		btnclose.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				finish();	
			}
		});
	}


}
