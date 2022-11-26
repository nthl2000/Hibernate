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
    private int CatagoryID;
    @Column
    private String Name;
    @Column 
    private String Description;
    
    @OneToMany (mappedBy = "CatagoryID")
    private List<Vegetable> listVegetable;

    public Category(){
        
    }
    public Category(int CatagoryID, String Name, String Description) {
        this.CatagoryID = CatagoryID;
        this.Name = Name;
        this.Description = Description;
//        this.listVegetable = listVegetable;
    }
    
    
}
