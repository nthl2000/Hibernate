/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BLL;

import DAL.Category;
import DAL.CategoryDAL;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Admin
 */
public class CategoryBLL {

    private CategoryDAL stdDal;

    public CategoryBLL() {
        stdDal = new CategoryDAL();
    }

    public List loadCategory() {
        List list;
        list = stdDal.loadCategory();
        return list;
    }

    public Category loadCategory(int categoryId) {
        Category c = new Category();
        c = stdDal.getCategory(categoryId);
        return c;
    }

    public Category[] convertList1(List<Category> list) {
        int rows = list.size();
        Category[] newList = new Category[rows];
        for (int i = 0; i < rows; i++) {
            newList[i] = list.get(i);

        }
        return newList;
    }

    public Object[][] convertCategoryList(List<Category> list) {
        int rows = list.size();
        int cols = 5;
        Object[][] obj = new Object[rows][cols];
        for (int i = 0; i < rows; i++) {
            obj[i][0] = i + 1;
            obj[i][1] = list.get(i).getCatagoryID();
            obj[i][2] = list.get(i).getName();
            obj[i][3] = list.get(i).getDescription();
            obj[i][4] = list.get(i).getListVegetable().size();
        }
        return obj;
    }

    //Add
    public boolean addCategory(Category c) {
        return stdDal.addCategory(c);
    }

    public Category getCategory(int categoryId) {
        Category c = stdDal.getCategory(categoryId);
        return c;
    }
//    Find
    public List findCategories(String toFind) {
        List list = new ArrayList();
        list = stdDal.findCategories(toFind);
        return list;
    }
    
    
    //Update
     public boolean updateCategory(Category c) {
        return stdDal.updateCategory(c);
         
     }
     //Delete
     public int deleteCategory(int CategoryId) {
         return stdDal.deleteCategory(CategoryId);
     }
    
    
    
}
