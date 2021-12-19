package bo.custom;

import bo.SuperBO;
import dto.ProgramDetailDTO;

import java.sql.SQLException;
import java.util.List;

public interface RegisterProgramBO extends SuperBO {
    boolean registerProgram(ProgramDetailDTO dto) throws SQLException, ClassNotFoundException;

    List<Object[]> getAllRegisteredStudents(String id);

    boolean isExistStudent(String stName, String programId);
}
