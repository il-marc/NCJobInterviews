package com.k1x.j2ee.webiface.calculations;

public class Calculations {
	
	public static String KV(int n, int k)
	{
		StringBuffer Str = new StringBuffer();

		int nel=1;
		int d1=n-k+1; //начало отсчета А
		int d2=2*n+3; //начало отсчета В
		int d3=5*n-k+3; //начало отсчета выходов
		int d4=(k+1)/2; //количество элкментов 2и
		
		System.out.println("n= " + n  + " k=" + k );
		System.out.println("d1="+d1+" d2="+d2+" d3="+d3+" d4="+d4);
		int M[][] = new int[4][255];
		for(int i=0;i<d4;i++)
		{
			M[1][i]=d1+i*2;
			M[2][i]=d2-i*2;
			M[3][i]=d3+i;

		}

		Str.append("\n");
		for(int j=nel;j<nel+d4;j++)
		{
			Str.append(" "+j);
			if(j<10) Str.append(" ");
			if(j<100) Str.append(" ");
		}
		
		Str.append("\n");
		for(int i=0;i<3;i++)
		{
			for(int j=0;j<d4;j++)
			{
				Str.append(" "+ M[i+1][j]);

			}
			Str.append("\n");
		}

		Str.append("\n");
		
		nel+=d4;
	//sum полный
		int d5=d3+d4; // начало нумерации выходов элементов с нечетными выходами
		int d7=d4/3; // количество сумматоров с 3мя входами
		int flag=0;
		if(d4%3!=0) {flag=1; d5+=3-d4%3; d7++;}
		int d6=d5+1; // начало нумерации выходов элементов с четными выходами

		System.out.println("d5="+d5+" d6="+d6+" d7="+d7+" flag="+flag);


		int M1[][] = new int[6][255];

		for(int i=0;i<d7;i++)
		{
			M1[1][i]=d3+3*i;
			M1[2][i]=d3+3*i+1;
			M1[3][i]=d3+3*i+2;
			M1[4][i]=d5+2*i;
			M1[5][i]=d6+2*i;
		}
		if(flag==1) for(int i=3;i>d4%3;i--)	M1[i][d7-1]=0;
		
		for(int j=nel;j<nel+d7;j++)
		{
			Str.append(" "+j);
			if(j<10) Str.append(" ");
			if(j<100) Str.append(" ");
		}
		Str.append("\n");

		for(int i=0;i<5;i++)
		{
			for(int j=0;j<d7;j++)
			{
				Str.append(" "+M1[i+1][j]);
			}
			Str.append("\n");
		}
		nel+=d7;
	// для Sum mod 3

		int d8=(k+1)/2+1; //количество сумматоров по модулю 3 первого ранга
		int d9=2*n+3; //определение отсчета начала нумеров входов числа А
		int d10=d9+2*d8-2; //определние отсчета начала нумеров входов числа B
		int d11 = d5+d7*2+2*(d7-1); //начальное значение
		int M2[][] = new int[7][255]; //массив, содержащий сумматоры по модулю 3
		int odd=0; //счетчик "одиночных" элементов, для которых не нашлось места в "пирамиде" 
		int M2_n[] = new int[127]; //массив, содержащий номера одиночных элементов
		int mn=0; //сдесь хранится последний используемый номер выхода

		M2[1][0]=n+1;
		M2[2][0]=n+2;
		M2[3][0]=2*n+3;
		M2[4][0]=2*n+4;
		M2[5][0]=d11;
		M2[6][0]=d11+1;
		//определяется элемент в который входят КА и КВ

		
		for(int i=1;i<d8;i++)
		{
			M2[1][i]=d9+2*i;
			M2[2][i]=d9+2*i+1;
			M2[3][i]=d10+2*i;
			M2[4][i]=d10+2*i+1;
			M2[5][i]=d11+2*i;
			M2[6][i]=d11+2*i+1;
		}
		if(d8%2!=0) 
		{
			M2_n[odd]=d8-1;
			odd++;
		}
		//определение сумматоров первого ранга, в которые входят KAn и КИn
		int max=d8;
		int step=d8;
		int st1=0;
		int odd_step=0;
		while(step!=1)
		{
		step=step/2;
		for(int i=0;i<step;i++)
		{
			if((d11+odd_step+4*st1+4*i+2)==262) odd_step+=2;
			M2[1][i+max]=d11+odd_step+4*st1+4*i;
			M2[2][i+max]=d11+odd_step+4*st1+4*i+1;
			M2[3][i+max]=d11+odd_step+4*st1+4*i+2;
			M2[4][i+max]=d11+odd_step+4*st1+4*i+3;
			M2[5][i+max]=d11+2*st1+2*d8+2*i;
			M2[6][i+max]=d11+2*st1+2*d8+2*i+1;
			mn=M2[6][i+max];
		}
		st1+=step;
		max+=step;
		if(step%2!=0)
		{
			M2_n[odd]=max-1;
			odd++;
			odd_step+=2;
		}
		}

		
	//соединение каскадом элементов, поступивших от сумматоров с 3мя входами. 	
		int d12=d5+d7*2;
		M2[1][max]=d5;
		M2[2][max]=d5+1;
		M2[3][max]=d5+2;
		M2[4][max]=d5+3;
		M2[5][max]=d12;
		M2[6][max]=d12+1;
		max++;
		for(int i=0;i<d7-2;i++)
		{
		M2[1][max]=d5+4+i*2;
		M2[2][max]=d5+5+i*2;
		M2[3][max]=d12+i*2;
		M2[4][max]=d12+i*2+1;
		M2[5][max]=d12+i*2+2;
		M2[6][max]=d12+i*2+3;
		M2_n[odd]=max;
		max++;
		}
		odd++;

	//Vy
		int dvy=3*n+5; //качало осчета Vy
		int nvy=4*n-k+4-dvy+1; //количество входов
		int nsum=(nvy-4)/2+(nvy-4)%2; //количетво сумматоров, необходимых для соеденнеия каскадом Vy, если количество входов больше 4 
		System.out.println("nvy = "+nvy);
		M2[1][max]=dvy;
		M2[2][max]=dvy+1;
		M2[3][max]=dvy+2;
		M2[4][max]=dvy+3;
		M2[5][max]=mn+1;
		M2[6][max]=mn+2;
		M2_n[odd]=max;
		max++;

		for(int i=0;i<nsum;i++)
		{
		M2[1][max]=dvy+4+i;
		M2[2][max]=dvy+5+i;
		if((nvy-4-2*i)%2!=0) M2[2][max]=0;
		M2[3][max]=mn+1;
		M2[4][max]=mn+2;
		M2[5][max]=mn+3;
		M2[6][max]=mn+4;
		M2_n[odd]=max;
		max++;
		mn+=2;
		}
		odd++;


	//Соеденение каскадом элементов отсавшихся одиночными	
		mn+=2;
		M2[1][max]=M2[5][M2_n[0]];
		M2[2][max]=M2[6][M2_n[0]];
		M2[3][max]=M2[5][M2_n[1]];
		M2[4][max]=M2[6][M2_n[1]];
		M2[5][max]=mn+1;
		M2[6][max]=mn+2;
		max++;

		for(int i=2;i<odd;i++)
		{
		M2[1][max]=M2[5][M2_n[i]];
		M2[2][max]=M2[6][M2_n[i]];
		M2[3][max]=mn+1;
		M2[4][max]=mn+2;
		M2[5][max]=mn+3;
		M2[6][max]=mn+4;
		mn+=2;
		max++;
		}

		Str.append("\n");
		for(int j=nel;j<max+nel;j++)
		{
			Str.append(" "+j);
			if(j<10) Str.append(" ");
			if(j<100) Str.append(" ");
		}
		Str.append("\n");

		for(int i=0;i<6;i++)
		{
			for(int j=0;j<max;j++)
			{
				Str.append(" "+M2[i+1][j]);
				if(M2[i+1][j]<10) Str.append(" ");
				if(M2[i+1][j]<100) Str.append(" ");

			}
			Str.append("\n");
		}
		
		
		System.out.println(Str);
		return Str.toString();
	}
}