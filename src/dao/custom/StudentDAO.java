package dao.custom;

import dao.CrudDAO;
import entity.Student;

import java.sql.SQLException;
import java.util.ArrayList;

public interface StudentDAO extends CrudDAO<Student, String> {

    String createStudentId() throws SQLException, ClassNotFoundException;


}
