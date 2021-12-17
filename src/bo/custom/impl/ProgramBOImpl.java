package bo.custom.impl;

import bo.custom.ProgramBO;
import dao.DAOFactory;
import dao.custom.ProgramDAO;
import dto.ProgramDTO;
import entity.Program;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProgramBOImpl implements ProgramBO {
    ProgramDAO programDAO = (ProgramDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.PROGRAM);

    @Override
    public String createItemId() throws SQLException, ClassNotFoundException {
        return programDAO.CreateProgramId();
    }

    @Override
    public boolean addProgram(ProgramDTO dto) throws SQLException, ClassNotFoundException {
        return programDAO.add(new Program(dto.getId(), dto.getName(), dto.getDuration(),dto.getFee()));
    }
}
