/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Project_JavaFx.Controller;

import java.io.IOException;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author lehie
 */
public class Navigator {
    public static final String LOGIN_FXML = "/Project_JavaFx/FXML/Login.fxml";
    public static final String MAIN_FXML = "/Project_JavaFx/FXML/FormMain.fxml";
    public static final String CREATE_CAR_FXML = "/Project_JavaFx/FXML/FormCUCar.fxml";
    public static final String CREATE_CONTRACT_FXML = "/Project_JavaFx/FXML/FormCUContract.fxml";
    public static final String CREATE_CATEGORY_FXML = "/Project_JavaFx/FXML/FormCUCategory.fxml";
    public static final String CREATE_BRAND_FXML = "/Project_JavaFx/FXML/FormCUBrand.fxml";
    
    private FXMLLoader loader;
    private Stage stage = null;

    public Stage getStage() {
        return stage;
    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }
    
    private static Navigator nav = null;
    
    private Navigator(){
        
    }
    
    public static Navigator getInstance(){
        if(nav == null){
            nav = new Navigator();
        }
        return nav;
    }
    
    private void goTo(String fxml) throws IOException {
        this.loader = new FXMLLoader();
        loader.setLocation(getClass().getResource(fxml));
        Parent root = loader.load();
        Scene scene = new Scene(root);
        this.stage.setScene(scene);
    }
    
    public void goToLogin() throws IOException{
        this.goTo(LOGIN_FXML);
    }
    
    public void goToMain() throws IOException{
        this.goTo(MAIN_FXML);
    }
    
    public void goToCreateCar() throws IOException{
        this.goTo(CREATE_CAR_FXML);
    }
    
    public void goToCreateContract() throws IOException{
        this.goTo(CREATE_CONTRACT_FXML);
    }
    
    public void goToCreateCategory() throws IOException{
        this.goTo(CREATE_CATEGORY_FXML);
    }
    
    public void goToCreateBrand() throws IOException{
        this.goTo(CREATE_BRAND_FXML);
    }

}
