/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BLL;

import DAL.Order;
import DAL.OrderDAL;
import java.util.List;

/**
 *
 * @author Admin
 */
public class OrderBLL {
    private OrderDAL orderDAL;
    public OrderBLL(){
        orderDAL = new OrderDAL();
    }
    public Object[][] convertOrder(List<Order> list){
        int rows = list.size();
        int cols=4;
        Object[][] obj = new Object[rows][cols];
        for(int i=0;i<rows;i++){
            obj[i][0] = list.get(i).getOrderId();
            obj[i][1] = list.get(i).getCustomer();
            obj[i][2] = list.get(i).getOrderId();
            obj[i][3] = list.get(i).getOrderId();
            obj[i][4] = list.get(i).getOrderId();
        }
        return obj;
    }
}
