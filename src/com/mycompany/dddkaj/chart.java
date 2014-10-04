package com.mycompany.dddkaj;

import android.app.*;
import android.os.*;
import android.view.*;
import android.widget.*;
import android.graphics.*;
import android.content.*;
import android.util.*;

public class chart extends Activity
{
	Double A,B,C,D,E,F;
	int PICN,ARG;
	@Override
	public void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		getWindow().setFlags(WindowManager.LayoutParams. FLAG_FULLSCREEN ,WindowManager.LayoutParams. FLAG_FULLSCREEN);
        setContentView(new Function(this));
	}
	
	class Function extends View{
		Paint paint,paintcos,paintsin,paintA,paintB;
		public Function(Context context) {
			super(context);
			paint = new Paint(); //笔刷1
			paint.setColor(Color.GRAY);//灰色
			paint.setStrokeJoin(Paint.Join.ROUND);
			paint.setStrokeCap(Paint.Cap.ROUND);
			paint.setStrokeWidth(3);//大小3
			paint.setAntiAlias(true);//抗锯齿
			paintA = new Paint(); //笔刷1
			paintA.setColor(Color.argb(125,0,255,0));//绿色
			paintA.setStrokeJoin(Paint.Join.ROUND);
			paintA.setStrokeCap(Paint.Cap.ROUND);
			paintA.setStrokeWidth(3);//大小3
			paintA.setAntiAlias(true);//抗锯齿
			paintB = new Paint(); //笔刷1
			paintB.setColor(Color.argb(125,0,0,255));//蓝色
			paintB.setStrokeJoin(Paint.Join.ROUND);
			paintB.setStrokeCap(Paint.Cap.ROUND);
			paintB.setStrokeWidth(3);//大小3
			paintB.setAntiAlias(true);//抗锯齿
			paintcos = new Paint(); //cos笔刷
			paintcos.setColor(Color.argb(125,0,255,0));//绿色
			paintcos.setStrokeJoin(Paint.Join.ROUND);
			paintcos.setStrokeCap(Paint.Cap.ROUND);
			paintcos.setStrokeWidth(3);//大小3
			paintcos.setAntiAlias(true);//抗锯齿
			paintsin = new Paint(); //sin笔刷
			paintsin.setColor(Color.argb(125,255,0,0));//红色
			paintsin.setStrokeJoin(Paint.Join.ROUND);
			paintsin.setStrokeCap(Paint.Cap.ROUND);
			paintsin.setStrokeWidth(3);//大小3
			paintsin.setAntiAlias(true);//抗锯齿
		}
		
		@Override
		protected void onDraw(Canvas canvas) {
			try{
				Intent intent=getIntent();
				A=intent.getDoubleExtra("IA",0);
				B=intent.getDoubleExtra("IB",0);
				C=intent.getDoubleExtra("IC",0);
				D=intent.getDoubleExtra("ID",0);
				E=intent.getDoubleExtra("IE",0);
				F=intent.getDoubleExtra("IF",0);
				ARG=intent.getIntExtra("IARG",0);
				PICN=intent.getIntExtra("PICN",0);
				Log.i("intent","A="+A+" B="+B+" C="+C+" D="+D+" E="+E+" F="+F+" ARG="+ARG);
			}catch(Exception e){
				Log.e("Intent","ERROR:"+e);
			}
			float a=Float.parseFloat((String.valueOf(A))),b=Float.parseFloat((String.valueOf(B))),c=Float.parseFloat((String.valueOf(C))),d=Float.parseFloat((String.valueOf(D))),e=Float.parseFloat((String.valueOf(E))),f=Float.parseFloat((String.valueOf(F)));
			int height=getHeight();
			int width=getWidth();
			//hxp把这句话提前了
			float hxp7646;//单位长度
			if(width<height)
			{
				hxp7646=width/24;
			}else{
				hxp7646=height/24;
			}
		//一次与二次
			if(ARG==0||ARG==1||ARG==3||ARG==4||ARG==5){
			//x轴
			canvas.drawLine(0,height/2,width,height/2,paint);
			Path trianglex=new Path();
			trianglex.moveTo(width/2,0);trianglex.lineTo(width/2+10,20);trianglex.lineTo(width/2-10,20);trianglex.lineTo(width/2,0);trianglex.close();
			canvas.drawPath(trianglex,paint);//箭头三角形
			canvas.drawPosText("X", new float[]{width/2-20,20}, paint);
			for(int hxp=0;hxp<height;hxp++)
			{
				canvas.drawLine(width/2+hxp*hxp7646,height/2+3,width/2+hxp*hxp7646,height/2-3,paint);
				canvas.drawLine(width/2-hxp*hxp7646,height/2+3,width/2-hxp*hxp7646,height/2-3,paint);
				//hxp调试错误的代码:canvas.drawPosText(String.valueOf(hxp),new float[]{width/2+hxp*hxp7646,20},paint);
			}
			
			//y轴
			canvas.drawLine(width/2,0,width/2,height,paint);
			Path triangley=new Path();
			triangley.moveTo(width,height/2);triangley.lineTo(width-20,height/2+10);triangley.lineTo(width-20,height/2-10);triangley.lineTo(width,height/2);triangley.close();
			canvas.drawPath(triangley,paint);//箭头三角形
			canvas.drawPosText("Y", new float[]{width-20,height/2+20}, paint);
			for(int hxp=0;hxp<5000;hxp++)
			{
				canvas.drawLine(width/2+3,height/2+hxp*hxp7646,width/2-3,height/2+hxp*hxp7646,paint);
				canvas.drawLine(width/2+3,height/2-hxp*hxp7646,width/2-3,height/2-hxp*hxp7646,paint);
			}
			
			//hxp画点算法
			int centerpointX=width/2;//原点x坐标
			int centerpointY=height/2;//原点y坐标
			/*这句话被hxp提前
			float hxp7646;//单位长度
			if(ARG==0){hxp7646=5;}else{hxp7646=15;}*/
			double sizeX=width/hxp7646,sizeY=height/hxp7646;
			float [] Xdata=new float[width*100];//要画的点X坐标写入这数组
			float [] Ydata=new float[height*100];//Y坐标写这里
			float [] XBdata=new float[width*100];//要画的点X坐标写入这数组
			float [] YBdata=new float[height*100];//Y坐标写这里
			boolean set2=true;int ybr=0;
			
			//二次函数
			float ddxF=-b/(2*a),ddxZ,ddxFB=-e/(2*d),ddxZB;
			ddxZ=ddxF;ddxZB=ddxFB;
			int F=0;
			double PIC=0,mode=0;
			if(ARG==0||ARG==3){
				if(PICN==3){
					paintA.setAlpha(10);//绿色
					paintB.setAlpha(10);//蓝色
				}
				//[数据阀3.0]
				if(PICN==0){
					PIC=0.5;
					mode=width/5;
				}
				if(PICN==1){
					PIC=0.1;
					mode=width;
				}
				if(PICN==2){
					PIC=0.01;
					mode=width*10;//要想使渣机运算快主要不是改变
				}				  //图像分辨率(PIC)而是改变while
				if(PICN==3){      //的运算次数(mode)，不然，运算速度照样慢
					PIC=0.001;     //希望这个画图经验对你有帮助，谢谢你的
					mode=width*18;//建议
				}
				while(set2){
					//对称轴左
					Xdata[ybr]=ddxF;
					Ydata[ybr]=a*ddxF*ddxF+b*ddxF+c;
					if(ARG==0){
						canvas.drawLine(centerpointX+Xdata[ybr]*hxp7646,centerpointY-Ydata[ybr]*hxp7646,centerpointX+Xdata[ybr]*hxp7646,centerpointY-Ydata[ybr]*hxp7646+1,paint);
					}else{
						XBdata[ybr]=ddxFB;
						YBdata[ybr]=d*ddxFB*ddxFB+e*ddxFB+f;
						canvas.drawLine(centerpointX+XBdata[ybr]*hxp7646,centerpointY-YBdata[ybr]*hxp7646,centerpointX+XBdata[ybr]*hxp7646,centerpointY-YBdata[ybr]*hxp7646+1,paintA);
						canvas.drawLine(centerpointX+Xdata[ybr]*hxp7646,centerpointY-Ydata[ybr]*hxp7646,centerpointX+Xdata[ybr]*hxp7646,centerpointY-Ydata[ybr]*hxp7646+1,paintB);
						ddxFB-=PIC;
					}
					ddxF-=PIC;
					ybr++;
					
					//对称轴右
					Xdata[ybr]=ddxZ;
					Ydata[ybr]=a*ddxZ*ddxZ+b*ddxZ+c;
					if(ARG==0){
						canvas.drawLine(centerpointX+Xdata[ybr]*hxp7646,centerpointY-Ydata[ybr]*hxp7646,centerpointX+Xdata[ybr]*hxp7646,centerpointY-Ydata[ybr]*hxp7646+1,paint);
					}else{
						XBdata[ybr]=ddxZB;
						YBdata[ybr]=d*ddxZB*ddxZB+e*ddxZB+f;
						canvas.drawLine(centerpointX+Xdata[ybr]*hxp7646,centerpointY-Ydata[ybr]*hxp7646,centerpointX+Xdata[ybr]*hxp7646,centerpointY-Ydata[ybr]*hxp7646+1,paintB);
						canvas.drawLine(centerpointX+XBdata[ybr]*hxp7646,centerpointY-YBdata[ybr]*hxp7646,centerpointX+XBdata[ybr]*hxp7646,centerpointY-YBdata[ybr]*hxp7646+1,paintA);
						ddxZB+=PIC;
					}
					ddxZ+=PIC;
					ybr++;
					F++;
					if(F==mode){
						set2=false;
					}
				}
				if(ARG==3){
					paintA.setAlpha(125);//绿色
					paintB.setAlpha(125);//蓝色
					String A="y1="+a+"x²",B="y2="+d+"x²";
					if(b!=0){
						if(b<0){A=A+""+b+"x";}else{
							A=A+"+"+b+"x";}
					}
					if(c!=0){
						if(c<0){A=A+""+c;}else{
							A=A+"+"+c;}
					}
					if(e!=0){
						if(b<0){B=B+""+e+"x";}else{
							B=B+"+"+e+"x";}
					}
					if(f!=0){
						if(c<0){B=B+""+f;}else{
							B=B+"+"+f;}
					}
					paint.setStyle(Paint.Style.FILL);
					canvas.drawRect(width-250,height-80,width-30,height-30,paint);// 长方形
					paint.setColor(Color.WHITE);
					canvas.drawLine(width-230,height-62,width-180,height-62,paintB);
					canvas.drawText(A,width-170,height-58,paint);
					canvas.drawLine(width-230,height-45,width-180,height-45,paintA);
					canvas.drawText(B,width-170,height-41,paint);
					paint.setColor(Color.GRAY);
				}
			}
			//一次函数
			if(ARG==1||ARG==4){
				if(ARG==4){
					paintA.setAlpha(150);//绿色
					paintB.setAlpha(150);//蓝色
				}
				float staX,staY,endX,endY,staXB,staYB,endXB,endYB;
				staX=centerpointX+(0-width/2)*hxp7646;
				staY=centerpointY+((0-width/2)*(0-a)-b)*hxp7646;
				endX=centerpointX+(width/2)*hxp7646;
				endY=centerpointY+((width/2)*(0-a)-b)*hxp7646;
				if(ARG==1){
					canvas.drawLine(staX,staY,endX,endY,paint);
				}else{
					staXB=centerpointX+(0-width/2)*hxp7646;
					staYB=centerpointY+((0-width/2)*(0-d)-e)*hxp7646;
					endXB=centerpointX+(width/2)*hxp7646;
					endYB=centerpointY+((width/2)*(0-d)-e)*hxp7646;
					canvas.drawLine(staX,staY,endX,endY,paintA);
					canvas.drawLine(staXB,staYB,endXB,endYB,paintB);
				}
				if(ARG==4){
					String A="y1="+a+"x",B="y2="+d+"x";
					if(b!=0){
						if(b<0){A=A+""+b;}else{
							A=A+"+"+b;}
					}
					if(e!=0){
						if(b<0){B=B+""+e;}else{
							B=B+"+"+e;}
					}
					paint.setStyle(Paint.Style.FILL);
					canvas.drawRect(width-250,height-80,width-30,height-30,paint);// 长方形
					paint.setColor(Color.WHITE);
					canvas.drawLine(width-230,height-62,width-180,height-62,paintA);
					canvas.drawText(A,width-170,height-58,paint);
					canvas.drawLine(width-230,height-45,width-180,height-45,paintB);
					canvas.drawText(B,width-170,height-41,paint);
					paint.setColor(Color.GRAY);
				}
			}
			
			//一次二次混合函数
			if(ARG==5){
				float staX,staY,endX,endY;
				if(PICN==3){paintA.setAlpha(10);}
				paintB.setAlpha(150);//蓝色
				//[数据阀3.0]
				if(PICN==0){
					PIC=0.5;
					mode=width/5;
				}
				if(PICN==1){
					PIC=0.1;
					mode=width;
				}
				if(PICN==2){
					PIC=0.01;
					mode=width*10;
				}
				if(PICN==3){
					PIC=0.001;
					mode=width*20;
				}
				while(set2){
					//对称轴左
					XBdata[ybr]=ddxFB;
					YBdata[ybr]=d*ddxFB*ddxFB+e*ddxFB+f;
					canvas.drawLine(centerpointX+XBdata[ybr]*hxp7646,centerpointY-YBdata[ybr]*hxp7646,centerpointX+XBdata[ybr]*hxp7646,centerpointY-YBdata[ybr]*hxp7646+1,paintA);
					ddxFB-=PIC;
					ybr++;
					XBdata[ybr]=ddxZB;
					YBdata[ybr]=d*ddxZB*ddxZB+e*ddxZB+f;
					canvas.drawLine(centerpointX+XBdata[ybr]*hxp7646,centerpointY-YBdata[ybr]*hxp7646,centerpointX+XBdata[ybr]*hxp7646,centerpointY-YBdata[ybr]*hxp7646+1,paintA);
					ddxZB+=PIC;
					ybr++;
					F++;
					if(F==mode){
						set2=false;
					}
				}
				staX=centerpointX+(0-width/2)*hxp7646;
				staY=centerpointY+((0-width/2)*(0-a)+b)*hxp7646;
				endX=centerpointX+(width/2)*hxp7646;
				endY=centerpointY+((width/2)*(0-a)+b)*hxp7646;
				canvas.drawLine(staX,staY,endX,endY,paintB);
				String A="y1="+a+"x",B="y2="+d+"x²";
				if(b!=0){
					if(b<0){A=A+""+b;}else{
						A=A+"+"+b;}
				}
				if(e!=0){
					if(b<0){B=B+""+e+"x";}else{
						B=B+"+"+e+"x";}
				}
				if(f!=0){
					if(c<0){B=B+""+f;}else{
						B=B+"+"+f;}
				}
				paintA.setAlpha(200);//绿色
				paintB.setAlpha(200);//蓝色
				paint.setStyle(Paint.Style.FILL);
				canvas.drawRect(width-250,height-80,width-30,height-30,paint);// 长方形
				paint.setColor(Color.WHITE);
				canvas.drawLine(width-230,height-62,width-180,height-62,paintB);
				canvas.drawText(A,width-170,height-58,paint);
				canvas.drawLine(width-230,height-45,width-180,height-45,paintA);
				canvas.drawText(B,width-170,height-41,paint);
				paint.setColor(Color.GRAY);
			}
			
				CustomToast.showToast(getBaseContext(),"屏幕大小为:"+height+"x"+width+"                                           "+
						   "坐标系大小为:"+sizeX+"x"+sizeY,2000);
		}
		//sin cos
		if(ARG==2){
			hxp7646=100;
			//x轴
			float centerpointX=20,centerpointY=height/2;
			canvas.drawLine(20,height/2,width-20,height/2,paint);
			Path trianglex=new Path();
			trianglex.moveTo(width-20,height/2);trianglex.lineTo(width-40,height/2-10);trianglex.lineTo(width-40,height/2+10);trianglex.lineTo(width-20,height/2);trianglex.close();
			canvas.drawPath(trianglex,paint);//箭头三角形
			canvas.drawPosText("X", new float[]{width-20,height/2-5}, paint);
			for(int hxp=0;hxp<width/hxp7646-1;hxp++)
			{
				canvas.drawLine(20+hxp*hxp7646,height/2+3,20+hxp*hxp7646,height/2-3,paint);
				//hxp调试错误的代码:canvas.drawPosText(String.valueOf(hxp),new float[]{width/2+hxp*hxp7646,20},paint);
			}

			//y轴
			canvas.drawLine(20,20,20,height-20,paint);
			Path triangley=new Path();
			triangley.moveTo(20,20);triangley.lineTo(10,40);triangley.lineTo(30,40);triangley.lineTo(20,20);triangley.close();
			canvas.drawPath(triangley,paint);//箭头三角形
			canvas.drawPosText("Y", new float[]{5,20}, paint);
			for(int hxp=0;hxp<height/hxp7646-1;hxp++)
			{
				canvas.drawLine(17,(height-20)-hxp*hxp7646,23,(height-20)-hxp*hxp7646,paint);
			}
			
			//曲线
			int ybr=0,F=0,mode=2;
			double x=0,PIC=1;
			//[数据阀4.0]
			if(PICN==0){
				PIC=1;
				mode=width/10;
			}
			if(PICN==1){
				PIC=0.5;
				mode=width/2;
			}
			if(PICN==2){
				PIC=0.1;
				mode=width;//要想使渣机运算快主要不是改变
			}				  //图像分辨率(PIC)而是改变while
			if(PICN==3){      //的运算次数(mode)，不然，运算速度照样慢
				PIC=0.01;     //希望这个画图经验对你有帮助，谢谢你的
				mode=width*15;//建议
			}
			float [] Xcosdata=new float[width*100];//要画的点X坐标写入这数组
			float [] Ycosdata=new float[height*100];//Y坐标写这里
			float [] Xsindata=new float[width*100];//要画的点X坐标写入这数组
			float [] Ysindata=new float[height*100];//Y坐标写这里
			boolean set=true;
			while(set){
				Xcosdata[ybr]=Float.parseFloat((String.valueOf(x)));
				Ycosdata[ybr]=Float.parseFloat((String.valueOf(Math.cos(x))));
				canvas.drawLine(centerpointX+Xcosdata[ybr]*hxp7646,centerpointY-Ycosdata[ybr]*hxp7646,centerpointX+Xcosdata[ybr]*hxp7646,centerpointY-Ycosdata[ybr]*hxp7646+1,paintcos);
				Xsindata[ybr]=Float.parseFloat((String.valueOf(x)));
				Ysindata[ybr]=Float.parseFloat((String.valueOf(Math.sin(x))));
				canvas.drawLine(centerpointX+Xsindata[ybr]*hxp7646,centerpointY-Ysindata[ybr]*hxp7646,centerpointX+Xsindata[ybr]*hxp7646,centerpointY-Ysindata[ybr]*hxp7646+1,paintsin);
				x+=PIC;
				ybr++;
				F++;
				if(F==mode){
				set=false;
				}
			}
			double sizeX=width/hxp7646,sizeY=height/hxp7646;
			CustomToast.showToast(getBaseContext(),"屏幕大小为:"+height+"x"+width+"                                           "+
						   "坐标系大小为:"+sizeX+"x"+sizeY,2000);
			
			//曲线标识
			paint.setStyle(Paint.Style.FILL);
			canvas.drawRect(width-230,height-80,width-30,height-30,paint);// 长方形
			paint.setColor(Color.WHITE);
			canvas.drawLine(width-210,height-62,width-130,height-62,paintcos);
			canvas.drawText("cos曲线",width-120,height-58,paint);
			canvas.drawLine(width-210,height-45,width-130,height-45,paintsin);
			canvas.drawText("sin曲线",width-120,height-41,paint);
			paint.setColor(Color.GRAY);
			}
		}
	}
}
