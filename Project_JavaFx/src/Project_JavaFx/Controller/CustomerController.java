/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Project_JavaFx.Controller;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

/**
 *
 * @author lehie
 */
public class CustomerController {
    @FXML
    private TableView<Customer> tvCustomer;

    @FXML
    private TableColumn<Customer, Integer> tcContract;

    @FXML
    private TableColumn<Customer, String> tcName;

    @FXML
    private TableColumn<Customer, String> tcphone;

    @FXML
    private TableColumn<Customer, String> tcAddress;

    @FXML
    private TableColumn<Customer, String> tcEmail;

    @FXML
    void btnCancel(ActionEvent event) throws IOException {
        Navigator.getInstance().goToMain();
    }

    @FXML
    void btnCreate(ActionEvent event) throws IOException {
        Navigator.getInstance().goToCreateCustomer();
    }

    @FXML
    void btnSearch(ActionEvent event) {

    }

    @FXML
    void btnUpdate(ActionEvent event) throws IOException {
        Navigator.getInstance().goToCreateCustomer();
    }

    @FXML
    void txtSearch(ActionEvent event) {

    }
    
//    private void selectedCustomerWarning() {
//        Alert alert = new Alert(Alert.AlertType.WARNING);
//        alert.setTitle("Vui lòng chọn một hợp đồng");
//        alert.setHeaderText("Bạn phải chọn một hợp đồng ở trong danh sách");
//        alert.showAndWait();
//    }
    
    public void initialize(){
        
        tvCustomer.setItems(Customer.selectAll());
        
        tcContract.setCellValueFactory((Customer)->{
            return Customer.getValue().getContractIDProperty();
        });
        
        tcName.setCellValueFactory((Customer)->{
            return Customer.getValue().getCustomerNameProperty();
        });
        
        tcphone.setCellValueFactory((Customer)->{
            return Customer.getValue().getPhoneProperty();
        });
        
        tcAddress.setCellValueFactory((Customer)->{
            return Customer.getValue().getAddressProperty();
        });
        
        tcEmail.setCellValueFactory((Customer)->{
            return Customer.getValue().getEmailProperty();
        });
    }
}
