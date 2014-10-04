package com.mycompany.dddkaj;

import android.app.*;
import android.os.*;
import android.view.*;
import android.widget.*;
import android.graphics.*;
import android.support.v4.content.*;
import android.content.*;

public class Manu extends Activity
{
	/** Called when the activity is first created. */
    @Override
	
	public void onCreate(Bundle savedInstanceState)
	{
        super.onCreate(savedInstanceState);
        setContentView(R.layout.manu);
	}
	
	public boolean onCreateOptionsMenu(Menu menu)
	{
		getMenuInflater().inflate(R.menu.menu, menu);
		return true;
	}
	
	public boolean onOptionsItemSelected(MenuItem item)
	{
		if(item.getItemId()==R.id.XGJ){
			Intent openXGJ = new Intent(Manu.this,XGJ.class);
			Manu.this.startActivity(openXGJ);
		}
		if(item.getItemId()==R.id.GY){
			Intent openGY = new Intent(Manu.this,GY.class);
			Manu.this.startActivity(openGY);
		}
		if(item.getItemId()==R.id.SMS){
			/*Intent openSMS = new Intent(Manu.this,SMS.class);
			Manu.this.startActivity(openSMS);*/
			CustomToast.showToast(getBaseContext(),"我不会...",2000);
		}
		if(item.getItemId()==R.id.CAL){
			Intent openCAL = new Intent(Manu.this,Cal.class);
			Manu.this.startActivity(openCAL);
		}
		return true;
	}
	
	
	public void open1(View view){
		Intent openC2 = new Intent(Manu.this,MainActivity.class);
		Manu.this.startActivity(openC2);
	}
	
	public void open2(View view){
		Intent openOCS = new Intent(Manu.this,OCS.class);
		Manu.this.startActivity(openOCS);
	}
	
	public void open3(View view){
		Intent openRy = new Intent(Manu.this,Ry.class);
		Manu.this.startActivity(openRy);
	}
	
	public void open4(View view){
		Intent openROUND= new Intent(Manu.this,ROUND.class);
		Manu.this.startActivity(openROUND);
	}
	
	public void open5(View view){
		Intent openCOR = new Intent(Manu.this,COR.class);
		Manu.this.startActivity(openCOR);
	}
	
	public void open6(View view){
		Intent openFC = new Intent(Manu.this,FC.class);
		Manu.this.startActivity(openFC);
	}
}
