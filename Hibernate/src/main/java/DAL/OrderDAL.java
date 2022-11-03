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
public class OrderDAL {
    Session session;
    public OrderDAL(){
        session = HibernateUtils.getSessionFactory().openSession();
    }
    public Order getOrder(int orderId){
        Order obj;
        session.beginTransaction();
        obj = session.get(Order.class, orderId);
        session.getTransaction().commit();
        return obj;
    }
}
