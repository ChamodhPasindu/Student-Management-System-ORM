package controller;

import bo.BOFactory;
import bo.custom.ProgramBO;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import dto.ProgramDTO;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;

import java.math.BigDecimal;
import java.sql.SQLException;

public class AddNewProgramFormController {
    ProgramBO programBO = (ProgramBO) BOFactory.getBoFactory().getBO(BOFactory.BoTypes.PROGRAM);
    public JFXTextField txtProgramId;
    public JFXTextField txtProgramName;
    public JFXTextField txtFee;
    public JFXTextField txtDuration;
    public JFXButton confirmOnAction;

    public void initialize(){
        try {
            createProgramId();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private void createProgramId() throws SQLException, ClassNotFoundException {
        txtProgramId.setText(programBO.createItemId());
    }

    public void confirmOnAction(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
        ProgramDTO programDTO = new ProgramDTO(
                txtProgramId.getText(),txtProgramName.getText(),txtDuration.getText(), new BigDecimal(txtFee.getText())
        );
        if (programBO.addProgram(programDTO)){
            new Alert(Alert.AlertType.INFORMATION,"Student Added Successfully").show();
            clearAllOnAction();
        }else{
            new Alert(Alert.AlertType.WARNING,"Error,Try Again Latter").show();
        }

    }

    private void clearAllOnAction() {
        txtProgramId.clear();
        txtProgramName.clear();
        txtDuration.clear();
        txtFee.clear();
    }
}
