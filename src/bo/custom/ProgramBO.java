package bo.custom;

import bo.SuperBO;
import dto.ProgramDTO;
import entity.Program;

import java.sql.SQLException;
import java.util.ArrayList;

public interface ProgramBO extends SuperBO {
    public String createItemId() throws SQLException, ClassNotFoundException;

    boolean addProgram(ProgramDTO dto) throws SQLException, ClassNotFoundException;

    ProgramDTO searchProgram(String id) throws SQLException, ClassNotFoundException;

    boolean updateProgram(ProgramDTO dto) throws SQLException, ClassNotFoundException;

    boolean deleteProgram(String id) throws SQLException, ClassNotFoundException;

    ArrayList<ProgramDTO> getAllProgramDetail() throws SQLException, ClassNotFoundException;

}
