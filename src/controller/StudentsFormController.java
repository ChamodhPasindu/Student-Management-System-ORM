package controller;

import bo.BOFactory;
import bo.custom.StudentBO;
import com.jfoenix.controls.JFXTextField;
import dao.custom.StudentDAO;
import dto.ProgramDTO;
import dto.StudentDTO;
import entity.Student;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import view.tm.ProgramTM;
import view.tm.StudentTM;

import java.sql.SQLException;
import java.util.ArrayList;

public class StudentsFormController {
    StudentBO studentBO = (StudentBO) BOFactory.getBoFactory().getBO(BOFactory.BoTypes.STUDENT);
    public JFXTextField txtStudentId;
    public JFXTextField txtStudentName;
    public JFXTextField txtAddress;
    public JFXTextField txtMobile;
    public JFXTextField txtNic;
    public TableView tblStudents;
    public TableColumn colStId;
    public TableColumn colStName;

    public void initialize(){
        colStId.setCellValueFactory(new PropertyValueFactory<>("stId"));
        colStName.setCellValueFactory(new PropertyValueFactory<>("stName"));

        try {
            loadStudentTable();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    ObservableList<StudentTM>studentTMS = FXCollections.observableArrayList();
    private void loadStudentTable() throws SQLException, ClassNotFoundException {
        studentTMS.clear();

        ArrayList<StudentDTO> studentDTOS = studentBO.getAllStudentDetail();
        for (StudentDTO dto:studentDTOS) {
            studentTMS.add(new StudentTM(dto.getStId(),dto.getName()));
        }
        tblStudents.setItems(studentTMS);
    }

    public void searchOnAction(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
        StudentDTO studentDTO = studentBO.searchStudent(txtStudentId.getText());
        if (studentDTO == null) {
            new Alert(Alert.AlertType.WARNING, "Empty Result set").show();
        } else {
            txtStudentName.setText(studentDTO.getName());
            txtAddress.setText(studentDTO.getAddress());
            txtMobile.setText(studentDTO.getMobile());
            txtNic.setText(studentDTO.getNic());
        }
    }

    public void updateOnAction(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
        StudentDTO studentDTO = new StudentDTO(txtStudentId.getText(), txtStudentName.getText(), txtAddress.getText()
                , txtNic.getText(), txtMobile.getText());
        if (studentBO.updateStudent(studentDTO)) {
            new Alert(Alert.AlertType.INFORMATION, "Updated Student Successfully").show();
            loadStudentTable();
        } else {
            new Alert(Alert.AlertType.WARNING, "Error,Try Again Latter").show();
        }
    }

    public void deleteOnAction(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
        if (studentBO.deleteStudent(txtStudentId.getText())) {
            new Alert(Alert.AlertType.INFORMATION, "Deleted Program Successfully").show();
            loadStudentTable();
        } else {
            new Alert(Alert.AlertType.WARNING, "Error,Try Again Latter").show();
        }
    }
}
