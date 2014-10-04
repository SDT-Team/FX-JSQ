package com.mycompany.dddkaj;

import android.app.*;
import android.os.*;
import android.view.*;
import android.widget.*;
import android.graphics.*;

public class MainActivity extends Activity
{
    /** Called when the activity is first created. */
    @Override
	TextView showView1,showView2,showView3,showView4,LR1,LR2,T;
	EditText ETa,ETb,ETc;
	CheckBox A,B;
	int L;
	boolean LA,LB,A1,B1;
	
    public void onCreate(Bundle savedInstanceState)
	{
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
		          
		ETa = (EditText)findViewById(R.id.edittext1);
		ETb = (EditText)findViewById(R.id.edittext2);      //分别获取编辑文本框abc
		ETc = (EditText)findViewById(R.id.edittext3);
		showView1 = (TextView)findViewById(R.id.TextView3);//获取x1文本
		showView2 = (TextView)findViewById(R.id.TextView4);//获取x2文本
		showView3 = (TextView)findViewById(R.id.TextView5);//获取Δ文本
		showView4 = (TextView)findViewById(R.id.TextView6);//获取方程式文本
		T = (TextView)findViewById(R.id.T);
		LR1 = (TextView)findViewById(R.id.LR1);//获取LR1文本
		LR2 = (TextView)findViewById(R.id.LR2);//获取LR2文本
		A = (CheckBox)findViewById(R.id.A);//一次选择
		B = (CheckBox)findViewById(R.id.B);//二次选择
	}
	
	public void cn(View view){
		ETa.setText("");//清空a
		ETb.setText("");//清空b
		ETc.setText("");//清空c
		LR1.setText("---");//清空LR1
		LR2.setText("---");//清空LR2
		showView1.setText("---");//清空x1
		showView2.setText("---");//清空x2
		showView3.setText("---");//清空Δ
		showView4.setText("---");//情空方程式
	}
	
	public void A(View view){//复选框二次
		LA=A.isChecked();
		if(LA==true){
			ETa.setHint("请输入A");
			ETb.setHint("请输入B");
			ETc.setHint("请输入C");
			T.setText("请将方程化简为“ax²+bx+c=0”的样子");
			LR1.setText("---");//清空LR1
			LR2.setText("---");//清空LR2
			showView1.setText("---");//清空x1
			showView2.setText("---");//清空x2
			showView3.setText("---");//清空Δ
			showView4.setText("---");//情空方程式
			L=1;
		}
		else{
			ETa.setHint("");
			ETb.setHint("");
			ETc.setHint("");
			T.setText("");
			LR1.setText("---");//清空LR1
			LR2.setText("---");//清空LR2
			showView1.setText("---");//清空x1
			showView2.setText("---");//清空x2
			showView3.setText("---");//清空Δ
			showView4.setText("---");//情空方程式
			L=0;
		}
		B.setChecked(false);
	}
	
	public void B(View view){//复选框一次
		LB=B.isChecked();
		if(LB==true){
			ETa.setHint("输入无效");
			ETb.setHint("请输入B");
			ETc.setHint("请输入C");
			T.setText("请将方程化简为“bx+c=0”的样子,a无效");
			LR1.setText("---");//清空LR1
			LR2.setText("---");//清空LR2
			showView1.setText("---");//清空x1
			showView2.setText("---");//清空x2
			showView3.setText("---");//清空Δ
			showView4.setText("---");//情空方程式
			L=2;
		}
		else{
			ETa.setHint("");
			ETb.setHint("");
			ETc.setHint("");
			T.setText("");
			LR1.setText("---");//清空LR1
			LR2.setText("---");//清空LR2
			showView1.setText("---");//清空x1
			showView2.setText("---");//清空x2
			showView3.setText("---");//清空Δ
			showView4.setText("---");//情空方程式
			L=0;
		}
		A.setChecked(false);
	}
	
