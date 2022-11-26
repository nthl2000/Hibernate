/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Admin
 */
public class OrderDAL {

    Session session;

    public OrderDAL() {
        session = HibernateUtils.getSessionFactory().openSession();
    }
    //load page
    public List loadOrder() {
        List<Order> order;
        session.beginTransaction();
        order = session.createQuery("FROM Order", Order.class).list();
        session.getTransaction().commit();
        return order;
    }
    
    //get selected row
    public Order getOrder(int orderId) {
        session.beginTransaction();
        Order obj = session.get(Order.class, orderId);
        session.getTransaction().commit();
        return obj;
    }
    


    //Find
    public List findOrders(String toFind) {
        List<Order> order;

        session.beginTransaction();

        String hql = "FROM Order where OrderID LIKE '%" + toFind + "%' "
                + "OR CustomerId LIKE '%" + toFind + "%' "
                + "OR Date LIKE '%" + toFind + "%'  ";

        System.out.println("hql: " + hql);
        order = session.createQuery(hql)
                .list();

        session.getTransaction().commit();

        return order;
    }

    public boolean addOrder(Order o) {

        try {
            session.beginTransaction();
            session.save(o);
            session.getTransaction().commit();

            return true;
        } catch (RuntimeException re) {

            return false;
        }

    }

    public boolean updateOrder(Order o) {

        try {
            session.beginTransaction();
            session.saveOrUpdate(o);
            session.getTransaction().commit();

            return true;
        } catch (RuntimeException re) {

            return false;
        }
    }

    public boolean deleteOrder(Order o) {
        try {
            session.beginTransaction();
            session.delete(o);
            session.getTransaction().commit();

            return true;
        } catch (RuntimeException re) {

            return false;
        }
    }

    public List loadCustomerId() {
         List<Customers> customerId;
        session.beginTransaction();
        customerId = session.createQuery("Select CustomerId FROM Customers", Customers.class).list();
        session.getTransaction().commit();
        return customerId;
    }

}
