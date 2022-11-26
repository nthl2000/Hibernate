/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BLL;

import DAL.OrderDetails;
import DAL.OrderDetailsDAL;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Admin
 */
public class OrderDetailsBLL {
     private OrderDetailsDAL stdDal;

    public OrderDetailsBLL() {
        stdDal = new OrderDetailsDAL();
    }

    public List loadOrderDetails() {
        List list;
        list = stdDal.loadOrderDetails();
        return list;
    }

    public OrderDetails loadOrderDetails(int orderDetailsId, int vegetableId) {
        OrderDetails o = new OrderDetails();
        o = stdDal.getOrderDetails(orderDetailsId,vegetableId);
        return o;
    }

    public OrderDetails[] convertList1(List<OrderDetails> list) {
        int rows = list.size();
        OrderDetails[] newList = new OrderDetails[rows];
        for (int i = 0; i < rows; i++) {
            newList[i] = list.get(i);

        }
        return newList;
    }

    public Object[][] convertOrderDetailsList(List<OrderDetails> list) {
        int rows = list.size();
        int cols = 5;
        Object[][] obj = new Object[rows][cols];
        for (int i = 0; i < rows; i++) {
            obj[i][0] = i + 1;
            obj[i][1] = list.get(i).getOrderId();
            obj[i][2] = list.get(i).getVegetableId();
            obj[i][3] = list.get(i).getQuantity();
            obj[i][4] = list.get(i).getPrice();
        }
        return obj;
    }

    //Add
    public boolean addOrderDetails(OrderDetails o) {
        return stdDal.addOrderDetails(o);
    }

    public OrderDetails getOrderDetails(int orderId,int vegetableId) {
        OrderDetails o = stdDal.getOrderDetails(orderId,vegetableId);
        return o;
    }
//    Find
    public List findCategories(String toFind) {
        List list = new ArrayList();
        list = stdDal.findDetails(toFind);
        return list;
    }
    
    

     //Delete
     public boolean deleteOrderDetails(OrderDetails o) {
         return stdDal.deleteOrderDetails(o);
     }
}
