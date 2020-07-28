/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Project_JavaFx.Controller.Customer;

import Project_JavaFx.Controller.Navigator;
import java.io.IOException;
import java.sql.SQLException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;

/**
 *
 * @author lehie
 */
public class CUCustomerController {
    private Customer editCustomer = null;

    @FXML
    private TextField txtName;

    @FXML
    private TextField txtPhone;

    @FXML
    private TextField txtAddress;

    @FXML
    private TextField txtEmail;

    @FXML
    void btnCancel(ActionEvent event) throws IOException {
        Navigator.getInstance().goToMain();
    }

    @FXML
    void btnSave(ActionEvent event) throws IOException, SQLException {
        if (editCustomer == null) {
            Customer insertCustomer = extractCustomerFromFields();
            insertCustomer = Customer.insert(insertCustomer);
            Navigator.getInstance().goToMain();
        }else{
            Customer updateCustomer = extractCustomerFromFields();
            updateCustomer.setCustomerID(this.editCustomer.getCustomerID());
            
            boolean result =Customer.update(updateCustomer);
            Alert alert = new Alert(Alert.AlertType.NONE);
            if(result){
                alert.setHeaderText("Cập nhật khách hàng thành công");
            }else{
                alert.setHeaderText("Cập nhật khách hàng không thành công");
            }
            Navigator.getInstance().goToMain();
        }
    }

    @FXML
    void txtAddress(ActionEvent event) {

    }

    @FXML
    void txtEmail(ActionEvent event) {

    }

    @FXML
    void txtName(ActionEvent event) {

    }

    @FXML
    void txtPhone(ActionEvent event) {

    }
    
    private Customer extractCustomerFromFields() {
        Customer customer = new Customer();
        customer.setCustomerName(txtName.getText());
        customer.setPhone(txtPhone.getText());
        customer.setAddress(txtAddress.getText());
        customer.setEmail(txtEmail.getText());
        return customer;
    }
    
    public void initialize(Customer editCustomer) {
        this.editCustomer = editCustomer;
        String msg = "";
        if (editCustomer == null) {
            msg = "Thêm mới thông tin khách hàng";
        } else {
            msg = "Chỉnh sửa thông tin khách hàng";
            txtName.setText(editCustomer.getCustomerName());
            txtPhone.setText(editCustomer.getPhone());
            txtAddress.setText(editCustomer.getAddress());
            txtEmail.setText(editCustomer.getEmail());
        }
    }
}
