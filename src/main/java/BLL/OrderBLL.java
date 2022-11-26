/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BLL;

import DAL.Order;
import DAL.OrderDAL;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Admin
 */
public class OrderBLL {

    private OrderDAL stdDAL;

    public OrderBLL() {
        stdDAL = new OrderDAL();
    }

    public List loadOrder() {
        List list;
        list = stdDAL.loadOrder();
        return list;
    }
    
    public Order loadOrder(int orderId) {
        Order o = new Order();
        o = stdDAL.getOrder(orderId);
        return o;
    }
    
    public Order[] convertList1(List<Order> list) {
        int rows = list.size();
        Order[] newList = new Order[rows];
        for (int i = 0; i < rows; i++) {
            newList[i] = list.get(i);
        }
        return newList;
    }

    public Object[][] convertOrderList(List<Order> list) {
        int rows = list.size();
        int cols = 5;
        Object[][] obj = new Object[rows][cols];
        for (int i = 0; i < rows; i++) {
            obj[i][0] = list.get(i).getOrderId();
            obj[i][1] = list.get(i).getCustomerId();
            obj[i][2] = list.get(i).getDate();
            obj[i][3] = list.get(i).getTotal();
            obj[i][4] = list.get(i).getNote();
        }
        return obj;
    }

    

    //Add
    public boolean addOrder(Order o) {
        return stdDAL.addOrder(o);
    }
    public Order getOrder(int orderId){
        Order o = stdDAL.getOrder(orderId);
        return o;
    }
    //Find
    public List findOrders(String toFind){
        List list = new ArrayList();
        list = stdDAL.findOrders(toFind);
        return list;
    }
    //Update
    public boolean updateOrder(Order o){
        return stdDAL.updateOrder(o);
    }
    //Delete
    public boolean deleteOrder(Order o){
        return stdDAL.deleteOrder(o);
    }
    public List loadCustomerId(){
        List list = new ArrayList();
        list = stdDAL.loadCustomerId();
        return list;
    }

}
