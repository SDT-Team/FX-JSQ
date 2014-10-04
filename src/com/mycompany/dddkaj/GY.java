package com.mycompany.dddkaj;

import android.app.*;
import android.os.*;
import android.view.*;
import android.widget.*;

public class GY extends Activity
{
	/** Called when the activity is first created. */
    @Override
	
	TextView B;
	public void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
        setContentView(R.layout.gy);
		
		B = (TextView)findViewById(R.id.B);
		B.setText("@ 2014 SRY技术组,all rights reserved"+"\n"+"你可以在贴吧上@1169699211或在微信上查找老爹或变种鱼肝油玩哦！"+"\n"+"感谢你对我们的支持");
	}
}
