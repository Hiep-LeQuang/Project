/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Project_JavaFx.Controller.Contract;

import Project_JavaFx.Controller.Customer.Customer;
import Project_JavaFx.Controller.DbService;
import Project_JavaFx.Controller.Navigator;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

/**
 *
 * @author lehie
 */
public class CUContractController {

    private Contract editContract = null;

    @FXML
    private TextField txtCustomer;

    @FXML
    private TextField txtPhone;

    @FXML
    private TextField txtPrice;

    @FXML
    private TextField txtDos;

    @FXML
    private TextField txtRD;

    @FXML
    private TextArea txtNote;

    @FXML
    private TextField txtEmail;

    @FXML
    private TextField txtAddress;

    @FXML
    private TextField txtAccountant;

    @FXML
    private TextField txtDeposits;

    @FXML
    private ComboBox<String> cbxStatus;

    @FXML
    private ComboBox<String> cbxSku;

    @FXML
    private ComboBox<String> cbxNameCar;

    @FXML
    void btnCancel(ActionEvent event) throws IOException {
        Navigator.getInstance().goToMain();
    }

    @FXML
    void btnSave(ActionEvent event) throws IOException, SQLException {
        if (editContract == null) {
            Customer insertCustomer = extractCustomerFromFields();
            Contract insertContract = extractContractFromFields();
            insertCustomer = Customer.insert(insertCustomer);
            insertContract.setCustomerID(insertCustomer.getCustomerID());
            insertContract = Contract.insert(insertContract);

            Navigator.getInstance().goToMain();
        } else {
            Contract updateContract = extractContractFromFields();
            updateContract.setContractID(this.editContract.getContractID());

            Customer updateCustomer = extractCustomerFromFields();
            updateCustomer.setCustomerID(editContract.getCustomerID());
            Customer.update(updateCustomer);

            boolean result = Contract.update(updateContract);
            Alert alert = new Alert(Alert.AlertType.NONE);
            if (result) {
                alert.setHeaderText("Cập nhật thương hiệu thành công");
            } else {
                alert.setHeaderText("Cập nhật thương hiệu không thành công");
            }
            Navigator.getInstance().goToMain();
        }
    }

    private Customer extractCustomerFromFields() {
        Customer customer = new Customer();
        customer.setCustomerName(txtCustomer.getText());
        customer.setPhone(txtPhone.getText());
        customer.setAddress(txtAddress.getText());
        customer.setEmail(txtEmail.getText());
        return customer;
    }

    private Contract extractContractFromFields() {
        Contract contract = new Contract();
        contract.setPrice(Integer.parseInt(txtPrice.getText()));
        contract.setDateOfSale(txtDos.getText());
        contract.setDeposits(Integer.parseInt(txtDeposits.getText()));
        contract.setProductReceiptDate(txtRD.getText());
        contract.setAccountant(txtAccountant.getText());
        contract.setNote(txtNote.getText());

        contract.setSku(cbxSku.getSelectionModel().getSelectedItem());
        contract.setCarName(cbxNameCar.getSelectionModel().getSelectedItem());
        contract.setStatus(cbxStatus.getSelectionModel().getSelectedItem());

        String sku = cbxSku.getSelectionModel().getSelectedItem();
        if (contract.getSku() != null) {
            contract.setCarID(contract.getCarID(sku));
        } else {
            Alert alert = new Alert(Alert.AlertType.WARNING, "Khong co xe!");

        }

        String customer = cbxNameCar.getSelectionModel().getSelectedItem();
        if (contract.getCustomerID(customer) != 0) {
            contract.setCustomerID(Contract.getCustomerID(customer));
        } else {
            Alert alert = new Alert(Alert.AlertType.WARNING, "Khong co khach hang!");

        }

        return contract;
    }

    @FXML
    void cbxNameCar(ActionEvent event) {

    }

    @FXML
    void cbxSku(ActionEvent event) {

    }

    @FXML
    void cbxStatus(ActionEvent event) {

    }

    @FXML
    void txtAccountant(ActionEvent event) {

    }

    @FXML
    void txtAddress(ActionEvent event) {

    }

    @FXML
    void txtCustomer(ActionEvent event) {

    }

    @FXML
    void txtDeposits(ActionEvent event) {

    }

    @FXML
    void txtDos(ActionEvent event) {

    }

    @FXML
    void txtEmail(ActionEvent event) {

    }

    @FXML
    void txtPhone(ActionEvent event) {

    }

    @FXML
    void txtPrice(ActionEvent event) {

    }

    @FXML
    void txtRD(ActionEvent event) {

    }

    public void initialize(Contract editContract) throws SQLException {
        this.editContract = editContract;
        String msg = "";
        if (editContract == null) {
            msg = "Thêm hợp đồng xe";
            cbxStatus.getItems().add("Chờ Lấy Hàng");
            cbxStatus.getItems().add("Đã Giao");

        } else {
            msg = "Chỉnh sửa hợp đồng";
            cbxStatus.getItems().add("Chờ Lấy Hàng");
            cbxStatus.getItems().add("Đã Giao");

            txtPrice.setText(editContract.getPrice().toString());
            txtDos.setText(editContract.getDateOfSale());
            txtDeposits.setText(editContract.getDeposits().toString());
            txtRD.setText(editContract.getProductReceiptDate());
            txtAccountant.setText(editContract.getAccountant());
            txtNote.setText(editContract.getNote());
            cbxSku.getSelectionModel().select(editContract.getSku());
            
//            cbxSku.buttonCellProperty().addListener((observable, oldValue, newValue) -> {
//                
//                
//            });
            
            cbxNameCar.getSelectionModel().select(editContract.getCarName());

            txtCustomer.setText(editContract.getCarName());
            txtPhone.setText(editContract.getPhone());
            txtAddress.setText(editContract.getAddress());
            txtEmail.setText(editContract.getEmail());

            if (editContract.getStatus().equals("Chờ Lấy Hàng")) {
                cbxStatus.getSelectionModel().select("Chờ Lấy Hàng");
            } else {
                cbxStatus.getSelectionModel().select("Đã Giao");
            }

        }

        try (Connection connection = DbService.getConnection()) {
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery("select * from Car");
            while (rs.next()) {
                cbxSku.getItems().add(rs.getString("sku"));
                cbxNameCar.getItems().add(rs.getString("carName"));
            }
        } catch (SQLException e) {
            e.getStackTrace();
        }
    }
}
