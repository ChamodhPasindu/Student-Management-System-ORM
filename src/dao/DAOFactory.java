package dao;

import bo.custom.impl.StudentBOImpl;
import dao.custom.ProgramDetailDAO;
import dao.custom.impl.ProgramDAOImpl;
import dao.custom.impl.ProgramDetailDAOImpl;
import dao.custom.impl.QueryDAOImpl;
import dao.custom.impl.StudentDAOImpl;

public class DAOFactory {
    private static DAOFactory daoFactory;

    public DAOFactory() {
    }

    public static DAOFactory getDaoFactory() {
        if (daoFactory == null) {
            daoFactory = new DAOFactory();
        }
        return daoFactory;
    }

    public SuperDAO getDAO(DAOTypes types) {
        switch (types) {
            case STUDENT:
                return new StudentDAOImpl();
            case PROGRAM:
                return new ProgramDAOImpl();
            case PROGRAMDETAIL:
                return new ProgramDetailDAOImpl();
            case QUERYDAO:
                return new QueryDAOImpl();
            default:
                return null;
        }
    }


    public enum DAOTypes {
        STUDENT, PROGRAM, PROGRAMDETAIL, QUERYDAO;
    }
}
