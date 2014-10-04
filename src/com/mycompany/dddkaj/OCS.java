package com.mycompany.dddkaj;

import android.app.*;
import android.os.*;
import android.view.*;
import android.widget.*;
import android.graphics.*;
import android.renderscript.*;
import android.content.*;

public class OCS extends Activity
{
	/** Called when the activity is first created. */
	@Override
	
	TextView ret,LR,x_x,x_y,y_x,y_y,a_x,a_y,b_x,b_y,c_x,c_y; 
	EditText ETa,ETb,ETc,ETd,sta,inte;
	double b,k,A,B,ARG=1;
	
	public void onCreate(Bundle savedInstanceState)
	{
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ocs);
		
		ETa = (EditText)findViewById(R.id.A_x);
		ETb = (EditText)findViewById(R.id.A_y);      //分别获取编辑文本框abc
		ETc = (EditText)findViewById(R.id.B_x);
		ETd = (EditText)findViewById(R.id.B_y);
		ret = (TextView)findViewById(R.id.ret);
		LR = (TextView)findViewById(R.id.E);
		a_x = (TextView)findViewById(R.id.a_x);
		a_y = (TextView)findViewById(R.id.a_y);
		b_x = (TextView)findViewById(R.id.b_x);
		b_y = (TextView)findViewById(R.id.b_y);
		c_x = (TextView)findViewById(R.id.c_x);
		c_y = (TextView)findViewById(R.id.c_y);
		x_x = (TextView)findViewById(R.id.x_x);
		y_x = (TextView)findViewById(R.id.y_x);
		x_y = (TextView)findViewById(R.id.x_y);
		y_y = (TextView)findViewById(R.id.y_y);
		sta = (EditText)findViewById(R.id.sta);
		inte = (EditText)findViewById(R.id.inte);
	}
	
	public void C(View view){
		ret.setText("---");
		ETa.setText("");
		ETb.setText("");
		ETc.setText("");
		ETd.setText("");
		LR.setText("---");
		x_x.setText("---");
		y_x.setText("---");
		x_y.setText("---");
		y_y.setText("---");
		a_x.setText("---");
		b_x.setText("---");
		a_y.setText("---");
		b_y.setText("---");
		c_x.setText("---");
		c_y.setText("---");
		sta.setText("");
		inte.setText("");
	}
	
	public void pic(View view){
		Intent chart=new Intent(OCS.this,chart.class);
		chart.putExtra("IA",A);
		chart.putExtra("IB",B);
		chart.putExtra("IARG",ARG);
		startActivity(chart);
	}
	
	public void sta(View view){
		ret.setText("---");
		LR.setText("---");
		x_x.setText("---");
		y_x.setText("---");
		x_y.setText("---");
		y_y.setText("---");
		a_x.setText("---");
		b_x.setText("---");
		a_y.setText("---");
		b_y.setText("---");
		c_x.setText("---");
		c_y.setText("---");
		String ax = ETa.getText().toString();
		String ay = ETb.getText().toString();
		String bx = ETc.getText().toString();
		String by = ETd.getText().toString();
		String st=sta.getText().toString();
		String ine=inte.getText().toString();
		
		if(ax.equals("")||ay.equals("")||bx.equals("")||by.equals("")){
			CustomToast.showToast(getBaseContext(),"我算不了嘛！"+"\n"+"ERROR:文本框不能为空",2000);
		}
		else{
		
		double Ax=Double.parseDouble(ax);//数据类型转换a
		double Ay=Double.parseDouble(ay);//数据类型转换b
		double Bx=Double.parseDouble(bx);//数据类型转换c
		double By=Double.parseDouble(by);
		
		k = (Ay-By)/(Ax-Bx);
		b = Ay-k*Ax;
		A=k;B=b;
		if(b>0){
			ret.setText("y="+k+"x"+"+"+b);
		}
		else{
			if(b==0){
				ret.setText("y="+k+"x");
			}
				else{
					ret.setText("y="+k+"x"+b);
				}
			}
			if(b!=0){
				double lr1=(Ax*k+b)-Ay;
				double lr2=(Bx*k+b)-By;
				double lr=(lr1+lr2)/2;
				LR.setText(lr+"");
			}else{
				double lr1=(Ax*k)-Ay;
				double lr2=(Bx*k)-By;
				double lr=(lr1+lr2)/2;
				LR.setText(lr+"");
			}
		}
		try{
			if(st.equals("")&&ine.equals("")){
				CustomToast.showToast(getBaseContext(),"表格甭想让我写了！"+"\n"+"ERROR:没有填写表格数据将不显示表格数据",2000);
			}else{
				double ST=Double.parseDouble(st);
				double in=Double.parseDouble(ine);
				if(b==0){
					x_x.setText("0.0");
					y_x.setText("0.0");
					x_y.setText("0.0");
					y_y.setText("0.0");
				}else{
					double x_xr=(0-b)/k;
					double y_yr=b;
					x_x.setText(""+x_xr);
					y_x.setText("0.0");
					x_y.setText("0.0");
					y_y.setText(""+y_yr);
				}
				double a_yr=k*ST+b;
				a_x.setText(ST+"");
				a_y.setText(a_yr+"");
				double b_yr=k*(ST+in)+b;
				b_x.setText((ST+in)+"");
				b_y.setText(b_yr+"");
				double c_yr=k*(ST+in+in)+b;
				c_x.setText((ST+in+in)+"");
				c_y.setText(c_yr+"");
			}
		}catch(Exception e){
			CustomToast.showToast(getBaseContext(),"这是什么东西！"+"\n"+"ERROR:表格数据创建错误，请从新填写数据",2000);
		}
	}
}
