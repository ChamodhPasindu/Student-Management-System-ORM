package bo.custom;

import bo.SuperBO;
import dto.StudentDTO;

import java.sql.SQLException;
import java.util.ArrayList;

public interface StudentBO extends SuperBO {
    public String createStudentId() throws SQLException, ClassNotFoundException;

    boolean addStudent(StudentDTO dto) throws SQLException, ClassNotFoundException;

    StudentDTO searchStudent(String id) throws SQLException, ClassNotFoundException;

    boolean updateStudent(StudentDTO dto) throws SQLException, ClassNotFoundException;

    boolean deleteStudent(String id) throws SQLException, ClassNotFoundException;

    ArrayList<StudentDTO> getAllStudentDetail() throws SQLException, ClassNotFoundException;

    ArrayList<String> getStudentId() throws SQLException, ClassNotFoundException;

}
