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
public class CategoryDAL {

    Session session;

    public CategoryDAL() {
        session = HibernateUtils.getSessionFactory().openSession();
    }

    //load page
    public List loadCategory() {
        List<Category> category;
        session.beginTransaction();
        category = session.createQuery("FROM Category", Category.class).list();
        session.getTransaction().commit();
        return category;
    }

    public Category getCategory(int categoryId) {
        Category obj;
        session.beginTransaction();
        obj = session.get(Category.class, categoryId);
        session.getTransaction().commit();
        return obj;
    }

    //get selected row
    public Category findCategory(int categoryId) {
        session.beginTransaction();
        Category c = session.get(Category.class, categoryId);
        session.getTransaction().commit();
        
        return c;
    }

    //Find
    public List findCategories(String toFind) {
        String hql = "Select * from Category where CatagoryID LIKE :toFind or Name LIKE :toFind";
        Query query = session.createQuery(hql);
        query.setParameter("cate_id", toFind);
        List results = query.list();
        session.getTransaction().commit();
        return results;
    }

    public boolean addCategory(Category c) {
     
        try {
            session.beginTransaction();
            session.save(c);
            session.getTransaction().commit();
            
            return true;
        }catch (RuntimeException re){
            return false;
        }
       
     
    }

    public boolean updateCategory(Category c) {
        
        try {
            session.beginTransaction();
            session.saveOrUpdate(c);
            session.getTransaction().commit();
            
            return true;
        }catch (RuntimeException re){
            return false;
        }
    }

    public int deleteCategory(int CategoryId) {
        String hql = "DELETE FROM CATEGORY WHERE CatagoryID = :id";
        Query query = session.createQuery(hql);
        query.setParameter("id", CategoryId);
        int result = query.executeUpdate();
        System.out.println("Rows affected:" + result);
        return result;
    }
}
