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
    public Category getCategory(int categoryId){
        Category obj;
        session.beginTransaction();
        obj = session.get(Category.class, categoryId);
        session.getTransaction().commit();
        return obj;
    }
    
}
