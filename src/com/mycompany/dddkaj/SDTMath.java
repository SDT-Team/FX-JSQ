package com.mycompany.dddkaj;
import android.util.*;

class SDTMath
{
	public static Double[] fractionroot(Integer A1,Integer A2)
	{/*
		 [分数开根函数1.0]
		 注：必须和root和ST函数一起使用
		 */
	 	Double[] re=new Double[3];
		Double[] root=new Double[2];
		Double[] ST=new Double[2];
		double n1=0,n2=0,N1=Double.parseDouble(A1+""),N2=Double.parseDouble(A2+"");
		n1=N1*N2;
		root=root((int)n1);
		n2=root[0];
		n1=root[1];
		ST=ST(n2,N2);
		re[0]=ST[0];
		re[1]=n1;
		re[2]=ST[1];
		Log.i("fractionroot","√("+A1+"/"+A2+")=("+re[0]+"√("+re[1]+"))/"+re[2]);
		return re;
	}

	public static Double[] root(Integer N)
	{/*
		 [开根函数1.0]
		 */
	 	Double[] re=new Double[2];
		int K=0,c=N+1;
		while(K==0){
			c--;
			if (N % (c * c) == 0){
				K=1;
			}
		}
		int d=c*c;
		double e=N/d;
		if(e==1){
			e=0;
		}
		re[0]=Double.parseDouble(""+c);
		re[1]=Double.parseDouble(""+e);
		Log.i("root","√"+N+"="+re[0]+"√"+re[1]);
		return re;
	}
	
	public static Double[] FM(Double A1,Double A2,Integer K,Double B1,Double B2)
	{/*
		 [分数基本计算函数2.0]
		 注：必须和ST函数一起使用
		 */
		double n1=0,n2=0;Double[] re=new Double[2];
		if(K==0){//A+B
			n1=A1*B2+B1*A2;
			n2=B2*A2;
			re=ST(n1,n2);
			Log.i("FM",A1+"/"+A2+"+"+B1+"/"+B2+"="+re[0]+"/"+re[1]);
		}
		if(K==1){//A-B
			n1=A1*B2-B1*A2;
			n2=B2*A2;
			re=ST(n1,n2);
			Log.i("FM",A1+"/"+A2+"-"+B1+"/"+B2+"="+re[0]+"/"+re[1]);
		}
		if(K==2){//AxB
			n1=A1*B1;
			n2=B2*A2;
			re=ST(n1,n2);
			Log.i("FM",A1+"/"+A2+"x"+B1+"/"+B2+"="+re[0]+"/"+re[1]);
		}
		if(K==3){//A÷B
			n1=A1*B2;
			n2=B1*A2;
			re=ST(n1,n2);
			Log.i("FM",A1+"/"+A2+"÷"+B1+"/"+B2+"="+re[0]+"/"+re[1]);
		}
		return re;
	}

	public static Double[] ST(Double n1,Double n2)
	{/*
		 [分数化简函数4.0]
		 n1分子，n2分母
		 含有质数的分数初步化简
		 */
		Double[] re=new Double[2];
		String N1=""+n1,N2=""+n2;int a=2;boolean set=true,T2=true,T3=true,T5=true,T7=true;
		double a1=n1,a2=n2;
		while(set){
			if(n2%a==0&&n1%a==0){
				n1=n1/a;n2=n2/a;
			}else{
				if(a==a1+1||a==a2+1||0-a==a1-1||0-a==a2-1){
					set=false;
				}else a++;}
		}

		//最后化简
		while(T2){//除以2化简
			if(n1%2==0&&n2%2==0){
				n1=n1/2;n2=n2/2;
			}else T2=false;
		}
		while(T3){//除以3化简
			if(n1%3==0&&n2%3==0){
				n1=n1/3;n2=n2/3;
			}else T3=false;
		}
		while(T5){//除以5化简
			if(n1%5==0&&n2%5==0){
				n1=n1/5;n2=n2/5;
			}else T5=false;
		}
		while(T7){//除以7化简
			if(n1%7==0&&n2%7==0){
				n1=n1/7;n2=n2/7;
			}else T7=false;
		}

		re[0]=n1;
		re[1]=n2;
		Log.i("ST",N1+"/"+N2+" --> "+re[0]+"/"+re[1]);
		return re;
	}
}
