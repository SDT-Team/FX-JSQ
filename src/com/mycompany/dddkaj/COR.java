package com.mycompany.dddkaj;

import android.app.*;
import android.os.*;
import android.view.*;
import android.widget.*;
import android.graphics.*;
import android.content.*;
import android.widget.AdapterView.*;
import android.util.*;

public class COR extends Activity
{
	String sa1,sa2,sb1,sb2,sc1,sc2;
	float MIN=0,MAX=0;
	double a1,a2,b1,b2,c1,c2,A=0,a=0,B=0,b=0,CI=0,c=0,d=0,e=0,f=0,ddx;
	EditText eta1,eta2,etb1,etb2,etc1,etc2;
	TextView tvdd,tvd1,tvd2,tvd3,tvd4,tvd5,tvd6,tvd7,tvdd1,tvd11,tvd21,tvd31,tvd41,tvd51,tvd61,tvd71,jxs;
	int arg,index = 0,picn=0,ARG,t=0;
	Button PIC,sta,C;
	boolean T=false,K=true,picT=false,T2=false,PT=false;
	private static final String[] m={"二次函数","一次函数","三角函数","2×二次","2×一次","一次+二次"};
	private static final String[] pic={"渣机画质(差)","Intel画质(一般)","N卡画质(中)","A卡画质(高)"};
	Spinner manup,PICT;
	private ArrayAdapter<String> manuP,PICt;
	
	@Override
	public void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
        setContentView(R.layout.cor);
		
		PIC = (Button)findViewById(R.id.pic);
		sta = (Button)findViewById(R.id.sta);
		C = (Button)findViewById(R.id.C);
		eta1 = (EditText)findViewById(R.id.a1);
		eta2 = (EditText)findViewById(R.id.a2);
		etb1 = (EditText)findViewById(R.id.b1);
		etb2 = (EditText)findViewById(R.id.b2);
		etc1 = (EditText)findViewById(R.id.c1);
		etc2 = (EditText)findViewById(R.id.c2);
		jxs = (TextView)findViewById(R.id.jxs);
		tvdd = (TextView)findViewById(R.id.dd);
		tvd1 = (TextView)findViewById(R.id.d1);
		tvd2 = (TextView)findViewById(R.id.d2);
		tvd3 = (TextView)findViewById(R.id.d3);
		tvd4 = (TextView)findViewById(R.id.d4);
		tvd5 = (TextView)findViewById(R.id.d5);
		tvd6 = (TextView)findViewById(R.id.d6);
		tvd7 = (TextView)findViewById(R.id.d7);
		tvdd1 = (TextView)findViewById(R.id.dd1);
		tvd11 = (TextView)findViewById(R.id.d11);
		tvd21 = (TextView)findViewById(R.id.d21);
		tvd31 = (TextView)findViewById(R.id.d31);
		tvd41 = (TextView)findViewById(R.id.d41);
		tvd51 = (TextView)findViewById(R.id.d51);
		tvd61 = (TextView)findViewById(R.id.d61);
		tvd71 = (TextView)findViewById(R.id.d71);
		
