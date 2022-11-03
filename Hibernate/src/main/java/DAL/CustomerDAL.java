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
public class CustomerDAL {
    Session session;
    public CustomerDAL(){
        session = HibernateUtils.getSessionFactory().openSession();
    }
    public Customers getCustomer(int customerId){
        Customers obj;
        session.beginTransaction();
        obj = session.get(Customers.class, customerId);
        session.getTransaction().commit();
        return obj;
    }
}
