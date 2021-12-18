package bo.custom.impl;

import bo.custom.RegisterProgramBO;
import dao.DAOFactory;
import dao.custom.ProgramDAO;
import dao.custom.ProgramDetailDAO;
import dao.custom.StudentDAO;
import dto.ProgramDetailDTO;
import entity.Program;
import entity.ProgramDetail;
import entity.Student;

import java.sql.SQLException;

public class RegisterProgramBOIpl implements RegisterProgramBO {
    ProgramDetailDAO programDetailDAO = (ProgramDetailDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.PROGRAMDETAIL);
    StudentDAO studentDAO = (StudentDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.STUDENT);
    ProgramDAO programDAO = (ProgramDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.PROGRAM);
    @Override
    public boolean registerProgram(ProgramDetailDTO dto) throws SQLException, ClassNotFoundException {
        Student student = studentDAO.search(dto.getStId());
        Program program = programDAO.search(dto.getProgramId());
       return programDetailDAO.add(new ProgramDetail(student, program, dto.getDate())) ;
    }
}
