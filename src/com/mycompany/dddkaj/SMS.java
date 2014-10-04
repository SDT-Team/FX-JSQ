package com.mycompany.dddkaj;

import android.app.*;
import android.os.*;
import android.view.*;
import android.widget.*;
import android.telephony.SmsManager;
import android.content.*;

public class SMS extends Activity
{
	/*EditText message;
	String l="",e="";
	
	public void onCreate(Bundle savedInstanceState)
	{
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sms);
		
		//message=(EditText)findViewById(R.id.message);
	}
	
	public void send(View view){
		String Message = message.getText().toString();
		SmsManager smsManager = SmsManager.getDefault();
		if(is(Message)==true){
			try{
				PendingIntent mPI = PendingIntent.getBroadcast(SMS.this,0,new Intent(),0);
				smsManager.sendTextMessage(l,null,Message,mPI,null);
				Toast.makeText(SMS.this,"发送完毕，感谢你的反馈",Toast.LENGTH_LONG).show();
			}catch(Exception e){
				Toast.makeText(SMS.this,"ERROR:"+e,Toast.LENGTH_LONG).show();
			}
		}
		else if(is(Message)==false){
			Toast.makeText(SMS.this,"信息过长",Toast.LENGTH_LONG).show();
			message.setText("");
		}
	}
	
	public static boolean is(String text)
	 {
		if (text.length()<=70)
			return true;
		else return false;
	 }*/
}
