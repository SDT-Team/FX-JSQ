package com.mycompany.dddkaj;

import android.app.*;
import android.os.*;
import android.view.*;
import android.widget.*;
import android.util.*;
import java.util.*;
import android.renderscript.*;

public class FC extends Activity
{
	@Override
	EditText  edittext;
	TextView textview,NO,sumTV,Min,Max,Median,Average,Mode;
	double sum=0,median,EXPL,EXPR,min,max,mode=0;
	public void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
        setContentView(R.layout.fc);
		
		edittext=(EditText)findViewById(R.id.edittext);
		textview=(TextView)findViewById(R.id.textview);
		NO=(TextView)findViewById(R.id.NO);
		sumTV=(TextView)findViewById(R.id.sum);
		Min=(TextView)findViewById(R.id.min);
		Max=(TextView)findViewById(R.id.max);
		Median=(TextView)findViewById(R.id.median);
		Average=(TextView)findViewById(R.id.average);
		Mode=(TextView)findViewById(R.id.mode);
	}
	
	public void button(View view){
		Average.setText("---");
		textview.setText("---");
		Max.setText("---");
		Min.setText("---");
		textview.setText("---");
		NO.setText("---");
		sumTV.setText("---");
		Median.setText("---");
		Mode.setText("---");
		String a = edittext.getText().toString();
		if(a.equals("")){
			CustomToast.showToast(getBaseContext(),"我算不了嘛！"+"\n"+"ERROR:文本框不能为空",2000);
		}else{
		sum=0;
		String data[]=a.split(" ");
		Arrays.sort(data);
		double s=0;
		if(ode(data.length)){
			double i3=Double.parseDouble(data[data.length/2-1]);
			double i4=Double.parseDouble(data[data.length/2]);
			median=(i3+i4)/2;
		}else{
			int i2=(int)(data.length/2+0.5);
			median=Double.parseDouble(data[i2]);
		}
		for(int i=0;i<data.length;i++){
			s+=Double.parseDouble(data[i]);
			sum+=Double.parseDouble(data[i]);
		}
		double avg=s/data.length;
		s=0;
		for(int i=0;i<data.length;i++){
			s+=Math.pow((Double.parseDouble(data[i])-avg),2);
		}
		try{
		double answer=s/data.length;
		EXPR=Double.parseDouble(data[data.length-1]);
		EXPL=Double.parseDouble(data[0]);
		if(EXPL<=EXPR){
			max=EXPR;
			min=EXPL;
		}else{
			max=EXPL;
			min=EXPR;
		}
		double[] dou = new double[data.length]; 
		for(int i=0;i<data.length;i++){
			dou[i] = Double.parseDouble(data[i]);
		}
		double mode=mode(dou);
		double longest=longest(dou);
		Max.setText(max+"");
		Min.setText(min+"");
		textview.setText(answer+"");
		NO.setText(data.length+"");
		sumTV.setText(sum+"");
		Median.setText(median+"");
		Average.setText(avg+"");
		Mode.setText(mode+"(n="+longest+")");
		}catch(Exception e){
			CustomToast.showToast(getBaseContext(),"ERROR:"+e,2000);
		}
	}}
	
	public void C(View view){
		edittext.setText("");
		textview.setText("---");
		Max.setText("---");
		Min.setText("---");
		textview.setText("---");
		NO.setText("---");
		sumTV.setText("---");
		Median.setText("---");
		Average.setText("---");
		Mode.setText("---");
	}
	
	public double mode(double[] array){
		Arrays.sort(array);
		int count=1;
		int longest=0;
		double mode=0;
		for(int i=0;i<array.length-1;i++){
			if(array[i]==array[i+1]){
				count++;
			}else{
				count=1;// 如果不等于，就换到了下一个数，那么计算下一个数的次数时，count的值应该重新符值为一
				continue;
			}
			if(count>longest){
				mode=array[i];
				longest=count;
			}
		}
		return mode;
	}
	
	public double longest(double[] array){
		Arrays.sort(array);
		int count=1;
		int longest=0;
		for(int i=0;i<array.length-1;i++){
			if(array[i]==array[i+1]){
				count++;
			}else{
				count=1;// 如果不等于，就换到了下一个数，那么计算下一个数的次数时，count的值应该重新符值为一
				continue;
			}
			if(count>longest){
				longest=count;
			}
		}
		return longest;
	}
	
	public static boolean ode(Integer number)
	{
		if (number%2==0)
			return true;//偶数
			else return false;//奇数
	}
}
