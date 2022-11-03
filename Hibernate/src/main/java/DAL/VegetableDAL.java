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
public class VegetableDAL {

    Session session;

    public VegetableDAL() {
        session = HibernateUtils.getSessionFactory().openSession();
    }
    public Vegetable getVegetable(int vegetableId){
        Vegetable obj;
        session.beginTransaction();
        obj = session.get(Vegetable.class, vegetableId);
        session.getTransaction().commit();
        return obj;
    }
}
