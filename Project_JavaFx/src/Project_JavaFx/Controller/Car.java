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
public class Car {
    private ObjectProperty<Integer> carID;
    private StringProperty sku;
    private StringProperty carName;
    private StringProperty brand;
    private StringProperty category;
    private ObjectProperty<Integer> yearOfManufacture;
    private StringProperty gear;
    private StringProperty color;
    private ObjectProperty<Integer> price;
    
    public Car(){
        carID = new SimpleObjectProperty<>(null);
        sku = new SimpleStringProperty();
        carName = new SimpleStringProperty();
        brand = new SimpleStringProperty();
        category = new SimpleStringProperty();
        yearOfManufacture = new SimpleObjectProperty<>(1900);
        gear = new SimpleStringProperty();
        color = new SimpleStringProperty();
        price = new SimpleObjectProperty<>(0);
    }

    public Integer getCarID() {
        return carID.get();
    }
    
    public String getSku() {
        return sku.get();
    }
    
    public String getCarName() {
        return carName.get();
    }
    
    public String getBrand() {
        return brand.get();
    }
    
    public String getCategory() {
        return category.get();
    }
    
    public Integer getYearOfManufacture() {
        return yearOfManufacture.get();
    }
    
    public String getGear() {
        return gear.get();
    }
    
    public String getColor() {
        return color.get();
    }
    
    public Integer getPrice() {
        return price.get();
    }
    
    public void setCarID(int carID) {
        this.carID.set(carID);
    }
    
    public void setSku(String sku) {
        this.sku.set(sku);
    }

    public void setCarName(String carName) {
        this.carName.set(carName);
    }
    
    public void setBrand(String brand) {
        this.brand.set(brand);
    }
    
    public void setCategory(String category) {
        this.category.set(category);
    }

    public void setYearOfManufacture(int yearOfManufacture) {
        this.yearOfManufacture.set(yearOfManufacture);
    }
    
    public void setGear(String gear) {
        this.gear.set(gear);
    }
    
    public void setColor(String color) {
        this.color.set(color);
    }
    
    public void setPrice(int price) {
        this.price.set(price);
    }

    public ObjectProperty<Integer> getCarIDProperty() {
        return this.carID;
    }
    
    public StringProperty getCarSkuProperty() {
        return this.sku;
    }

    public StringProperty getCarNameProperty() {
        return this.carName;
    }
    
    public StringProperty getBrandProperty() {
        return this.brand;
    }

    public StringProperty getCategoryProperty() {
        return this.category;
    }
    
    public ObjectProperty<Integer> getYearOfManufactureProperty() {
        return this.yearOfManufacture;
    }
    
    public StringProperty getGearProperty() {
        return this.gear;
    }
    
    public StringProperty getColorProperty() {
        return this.color;
    }

    public ObjectProperty<Integer> getPriceProperty() {
        return this.price;
    }
    
    
    
    public static ObservableList<Car> selectAll(){
        ObservableList<Car> cars = FXCollections.observableArrayList();
            
        try (
                Connection conn = DbService.getConnection();
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery("SELECT car.carID, car.sku, brand.brand,category.categoryName, Car.carName,car.yearOfManufacture,car.price,car.gear,color.color FROM car, brand ,category,color,carcolor WHERE brand.brandID = car.brandID AND category.categoryID = car.categoryID AND carcolor.carID = car.carID AND carcolor.colorID = color.colorID");){
            
            while (rs.next()) {
                Car b = new Car();
                b.setCarID(rs.getInt("carID"));
                b.setSku(rs.getString("sku"));
                b.setCarName(rs.getString("carName"));
                b.setBrand(rs.getString("brand"));
                b.setCategory(rs.getString("categoryName"));
                b.setYearOfManufacture(rs.getInt("YearOfManufacture"));
                b.setGear(rs.getString("gear"));
                b.setPrice(rs.getInt("price"));
                b.setColor(rs.getString("color"));
                
                cars.add(b);
            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        
        return cars;
    }
}
