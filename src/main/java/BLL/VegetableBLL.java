/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BLL;

import DAL.Vegetable;
import DAL.VegetableDAL;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Admin
 */
public class VegetableBLL {
    private VegetableDAL stdDAL;
    private Vegetable v;
    public VegetableBLL(){
        stdDAL = new VegetableDAL();
    }
    
    public List loadVegetable(){
        List list;
        list = stdDAL.loadVegetable();
        return list;
    }
    public Vegetable loadVegetable(int vegetableId){
        v = new Vegetable();
        v= stdDAL.getVegetable(vegetableId);
        return v;
    }
    public Object[][] convertVegetable(List<Vegetable> list){
        int rows = list.size();
        int cols=7;
        Object[][] obj = new Object[rows][cols];
        for(int i=0;i<rows;i++){
            obj[i][0] = list.get(i).getVegetableId();
            obj[i][1] = list.get(i).getCatagoryID();
            obj[i][2] = list.get(i).getVegetableName();
            obj[i][3] = list.get(i).getUnit();
            obj[i][4] = list.get(i).getAmount();
            obj[i][5] = list.get(i).getImage();
            obj[i][6] = list.get(i).getPrice();
        }
        return obj;
    }
    //Add
    public boolean addVegetable(Vegetable c) {
        return stdDAL.addVegetable(c);
    }

    public Vegetable getVegetable(int categoryId) {
        Vegetable c = stdDAL.getVegetable(categoryId);
        return c;
    }
//    Find
    public List findVegetables(String toFind) {
        List list = new ArrayList();
        list = stdDAL.findVegetable(toFind);
        return list;
    }
    
    
    //Update
     public boolean updateVegetable(Vegetable c) {
        return stdDAL.updateVegetable(c);
         
     }
     //Delete
     public boolean deleteVegetable(Vegetable c) {
         return stdDAL.deleteVegetable(c);
     }
}
