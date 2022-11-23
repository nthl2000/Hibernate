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
@Table (name = "customers")
public class Customers {
    
    @Id 
    private int customerId;
    @Column
    private String password;
    @Column 
    private String fullName;
    @Column 
    private String address;
    @Column
    private String city;
//    @OneToMany (mappedBy = "customers")
//    private List <Order> listOrder;
    
    
}
