package dao.custom;

import dao.SuperDAO;
import dto.CustomDTO;

import java.util.ArrayList;
import java.util.List;

public interface QueryDAO extends SuperDAO {
    List<Object[]> getAllRegisteredStudent(String id);
}
