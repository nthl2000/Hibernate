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
//    public OrderDetails getOrderDetails(int orderId, int vegetableId){
//        OrderDetails obj;
//        session.beginTransaction();
//        obj = session.get(OrderDetails.class, orderId,vegetableId);
//        
//    }
}
