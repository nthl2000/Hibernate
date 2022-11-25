/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BLL;

import DAL.CustomerDAL;
import DAL.Customers;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Admin
 */
public class CustomerBLL {

    private CustomerDAL stdDAL;

    public CustomerBLL() {
        stdDAL = new CustomerDAL();
    }

    public List loadCustomer() {
        List list;
        list = stdDAL.loadCustomer();
        return list;
    }

    public Customers loadCustomer(int customerId) {
        Customers c = new Customers();
        c = stdDAL.getCustomer(customerId);
        return c;
    }

    public Customers[] convertList1(List<Customers> list) {
        int rows = list.size();
        Customers[] newList = new Customers[rows];
        for (int i = 0; i < rows; i++) {
            newList[i] = list.get(i);

        }
        return newList;
    }

    public Object[][] convertList(List<Customers> list) {
        int rows = list.size();
        int cols = 6;
        Object[][] obj = new Object[rows][cols];
        for (int i = 0; i < rows; i++) {
            obj[i][0] = i + 1;
            obj[i][1] = list.get(i).getCustomerId();
            obj[i][2] = list.get(i).getPassword();
            obj[i][3] = list.get(i).getFullName();
            obj[i][4] = list.get(i).getAddress();
            obj[i][5] = list.get(i).getCity();
        }
        return obj;
    }

    //Add
    public boolean addCustomers(Customers c) {
        return stdDAL.addCustomer(c);
    }

    public Customers getCustomers(int categoryId) {
        Customers c = stdDAL.getCustomer(categoryId);
        return c;
    }
//    Find

    public List findCategories(String toFind) {
        List list = new ArrayList();
        list = stdDAL.findCustomers(toFind);
        return list;
    }

    //Update
    public boolean updateCustomers(Customers c) {
        return stdDAL.updateCustomer(c);

    }
    //Delete

    public int deleteCustomers(int CustomersId) {
        return stdDAL.deleteCustomer(CustomersId);
    }

}
