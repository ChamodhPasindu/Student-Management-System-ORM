package dao.custom;

import dao.CrudDAO;
import entity.Program;

import java.sql.SQLException;
import java.util.ArrayList;

public interface ProgramDAO extends CrudDAO<Program, String> {
    String CreateProgramId() throws SQLException, ClassNotFoundException;

    ArrayList<String> getProgramIds() throws SQLException, ClassNotFoundException;

    ArrayList<String> getAllProgramNames() throws SQLException, ClassNotFoundException;

    String getProgram(String name);

}
