package controller;

import bo.BOFactory;
import bo.custom.StudentBO;
import com.jfoenix.controls.JFXTextField;
import dto.StudentDTO;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;

import java.sql.SQLException;

public class AddNewStudentFormController {
    private StudentBO studentBO = (StudentBO) BOFactory.getBoFactory().getBO(BOFactory.BoTypes.STUDENT);
    public JFXTextField txtStudentId;
    public JFXTextField txtStudentName;
    public JFXTextField txtAddress;
    public JFXTextField txtMobile;
    public JFXTextField txtNic;

    public void initialize(){
        try {
            setStudentId();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private void setStudentId() throws SQLException, ClassNotFoundException {
        txtStudentId.setText(studentBO.createStudentId());
    }

    public void confirmOnAction(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
        StudentDTO studentDTO = new StudentDTO(
                txtStudentId.getText(),txtStudentName.getText(),txtAddress.getText(),txtNic.getText(),
                txtMobile.getText()
        );
        if (studentBO.addStudent(studentDTO)){
            new Alert(Alert.AlertType.CONFIRMATION,"Student Added Successfully").show();
            clearAllOnAction();
        }else{
            new Alert(Alert.AlertType.WARNING,"Error,Try Again Latter").show();
        }

    }

    private void clearAllOnAction() {
        txtStudentId.clear();
        txtAddress.clear();
        txtMobile.clear();
        txtStudentName.clear();
        txtNic.clear();
    }
}
