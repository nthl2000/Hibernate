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
    public Object[][] convertOrderList(List<Order> list){
        int rows = list.size();
        int cols=5;
        Object[][] obj = new Object[rows][cols];
        for(int i=0;i<rows;i++){
            obj[i][0] = list.get(i).getOrderId();
            obj[i][1] = list.get(i).getCustomer().getCustomerId();
            obj[i][2] = list.get(i).getDate();
            obj[i][3] = list.get(i).getTotal();
            obj[i][4] = list.get(i).getNote();
        }
        return obj;
    }

    public List loadOrder() {
        List list;
        list = orderDAL.loadOrder();
        return list;
    }
    public void addOrder(Order o){
        orderDAL.addOrder(o);
    }
    public Order getOrder(int orderId){
        Order o = orderDAL.getOrder(orderId);
        return o;
    }
}
