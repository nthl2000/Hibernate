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
public class CategoryDAL {
    Session session;
    public CategoryDAL(){
        session = HibernateUtils.getSessionFactory().openSession();
    }
    public List loadCategory(){
        List<Category> category;
        session.beginTransaction();
        category = session.createQuery("FROM Category",Category.class).list();
        session.getTransaction().commit();
        return category;
    }
    public Category getCategory(int categoryId){
        Category obj;
        session.beginTransaction();
        obj = session.get(Category.class, categoryId);
        session.getTransaction().commit();
        return obj;
    }
    public void addCategory(Category c){
        session.save(c);
    }
    public void updateCategory(Category c){
        session.update(c);
    }
    public void deleteCategory(Category c){
        session.delete(c);
    }
    
    
}
