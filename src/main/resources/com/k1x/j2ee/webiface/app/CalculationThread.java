package com.k1x.j2ee.webiface.app;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.StaleStateException;

import com.k1x.j2ee.webiface.persistance.Calculations;
import com.k1x.j2ee.webiface.persistance.CalcThreadDbUtil;
import com.k1x.j2ee.webiface.persistance.HibernateUtil;
import com.k1x.j2ee.webiface.calculations.CalculationUtil;

public class CalculationThread extends Thread {

	@Override
	public synchronized void run() {
		try {
		while(true)
		{	
			wait(5000);
			Calculate();
			System.out.println("Waiting for more calculations to do...");
		}
		} catch (Exception e) {
			e.printStackTrace();
		}

		

	}
	
	private void Calculate() throws Exception
	{
		List<Calculations> calculations = CalcThreadDbUtil.GetNotCompleteCalculations();
		if(calculations!=null)
		for(Calculations calculation:calculations )
		{
			System.out.println(calculation.getName() + " is started!");
			wait(15000);
			calculation.setComplete(1);
			
			String data = CalculationUtil.KV(calculation.getK(), calculation.getK());
			
			calculation.setData(data);
			
			try
			{
			CalcThreadDbUtil.CompleteCalculation(calculation);
			}
			catch(StaleStateException e)
			{
				System.out.println("Error with update " + e.getMessage());
				break;
			}
			
			System.out.println(calculation.toString());

		}
	}
	
	public void doShutdown() {

	}



}
