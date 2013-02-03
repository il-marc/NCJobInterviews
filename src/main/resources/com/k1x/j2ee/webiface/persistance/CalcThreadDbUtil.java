/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.k1x.j2ee.webiface.persistance;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.StaleStateException;

import com.k1x.j2ee.webiface.persistance.HibernateUtil;
import com.k1x.j2ee.webiface.persistance.Users;

import java.util.List;

/**
 *
 * @author k1x
 */
public class CalcThreadDbUtil {

    
    public static List<Calculations> GetNotCompleteCalculations()
    {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        
		session.beginTransaction();
		String query = "from Calculations where complete = 0";
        List<Calculations> result = session.createQuery(query).list();
		session.getTransaction().commit();
		
        return result;   
    }
    
    public static void CompleteCalculation(Calculations calculation) throws StaleStateException
    {
    		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
       		session.beginTransaction();
       		session.update(calculation);
            session.getTransaction().commit();
    }
     
    
}
