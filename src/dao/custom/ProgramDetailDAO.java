package dao.custom;

import dao.CrudDAO;
import entity.ProgramDetail;

public interface ProgramDetailDAO extends CrudDAO<ProgramDetail, String> {
    boolean isExistStudent(String stId, String programId);
}
