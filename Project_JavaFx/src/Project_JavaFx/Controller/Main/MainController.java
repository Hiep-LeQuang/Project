/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Project_JavaFx.Controller.Main;

import Project_JavaFx.Controller.Navigator;
import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.Pane;

/**
 *
 * @author lehie
 */
public class MainController {
    @FXML
    void btnLogo(ActionEvent event) throws IOException{
        Navigator.getInstance().goToMain();
    }

    @FXML
    void btnProduct(ActionEvent event) throws IOException {
        secPane.getChildren().clear();
        Pane newLoadedPane = FXMLLoader.load(getClass().getResource("/Project_JavaFx/FXML/Car/FormCar.fxml"));
        secPane.getChildren().add(newLoadedPane);
    }

    @FXML
    void btnBrand(ActionEvent event) throws IOException {
        secPane.getChildren().clear();
        Pane newLoadedPane = FXMLLoader.load(getClass().getResource("/Project_JavaFx/FXML/Brand/FormBrand.fxml"));
        secPane.getChildren().add(newLoadedPane);
    }

    @FXML
    void btnCategory(ActionEvent event) throws IOException {
        secPane.getChildren().clear();
        Pane newLoadedPane = FXMLLoader.load(getClass().getResource("/Project_JavaFx/FXML/Category/FormCategory.fxml"));
        secPane.getChildren().add(newLoadedPane);
    }

    @FXML
    void btnColor(ActionEvent event) throws IOException {
        secPane.getChildren().clear();
        Pane newLoadedPane = FXMLLoader.load(getClass().getResource("/Project_JavaFx/FXML/Color/FormColor.fxml"));
        secPane.getChildren().add(newLoadedPane);
    }
    
    @FXML
    void btnCustomer(ActionEvent event) throws IOException {
        secPane.getChildren().clear();
        Pane newLoadedPane = FXMLLoader.load(getClass().getResource("/Project_JavaFx/FXML/Customer/FormCustomer.fxml"));
        secPane.getChildren().add(newLoadedPane);
    }

    @FXML
    void btnContract(ActionEvent event) throws IOException {
        secPane.getChildren().clear();
        Pane newLoadedPane = FXMLLoader.load(getClass().getResource("/Project_JavaFx/FXML/Contract/FormContract.fxml"));
        secPane.getChildren().add(newLoadedPane);
    }

    @FXML
    void btnAccount(ActionEvent event) throws IOException {
//        secPane.getChildren().clear();
//        Pane newLoadedPane = FXMLLoader.load(getClass().getResource("/Project_JavaFx/FXML/FormCustomer.fxml"));
//        secPane.getChildren().add(newLoadedPane);
    }
        
    @FXML
    void btnLogOut(ActionEvent event) throws IOException {
        Navigator.getInstance().goToLogin();
    }
        
    @FXML
    private Pane secPane;

}
