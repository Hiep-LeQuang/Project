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
public class BrandController {
    @FXML
    private TableView<Brand> tvBrand;

    @FXML
    private TableColumn<Brand, String> tcBrand;
    
    @FXML
    void btnCancel(ActionEvent event) {

    }

    @FXML
    void btnCreate(ActionEvent event) throws IOException {
        Navigator.getInstance().goToCreateBrand();
    }

    @FXML
    void btnDelete(ActionEvent event) {

    }

    @FXML
    void btnUpdate(ActionEvent event) throws IOException {
        Navigator.getInstance().goToCreateBrand();
    }
    
    @FXML
    void txtSearch(ActionEvent event) {

    }
    
    @FXML
    void btnSearch(ActionEvent event) {

    }
    
    public void initialize(){
        
        tvBrand.setItems(Brand.selectAll());
        
        tcBrand.setCellValueFactory((Brand)->{
            return Brand.getValue().getBrandProperty();
        });   
    }
}
