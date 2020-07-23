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
public class Customer {
    private ObjectProperty<Integer> customerID;
    private StringProperty customerName;
    private StringProperty phone;
    private StringProperty address;
    private StringProperty email;
    private ObjectProperty<Integer> contractID;
    
    public Customer(){
        customerID = new SimpleObjectProperty<>(null);
        customerName = new SimpleStringProperty();
        phone = new SimpleStringProperty();
        address = new SimpleStringProperty();
        email = new SimpleStringProperty();
        contractID = new SimpleObjectProperty<>(null);
    }
    
    public Integer getCustomerID() {
        return customerID.get();
    }

    public String getCustomerName() {
        return customerName.get();
    }
    
    public String getPhone() {
        return phone.get();
    }
    
    public String getAddress() {
        return address.get();
    }
    
    public String getEmail() {
        return email.get();
    }
    
    public Integer getContractID() {
        return contractID.get();
    }

    public void setCustomerID(int customerID) {
        this.customerID.set(customerID);
    }
    
    public void setCustomerName(String customerName) {
        this.customerName.set(customerName);
    }
    
    public void setPhone(String phone) {
        this.phone.set(phone);
    }
    
    public void setAddress(String address) {
        this.address.set(address);
    }
    
    public void setEmail(String email) {
        this.email.set(email);
    }
    
    public void setContractID(int contractID) {
        this.contractID.set(contractID);
    }
    
    public ObjectProperty<Integer> getCustomerIDProperty() {
        return this.customerID;
    }

    public StringProperty getCustomerNameProperty() {
        return this.customerName;
    }
    
    public StringProperty getPhoneProperty() {
        return this.phone;
    }
    
    public StringProperty getAddressProperty() {
        return this.address;
    }
    
    public StringProperty getEmailProperty() {
        return this.email;
    }
    
    public ObjectProperty<Integer> getContractIDProperty() {
        return this.contractID;
    }

    public static ObservableList<Customer> selectAll(){
        ObservableList<Customer> customers = FXCollections.observableArrayList();
            
        try (
                Connection conn = DbService.getConnection();
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery("SELECT customer.customerID, customer.customerName, customer.phone, customer.address, customer.email , contract.contractID FROM customer,contract WHERE contract.customerID = customer.customerID;");){
            
            while (rs.next()) {
                Customer b = new Customer();
                b.setCustomerID(rs.getInt("customerID"));
                b.setCustomerName(rs.getString("customerName"));
                b.setPhone(rs.getString("phone"));
                b.setAddress(rs.getString("address"));
                b.setEmail(rs.getString("email"));
                b.setContractID(rs.getInt("contractID"));
                
                customers.add(b);
            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        
        return customers;
    }
    
    public static boolean update(Customer updateBrand){
        String sql = "UPDATE customer SET customerName = ?, phone = ?, address = ?, email = ? WHERE customerID = ? ;";
               System.out.println(updateBrand); 
        try (
                Connection conn = DbService.getConnection();
                PreparedStatement stmt = conn.prepareStatement(sql);
                ){
            
            stmt.setString(1, updateBrand.getCustomerName());
            stmt.setString(2, updateBrand.getPhone());
            stmt.setString(3, updateBrand.getAddress());
            stmt.setString(4, updateBrand.getEmail());
            stmt.setInt(5, updateBrand.getCustomerID());
                    
            int rowUpdate1 = stmt.executeUpdate();
            if(rowUpdate1 == 1 ){
                return true;
            }else{
                System.out.println("Cập nhật không thành công");
                return false;
            }
   
        } catch (Exception e) {
            System.err.print(e);
            return false;
        }
    }
}
