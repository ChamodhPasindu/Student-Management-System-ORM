package controller;

import bo.BOFactory;
import bo.custom.ProgramBO;
import bo.custom.RegisterProgramBO;
import bo.custom.StudentBO;
import dto.CustomDTO;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import view.tm.StudentTM;

import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class DashboardFormController {
    public TableColumn colStId;
    public TableColumn colName;
    public TableColumn colAddress;
    public TableColumn colNic;
    public TableColumn colMobile;
    public TableColumn colDate;
    ProgramBO programBO = (ProgramBO) BOFactory.getBoFactory().getBO(BOFactory.BoTypes.PROGRAM);
    StudentBO studentBO = (StudentBO) BOFactory.getBoFactory().getBO(BOFactory.BoTypes.STUDENT);
    RegisterProgramBO registerProgramBO = (RegisterProgramBO) BOFactory.getBoFactory().getBO(BOFactory.BoTypes.REGISTER_PROGRAM);

    public AnchorPane subContext;
    public TableView tblRegistered;
    public ComboBox<String> cmbPrograms;
    public AnchorPane dashboardContext;

    public void initialize(){
        colStId.setCellValueFactory(new PropertyValueFactory<>("stId"));
        colName.setCellValueFactory(new PropertyValueFactory<>("stName"));
        colAddress.setCellValueFactory(new PropertyValueFactory<>("address"));
        colNic.setCellValueFactory(new PropertyValueFactory<>("nic"));
        colMobile.setCellValueFactory(new PropertyValueFactory<>("mobile"));
        colDate.setCellValueFactory(new PropertyValueFactory<>("date"));
        try {
            loadProgramNames();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        cmbPrograms.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            loadRegisterTable(newValue);
        });
    }

    ObservableList<StudentTM>studentTMS = FXCollections.observableArrayList();
    private void loadRegisterTable(String name) {
        studentTMS.clear();

        String id = programBO.getProgram(name);
        List<Object[]> students = registerProgramBO.getAllRegisteredStudents(id);

        int i=0;
        for (Object[] dto:students) {
            studentTMS.add(new StudentTM(dto[i].toString(), dto[i+1].toString(), dto[i+2].toString(), dto[i+3].toString(),
                    dto[i+4].toString(), LocalDate.parse(dto[i+5].toString())));
        }
        tblRegistered.setItems(studentTMS);
    }

    private void loadProgramNames() throws SQLException, ClassNotFoundException {
        ArrayList<String> programName = programBO.getProgramName();
        cmbPrograms.getItems().addAll(programName);

    }

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
