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

    final Session session;

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
    //get selected row

    public Category getCategory(int categoryId) {
        session.beginTransaction();
        Category obj = session.get(Category.class, categoryId);
        session.getTransaction().commit();
        return obj;
    }

    //Find
    public List findCategories(String toFind) {
        List<Category> category;

        session.beginTransaction();

        String hql = "FROM Category where CatagoryID LIKE '%" + toFind + "%' OR Name LIKE '%" + toFind + "%'  ";

        System.out.println("hql: " + hql);
        category = session.createQuery(hql)
                .list();

        session.getTransaction().commit();

        return category;
    }
    //Add
    public boolean addCategory(Category c) {

        try {
            session.beginTransaction();
            session.save(c);
            session.getTransaction().commit();

            return true;
        } catch (RuntimeException re) {

            return false;
        }

    }

    public boolean updateCategory(Category c) {

        try {
            session.beginTransaction();
            session.saveOrUpdate(c);
            session.getTransaction().commit();

            return true;
        } catch (RuntimeException re) {

            return false;
        }
    }

    public boolean deleteCategory(Category c) {
        try {
            session.beginTransaction();
            session.delete(c);
            session.getTransaction().commit();

            return true;
        } catch (RuntimeException re) {

            return false;
        }
    }
}
