package pm1.hieupv.service.impl;

import pm1.hieupv.dao.JDBCConnector;
import pm1.hieupv.dao.ClassDAO;
import pm1.hieupv.model.Class;
import pm1.hieupv.service.ClassService;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ClassServiceImpl implements ClassService {
    private JDBCConnector jdbcConnector = new JDBCConnector();
    private Connection connection = jdbcConnector.getConnection();
    private ClassDAO classDAO = new ClassDAO(connection);

    public ClassServiceImpl() throws SQLException {
    }

    public List<Class> findAll() throws SQLException {
        return classDAO.findAll();
    }

    public List<Class> selectClass(Integer index) throws SQLException {
        return classDAO.findByRow(index);
    }

    public boolean save(Class aClass) throws SQLException {
        return classDAO.save(aClass);
    }

    public boolean update(Class aClass) throws SQLException {
        return classDAO.update(aClass);
    }

    public boolean delete(Class aClass) throws SQLException {
        return classDAO.delete(aClass);
    }

    @Override
    public List<Class> findByProperty(Class aClass) throws SQLException {
        return classDAO.findByProperty(aClass);
    }



}
