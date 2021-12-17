package bo.custom;

import bo.SuperBO;
import dto.ProgramDTO;

import java.sql.SQLException;

public interface ProgramBO extends SuperBO {
    public String createItemId() throws SQLException, ClassNotFoundException;
    boolean addProgram(ProgramDTO dto) throws SQLException, ClassNotFoundException;

}
