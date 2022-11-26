/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import java.util.List;
import org.hibernate.Session;

/**
 *
 * @author Admin
 */
public class OrderDetailsDAL {

    Session session;

    public OrderDetailsDAL() {
        session = HibernateUtils.getSessionFactory().openSession();
    }
    
    //load page
    public List loadOrderDetails() {
        List<OrderDetails> orderDetails;
        session.beginTransaction();
        orderDetails = session.createQuery("FROM OrderDetails", OrderDetails.class).list();
        session.getTransaction().commit();
        return orderDetails;
    }
    //get selected row

    public OrderDetails getOrderDetails(int orderId, int VegetableId) {
        session.beginTransaction();
        OrderDetails obj = session.get(OrderDetails.class, orderId);
        session.getTransaction().commit();
        return obj;
    }

    //Find
    public List findDetails(String toFind) {
        List<OrderDetails> orderDetails;

        session.beginTransaction();

        String hql = "FROM OrderDetails where OrderID LIKE '%" + toFind + "%' OR VegetableID LIKE '%" + toFind + "%'  ";

        System.out.println("hql: " + hql);
        orderDetails = session.createQuery(hql)
                .list();

        session.getTransaction().commit();

        return orderDetails;
    }
    //Add
    public boolean addOrderDetails(OrderDetails o) {

        try {
            session.beginTransaction();
            session.save(o);
            session.getTransaction().commit();

            return true;
        } catch (RuntimeException re) {

            return false;
        }

    }

    public boolean deleteOrderDetails(OrderDetails o) {
        try {
            session.beginTransaction();
            session.delete(o);
            session.getTransaction().commit();

            return true;
        } catch (RuntimeException re) {

            return false;
        }
    }
}
