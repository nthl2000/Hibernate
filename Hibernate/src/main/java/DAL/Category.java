/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.*;
import javax.persistence.Table;
import lombok.Data;
import org.hibernate.*;

/**
 *
 * @author Admin
 */
@Data
@Entity
@Table (name = "category")
public class Category {
    @Id
    private int CatagoryId;
    @Column
    private String Name;
    @Column 
    private String Description;
    
    @OneToMany (mappedBy = "catagory")
    private List<Vegetable> listVegetable;

}
