/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Project_JavaFx.Controller;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

/**
 *
 * @author lehie
 */
public class CategoryController {
    @FXML
    private TableView<Category> tvCategory;

    @FXML
    private TableColumn<Category, String> tcCategory;
    
    @FXML
    void btnCancel(ActionEvent event) {

    }

    @FXML
    void btnCreate(ActionEvent event) throws IOException {
        Navigator.getInstance().goToCreateCategory();
    }

    @FXML
    void btnDelete(ActionEvent event) {

    }

    @FXML
    void btnUpdate(ActionEvent event) throws IOException {
        Navigator.getInstance().goToCreateCategory();
    }
    
    @FXML
    void txtSearch(ActionEvent event) {

    }
    
    @FXML
    void btnSearch(ActionEvent event) {

    }
    
    public void initialize(){
        
        tvCategory.setItems(Category.selectAll());
        
        tcCategory.setCellValueFactory((Category)->{
            return Category.getValue().getCategoryProperty();
        });   
    }
}
