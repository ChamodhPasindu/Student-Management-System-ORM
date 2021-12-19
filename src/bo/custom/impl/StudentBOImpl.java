package bo.custom.impl;

import bo.custom.StudentBO;
import dao.DAOFactory;
import dao.custom.StudentDAO;
import dto.StudentDTO;
import entity.Student;

import java.sql.SQLException;
import java.util.ArrayList;

public class StudentBOImpl implements StudentBO {
    StudentDAO studentDAO = (StudentDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.STUDENT);

    @Override
    public String createStudentId() throws SQLException, ClassNotFoundException {
        return studentDAO.createStudentId();
    }

    @Override
    public boolean addStudent(StudentDTO dto) throws SQLException, ClassNotFoundException {
        return studentDAO.add(new Student(dto.getStId(), dto.getName(), dto.getNic(), dto.getMobile(), dto.getAddress()));
    }

    @Override
    public StudentDTO searchStudent(String id) throws SQLException, ClassNotFoundException {
        Student student = studentDAO.search(id);
        if (student != null) {
            return new StudentDTO(student.getStudentId(), student.getStudentName(), student.getAddress(), student.getNic(),
                    student.getMobile());
        } else {
            return null;
        }
    }

    @Override
    public boolean updateStudent(StudentDTO dto) throws SQLException, ClassNotFoundException {
        return studentDAO.update(new Student(dto.getStId(), dto.getName(), dto.getNic(), dto.getMobile(), dto.getAddress()));
    }

    @Override
    public boolean deleteStudent(String id) throws SQLException, ClassNotFoundException {
        return studentDAO.delete(id);
    }

    @Override
    public ArrayList<StudentDTO> getAllStudentDetail() throws SQLException, ClassNotFoundException {
        ArrayList<Student> details = studentDAO.getAll();
        ArrayList<StudentDTO> dtos = new ArrayList<>();

        for (Student student : details) {
            dtos.add(new StudentDTO(student.getStudentId(), student.getStudentName(), student.getAddress(), student.getNic(), student.getMobile()));
        }
        return dtos;
    }

    @Override
    public ArrayList<String> getStudentId() throws SQLException, ClassNotFoundException {
        return studentDAO.getStudentIds();
    }
}
