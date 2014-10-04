package com.mycompany.dddkaj;

import android.app.*;
import android.os.*;
import android.view.*;
import android.widget.*;
import android.graphics.*;

public class ROUND extends Activity
{
	/** Called when the activity is first created. */
    @Override
	EditText ET_n,ET_r;
	TextView result_s,result_l;
	double s,l,PI=3.14;
	CheckBox CB_pi;
	
    public void onCreate(Bundle savedInstanceState)
	{
        super.onCreate(savedInstanceState);
        setContentView(R.layout.round);
		
		ET_n=(EditText)findViewById(R.id.ET_n);
		ET_r=(EditText)findViewById(R.id.ET_r);
		result_s=(TextView)findViewById(R.id.TV_result_s);
		result_l=(TextView)findViewById(R.id.TV_result_l);
		CB_pi = (CheckBox)findViewById(R.id.CB_pi);
    }
	
	public void C(View v)
	{
		result_l.setText("---");
		result_s.setText("---");
		ET_n.setText("");
		ET_r.setText("");
	}
	
	public void start(View v)
	{
		String sn = ET_n.getText().toString();
		String sr = ET_r.getText().toString(); 
		if(sn.equals("")||sr.equals("")){
			CustomToast.showToast(getBaseContext(),"我算不了嘛！"+"\n"+"ERROR:文本框不能为空",2000);
		}else{
		double n;
		double r;
		n=Double.parseDouble(sn);
		r=Double.parseDouble(sr);
		if(CB_pi.isChecked()){
			l=(n*PI*r)/180;
			s=(n*PI*r*r)/360;
		}else{
			l=(n*r)/180;
			s=(n*r*r)/360; 
		}
		if(CB_pi.isChecked())
		{
			result_s.setText(s+"");
			result_l.setText(l+"");
		}else{
			result_s.setText(s+"π");
			result_l.setText(l+"π");
			}
		}
	}
}
