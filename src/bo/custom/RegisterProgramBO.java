package bo.custom;

import bo.SuperBO;
import dto.CustomDTO;
import dto.ProgramDetailDTO;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public interface RegisterProgramBO extends SuperBO {
    boolean registerProgram(ProgramDetailDTO dto) throws SQLException, ClassNotFoundException;
    List<Object[]> getAllRegisteredStudents(String id);
}
