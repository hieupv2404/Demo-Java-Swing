package pm1.hieupv.service;

import pm1.hieupv.model.Class;

import java.sql.SQLException;
import java.util.List;

public interface ClassService {
    List<Class> selectClass(Integer id) throws SQLException;
    List<Class> findByProperty(Class aClass) throws SQLException;
    boolean save(Class aClass) throws SQLException;
    boolean update(Class aClass) throws SQLException;
    boolean delete(Class aClass) throws SQLException;

}
