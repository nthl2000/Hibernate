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
    public OrderDAL(){
        session = HibernateUtils.getSessionFactory().openSession();
    }
    public List loadOrder() {
        List<Order> order;
        session.beginTransaction();
       
        order = session.createQuery("FROM Order", Order.class).list();
        
        session.getTransaction().commit();
        
        return order;
    }
    public Order getOrder(int orderId){
        Order obj;
        session.beginTransaction();
        obj = session.get(Order.class, orderId);
        session.getTransaction().commit();
        return obj;
    }
    public void addOrder(Order o){
        session.save(o);
    }
    public void updateOrder(Order o){
        session.update(o);
    }
    public void deleteOrder(Order o){
        session.delete(o);
    }
    
   
}
