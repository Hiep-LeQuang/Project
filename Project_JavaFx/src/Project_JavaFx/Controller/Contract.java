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
public class Contract {
    private ObjectProperty<Integer> contractID;
    private ObjectProperty<Integer> carID;
    private ObjectProperty<Integer> colorID;
    private StringProperty sku;
    private StringProperty carName;
    private StringProperty productReceiptDate;
    private ObjectProperty<Integer> price;
    private ObjectProperty<Integer> deposits;
    private StringProperty customerName;
    private StringProperty phone;
    private StringProperty address;
    private ObjectProperty<Integer> customerID;
    private StringProperty status;
    private StringProperty note;
    private StringProperty accountant;
    private StringProperty dateOfSale;
    private StringProperty email;
    public Contract(){
        contractID = new SimpleObjectProperty<>(null);
        carID = new SimpleObjectProperty<>(null);
        colorID = new SimpleObjectProperty<>(null);
        customerID = new SimpleObjectProperty<>(null);
        sku = new SimpleStringProperty();
        carName = new SimpleStringProperty();
        productReceiptDate = new SimpleStringProperty();
        price = new SimpleObjectProperty<>(0);
        deposits = new SimpleObjectProperty<>(0);
        customerName = new SimpleStringProperty();
        phone = new SimpleStringProperty();
        status = new SimpleStringProperty();
        note = new SimpleStringProperty();
        accountant = new SimpleStringProperty();
        dateOfSale = new SimpleStringProperty();
        email = new SimpleStringProperty();
        address = new SimpleStringProperty();
    }   
    
    public Integer getContractID() {
        return contractID.get();
    }
    
    public Integer getColorID() {
        return colorID.get();
    }
    
    public Integer getCarID() {
        return carID.get();
    }
    