		PICT = (Spinner) findViewById(R.id.PICT);
		PICt = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,pic);
		PICT.setAdapter(PICt);
		PICT.setVisibility(View.VISIBLE);
		PICT.setOnItemSelectedListener(new SpinnerSelectedListenera());
		
		manup = (Spinner) findViewById(R.id.manup);
		manuP = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,m);
		manup.setAdapter(manuP);
		manup.setVisibility(View.VISIBLE);
		manup.setOnItemSelectedListener(new SpinnerSelectedListener());
    }
	
	class SpinnerSelectedListenera implements OnItemSelectedListener
	{
		@Override
		public void onItemSelected(AdapterView<?> p1, View p2, int p3, long p4)
		{
			// TODO: Implement this method
			picn=p3;
		}
		@Override
		public void onNothingSelected(AdapterView<?> p1){}
		}
	
	class SpinnerSelectedListener implements OnItemSelectedListener{
		public void onItemSelected(AdapterView<?> arg0, View arg1,int arg2,long arg3){
			arg=arg2;
			eta1.setText("");
			eta2.setText("");
			etb1.setText("");
			etb2.setText("");
			etc1.setText("");
			etc2.setText("");
			tvdd.setText("---");
			tvd1.setText("---");
			tvd2.setText("---");
			tvd3.setText("---");
			tvd4.setText("---");
			tvd5.setText("---");
			tvd6.setText("---");
			tvd7.setText("---");
			tvdd1.setText("---");
			tvd11.setText("---");
			tvd21.setText("---");
			tvd31.setText("---");
			tvd41.setText("---");
			tvd51.setText("---");
			tvd61.setText("---");
			tvd71.setText("---");
			PT=false;
			if(arg2==0){
				jxs.setText("y=ax²+bx+c(a≠0)");
				jxs.setTextSize(0,50);
				eta1.setEnabled(true);
				etb1.setEnabled(true);
				etc1.setEnabled(true);
				eta2.setEnabled(true);
				etb2.setEnabled(true);
				etc2.setEnabled(true);
				PIC.setEnabled(false);
				PICT.setEnabled(true);
				sta.setEnabled(true);
				C.setEnabled(true);
				sta.setText("完成");
				picT=true;
			}
			if(arg2==1){
				jxs.setText("y=ax+b");
				jxs.setTextSize(0,50);
				eta1.setEnabled(true);
				etb1.setEnabled(true);
				etc1.setEnabled(true);
				eta2.setEnabled(true);
				etb2.setEnabled(true);
				etc2.setEnabled(true);
				PIC.setEnabled(false);
				PICT.setEnabled(false);
				sta.setEnabled(true);
				C.setEnabled(true);
				sta.setText("完成");
				picT=true;
			}
			if(arg2==2){
				jxs.setText("y=cosx,y=sinx");
				jxs.setTextSize(0,50);
				eta1.setEnabled(false);
				etb1.setEnabled(false);
				etc1.setEnabled(false);
				eta2.setEnabled(false);
				etb2.setEnabled(false);
				etc2.setEnabled(false);
				PIC.setEnabled(true);
				PICT.setEnabled(true);
				sta.setEnabled(false);
				C.setEnabled(false);
				sta.setText("完成");
				picT=true;
				PT=true;
			}
			if(arg2==3){
				jxs.setText("y1=ax²+bx+c&y2=dx²+ex+f(d≠a≠0)");
				jxs.setTextSize(0,30);
				eta1.setEnabled(true);
				etb1.setEnabled(true);
				etc1.setEnabled(true);
				eta2.setEnabled(true);
				etb2.setEnabled(true);
				etc2.setEnabled(true);
				PIC.setEnabled(false);
				PICT.setEnabled(true);
				sta.setEnabled(true);
				C.setEnabled(true);
				sta.setText("下一个");
				picT=false;
			}
			if(arg2==4){
				jxs.setText("y1=ax+b&y2=cx+d");
				jxs.setTextSize(0,50);
				eta1.setEnabled(true);
				etb1.setEnabled(true);
				etc1.setEnabled(true);
				eta2.setEnabled(true);
				etb2.setEnabled(true);
				etc2.setEnabled(true);
				PIC.setEnabled(false);
				PICT.setEnabled(false);
				sta.setEnabled(true);
				C.setEnabled(true);
				sta.setText("下一个");
				picT=false;
			}
			if(arg2==5){
				jxs.setText("y1=ax+b&y2=cx²+dx+e(a≠0)");
				jxs.setTextSize(0,37);
				eta1.setEnabled(true);
				etb1.setEnabled(true);
				etc1.setEnabled(true);
				eta2.setEnabled(true);
				etb2.setEnabled(true);
				etc2.setEnabled(true);
				PIC.setEnabled(false);
				PICT.setEnabled(true);
				sta.setEnabled(true);
				C.setEnabled(true);
				sta.setText("下一个");
				picT=false;
			}
		}
		public void onNothingSelected(AdapterView<?> arg0) {}
	}
	public void start(View view)
	{
		/*int k=2,y=k;
		for(int i=1;i<3;i++){
			k=k*y;
		}
		Log.i("k³","k³="+k);*/
		Log.i("ARG","ARG="+arg);
		ARG=arg;
		tvdd.setText("---");
		tvd1.setText("---");
		tvd2.setText("---");
		tvd3.setText("---");
		tvd4.setText("---");
		tvd5.setText("---");
		tvd6.setText("---");
		tvd7.setText("---");
		tvdd1.setText("---");
		tvd11.setText("---");
		tvd21.setText("---");
		tvd31.setText("---");
		tvd41.setText("---");
		tvd51.setText("---");
		tvd61.setText("---");
		tvd71.setText("---");
		sa1=eta1.getText().toString();
		sa2=eta2.getText().toString();
		sb1=etb1.getText().toString();
		sb2=etb2.getText().toString();
		sc1=etc1.getText().toString();
		sc2=etc2.getText().toString();
	try{					//非法字符检测[数据过滤器NO.2]
			/*
		 如果是非法字符则会转换失败，抛出error，而
		 触发catch，从而阻止intent错误，如:1...1,--1,1-1
		 也巧妙的避免使用复杂的正则表达试*/
		if(sa2.equals("0"))
		{
			CustomToast.showToast(getBaseContext(),"除不了嘛！"+"\n"+"ERROR：分母不能为零，双击有错误的地方更正",2000);
		}
		if(sb2.equals("0"))
		{
			CustomToast.showToast(getBaseContext(),"除不了嘛！"+"\n"+"ERROR：分母不能为零，双击有错误的地方更正",2000);
		}
		if(sc2.equals("0"))
		{
			CustomToast.showToast(getBaseContext(),"除不了嘛！"+"\n"+"ERROR：分母不能为零，双击有错误的地方更正",2000);
		}
		if(sa1.equals(""))
		{
			a1=0;
		}else{
			a1=Double.parseDouble(sa1);
		}
		if(sb1.equals(""))
		{
			b1=0;
		}else{
			b1=Double.parseDouble(sb1);
		}
		if(sc1.equals(""))
		{
			c1=0;
		}else{
			c1=Double.parseDouble(sc1);
		}
		if(sa2.equals(""))
		{
			a2=1;
		}else{
			if(!sa2.equals("0"))
			{
				a2=Double.parseDouble(sa2);
			}
		}
		if(sb2.equals(""))
		{
			b2=1;
		}else{
			if(!sb2.equals("0"))
			{
				b2=Double.parseDouble(sb2);
			}
		}
		if(sc2.equals(""))
		{
			c2=1;
		}else{
			if(!sc2.equals("0"))
			{
				c2=Double.parseDouble(sc2);
			}
		}
	}catch(Exception e){
		K=false;
		Log.e("非法字符",eta1.getText().toString()+etb1.getText().toString()+etc1.getText().toString());
		CustomToast.showToast(getBaseContext(),"卧槽，你打错字了"+"\n"+e,2000);
	}
		a=a1/a2;
		b=b1/b2;
		c=c1/c2;
		if(arg==0||arg==3){
		ddx=-b/(2*a);
		tvdd.setText((ddx)+"");
		tvd1.setText((ddx-3)+"");
		tvd2.setText((ddx-2)+"");
		tvd3.setText((ddx-1)+"");
		tvd4.setText((ddx)+"");
		tvd5.setText((ddx+1)+"");
		tvd6.setText((ddx+2)+"");
		tvd7.setText((ddx+3)+"");
		tvdd1.setText(""+(a*ddx*ddx+b*ddx+c));
		tvd11.setText(""+(a*(ddx-3)*(ddx-3)+b*(ddx-3)+c));
		tvd21.setText(""+(a*(ddx-2)*(ddx-2)+b*(ddx-2)+c));
		tvd31.setText(""+(a*(ddx-1)*(ddx-1)+b*(ddx-1)+c));
		tvd41.setText(""+(a*(ddx)*(ddx)+b*(ddx)+c));
		tvd51.setText(""+(a*(ddx+1)*(ddx+1)+b*(ddx+1)+c));
		tvd61.setText(""+(a*(ddx+2)*(ddx+2)+b*(ddx+2)+c));
		tvd71.setText(""+(a*(ddx+3)*(ddx+3)+b*(ddx+3)+c));
		}else{
			if(arg==1||arg==4){
				double[] datax=new double[7];
				double[] datay=new double[7];
				for(int i=-3;i<4;i++){
					datax[i+3]=i;
					datay[i+3]=i*a+b;
				}
				tvd1.setText(datax[0]+"");
				tvd2.setText(datax[1]+"");
				tvd3.setText(datax[2]+"");
				tvd4.setText(datax[3]+"");
				tvd5.setText(datax[4]+"");
				tvd6.setText(datax[5]+"");
				tvd7.setText(datax[6]+"");
				tvd11.setText(""+datay[0]);
				tvd21.setText(""+datay[1]);
				tvd31.setText(""+datay[2]);
				tvd41.setText(""+datay[3]);
				tvd51.setText(""+datay[4]);
				tvd61.setText(""+datay[5]);
				tvd71.setText(""+datay[6]);
			}else{
				if(arg==5){
					if(t==0){
						double[] datax=new double[7];
						double[] datay=new double[7];
						for(int i=-3;i<4;i++){
							datax[i+3]=i;
							datay[i+3]=i*a+b;
						}
						tvd1.setText(datax[0]+"");
						tvd2.setText(datax[1]+"");
						tvd3.setText(datax[2]+"");
						tvd4.setText(datax[3]+"");
						tvd5.setText(datax[4]+"");
						tvd6.setText(datax[5]+"");
						tvd7.setText(datax[6]+"");
						tvd11.setText(""+datay[0]);
						tvd21.setText(""+datay[1]);
						tvd31.setText(""+datay[2]);
						tvd41.setText(""+datay[3]);
						tvd51.setText(""+datay[4]);
						tvd61.setText(""+datay[5]);
						tvd71.setText(""+datay[6]);
						t=1;
					}else{
						ddx=-b/(2*a);
						tvdd.setText((ddx)+"");
						tvd1.setText((ddx-3)+"");
						tvd2.setText((ddx-2)+"");
						tvd3.setText((ddx-1)+"");
						tvd4.setText((ddx)+"");
						tvd5.setText((ddx+1)+"");
						tvd6.setText((ddx+2)+"");
						tvd7.setText((ddx+3)+"");
						tvdd1.setText(""+(a*ddx*ddx+b*ddx+c));
						tvd11.setText(""+(a*(ddx-3)*(ddx-3)+b*(ddx-3)+c));
						tvd21.setText(""+(a*(ddx-2)*(ddx-2)+b*(ddx-2)+c));
						tvd31.setText(""+(a*(ddx-1)*(ddx-1)+b*(ddx-1)+c));
						tvd41.setText(""+(a*(ddx)*(ddx)+b*(ddx)+c));
						tvd51.setText(""+(a*(ddx+1)*(ddx+1)+b*(ddx+1)+c));
						tvd61.setText(""+(a*(ddx+2)*(ddx+2)+b*(ddx+2)+c));
						tvd71.setText(""+(a*(ddx+3)*(ddx+3)+b*(ddx+3)+c));
						t=0;
					}
				}
			}
		}
		//[数据分流器1.0]&[数据过滤器NO.3]
		if(picT){
			PIC.setEnabled(true);
			if(arg==3||arg==4||arg==5){
			d=a;e=b;f=c;picT=false;
			sta.setText("输入新的数据");
			PT=true;
			}else{
			A=a;B=b;CI=c;PT=true;}
		}else{
			A=a;B=b;CI=c;
			picT=true;
			PT=false;
			PIC.setEnabled(false);
			sta.setText("完成");
		}
	}
	
	public void C(View view){
		PIC.setEnabled(false);
		if(arg==3||arg==4||arg==5){
		picT=false;
		sta.setText("下一个");
		}
		eta1.setText("");
		eta2.setText("");
		etb1.setText("");
		etb2.setText("");
		etc1.setText("");
		etc2.setText("");
		tvdd.setText("---");
		tvd1.setText("---");
		tvd2.setText("---");
		tvd3.setText("---");
		tvd4.setText("---");
		tvd5.setText("---");
		tvd6.setText("---");
		tvd7.setText("---");
		tvdd1.setText("---");
		tvd11.setText("---");
		tvd21.setText("---");
		tvd31.setText("---");
		tvd41.setText("---");
		tvd51.setText("---");
		tvd61.setText("---");
		tvd71.setText("---");
	}
	
	public void jxs(View view){
		//[数据过滤器NO.1][数据防火墙]
		T=false;
		if(arg==1){
			if(!K){
				CustomToast.showToast(getBaseContext(),"你让我咋画"+"\n"+"ERROR：空数据或无效数据",2000);
				PIC.setEnabled(false);
				T=false;
			}else{
				T=true;
			}
		}
		if(arg==0){
			if(a==0||eta1.getText().toString().equals("")){
				CustomToast.showToast(getBaseContext(),"你让我咋画"+"\n"+"ERROR：空数据或无效数据",2000);
				PIC.setEnabled(false);
				T=false;
			}else{
				T=true;
			}
		}
		if(arg==3){
			if(a==0||d==0||eta1.getText().toString().equals("")){
				CustomToast.showToast(getBaseContext(),"你让我咋画"+"\n"+"ERROR：空数据或无效数据",2000);
				PIC.setEnabled(false);
				T=false;picT=false;
			}else{
				T=true;
			}
		}
		if(arg==4){
			if(!K){
				CustomToast.showToast(getBaseContext(),"你让我咋画"+"\n"+"ERROR：空数据或无效数据",2000);
				PIC.setEnabled(false);
				T=false;
			}else{
				T=true;
			}
		}
		if(arg==5){
			if(a==0||d==0||eta1.getText().toString().equals("")||!K){
				CustomToast.showToast(getBaseContext(),"你让我咋画"+"\n"+"ERROR：空数据或无效数据",2000);
				PIC.setEnabled(false);
				T=false;picT=false;
			}else{
				T=true;
			}
		}
		if(arg==2){
			T=true;
		}
		
		//传值
		if(T&&PT){
		try{
		Intent chart=new Intent(COR.this,chart.class);
		chart.putExtra("IA",A);
		chart.putExtra("IB",B);
		chart.putExtra("IC",CI);
		chart.putExtra("ID",d);
		chart.putExtra("IE",e);
		chart.putExtra("IF",f);
		chart.putExtra("IARG",arg);
		chart.putExtra("PICN",picn);
		eta1.setText("");
		eta2.setText("");
		etb1.setText("");
		etb2.setText("");
		etc1.setText("");
		etc2.setText("");
		tvdd.setText("---");
		tvd1.setText("---");
		tvd2.setText("---");
		tvd3.setText("---");
		tvd4.setText("---");
		tvd5.setText("---");
		tvd6.setText("---");
		tvd7.setText("---");
		tvdd1.setText("---");
		tvd11.setText("---");
		tvd21.setText("---");
		tvd31.setText("---");
		tvd41.setText("---");
		tvd51.setText("---");
		tvd61.setText("---");
		tvd71.setText("---");
		if(arg!=2){PIC.setEnabled(false);}
		Log.i("ARG","ARG="+ARG+"("+arg+")");
		if(arg==3||arg==4||arg==5){
			picT=false;
		}
		startActivity(chart);
		}catch(Exception e){
			Log.e("chart",e+"");
			}
		}
	}
}
