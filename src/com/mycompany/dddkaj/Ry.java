package com.mycompany.dddkaj;

import android.app.*;
import android.os.*;
import android.view.*;
import android.widget.*;
import android.graphics.*;
import android.renderscript.*;
import android.view.View;
import android.view.View.OnClickListener;
import java.text.*;

public class Ry extends Activity
{
	/** Called when the activity is first created. */
	@Override
	EditText ix1,ix2;
	TextView A,B,C,lr;
	Button N1;
	CheckBox G1,S1,H1,RAS1;
	double LY,LR;
	boolean G,PH,PRAS,LH,LRAS;
	int L;
	
	public void onCreate(Bundle savedInstanceState)
	{
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ry);
		
		ix1 = (EditText)findViewById(R.id.x1);  //输入数据
		ix2 = (EditText)findViewById(R.id.x2);
		A = (TextView)findViewById(R.id.A);//结果输出A
		B = (TextView)findViewById(R.id.B);//结果输出B
		C = (TextView)findViewById(R.id.C);//结果输出C
		N1 = (Button)findViewById(R.id.SA);
		G1 = (CheckBox)findViewById(R.id.G);//保留根号
		H1 = (CheckBox)findViewById(R.id.Ca);//模式选择H（斜边）
		RAS1 = (CheckBox)findViewById(R.id.Cb);//模式选择RAS（直角边）
		lr = (TextView)findViewById(R.id.lr);
	}
	
	public void C(View view)
	{
		LY=0;
		L=0;
		A.setText("---");
		B.setText("---");
		C.setText("---");
		ix1.setText("");
		ix2.setText("");
		lr.setText("---");
		G=false;
	}
	
	public void RAS(View view){//复选框RAS
		LRAS=RAS1.isChecked();
		if(LRAS==true){
			ix1.setHint("请输入斜边");
			ix2.setHint("请输入直角边");
			L=1;
		}
		else{
			ix1.setHint("");
			ix2.setHint("");
			L=0;
			}
			H1.setChecked(false);
	}

	public void H(View view){//复选框H
		LH=H1.isChecked();
		if(LH==true){
			ix1.setHint("请输入直角边");
			ix2.setHint("请输入另一直角边");
			L=2;
		}
		else{
			ix1.setHint("");
			ix2.setHint("");
			L=0;
			}
			RAS1.setChecked(false);
	}
		
	public void sta(View view)
	{
		G=G1.isChecked();
		PH=H1.isChecked();
		PRAS=RAS1.isChecked();
		String x1 = ix1.getText().toString();
		String x2 = ix2.getText().toString();
		
		if(x1.equals("")||x2.equals("")){
			CustomToast.showToast(getBaseContext(),"我算不了嘛！"+"\n"+"ERROR:文本框不能为空",2000);
		}
		
		else{
		double X1=Double.parseDouble(x1);
		double X2=Double.parseDouble(x2);
		
		if(PH==false&&PRAS==false){
			L=0;
			CustomToast.showToast(getBaseContext(),"你到底想算什么？！"+"\n"+"ERROR:请重新选择计算模式再按下计算键",2000);
		}
		else{
			if(PRAS==true){
				if(X1>=X2){
				LY=X1*X1-X2*X2;
				}
				else{
					CustomToast.showToast(getBaseContext(),"这是硕么三角形？！"+"\n"+"ERROR:斜边不能大于等于直角边",2000);
				}
			}
			else{
				if(PH==true){
					LY=X1*X1+X2*X2;
				}
			}
			
		if(G==true){
			double LY1=LY;
			if(LY1!=(long)LY1){
				A.setText("---");
				B.setText("---");
				C.setText("---");
				CustomToast.showToast(getBaseContext(),"这是什么东西！"+"\n"+"ERROR:本模式暂不支持保留根号的小数计算",2000);
			}
			else{
			int c=(int)LY+1;
			int K=0;
			while(K==0){
				c--;
				if(LY%(c*c)==0){
					K=1;
				}
			}
			int d=c*c;
			double e=LY/d;
			if(L==1){
				A.setText(x2);
				B.setText(c+"√"+e);
				C.setText(x1);
				if(e!=(int)e){
					int e1=(int)e;
					LR=X1*X1-X2*X2-c*c*e1;
					lr.setText(LR+"");
				}
				else lr.setText("0.0");
				if(X1<=X2){
					CustomToast.showToast(getBaseContext(),"这是什么三角形！"+"\n"+"ERROR:本模式暂不支持保留根号的小数计算",2000);
					B.setText("---");
					lr.setText("---");
				}
			}
			else{
				if(L==2){
					A.setText(x1);
					B.setText(x2);
					C.setText(c+"√"+e);
					if(e!=(long)e){
						int e1=(int)e;
						LR=c*c*e1-X1*X1-X2*X2;
						lr.setText(LR+"");
					}
					else lr.setText("0.0");
						}
					}
				}
			}
		else{
			double T=Math.sqrt(LY);
			if(L==1){
				A.setText(x2);
				B.setText(T+"");
				C.setText(x1);
				if(T!=(long)T){
					int T1=(int)T;
					LR=X1*X1-T1*T1-X2*X2;
					lr.setText("---");
				}
				else lr.setText("0.0");
				if(X1<=X2){
					CustomToast.showToast(getBaseContext(),"这是硕么三角形！"+"\n"+"ERROR:斜边不能大于等于直角边",2000);
					B.setText("---");
					lr.setText("---");
				}
			}
			else{
				if(L==2){
					A.setText(x1);
					B.setText(x2);
					C.setText(T+"");
					LR=T*T-X1*X1-X2*X2;
					lr.setText(LR+"");
					if(T!=(long)T){
						int T1=(int)T;
						LR=T1*T1-X1*X1-X2*X2;
						lr.setText("---");
					}
					else lr.setText("---");
				}
			}
		}
		ix1.setText("");
		ix2.setText("");
			}
		}
	}
}

