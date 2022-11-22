/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import java.io.Serializable;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.persistence.*;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import lombok.Data;
import org.hibernate.*;

/**
 *
 * @author Admin
 */
@Embeddable
public class OrderDetails_Id implements Serializable {

    protected int orderId;
    protected int vegetableId;

    public OrderDetails_Id() {

    }

    public OrderDetails_Id(int orderId, int vegetableId) {
        super();
        this.orderId = orderId;
        this.vegetableId = vegetableId;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public int getVegetableId() {
        return vegetableId;
    }

    public void setVegetableId(int vegetableId) {
        this.vegetableId = vegetableId;
    }

}
