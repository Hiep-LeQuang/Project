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
public class Contract {
    private StringProperty sku;
    private StringProperty carName;
    private StringProperty productReceiptDate;
    private ObjectProperty<Integer> price;
    private ObjectProperty<Integer> deposits;
    private StringProperty customerName;
    private ObjectProperty<Integer> phone;
    private StringProperty address;
    
    public Contract(){
        sku = new SimpleStringProperty();
        carName = new SimpleStringProperty();
        productReceiptDate = new SimpleStringProperty();
        price = new SimpleObjectProperty<>(0);
        deposits = new SimpleObjectProperty<>(0);
        customerName = new SimpleStringProperty();
        phone = new SimpleObjectProperty<>(0);
        address = new SimpleStringProperty();
    }
    
    public String getSku() {
        return sku.get();
    }
    
    public String getCarName() {
        return carName.get();
    }
    
    public String getProductReceiptDate() {
        return productReceiptDate.get();
    }
    
    public Integer getPrice() {
        return price.get();
    }
    
    public Integer getDeposits() {
        return deposits.get();
    }
    
    public String getCustomerName() {
        return customerName.get();
    }
    
    public Integer getPhone() {
        return price.get();
    }
    
    public String getAddress() {
        return address.get();
    }
    
    public void setSku(String sku) {
        this.sku.set(sku);
    }
    
    public void setCarName(String carName) {
        this.carName.set(carName);
    }
    
    public void setProductReceiptDate(String productReceiptDate) {
        this.productReceiptDate.set(productReceiptDate);
    }

    public void setPrice(int price) {
        this.price.set(price);
    }
    
    public void setDeposits(int deposits) {
        this.deposits.set(deposits);
    }
    
    public void setCustomerName(String customerName) {
        this.customerName.set(customerName);
    }
    
    public void setPhone(int phone) {
        this.phone.set(phone);
    }
    
    public void setAddress(String address) {
        this.address.set(address);
    }

    public StringProperty getCarSkuProperty() {
        return this.sku;
    }

    public StringProperty getCarNameProperty() {
        return this.carName;
    }

    public StringProperty getProductReceiptDateProperty() {
        return this.productReceiptDate;
    }

    public ObjectProperty<Integer> getPriceProperty() {
        return this.price;
    }

    public ObjectProperty<Integer> getDepositsProperty() {
        return this.deposits;
    }

    public StringProperty getCustomerNameProperty() {
        return this.customerName;
    }

    public ObjectProperty<Integer> getPhoneProperty() {
        return this.phone;
    }

    public StringProperty getAddressProperty() {
        return this.address;
    }
    
    public static ObservableList<Contract> selectAll(){
        ObservableList<Contract> contracts = FXCollections.observableArrayList();
            
        try (
                Connection conn = DbService.getConnection();
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery("SELECT car.sku, car.carName, contract.productReceiptDate, car.price, contract.deposits, customer.customerName, customer.phone, customer.address FROM contract, car, customer WHERE contract.CarID = car.carID AND contract.customerID = customer.customerID");){
            
            while (rs.next()) {
                Contract c = new Contract();
                c.setSku(rs.getString("sku"));
                c.setCarName(rs.getString("carName"));
                c.setProductReceiptDate(rs.getString("productReceiptDate"));
                c.setPrice(rs.getInt("price"));
                c.setDeposits(rs.getInt("deposits"));
                c.setCustomerName(rs.getString("customerName"));
                c.setPhone(rs.getInt("phone"));
                c.setAddress(rs.getString("address"));
                
                contracts.add(c);
            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        
        return contracts;
    }
    
}
