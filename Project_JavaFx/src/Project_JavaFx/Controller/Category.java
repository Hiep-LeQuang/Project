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
public class Category {
    private ObjectProperty<Integer> categoryID;
    private StringProperty category;
    
    public Category(){
        categoryID = new SimpleObjectProperty<>(null);
        category = new SimpleStringProperty();
    }
    
    public Integer getCategoryID() {
        return categoryID.get();
    }

    public String getCategory() {
        return category.get();
    }

    public void setCategoryID(int categoryID) {
        this.categoryID.set(categoryID);
    }

    public void setCategory(String category) {
        this.category.set(category);
    }

    public ObjectProperty<Integer> getCategoryIDProperty() {
        return this.categoryID;
    }

    public StringProperty getCategoryProperty() {
        return this.category;
    }
    
    public static ObservableList<Category> selectAll(){
        ObservableList<Category> categorys = FXCollections.observableArrayList();
            
        try (
                Connection conn = DbService.getConnection();
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery("SELECT * FROM category");){
            
            while (rs.next()) {
                Category c = new Category();
                c.setCategory(rs.getString("categoryName"));
                
                categorys.add(c);
            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        
        return categorys;
    }
}
