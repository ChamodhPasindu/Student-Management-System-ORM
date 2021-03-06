package controller;

import bo.BOFactory;
import bo.custom.ProgramBO;
import com.jfoenix.controls.JFXTextField;
import dto.ProgramDTO;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import view.tm.ProgramTM;

import java.io.IOException;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.ArrayList;

public class ProgramsFormController {
    ProgramBO programBO = (ProgramBO) BOFactory.getBoFactory().getBO(BOFactory.BoTypes.PROGRAM);
    public JFXTextField txtProgramId;
    public JFXTextField txtProgramName;
    public JFXTextField txtFee;
    public JFXTextField txtDuration;
    public TableView tblPrograms;
    public TableColumn colProgramId;
    public TableColumn colProgramName;

    public void initialize() {

        colProgramId.setCellValueFactory(new PropertyValueFactory<>("id"));
        colProgramName.setCellValueFactory(new PropertyValueFactory<>("name"));

        try {
            loadProgramTable();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    ObservableList<ProgramTM> programTMS = FXCollections.observableArrayList();

    private void loadProgramTable() throws SQLException, ClassNotFoundException {
        programTMS.clear();

        ArrayList<ProgramDTO> allProgramDetail = programBO.getAllProgramDetail();
        for (ProgramDTO dto : allProgramDetail) {
            programTMS.add(new ProgramTM(dto.getId(), dto.getName()));
        }
        tblPrograms.setItems(programTMS);
    }

    public void updateOnAction(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
        ProgramDTO programDTO = new ProgramDTO(
                txtProgramId.getText(), txtProgramName.getText(), txtDuration.getText(), new BigDecimal(txtFee.getText())
        );
        if (programBO.updateProgram(programDTO)) {
            new Alert(Alert.AlertType.INFORMATION, "Updated Program Successfully").show();
            loadProgramTable();
        } else {
            new Alert(Alert.AlertType.WARNING, "Error,Try Again Latter").show();
        }
    }

    public void deleteOnAction(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
        if (programBO.deleteProgram(txtProgramId.getText())) {
            new Alert(Alert.AlertType.INFORMATION, "Deleted Program Successfully").show();
            loadProgramTable();
        } else {
            new Alert(Alert.AlertType.WARNING, "Error,Try Again Latter").show();
        }
    }

    public void searchOnAction(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
        ProgramDTO programDTO = programBO.searchProgram(txtProgramId.getText());
        if (programDTO == null) {
            new Alert(Alert.AlertType.WARNING, "Empty Result set").show();
        } else {
            txtProgramName.setText(programDTO.getName());
            txtDuration.setText(programDTO.getDuration());
            txtFee.setText(programDTO.getFee().toString());
        }
    }

    public void addNewProgramOnAction(ActionEvent actionEvent) throws IOException {
        Parent load = FXMLLoader.load(getClass().getResource("../view/AddNewProgramForm.fxml"));
        Scene scene = new Scene(load);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.setTitle("Add new Program");
        stage.show();
        stage.setOnCloseRequest(event -> {
            try {
                loadProgramTable();
            } catch (SQLException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        });
    }
}
