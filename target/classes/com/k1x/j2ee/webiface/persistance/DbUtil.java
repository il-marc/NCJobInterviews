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
public class DbUtil {

    
    
    public static List<Users> GetUsers(String name)
    {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();	

		session.beginTransaction();

    	List<Users> result = session.createQuery("from Users u where u.name='"+name+"'").list();  
    	
    	session.getTransaction().commit();
        return result;   
    }
    
    public static List<Calculations> GetCalculations()
    {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();  	

        session.beginTransaction();
        List<Calculations> result = session.createQuery("from Calculations").list();
       
       	session.getTransaction().commit();

        return result;   
    }

    public static Calculations GetCalculation(int id)
    {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();  	
    	
        session.beginTransaction();
        List<Calculations> result = session.createQuery("from Calculations where id = "+id).list();
        session.getTransaction().commit();

        if(result!=null)
        return result.get(0);   
        else return null;
    }
    
    public static List<Calculations> GetCalculations(int[] ids)
    {      

        StringBuffer query = new StringBuffer("from Calculations where id in (");
        for(int i = 0; i < ids.length; i++)
        {
        	query.append(ids[i]);
        	if(i< ids.length - 1)
        	query.append(",");
        }
        query.append(")");

        Session session = HibernateUtil.getSessionFactory().getCurrentSession(); 	
        session.beginTransaction();
        List<Calculations> result = session.createQuery(query.toString()).list();
       	session.getTransaction().commit();

        return result;   
    }
    
    
    public static void DeleteCalculations(int[] ids)
    {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession(); 	

        session.beginTransaction();
        
        StringBuffer query = new StringBuffer("delete from Calculations where id in (");
        for(int i = 0; i < ids.length; i++)
        {
        	query.append(ids[i]);
        	if(i< ids.length - 1)
        	query.append(",");
        }
        query.append(")");
        
        Query hquery = session.createQuery(query.toString());
        int result = hquery.executeUpdate();
        System.out.println(result);
        session.getTransaction().commit();
        
    }
    
    public static int CheckLogin(String name)
    {
             List<Users> result = GetUsers(name);
             int i=0;
             for(Users userdata:(List<Users>)result)
             {
                 if(userdata.getName().equalsIgnoreCase(name))
                 i++;
             }
    //    m=(users)session.get(users.class,1);       
        return i;   
    }
    
    public static void addMember(String name, String password, String fullname)
    {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();  	

        Users m = new Users(name,password,fullname);
        session.beginTransaction();
        session.save(m);
        session.getTransaction().commit();
    }
    
    
    public static void addCalculation(Users user, String name, String n, String k)
    {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession(); 	

    	int nInt = Integer.parseInt(n);
    	int kInt = Integer.parseInt(k);
    	Calculations calculation = new Calculations(0, 0, user.getId() , name, "Not Compelte", nInt, kInt);
        session.beginTransaction();
        session.save(calculation);
        session.getTransaction().commit();    
    }


}
