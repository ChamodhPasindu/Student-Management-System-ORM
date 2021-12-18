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

    @Override
    public ProgramDTO searchProgram(String id) throws SQLException, ClassNotFoundException {
        Program program = programDAO.search(id);
        if (program!=null){
            return new ProgramDTO(program.getId(),program.getName(),program.getDuration(),program.getFee());
        }else{
            return null;
        }
    }

    @Override
    public boolean updateProgram(ProgramDTO dto) throws SQLException, ClassNotFoundException {
        return programDAO.update(new Program(dto.getId(), dto.getName(), dto.getDuration(),dto.getFee()));
    }

    @Override
    public boolean deleteProgram(String id) throws SQLException, ClassNotFoundException {
        return programDAO.delete(id);
    }

    @Override
    public ArrayList<ProgramDTO> getAllProgramDetail() throws SQLException, ClassNotFoundException {
        ArrayList<Program> details = programDAO.getAll();
        ArrayList<ProgramDTO> dtos = new ArrayList<>();

        for (Program program:details) {
            dtos.add(new ProgramDTO(program.getId(),program.getName(),program.getDuration(),program.getFee()));
        }
        return dtos;
    }
}
