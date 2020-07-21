/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Project_JavaFx.Controller;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author lehie
 */
public class Brand {
    private ObjectProperty<Integer> brandID;
    private StringProperty brand;
    
    public Brand(){
        brandID = new SimpleObjectProperty<>(null);
        brand = new SimpleStringProperty();
    }
    
    public Integer getBrandID() {
        return brandID.get();
    }

    public String getBrand() {
        return brand.get();
    }

    public void setBrandID(int brandID) {
        this.brandID.set(brandID);
    }
    
    public void setBrand(String brand) {
        this.brand.set(brand);
    }
    
    public ObjectProperty<Integer> getBrandIDProperty() {
        return this.brandID;
    }

    public StringProperty getBrandProperty() {
        return this.brand;
    }

    public static ObservableList<Brand> selectAll(){
        ObservableList<Brand> brands = FXCollections.observableArrayList();
            
        try (
                Connection conn = DbService.getConnection();
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery("SELECT * FROM brand");){
            
            while (rs.next()) {
                Brand b = new Brand();
                b.setBrand(rs.getString("brand"));
                
                brands.add(b);
            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        
        return brands;
    }
    
}
