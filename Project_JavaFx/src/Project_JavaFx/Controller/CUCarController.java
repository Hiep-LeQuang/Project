/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Project_JavaFx.Controller;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;

/**
 *
 * @author lehie
 */
public class CUCarController {
    @FXML
    private TextField txtCarName;

    @FXML
    private TextField txtColor;

    @FXML
    private TextField txtGear;

    @FXML
    private TextField txtPrice;

    @FXML
    private TextField txtLeatherUpholstery;

    @FXML
    private TextField txtCDPlayer;

    @FXML
    private TextField txtRearCamera;

    @FXML
    private ComboBox<?> cbxBrand;

    @FXML
    private Button btnCancel;

    @FXML
    private ImageView btnBack;

    @FXML
    private Button btnSave;

    @FXML
    private ComboBox<?> cbxCategor;

    @FXML
    private ComboBox<?> cbxFuel;

    @FXML
    private ComboBox<?> cbxGlasses;

    @FXML
    private TextField txtYear;

    @FXML
    void btnCancel(ActionEvent event) throws IOException {
        Navigator.getInstance().goToMain();
    }

    @FXML
    void btnSave(ActionEvent event) {

    }

    @FXML
    void cbxBrand(ActionEvent event) {

    }

    @FXML
    void cbxCategor(ActionEvent event) {

    }

    @FXML
    void cbxFuel(ActionEvent event) {

    }

    @FXML
    void cbxGlasses(ActionEvent event) {

    }

    @FXML
    void txtCDPlayer(ActionEvent event) {

    }

    @FXML
    void txtCarName(ActionEvent event) {

    }

    @FXML
    void txtColor(ActionEvent event) {

    }

    @FXML
    void txtGear(ActionEvent event) {

    }

    @FXML
    void txtLeatherUpholstery(ActionEvent event) {

    }

    @FXML
    void txtPrice(ActionEvent event) {

    }

    @FXML
    void txtRearCamera(ActionEvent event) {

    }

    @FXML
    void txtYear(ActionEvent event) {

    }
}
