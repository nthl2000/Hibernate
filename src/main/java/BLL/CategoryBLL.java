/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BLL;

import DAL.Category;
import DAL.CategoryDAL;
import java.util.List;

/**
 *
 * @author Admin
 */
public class CategoryBLL {

    private CategoryDAL cateDAL;

    public CategoryBLL() {
        cateDAL = new CategoryDAL();
    }

    public List loadCategory() {
        List list;
        list = cateDAL.loadCategory();
        return list;
    }

    public Object[][] convertList(List<Category> list) {
        int rows = list.size();
        int cols = 4;
        Object[][] obj = new Object[rows][cols];
        for (int i = 0; i < rows; i++) {
            obj[i][0] = list.get(i).getCatagoryID();
            obj[i][1] = list.get(i).getName();
            obj[i][2] = list.get(i).getDescription();
            obj[i][3] = list.get(i).getListVegetable().size();
        }
        return obj;
    }
    public void addCategory(Category c){
        cateDAL.addCategory(c);
    }
    public Category getCategory(int categoryId){
        Category c = cateDAL.getCategory(categoryId);
        return c;
    }
    
}
