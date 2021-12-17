package bo.custom;

import bo.SuperBO;
import dto.StudentDTO;

import java.sql.SQLException;

public interface StudentBO extends SuperBO {
    public String createStudentId() throws SQLException, ClassNotFoundException;
    boolean addStudent(StudentDTO dto) throws SQLException, ClassNotFoundException;

}
