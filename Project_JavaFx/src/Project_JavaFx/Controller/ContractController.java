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
public class ContractController {
    @FXML
    private TableView<Contract> tvContract; 

     @FXML
    private TableColumn<Contract, String> tcSeri;

    @FXML
    private TableColumn<Contract, String> tcCarName;

    @FXML
    private TableColumn<Contract, String> tcReceiptDate;

    @FXML
    private TableColumn<Contract, Integer> tcPrice;

    @FXML
    private TableColumn<Contract, Integer> tcDeposits;

    @FXML
    private TableColumn<Contract, String> tcCustomerName;

    @FXML
    private TableColumn<Contract, Integer> tcPhone;

    @FXML
    private TableColumn<Contract, String> tcAddress;
    
    @FXML
    void btnDetails(ActionEvent event) {

    }
           
    @FXML
    void txtSearch(ActionEvent event) {

    }

    @FXML
    void btnSearch(ActionEvent event) {

    }
    

    @FXML
    void btnCreate(ActionEvent event) throws IOException {
        Navigator.getInstance().goToCreateContract();
    }

    @FXML
    void btnUpdate(ActionEvent event) throws IOException {
        Navigator.getInstance().goToCreateContract();
    }


    @FXML
    void btnDelete(ActionEvent event) {

    }

    @FXML
    void btnCancel(ActionEvent event) {

    }
    
     public void initialize(){
        
        tvContract.setItems(Contract.selectAll());
        
        tcSeri.setCellValueFactory((Contract)->{
            return Contract.getValue().getCarSkuProperty();
        });
        tcCarName.setCellValueFactory((Contract)->{
            return Contract.getValue().getCarNameProperty();
        });
        tcReceiptDate.setCellValueFactory((Contract)->{
            return Contract.getValue().getProductReceiptDateProperty();
        });
        tcPrice.setCellValueFactory((Contract)->{
            return Contract.getValue().getPriceProperty();
        });
        tcDeposits.setCellValueFactory((Contract)->{
            return Contract.getValue().getDepositsProperty();
        });
        tcCustomerName.setCellValueFactory((Contract)->{
            return Contract.getValue().getCustomerNameProperty();
        });
        tcPhone.setCellValueFactory((Contract)->{
            return Contract.getValue().getPhoneProperty();
        });
        tcAddress.setCellValueFactory((Contract)->{
            return Contract.getValue().getAddressProperty();
        });
    }
}
