package com.mycompany.dddkaj;

import android.app.*;
import android.os.*;
import android.view.*;
import android.widget.*;
import android.util.*;
import android.hardware.*;
import android.hardware.Camera.*;
import android.widget.CompoundButton.*;
import android.graphics.Color;
import java.util.*;
import android.widget.SeekBar.*;


public class LED extends Activity
{
	Switch 电灯泡,LEDS,sleep;
	SeekBar red,green,blue,light;
	double r,g,b,l;
	TextView LED;
	Camera camera;
	LinearLayout A,B,C,cr,cg,cb,cl;
	int hxp,M,H,K;
	boolean P2=false;
	Handler handler;
	EditText min;
	
	@Override
	public void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		getWindow().setFlags(WindowManager.LayoutParams. FLAG_FULLSCREEN ,WindowManager.LayoutParams. FLAG_FULLSCREEN);
        setContentView(R.layout.led);
		
		电灯泡=(Switch)findViewById(R.id.ddp);
		LEDS=(Switch)findViewById(R.id.led);
		red=(SeekBar)findViewById(R.id.red);
		red.setMax(255);
		green=(SeekBar)findViewById(R.id.green);
		green.setMax(255);
		blue=(SeekBar)findViewById(R.id.blue);
		blue.setMax(255);
		light=(SeekBar)findViewById(R.id.light);
		light.setMax(255);
		cr=(LinearLayout)findViewById(R.id.cr);
		cg=(LinearLayout)findViewById(R.id.cg);
		cb=(LinearLayout)findViewById(R.id.cb);
		cl=(LinearLayout)findViewById(R.id.cl);
		A=(LinearLayout)findViewById(R.id.A);
		B=(LinearLayout)findViewById(R.id.B);
		C=(LinearLayout)findViewById(R.id.C);
		min=(EditText)findViewById(R.id.min);
		
		OnSeekBarChangeListener rgb = new OnSeekBarChangeListener(){
			@Override
			int Cr,Cg,Cb,Cl;
			public void onProgressChanged(SeekBar p1, int p2, boolean p3)
			{
				// TODO: Implement this method
				try{
				r=red.getProgress();
				g=green.getProgress();
				b=blue.getProgress();
				l=light.getProgress();
				Cr=(int)r;Cg=(int)g;Cb=(int)b;Cl=(int)l;
				cr.setBackgroundColor(Color.rgb(Cr,0,0));
				cg.setBackgroundColor(Color.rgb(0,Cg,0));
				cb.setBackgroundColor(Color.rgb(0,0,Cb));
				cl.setBackgroundColor(Color.argb(Cl,Cr,Cg,Cb));
				if(P2){
					A.setBackgroundColor(Color.argb(Cl,Cr,Cg,Cb));
					B.setBackgroundColor(Color.argb(Cl,Cr,Cg,Cb));
					C.setBackgroundColor(Color.argb(Cl,Cr,Cg,Cb));
				}
				}catch(Exception e){}
			}

			@Override
			public void onStartTrackingTouch(SeekBar p1)
			{
				// TODO: Implement this method
				if(!P2){CustomToast.showToast(getBaseContext(),"LED不酱了！"+"\n"+"ERROR:没有将LED打开",2000);}
			}

			@Override
			public void onStopTrackingTouch(SeekBar p1)
			{
				// TODO: Implement this method
			}
		};
		red.setOnSeekBarChangeListener(rgb);
		green.setOnSeekBarChangeListener(rgb);
		blue.setOnSeekBarChangeListener(rgb);
		light.setOnSeekBarChangeListener(rgb);
		
		电灯泡.setOnCheckedChangeListener(new OnCheckedChangeListener(){
			@Override
			public void onCheckedChanged(CompoundButton p1, boolean p2)
			{
				// TODO: Implement this method
				try{
					if(p2){
						camera=Camera.open();
						Parameters mParameters=camera.getParameters();
						mParameters.setFlashMode(Camera.Parameters.FLASH_MODE_TORCH);
						camera.setParameters(mParameters);
						camera.startPreview();
					}else{
						camera.stopPreview();
						camera.release();
					}
				}catch(Exception e){
					Log.e("light",e+"");
					CustomToast.showToast(getBaseContext(),"大电灯泡不酱了！"+"\n"+"ERROR:电灯泡错误,请尝试重启应用解决问题",2000);
				}
			}
		});
		
		LEDS.setOnCheckedChangeListener(new OnCheckedChangeListener(){
			@Override
			public void onCheckedChanged(CompoundButton p1, boolean p2)
			{
				// TODO: Implement this method
				int Cr,Cg,Cb,Cl;
				P2=p2;Cr=(int)r;Cg=(int)g;Cb=(int)b;Cl=(int)l;
				if(p2){
					A.setBackgroundColor(Color.argb(Cl,Cr,Cg,Cb));
					B.setBackgroundColor(Color.argb(Cl,Cr,Cg,Cb));
					C.setBackgroundColor(Color.argb(Cl,Cr,Cg,Cb));
				}else{
					A.setBackgroundColor(Color.BLACK);
					B.setBackgroundColor(Color.BLACK);
					C.setBackgroundColor(Color.BLACK);
				}
			}
		});
	}
}
