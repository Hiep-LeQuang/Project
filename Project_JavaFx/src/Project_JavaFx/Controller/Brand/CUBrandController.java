/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Project_JavaFx.Controller.Brand;

import Project_JavaFx.Controller.Navigator;
import java.io.IOException;
import java.sql.SQLException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

/**
 *
 * @author lehie
 */
public class CUBrandController {

    private Brand editBrand = null;

    @FXML
    private ComboBox<String> cbxStatus;

    @FXML
    private TextField txtBrand;

    @FXML
    void btnCancel(ActionEvent event) throws IOException {
        Navigator.getInstance().goToMain();
    }

    @FXML
    void btnSave(ActionEvent event) throws SQLException, IOException {
        if (editBrand == null) {
            Brand insertBrand = extractBrandFromFields();
            insertBrand = Brand.insert(insertBrand);
            Navigator.getInstance().goToMain();
        }else{
            Brand updateBrand = extractBrandFromFields();
            updateBrand.setBrandID(this.editBrand.getBrandID());
            
            boolean result =Brand.update(updateBrand);
            Alert alert = new Alert(Alert.AlertType.NONE);
            if(result){
                alert.setHeaderText("Cập nhật thương hiệu thành công");
            }else{
                alert.setHeaderText("Cập nhật thương hiệu không thành công");
            }
            Navigator.getInstance().goToMain();
        }
    }
    
    @FXML
    void txtBrand(ActionEvent event) {

    }

    private Brand extractBrandFromFields() {
        Brand brand = new Brand();
        brand.setBrand(txtBrand.getText());
        brand.setStatus(cbxStatus.getSelectionModel().getSelectedItem());
        return brand;
    }

    public void initialize(Brand editBrand) {
        this.editBrand = editBrand;
        String msg = "";
        if (editBrand == null) {
            msg = "Thêm mới thương hiệu";
            cbxStatus.getItems().add("Đang Kinh Doanh");
            cbxStatus.getItems().add("Ngừng Kinh Doanh");
        } else {
            msg = "Chỉnh sửa thương hiệu";
            cbxStatus.getItems().add("Đang Kinh Doanh");
            cbxStatus.getItems().add("Ngừng Kinh Doanh");
            txtBrand.setText(editBrand.getBrand());
            if (editBrand.getStatus().equals("Đang Kinh Doanh")) {
                cbxStatus.getSelectionModel().select("Đang Kinh Doanh");
            } else {
                cbxStatus.getSelectionModel().select("Ngừng Kinh Doanh");
            }
        }
    }
}
