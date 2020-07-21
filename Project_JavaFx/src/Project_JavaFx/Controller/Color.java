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
public class Color {
    private ObjectProperty<Integer> colorID;
    private StringProperty color;
    
    public Color(){
        colorID = new SimpleObjectProperty<>(null);
        color = new SimpleStringProperty();
    }
    
    public Integer getColorID() {
        return colorID.get();
    }

    public String getColor() {
        return color.get();
    }

    public void setColorID(int colorID) {
        this.colorID.set(colorID);
    }
    
    public void setColor(String color) {
        this.color.set(color);
    }
    
    public ObjectProperty<Integer> getColorIDProperty() {
        return this.colorID;
    }

    public StringProperty getColorProperty() {
        return this.color;
    }

    public static ObservableList<Color> selectAll(){
        ObservableList<Color> colors = FXCollections.observableArrayList();
            
        try (
                Connection conn = DbService.getConnection();
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery("SELECT * FROM Color");){
            
            while (rs.next()) {
                Color c = new Color();
                c.setColorID(rs.getInt("colorID"));
                c.setColor(rs.getString("color"));
                
                colors.add(c);
            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        
        return colors;
    }
}
