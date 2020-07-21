/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Project_JavaFx.Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

/**
 *
 * @author lehie
 */
public class ColorController {
    @FXML
    private TableView<Color> tvColor;

    @FXML
    private TableColumn<Color, String> tcColor;

    @FXML
    void btnCancel(ActionEvent event) {

    }

    @FXML
    void btnCreate(ActionEvent event) {

    }

    @FXML
    void btnSearch(ActionEvent event) {

    }

    @FXML
    void btnUpdate(ActionEvent event) {

    }

    @FXML
    void txtSearch(ActionEvent event) {

    }
    
    public void initialize(){
        
        tvColor.setItems(Color.selectAll());
        
        tcColor.setCellValueFactory((Color)->{
            return Color.getValue().getColorProperty();
        });   
    }
}
