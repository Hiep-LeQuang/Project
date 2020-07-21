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
import javafx.scene.control.TextField;

/**
 *
 * @author lehie
 */
public class LoginController {
    @FXML
    private TextField txtName;

    @FXML
    private TextField txtPass;

    @FXML
    private Button btnLogin;

    @FXML
    private Button btnCancel;

    @FXML
    void btnCancel(ActionEvent event) {
        System.exit(0);
    }

    @FXML
    void btnLogin(ActionEvent event) throws IOException {
        Navigator.getInstance().goToMain();
    }
}
