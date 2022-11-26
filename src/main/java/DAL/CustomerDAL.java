/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.query.Query;

/**
 *
 * @author Admin
 */
public class CustomerDAL {

    Session session;

    public CustomerDAL() {
        session = HibernateUtils.getSessionFactory().openSession();
    }

    //load page
    public List loadCustomer() {
        List<Customers> customer;
        session.beginTransaction();
        customer = session.createQuery("FROM Customers", Customers.class).list();
        session.getTransaction().commit();
        return customer;
    }

    //get selected row
    public Customers getCustomer(int customerId) {

        session.beginTransaction();
        Customers obj = session.get(Customers.class, customerId);
        session.getTransaction().commit();
        return obj;
    }

    //Find
    public List findCustomers(String toFind) {
        List<Customers> customers;
        session.beginTransaction();
        String hql = "From Customers where CustomerId LIKE '%"+ toFind +"%' or FullName Like '%"+ toFind +"%'";
        System.out.println("hql: " + hql);
        customers = session.createQuery(hql)
                .list();
        
        session.getTransaction().commit();
        return customers;
    }

    //Create
    public boolean addCustomer(Customers c) {

        try {
            session.beginTransaction();
            session.save(c);
            session.getTransaction().commit();

            return true;
        } catch (RuntimeException re) {
            return false;
        }
    }

    public boolean updateCustomer(Customers c) {

        try {
            session.beginTransaction();
            session.saveOrUpdate(c);
            session.getTransaction().commit();

            
            return true;
        } catch (RuntimeException re) {

            return false;
        }
    }

    public boolean deleteCustomer(Customers c) {
        try {
            session.beginTransaction();
            session.delete(c);
            session.getTransaction().commit();

           
            return true;
        } catch (RuntimeException re) {

            return false;
        }
    }

}
