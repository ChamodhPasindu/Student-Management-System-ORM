package dao.custom.impl;

import dao.custom.ProgramDetailDAO;
import entity.Program;
import entity.ProgramDetail;
import entity.Student;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import util.FactoryConfiguration;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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

    @Override
    public boolean isExistStudent(String stId, String programId) {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        Student student = session.get(Student.class, stId);
        Program program = session.get(Program.class, programId);

        String hql = "SELECT date FROM program_detail WHERE student=:stId AND program=:programId";
        Query query = session.createQuery(hql);
        query.setParameter("stId", student);
        query.setParameter("programId", program);
        List list = query.list();
        transaction.commit();
        session.close();
        if (!list.isEmpty()) {
            return true;
        } else {
            return false;
        }
    }
}
