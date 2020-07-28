/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Project_JavaFx.Controller.Color;

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
public class CUColorController {
    private Color editColor = null;
    
    @FXML
    private TextField txtColor;
    
    @FXML
    void btnCancel(ActionEvent event) throws IOException {
        Navigator.getInstance().goToMain();
    }

    @FXML
    void btnSave(ActionEvent event) throws IOException, SQLException {
        if (editColor == null) {
            Color insertColor = extractColorFromFields();
            insertColor = Color.insert(insertColor);
            Navigator.getInstance().goToMain();
        }else{
            Color updateColor = extractColorFromFields();
            updateColor.setColorID(this.editColor.getColorID());
            
            boolean result =Color.update(updateColor);
            Alert alert = new Alert(Alert.AlertType.NONE);
            if(result){
                alert.setHeaderText("Cập nhật màu sắc thành công");
            }else{
                alert.setHeaderText("Cập nhật màu sắc không thành công");
            }
            Navigator.getInstance().goToMain();
        }
    }

    @FXML
    void txtColor(ActionEvent event) {

    }
    
    private Color extractColorFromFields() {
        Color color = new Color();
        color.setColor(txtColor.getText());
        return color;
    }

    public void initialize(Color editColor) {
        this.editColor = editColor;
        String msg = "";
        if (editColor == null) {
            msg = "Thêm mới màu xe";
        } else {
            msg = "Chỉnh sửa màu xe";
            txtColor.setText(editColor.getColor());
        }
    }
}
