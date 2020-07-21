/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Project_JavaFx.Controller;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

/**
 *
 * @author lehie
 */
public class CUCategoryController {
    @FXML
    void btnCancel(ActionEvent event) throws IOException {
        Navigator.getInstance().goToMain();
    }

    @FXML
    void btnSave(ActionEvent event) {

    }
}
