/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BLL;

import DAL.Vegetable;
import DAL.VegetableDAL;
import java.util.List;

/**
 *
 * @author Admin
 */
public class VegetableBLL {
    private VegetableDAL vegDAL;
    public VegetableBLL(){
        vegDAL = new VegetableDAL();
    }
    public Object[][] convertVegetable(List<Vegetable> list){
        int rows = list.size();
        int cols=6;
        Object[][] obj = new Object[rows][cols];
        for(int i=0;i<rows;i++){
            obj[i][0] = list.get(i).getVegetableId();
            obj[i][1] = list.get(i).getVegetableName();
            obj[i][2] = list.get(i).getUnit();
            obj[i][3] = list.get(i).getAmount();
            obj[i][4] = list.get(i).getImage();
            obj[i][5] = list.get(i).getPrice();
            
        }
        return obj;
    }
}
