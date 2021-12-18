package dao.custom.impl;

import dao.custom.StudentDAO;
import entity.Program;
import entity.Student;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import util.FactoryConfiguration;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StudentDAOImpl implements StudentDAO {
    @Override
    public boolean add(Student student) throws SQLException, ClassNotFoundException {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        session.save(student);

        transaction.commit();
        session.close();
        return true;
    }

    @Override
    public boolean delete(String s) throws SQLException, ClassNotFoundException {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        Student student = session.load(Student.class, s);
        session.delete(student);
        transaction.commit();
        session.close();
        return true;
    }

    @Override
    public boolean update(Student student) throws SQLException, ClassNotFoundException {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        session.update(student);
        transaction.commit();
        session.close();
        return true;
    }

    @Override
    public Student search(String s) throws SQLException, ClassNotFoundException {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        Student student = session.get(Student.class, s);
        transaction.commit();
        session.close();
        return student;
    }

    @Override
    public ArrayList<Student> getAll() throws SQLException, ClassNotFoundException {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        String hql = "FROM student";
        Query query = session.createQuery(hql);
        List<Student> list = query.list();

        transaction.commit();
        session.close();

        ArrayList<Student> students = new ArrayList<>();
        students.addAll(list);
        return students;
    }

    @Override
    public String createStudentId() throws SQLException, ClassNotFoundException {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        String hql = "SELECT studentId FROM student ORDER BY studentId DESC ";
        Query query = session.createQuery(hql);
        query.setMaxResults(1);
        List<String> list = query.list();

        transaction.commit();
        session.close();

        if (!list.isEmpty()) {
            int tempId = Integer.parseInt(list.get(0).split("-")[1]);
            tempId = tempId + 1;
            if (tempId <= 9) {
                return "ST-00" + tempId;
            } else if (tempId <= 99) {
                return "ST-0" + tempId;
            } else {
                return "ST-" + tempId;
            }
        } else {
            return "ST-001";
        }
    }

    @Override
    public ArrayList<String> getStudentIds() throws SQLException, ClassNotFoundException {
        return null;
    }
}
