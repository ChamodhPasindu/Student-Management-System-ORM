package controller;

import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class LoginFormController {
    public JFXTextField txtName;
    public AnchorPane loginContext;
    public JFXPasswordField txtPassword;

    public void loginBtnOnAction(ActionEvent actionEvent) throws IOException {

        if (txtName.getText().equals("admin") && txtPassword.getText().equals("1234")) {

            Parent load = FXMLLoader.load(getClass().getResource("../view/DashboardForm.fxml"));
            Scene scene = new Scene(load);
            Stage window = (Stage) loginContext.getScene().getWindow();
            window.setScene(scene);
            return;

        } else {
            new Alert(Alert.AlertType.WARNING, "The user name or password that you entered is incorrect.Try Again.. ", ButtonType.CLOSE).show();
        }
    }
}
