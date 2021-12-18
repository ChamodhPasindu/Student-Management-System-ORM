package controller;

import bo.BOFactory;
import bo.custom.ProgramBO;
import bo.custom.RegisterProgramBO;
import bo.custom.StudentBO;
import com.jfoenix.controls.JFXTextField;
import dto.ProgramDTO;
import dto.ProgramDetailDTO;
import dto.StudentDTO;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import view.tm.ProgramTM;

import java.io.IOException;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;

public class PaymentsFormController {
    public JFXTextField txtStId;
    ProgramBO programBO = (ProgramBO) BOFactory.getBoFactory().getBO(BOFactory.BoTypes.PROGRAM);
    StudentBO studentBO = (StudentBO) BOFactory.getBoFactory().getBO(BOFactory.BoTypes.STUDENT);
    RegisterProgramBO registerProgramBO = (RegisterProgramBO) BOFactory.getBoFactory().getBO(BOFactory.BoTypes.REGISTER_PROGRAM);

    public Label lblDate;
    public ComboBox<String> cmbProgramId;
    public JFXTextField txtStudentName;
    public JFXTextField txtMobile;
    public JFXTextField txtAddress;
    public JFXTextField txtProgramName;
    public JFXTextField txtFee;
    public JFXTextField txtDuration;
   public TableView tblPrograms;
    public TableColumn colProgramId;
    public TableColumn colProgram;
    public TableColumn colDuration;
    public TableColumn colFee;

    public void initialize(){
        colProgramId.setCellValueFactory(new PropertyValueFactory<>("id"));
        colProgram.setCellValueFactory(new PropertyValueFactory<>("name"));
        colDuration.setCellValueFactory(new PropertyValueFactory<>("duration"));
        colFee.setCellValueFactory(new PropertyValueFactory<>("fee"));

        try {
            loadProgramTable();
            loadDate();
            loadProgramId();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        
        cmbProgramId.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue==null){
                return;
            }
            try {
                setProgramData(newValue);
            } catch (SQLException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        });
    }



    private void loadProgramId() throws SQLException, ClassNotFoundException {
        ArrayList<String> programId = programBO.getProgramId();
        cmbProgramId.getItems().addAll(programId);
    }

    private void setProgramData(String id) throws SQLException, ClassNotFoundException {
        ProgramDTO programDTO = programBO.searchProgram(id);
        txtProgramName.setText(programDTO.getName());
        txtDuration.setText(programDTO.getDuration());
        txtFee.setText(programDTO.getFee().toString());
    }


    private void loadDate() {
        Date date = new Date();
        SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd");
        lblDate.setText(f.format(date));
    }

    ObservableList<ProgramTM>programTMS = FXCollections.observableArrayList();
    private void loadProgramTable() throws SQLException, ClassNotFoundException {
        programTMS.clear();

        ArrayList<ProgramDTO> allProgramDetail = programBO.getAllProgramDetail();
        for (ProgramDTO dto:allProgramDetail) {
            programTMS.add(new ProgramTM(dto.getId(),dto.getName(),dto.getDuration(),dto.getFee()));
        }
        tblPrograms.setItems(programTMS);
    }


    public void addNewStudentOnAction(ActionEvent actionEvent) throws IOException {
        Parent load = FXMLLoader.load(getClass().getResource("../view/AddNewStudentForm.fxml"));
        Scene scene = new Scene(load);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.setTitle("Add new Student");
        stage.show();
    }

    public void addOnAction(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
        ProgramDetailDTO dto = new ProgramDetailDTO(
                txtStId.getText(),cmbProgramId.getValue(), LocalDate.parse(lblDate.getText())
        );
        if (registerProgramBO.registerProgram(dto)) {
            new Alert(Alert.AlertType.INFORMATION,"Successful").show();
        }else{
            new Alert(Alert.AlertType.INFORMATION,"Try Again").show();
        }
    }

    public void clearOnAction(ActionEvent actionEvent) {
    }

    public void searchOnAction(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
        StudentDTO studentDTO = studentBO.searchStudent(txtStId.getText());
        if (studentDTO==null){
            new Alert(Alert.AlertType.WARNING, "Empty Result set").show();
        }else{
            txtStudentName.setText(studentDTO.getName());
            txtMobile.setText(studentDTO.getMobile());
            txtAddress.setText(studentDTO.getAddress());
        }

    }
}
