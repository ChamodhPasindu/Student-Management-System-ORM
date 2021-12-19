package dao.custom.impl;

import dao.SuperDAO;
import dao.custom.QueryDAO;
import dto.CustomDTO;
import entity.Program;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import util.FactoryConfiguration;

import java.util.ArrayList;
import java.util.List;

public class QueryDAOImpl implements QueryDAO {
    @Override
    public List<Object[]> getAllRegisteredStudent(String id) {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        Program program = session.load(Program.class, id);

        String hql = "SELECT s.studentId,s.studentName, s.address,s.nic,s.mobile,p.date FROM student s JOIN program_detail p" +
                " ON s.studentId=p.student WHERE p.program=:program_id";
        Query query = session.createQuery(hql);
        query.setParameter("program_id",program);
        List<Object[]> list = query.list();
        return list;
    }
}
