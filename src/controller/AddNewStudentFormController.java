package controller;

import com.jfoenix.controls.JFXTextField;
import dto.StudentDTO;
import javafx.event.ActionEvent;

public class AddNewStudentFormController {
    public JFXTextField txtStudentId;
    public JFXTextField txtStudentName;
    public JFXTextField txtAddress;
    public JFXTextField txtMobile;
    public JFXTextField txtNic;

    public void confirmOnAction(ActionEvent actionEvent) {
        StudentDTO dto = new StudentDTO(
                txtStudentId.getText(),txtStudentName.getText(),txtAddress.getText(),txtNic.getText(),
                txtMobile.getText()
        );

    }
}