	public void start(View view){  //与按钮关联
	A1=A.isChecked();
	B1=B.isChecked();
	if(A1==true||B1==true){
		String Sa = ETa.getText().toString();
		String Sb = ETb.getText().toString();
		String Sc = ETc.getText().toString();
		double x1;
		double x2;             //方程的解
		
		if(L == 2){        //一元一次方程部分
		if(Sb.equals("")||Sc.equals("")){
			CustomToast.showToast(getBaseContext(),"我算不了嘛！"+"\n"+"ERROR:文本框不能为空",2000);
			LR1.setText("---");//清空LR1
			LR2.setText("---");//清空LR2
			showView1.setText("---");//清空x1
			showView2.setText("---");//清空x2
			showView3.setText("---");//清空Δ
			showView4.setText("---");//情空方程式
		}
		else{
			if(Sa.equals("")){}
			else {CustomToast.showToast(getBaseContext(),"你到底想让我算硕么？"+"\n"+"ERROR：A是无效的，如要计算二元一次请重新选择计算模式",2000);}
			double b=Double.parseDouble(Sb);//数据类型转换b
			double c=Double.parseDouble(Sc);//数据类型转换c
			showView2.setText("---");
			showView3.setText("---");//清空Δ
			double sry4;
			sry4 = 0-c;     						//运算部分
			x1 = sry4/b;
			String sry5 = String.valueOf(x1);       //double转字符串x1
			showView1.setText(sry5);
			if(c>=0){
			showView4.setText(b + "x" + "+" + c + "=" + "0");  //输出方程式
			}
			else{showView4.setText(b + "x" + c + "=" + "0");}  //输出方程式
			double LR = (x1*b+c)-0;
			LR1.setText(LR+"");
			LR2.setText("---");
			}
		}
		
		else{//一元二次方程部分
		if(L == 1){
			if(Sb.equals("")||Sc.equals("")){
				CustomToast.showToast(getBaseContext(),"我算不了嘛！"+"\n"+"ERROR:文本框不能为空",2000);
				LR1.setText("---");//清空LR1
				LR2.setText("---");//清空LR2
				showView1.setText("---");//清空x1
				showView2.setText("---");//清空x2
				showView3.setText("---");//清空Δ
				showView4.setText("---");//情空方程式
			}
			else{
			if(Sa.equals("")){
				CustomToast.showToast(getBaseContext(),"我算不了嘛！"+"\n"+"ERROR:文本框不能为空",2000);
				LR1.setText("---");//清空LR1
				LR2.setText("---");//清空LR2
				showView1.setText("---");//清空x1
				showView2.setText("---");//清空x2
				showView3.setText("---");//清空Δ
				showView4.setText("---");//情空方程式
			}
				else{
					
			double a=Double.parseDouble(Sa);//数据类型转换a
			double b=Double.parseDouble(Sb);//数据类型转换b
			double c=Double.parseDouble(Sc);//数据类型转换c
			//变量名不知道怎么设就全hxp了，为了ll)纪念他.			
			double hxp = b*b;
			double hxp1 = 4*a*c;
			//这叫做德尔塔，就是那个根的判别式
			double hxp2 = hxp-hxp1;
			String sry7 = String.valueOf(hxp2); //double转字符串x1
			showView3.setText(sry7);
			showView4.setText(a + "x²" + "+" + b + "x" + "+" + c + "=" + "0");
			//判断德尔塔是否为非负数
			double hxp3 = 0;
			if (hxp2 >= 0){
				hxp3 = 1;
			}
			else{
				showView1.setText("---");
				showView2.setText("---");
				LR1.setText("---");
				LR2.setText("---");
			}
			double hxp4;
			double hxp5;
			double hxp6;
			double hxp7;
			double hxp8;
			if (hxp3 == 1)
			{
				hxp4 = Math.sqrt(hxp2);
				hxp5 = -Math.sqrt(hxp2);
				hxp6 = -b+hxp4;
				hxp7 = -b+hxp5;
				hxp8 = 2*a;
				x1 = hxp6/hxp8;
				x2 = hxp7/hxp8;
				String sry5 = String.valueOf(x1); //double转字符串x1
				String sry6 = String.valueOf(x2); //double转字符串x2
				showView1.setText(sry5);          //字符串输出x1
				showView2.setText(sry6);          //字符串输出x2
				double lr1 = (x1*x1*a+x1*b+c)-0;
				double lr2 = (x2*x2*a+x2*b+c)-0;
				LR1.setText(lr1+"");
				LR2.setText(lr2+"");
							}
						}
					}
				}
			}
		}
	else{
		CustomToast.showToast(getBaseContext(),"我算不了嘛！"+"\n"+"ERROR:文本框不能为空",2000);
		showView1.setText("---");
		showView2.setText("---");
		ETa.setHint("");
		ETb.setHint("");
		ETc.setHint("");
		LR1.setText("---");
		LR2.setText("---");
		}
	}
}
