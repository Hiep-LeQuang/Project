/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Project_JavaFx.Controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
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
    private StringProperty status;
    
    public Brand(){
        brandID = new SimpleObjectProperty<>(null);
        brand = new SimpleStringProperty();
        status = new SimpleStringProperty();
    }
    
    public Integer getBrandID() {
        return brandID.get();
    }

    public String getBrand() {
        return brand.get();
    }
    
    public String getStatus() {
        return status.get();
    }

    public void setBrandID(int brandID) {
        this.brandID.set(brandID);
    }
    
    public void setBrand(String brand) {
        this.brand.set(brand);
    }
    
    public void setStatus(String status) {
        this.status.set(status);
    }
    
    public ObjectProperty<Integer> getBrandIDProperty() {
        return this.brandID;
    }

    public StringProperty getBrandProperty() {
        return this.brand;
    }
    
    public StringProperty getStatusProperty() {
        return this.status;
    }

    public static ObservableList<Brand> selectAll(){
        ObservableList<Brand> brands = FXCollections.observableArrayList();
            
        try (
                Connection conn = DbService.getConnection();
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery("SELECT * FROM brand");){
            
            while (rs.next()) {
                Brand b = new Brand();
                b.setBrandID(rs.getInt("brandID"));
                b.setBrand(rs.getString("brand"));
                if(rs.getInt("status") == 0){
                     b.setStatus("Ngừng Kinh Doanh");
                } else{
                    b.setStatus("Đang Kinh Doanh");
                }
                
                brands.add(b);
            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        
        return brands;
    }
    
    public static boolean update(Brand updateBrand){
        String sql = "UPDATE brand SET brand = ?, status = ? WHERE brandID = ? ;";
               System.out.println(updateBrand); 
        try (
                Connection conn = DbService.getConnection();
                PreparedStatement stmt = conn.prepareStatement(sql);
                ){
            
            stmt.setString(1, updateBrand.getBrand());
            if(updateBrand.getStatus().equals("Đang Kinh Doanh")){
                stmt.setInt(2,1); 
            } else{
                stmt.setInt(2,0); 
            }
            
            stmt.setInt(3, updateBrand.getBrandID());
                    
            int rowUpdate1 = stmt.executeUpdate();
            if(rowUpdate1 == 1 ){
                return true;
            }else{
                System.out.println("Không thay đổi được trạng thái của thương hiệu");
                return false;
            }
   
        } catch (Exception e) {
            System.err.print(e);
            return false;
        }
    }
}
