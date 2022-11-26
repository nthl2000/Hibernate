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
public class VegetableDAL {

    Session session;

    public VegetableDAL() {
        session = HibernateUtils.getSessionFactory().openSession();
    }

    //load page
    public List loadVegetable(){
        List<Vegetable> vegetable;
        session.beginTransaction();
        vegetable = session.createQuery("FROM Vegetable", Vegetable.class).list();
        session.getTransaction().commit();
        return vegetable;
    }
    //get selected row
    public Vegetable getVegetable(int vegetableId) {
        session.beginTransaction();
        Vegetable obj = session.get(Vegetable.class, vegetableId);
        session.getTransaction().commit();
        return obj;
    }
    //Find
    public List findVegetable(String toFind) {
        List<Vegetable> vegetable;
        
        session.beginTransaction();
        String hql = "FROM Vegetable where VegetableID LIKE '%" + toFind + "%' OR VegetableName LIKE '%" + toFind + "%'  ";

        System.out.println("hql: " + hql);
        vegetable = session.createQuery(hql)
                .list();

        session.getTransaction().commit();
        return vegetable;
    }
    
    //Add
    public boolean addVegetable(Vegetable v){
try {
            session.beginTransaction();
            session.save(v);
            session.getTransaction().commit();

            return true;
        } catch (RuntimeException re) {

            return false;
        }

    }

    public boolean updateVegetable(Vegetable v) {

        try {
            session.beginTransaction();
            session.saveOrUpdate(v);
            session.getTransaction().commit();

            return true;
        } catch (RuntimeException re) {

            return false;
        }
    }

    public boolean deleteVegetable(Vegetable v) {
        try {
            session.beginTransaction();
            session.delete(v);
            session.getTransaction().commit();

            return true;
        } catch (RuntimeException re) {

            return false;
        }
    }
}
