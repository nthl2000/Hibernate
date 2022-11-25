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
        String hql = "Select * from Customers where CustomerId LIKE :toFind or FullName Like :toFind";
        Query query = session.createQuery(hql);
        query.setParameter("toFind", toFind);
        List results = query.list();
        session.getTransaction().commit();
        return results;
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
            String hql = "Update Customers set Fullname = :fullname , Password = :pass , Address= :address , City = :city   "
                    + "WHERE CUSTOMERID = :id";
            Query query = session.createQuery(hql);
            query.setParameter("id", c.getCustomerId());
            query.setParameter("fullname", c.getFullName());
            query.setParameter("pass", c.getPassword());
            query.setParameter("address", c.getAddress());
            query.setParameter("city", c.getCity());
            int result = query.executeUpdate();
            System.out.println("Rows affected:" +result);
            session.saveOrUpdate(c);

            session.getTransaction().commit();

            return true;
        } catch (RuntimeException re) {
            return false;
        }
    }

    public int deleteCustomer(int customerId) {
        String hql = "DELETE FROM CUSTOMERS WHERE CustomerID = :id";
        Query query = session.createQuery(hql);
        query.setParameter("id", customerId);
        int result = query.executeUpdate();
        System.out.println("Rows affected:" + result);
        return result;
    }

}
