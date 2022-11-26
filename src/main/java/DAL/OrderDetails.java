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
@Data
@Entity
@Table (name = "orderdetail")
public class OrderDetails implements Serializable{
    @Id
    @ManyToOne
    @JoinColumn(name = "OrderID")
    private Order orderId;
    
    @Id
    @ManyToOne
    @JoinColumn (name = "VegetableID")
    private Vegetable vegetableId;
    
     @Column 
    private int quantity;
    @Column 
    private double price;
   
    
}
