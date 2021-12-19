package dao.custom.impl;

import dao.custom.ProgramDAO;
import entity.Program;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import util.FactoryConfiguration;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProgramDAOImpl implements ProgramDAO {

    @Override
    public boolean add(Program program) throws SQLException, ClassNotFoundException {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        session.save(program);
        transaction.commit();
        session.close();
        return true;
    }

    @Override
    public boolean delete(String s) throws SQLException, ClassNotFoundException {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        Program program = session.load(Program.class, s);

        session.delete(program);
        transaction.commit();
        session.close();
        return true;
    }

    @Override
    public boolean update(Program program) throws SQLException, ClassNotFoundException {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        session.update(program);
        transaction.commit();
        session.close();
        return true;
    }

    @Override
    public Program search(String s) throws SQLException, ClassNotFoundException {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        Program program = session.get(Program.class, s);

        transaction.commit();
        session.close();
        return program;
    }

    @Override
    public ArrayList<Program> getAll() throws SQLException, ClassNotFoundException {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        String hql = "FROM program";
        Query query = session.createQuery(hql);
        List<Program> list = query.list();

        transaction.commit();
        session.close();

        ArrayList<Program> programs = new ArrayList<>();
        programs.addAll(list);
        return programs;
    }

    @Override
    public String CreateProgramId() throws SQLException, ClassNotFoundException {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        String hql = "SELECT id FROM program ORDER BY id DESC ";
        Query query = session.createQuery(hql);
        query.setMaxResults(1);
        List<String> list = query.list();

        transaction.commit();
        session.close();

        if (!list.isEmpty()) {
            int tempId = Integer.parseInt(list.get(0).split("O")[1]);
            tempId = tempId + 1;
            if (tempId <= 9) {
                return "CTO00" + tempId;
            } else if (tempId <= 99) {
                return "CTO0" + tempId;
            } else {
                return "CTO" + tempId;
            }
        } else {
            return "CTO001";
        }
    }

    @Override
    public ArrayList<String> getProgramIds() throws SQLException, ClassNotFoundException {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        String hql = "SELECT DISTINCT id FROM program ";
        Query query = session.createQuery(hql);
        List<String> list = query.list();

        transaction.commit();
        session.close();

        ArrayList<String> programId = new ArrayList<>();
        programId.addAll(list);


        return programId;
    }

    @Override
    public ArrayList<String> getAllProgramNames() throws SQLException, ClassNotFoundException {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        String hql = "SELECT DISTINCT name FROM program ";
        Query query = session.createQuery(hql);
        List<String> list = query.list();

        transaction.commit();
        session.close();

        ArrayList<String> programName = new ArrayList<>();
        programName.addAll(list);


        return programName;
    }

    @Override
    public String getProgram(String name) {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        String hql = "SELECT id FROM program WHERE name=:name";
        Query query = session.createQuery(hql);
        query.setParameter("name", name);
        List list = query.list();
        return list.get(0).toString();
    }

}
