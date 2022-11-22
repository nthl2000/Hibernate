/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;
import java.sql.Date;
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
@Table (name = "order")
public class Order {
    @Id
    @GeneratedValue
    private int orderId;
    @Column
    private Date date;
    @Column 
    private double total;
    @Column 
    private String note;
    @ManyToOne
    @JoinColumn(name = "customerID")
    private Customers customer;
    @OneToMany (mappedBy = "order")
    private List<OrderDetails> listOrderDetails;
}
