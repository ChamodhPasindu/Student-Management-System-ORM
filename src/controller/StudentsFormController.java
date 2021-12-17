package controller;

import bo.BOFactory;
import bo.custom.StudentBO;
import com.jfoenix.controls.JFXTextField;
import dao.custom.StudentDAO;
import dto.StudentDTO;
import entity.Student;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

import java.sql.SQLException;

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
        } else {
            new Alert(Alert.AlertType.WARNING, "Error,Try Again Latter").show();
        }
    }

    public void deleteOnAction(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
        if (studentBO.deleteStudent(txtStudentId.getText())) {
            new Alert(Alert.AlertType.INFORMATION, "Deleted Program Successfully").show();
        } else {
            new Alert(Alert.AlertType.WARNING, "Error,Try Again Latter").show();
        }
    }
}