    public Integer getCustomerID() {
        return this.customerID.get();
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
    
    public String getPhone() {
        return phone.get();
    }
    
    public String getAddress() {
        return address.get();
    }
    
    public String getStatus() {
        return status.get();
    }
    
    public String getNote() {
        return note.get();
    }
    
    public String getAccountant() {
        return accountant.get();
    }
    
    public String getDateOfSale() {
        return dateOfSale.get();
    }
    
    public String getEmail() {
        return email.get();
    }
    
    public void setContractID(int contractID) {
        this.contractID.set(contractID);
    }
    
    public void setCarID(int carID) {
        this.carID.set(carID);
    }
    
    public void setColorID(int colorID) {
        this.colorID.set(colorID);
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
    
    public void setPhone(String phone) {
        this.phone.set(phone);
    }
    
    public void setAddress(String address) {
        this.address.set(address);
    }
    
    public void setStatus(String status) {
        this.status.set(status);
    }
    
    public void setNote(String note) {
        this.note.set(note);
    }
    
    public void setAccountant(String accountant) {
        this.accountant.set(accountant);
    }
    
    public void setDateOfSale(String dateOfSale) {
        this.dateOfSale.set(dateOfSale);
    }
    
    public void setEmail(String email) {
        this.email.set(email);
    }
    public void setCustomerID(int customerID){
        this.customerID.set(customerID);
    }
    public ObjectProperty<Integer> getContractIDProperty() {
        return this.contractID;
    }
    
    public ObjectProperty<Integer> getCarIDProperty() {
        return this.carID;
    }
    
    public ObjectProperty<Integer> getColorIDProperty() {
        return this.colorID;
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

    public StringProperty getPhoneProperty() {
        return this.phone;
    }

    public StringProperty getAddressProperty() {
        return this.address;
    }
    
    public ObjectProperty<Integer> getCustomerIDProperty() {
        return this.customerID;
    }
    
    public StringProperty getStatusProperty() {
        return this.status;
    }
    
    public StringProperty getNoteProperty() {
        return this.note;
    }
    
    public StringProperty getAccountantProperty() {
        return this.accountant;
    }
    
    public StringProperty getDateOfSaleProperty() {
        return this.dateOfSale;
    }
    
    public StringProperty getEmailProperty() {
        return this.email;
    }
    
    public static ObservableList<Contract> selectAll(){
        ObservableList<Contract> contracts = FXCollections.observableArrayList();
            
        try (
                Connection conn = DbService.getConnection();
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery("SELECT contract.contractID, contract.colorID, car.carID, contract.customerID, car.sku, car.carName, contract.productReceiptDate, contract.status , contract.note,  contract.accountant, contract.dateOfSale, car.price, contract.deposits, customer.customerName,customer.email, customer.phone, customer.address FROM contract, car, customer WHERE contract.CarID = car.carID AND contract.customerID = customer.customerID");){
            
            while (rs.next()) {
                Contract c = new Contract();
                c.setContractID(rs.getInt("contractID"));
                c.setSku(rs.getString("sku"));
                c.setCarName(rs.getString("carName"));
                c.setProductReceiptDate(rs.getString("productReceiptDate"));
                c.setPrice(rs.getInt("price"));
                c.setDeposits(rs.getInt("deposits"));
                c.setCustomerName(rs.getString("customerName"));
                c.setPhone(rs.getString("phone"));
                c.setAddress(rs.getString("address"));
                c.setCustomerID(rs.getInt("customerID"));
                if(rs.getInt("status") == 1){
                     c.setStatus("Đã Giao");
                } else{
                    c.setStatus("Đang Lấy Hàng");
                }
                c.setNote(rs.getString("note"));
                c.setAccountant(rs.getString("accountant"));
                c.setDateOfSale(rs.getString("dateOfSale"));
                c.setEmail(rs.getString("email"));
                c.setCarID(rs.getInt("carID"));
                c.setColorID(rs.getInt("colorID"));
                
                contracts.add(c);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return contracts;
    }
    
    public static boolean update(Contract updateContract){
        String sql = "UPDATE contract SET customerID = ?, price = ?, dateOfSale = ?, status = ?, deposits = ?, productReceiptDate = ?, accountant = ?, CarID = ?, colorID = ?, note = ? WHERE contract.contractID = ?";
               System.out.println(updateContract); 
        try (
                Connection conn = DbService.getConnection();
                PreparedStatement stmt = conn.prepareStatement(sql);
                ){
            
            stmt.setInt(1, updateContract.getCustomerID());
            stmt.setInt(2, updateContract.getPrice());
            stmt.setString(3, updateContract.getDateOfSale());
            if(updateContract.getStatus().equals("Đã Giao")){
                stmt.setInt(4,1); 
            } else{
                stmt.setInt(4,0); 
            }
            stmt.setInt(5, updateContract.getDeposits());
            stmt.setString(6,updateContract.getProductReceiptDate());
            stmt.setString(7,updateContract.getAccountant());
            stmt.setInt(8,updateContract.getCarID());
            stmt.setInt(9,updateContract.getColorID());
            stmt.setString(10,updateContract.getNote());
            stmt.setInt(11,updateContract.getContractID());
            int rowUpdate = stmt.executeUpdate();
            if(rowUpdate == 1 ){
                return true;
            }else{
                System.out.println("Chuyển Trạng Thái Không Thành Công");
                return false;
            }
   
        } catch (Exception e) {
            System.err.print(e);
            return false;
        }
    }
    
    public static boolean delete(Contract deleteContract){
        String sql1 = "DELETE FROM Contract WHERE contractID = ?";
        String sql2 = "DELETE FROM Customer WHERE customerID = ?";
        
        try (
                Connection conn = DbService.getConnection();
                PreparedStatement stmt1 = conn.prepareStatement(sql1);
                PreparedStatement stmt2 = conn.prepareStatement(sql2);
                ){
            stmt1.setInt(1, deleteContract.getContractID());
            stmt2.setInt(1, deleteContract.getCustomerID());
            
            int rowDelete1 = stmt1.executeUpdate();
            int rowDelete2 = stmt2.executeUpdate();
            if(rowDelete1 == 1 && rowDelete2 == 1){
                System.out.println("Xoa ok");
                return true;
            } else {
                return false;
            }
            
        } catch (Exception e) {
            System.out.println(e);
            return false;
        }
    }
}
