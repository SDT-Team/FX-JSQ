package com.mycompany.dddkaj;

import android.app.*;
import android.os.*;
import android.view.*;
import android.widget.*;
import android.graphics.*;
import android.support.v4.content.*;
import android.content.*;

public class XGJ extends Activity
{
	/** Called when the activity is first created. */
    @Override
	public void onCreate(Bundle savedInstanceState)
	{
        super.onCreate(savedInstanceState);
        setContentView(R.layout.xgj);
	}
	
	public void op1(View view){
		i=0;
		Intent openC2 = new Intent(XGJ.this,KGJ.class);
		XGJ.this.startActivity(openC2);
	}
	
	public void op2(View view){
		i=0;
		Intent openLED = new Intent(XGJ.this,LED.class);
		XGJ.this.startActivity(openLED);
	}
	
	int i=0;
	public void op3(View view){
		Toast toast=Toast.makeText(XGJ.this,"",Toast.LENGTH_SHORT);
		toast.setGravity(Gravity.CENTER,0,0);
		if(i<=0){
			CustomToast.showToast(getBaseContext(),"不要点了没有的...",1000);
		}else{
			if(i>0&&i<=1){
				CustomToast.showToast(getBaseContext(),"你想干什么？!",1000);
			}else{
				if(i>1&&i<=2){
					CustomToast.showToast(getBaseContext(),"嘿！！！骚年，摸点了！再点我就消失!",1000);
				}else{
					toast.cancel();
					toast=Toast.makeText(XGJ.this,"哈！哈！哈！哈！让你点!",1);
					LinearLayout toastView=(LinearLayout)toast.getView();
					ImageView image=new ImageView(getApplication());
					image.setImageResource(R.drawable.myl);
					toastView.addView(image,0);
					toast.show();
					Intent openManu = new Intent(XGJ.this,Manu.class);
					XGJ.this.startActivity(openManu);
				}
			}
		}
		i++;
	}
}
