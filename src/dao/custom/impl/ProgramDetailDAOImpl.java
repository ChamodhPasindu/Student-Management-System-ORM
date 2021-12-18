package dao.custom.impl;

import dao.custom.ProgramDetailDAO;
import entity.ProgramDetail;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.FactoryConfiguration;

import java.sql.SQLException;
import java.util.ArrayList;

public class ProgramDetailDAOImpl implements ProgramDetailDAO {

    @Override
    public boolean add(ProgramDetail programDetail) throws SQLException, ClassNotFoundException {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        session.save(programDetail);
        transaction.commit();
        session.close();
        return true;
    }

    @Override
    public boolean delete(String s) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean update(ProgramDetail programDetail) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public ProgramDetail search(String s) throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public ArrayList<ProgramDetail> getAll() throws SQLException, ClassNotFoundException {
        return null;
    }
}
