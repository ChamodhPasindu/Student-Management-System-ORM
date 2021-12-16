package dao.custom.impl;

import dao.custom.ProgramDAO;
import entity.Program;

import java.sql.SQLException;
import java.util.ArrayList;

public class ProgramDAOImpl implements ProgramDAO {

    @Override
    public boolean add(Program program) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean delete(String s) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean update(Program program) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public Program search(String s) throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public ArrayList<Program> getAll() throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public String CreateProgramId() throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public ArrayList<String> getProgramIds() throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public ArrayList<Program> getAllProgramDetails() throws SQLException, ClassNotFoundException {
        return null;
    }
}
