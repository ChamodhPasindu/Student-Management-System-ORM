package bo.custom;

import bo.SuperBO;
import dto.ProgramDetailDTO;

import java.sql.SQLException;

public interface RegisterProgramBO extends SuperBO {
    boolean registerProgram(ProgramDetailDTO dto) throws SQLException, ClassNotFoundException;
}
