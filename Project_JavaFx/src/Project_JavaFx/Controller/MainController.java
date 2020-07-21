/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Project_JavaFx.Controller;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.Pane;

/**
 *
 * @author lehie
 */
public class MainController {
    @FXML
    private TableView<Car> tvCars;

    @FXML
    private TableColumn<Car, String> tcProduct;

    @FXML
    private TableColumn<Car, String> tcBrand;

    @FXML
    private TableColumn<Car, String> tcCategory;

    @FXML
    private TableColumn<Car, Integer> tcYear;

    @FXML
    private TableColumn<Car, String> tcGear;

    @FXML
    private TableColumn<Car, String> tcColor;

    @FXML
    private TableColumn<Car, Integer> tcPrice;
    
    @FXML
    void btnProduct(ActionEvent event) throws IOException {
        secPane.getChildren().clear();
        Pane newLoadedPane = FXMLLoader.load(getClass().getResource("/Project_JavaFx/FXML/FormCar.fxml"));
        secPane.getChildren().add(newLoadedPane);
    }
    
     @FXML
    void btnBrand(ActionEvent event) throws IOException {
        secPane.getChildren().clear();
        Pane newLoadedPane = FXMLLoader.load(getClass().getResource("/Project_JavaFx/FXML/FormBrand.fxml"));
        secPane.getChildren().add(newLoadedPane);
    }
    
    @FXML
    void btnCategory(ActionEvent event) throws IOException {
        secPane.getChildren().clear();
        Pane newLoadedPane = FXMLLoader.load(getClass().getResource("/Project_JavaFx/FXML/FormCategory.fxml"));
        secPane.getChildren().add(newLoadedPane);
    }
    
    @FXML
    void btnColor(ActionEvent event) throws IOException {
        secPane.getChildren().clear();
        Pane newLoadedPane = FXMLLoader.load(getClass().getResource("/Project_JavaFx/FXML/FormColor.fxml"));
        secPane.getChildren().add(newLoadedPane);
    }
    
    @FXML
    void btnCar(ActionEvent event) {
        
    }
    
    @FXML
    void btnAccessories(ActionEvent event) {
        
    }

    @FXML
    void btnHonda(ActionEvent event) {

    }

    @FXML
    void btnToyota(ActionEvent event) {

    }

    @FXML
    void btnVinfat(ActionEvent event) {

    }
    
    @FXML
    void btnAccount(ActionEvent event) {

    }
    
    @FXML
    void btnContract(ActionEvent event) throws IOException {
        secPane.getChildren().clear();
        Pane newLoadedPane = FXMLLoader.load(getClass().getResource("/Project_JavaFx/FXML/FormContract.fxml"));
        secPane.getChildren().add(newLoadedPane);
    }
    
    @FXML
    private Pane secPane;
    
    @FXML
    void btnCarName(ActionEvent event) {

    }
    
    @FXML
    void btnYear(ActionEvent event) {

    }
    
    @FXML
    void txtSearch(ActionEvent event) {

    }
    
    @FXML
    void btnSearch(ActionEvent event) {

    }
    
    @FXML
    void btnCreate(ActionEvent event) throws IOException {
        Navigator.getInstance().goToCreateCar();
    }
    
    @FXML
    void btnUpdate(ActionEvent event) {

    }

    @FXML
    void btnDelete(ActionEvent event) {

    }
     
    @FXML
    void btnCancel(ActionEvent event) {
        
    }
    
    public void initialize(){
        
        tvCars.setItems(Car.selectAll());
        
        tcProduct.setCellValueFactory((Car)->{
            return Car.getValue().getCarNameProperty();
        });
        tcBrand.setCellValueFactory((Car)->{
            return Car.getValue().getBrandProperty();
        });
        tcCategory.setCellValueFactory((Car)->{
            return Car.getValue().getCategoryProperty();
        });
        tcYear.setCellValueFactory((Car)->{
            return Car.getValue().getYearOfManufactureProperty();
        });
        tcPrice.setCellValueFactory((Car)->{
            return Car.getValue().getPriceProperty();
        });
        tcGear.setCellValueFactory((Car)->{
            return Car.getValue().getGearProperty();
        });
        tcColor.setCellValueFactory((Car)->{
            return Car.getValue().getColorProperty();
        });
    }
}
