/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BLL;

import DAL.CustomerDAL;
import DAL.Customers;
import java.util.List;

/**
 *
 * @author Admin
 */
public class CustomerBLL {
    private CustomerDAL cusDAL;
    public CustomerBLL(){
        cusDAL = new CustomerDAL();
    }
    public Object[][] convertList(List<Customers> list){
        int rows =list.size();
        int cols = 6;
        Object[][] obj = new Object[rows][cols];
        for(int i=0;i<rows;i++){
            obj[i][0] = i+1;
            obj[i][1] = list.get(i).getCustomerId();
            obj[i][2] = list.get(i).getPassword();
            obj[i][3] = list.get(i).getFullName();
            obj[i][4] = list.get(i).getAddress();
            obj[i][5] = list.get(i).getCity();
        }
        return obj;
}
    public List loadCustomer() {
        List list;
        list = cusDAL.loadCustomer();
        return list;
    }
}