/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;
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
@Table (name = "Vegetable")
public class Vegetable {

    @Id
    @GeneratedValue
    private int vegetableId;
    @Column
    private String vegetableName;
    @Column
    private String unit;
    @Column
    private int amount;
    @Column
    private String image;
    @Column 
    private double price;
    
    @ManyToOne
    @JoinColumn(name = "CatagoryID")
    private Category catagory;
    @OneToMany (mappedBy = "vegetable")
    private List<OrderDetails> listOrderItem;
}
