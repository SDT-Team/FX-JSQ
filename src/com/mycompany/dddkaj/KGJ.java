package com.mycompany.dddkaj;

import android.app.*;
import android.os.*;
import android.view.*;
import android.widget.*;
import java.text.*;

public class KGJ extends Activity
{
	/** Called when the activity is first created. */
	@Override
		EditText ret;
		TextView F;
		CheckBox G1,S1;
		
		public void onCreate(Bundle savedInstanceState)
		{
			super.onCreate(savedInstanceState);
			setContentView(R.layout.kgj);
			
			ret = (EditText)findViewById(R.id.a);
			F = (TextView)findViewById(R.id.abc);
			G1 = (CheckBox)findViewById(R.id.G);
			S1 = (CheckBox)findViewById(R.id.S);
	}
	public void sta(View view)
	{
		String a = ret.getText().toString();
		
		if(a.equals("")){
			CustomToast.showToast(getBaseContext(),"我算不了嘛！"+"\n"+"ERROR:文本框不能为空",2000);
		}
		else{
		double b=Double.parseDouble(a);
		boolean G=G1.isChecked();
		boolean S=S1.isChecked();
		
		double LY1=b;
		if(G==true){
			if(LY1!=(long)LY1){
				CustomToast.showToast(getBaseContext(),"这是什么东西！"+"\n"+"ERROR:本模式暂不支持保留根号的小数计算",2000);
				F.setText(LY1+"");
			}
			else{
			int c=(int)b+1;
			if(b==1){
				F.setText("±1");//输入1时直接输出1
				if(S==true){
					F.setText("1");
				}
			}
			else{
				int K=0;
				while(K==0){
					c--;
					if(b%(c*c)==0){
						K=1;
					}
				}
				int d=c*c;
				double e=b/d;
				if(S==true){
					F.setText(c+"√"+e);
				}
				else{
					F.setText("±"+c+"√"+e);
					}
				}
			}
		}
		else{
			double T=Math.sqrt(b);
			if(S==true){
				F.setText(T+"");
			}
			else{
				F.setText("±"+T);
				}
			}
		}
	}
}
