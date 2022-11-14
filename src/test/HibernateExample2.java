
import java.util.Iterator;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Admin
 */
public class HibernateExample2{
    private static SessionFactory factory;
    public static void main(String[] args){
        try{
        factory = new Configuration().configure().buildSessionFactory();
        } catch (Throwable ex){
            System.err.println("Failed to create sessionFactory object." + ex);
            throw new ExceptionInInitializerError(ex);
        }
        HibernateExample2 hb = new HibernateExample2();
        hb.listDepartment();
    }
    public void listDepartment( ){
        Session session = factory.openSession();
        Transaction tx = null;
        try{
            tx = session.beginTransaction();
            List employees = session.createQuery("From Department").list();
            for (Iterator iterator = employees.iterator(); iterator.hasNext();){
            Department dp = (Department) iterator.next();
                System.out.println("Name: " + dp.getName());
                System.out.println("StartDate: " + dp.getStartDate());
                System.out.println("Budget: " + dp.getBudget());
            }
            tx.commit();
        } catch(HibernateException e){
            if(tx!= null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }
    
}
