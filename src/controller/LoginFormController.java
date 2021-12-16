package controller;

import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class LoginFormController {
    public JFXTextField txtName;
    public JFXTextField txtPassword;
    public AnchorPane loginContext;

    public void loginBtnOnAction(ActionEvent actionEvent) throws IOException {
        Parent load = FXMLLoader.load(getClass().getResource("../view/DashboardForm.fxml"));
        Scene scene = new Scene(load);
        Stage window = (Stage) loginContext.getScene().getWindow();
        window.setScene(scene);
    }
}
