package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class DashboardFormController {
    public AnchorPane subContext;
    public TableView tblRegistered;
    public ComboBox cmbPrograms;
    public AnchorPane dashboardContext;

    public void studentsOnAction(ActionEvent actionEvent) throws IOException {
        Parent load = FXMLLoader.load(getClass().getResource("../view/StudentsForm.fxml"));
        subContext.getChildren().clear();;
        subContext.getChildren().add(load);
    }

    public void logOutBtnOnAction(ActionEvent actionEvent) throws IOException {
        Parent load = FXMLLoader.load(getClass().getResource("../view/LoginForm.fxml"));
        Scene scene = new Scene(load);
        Stage window = (Stage) dashboardContext.getScene().getWindow();
        window.setScene(scene);
    }

    public void paymentsOnAction(ActionEvent actionEvent) throws IOException {
        Parent load = FXMLLoader.load(getClass().getResource("../view/paymentsForm.fxml"));
        subContext.getChildren().clear();;
        subContext.getChildren().add(load);
    }

    public void programsOnAction(ActionEvent actionEvent) throws IOException {
        Parent load = FXMLLoader.load(getClass().getResource("../view/ProgramsForm.fxml"));
        subContext.getChildren().clear();;
        subContext.getChildren().add(load);
    }

    public void dashboardOnAction(ActionEvent actionEvent) throws IOException {
        Parent load = FXMLLoader.load(getClass().getResource("../view/DashboardForm.fxml"));
        Scene scene = new Scene(load);
        Stage window = (Stage) dashboardContext.getScene().getWindow();
        window.setScene(scene);
    }
}
