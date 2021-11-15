package pm1.hieupv.dao;

import pm1.hieupv.model.Class;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ClassDAO {
    private Connection connection;
    private List<Class> classList;


    public ClassDAO(Connection connection) {
        this.connection = connection;
        this.classList = new ArrayList<>();
    }

    public List<Class> findAll() throws SQLException {
        classList = new ArrayList<>();
        String sql = "select * from class";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while(resultSet.next())
                {
                    Class aClass = new Class();
                    aClass.setMsl(resultSet.getString("msl"));
                    aClass.setName(resultSet.getString("name"));
                    aClass.setGvcn(resultSet.getString("gvcn"));
                    classList.add(aClass);
                }
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        finally {
        }
        return classList;
    }

    public List<Class> findByRow(Integer index) throws SQLException {
        String sql = "select * from class";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
              while (resultSet.next())
              {
                  Class aClass = new Class();
                  aClass.setMsl(resultSet.getString("msl"));
                  aClass.setName(resultSet.getString("name"));
                  aClass.setGvcn(resultSet.getString("gvcn"));
                  classList.add(aClass);
              }
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        finally {

        }
        return classList;
    }


    public boolean save(Class aClass) throws SQLException {
        String sql = "select msl from class where msl=?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1,aClass.getMsl());
        ResultSet resultSet = preparedStatement.executeQuery();
        String msl ="";
        while(resultSet.next()) {
            msl = resultSet.getString("msl");
        }

        if(msl.equals("")) {

            sql = "insert into class (msl,name,gvcn)" +
                    "values (?,?,?)";
            preparedStatement = connection.prepareStatement(sql);
//        preparedStatement.setInt(1,maxID+1);
            preparedStatement.setString(1, aClass.getMsl());
            preparedStatement.setString(2, aClass.getName());
            preparedStatement.setString(3, aClass.getGvcn());

            return preparedStatement.execute();
        }
        else{
            return preparedStatement.execute();
        }
    }

    public boolean update(Class aClass) throws SQLException {
        String sql = "select msl from class where msl=?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, aClass.getMsl());
        ResultSet resultSet = preparedStatement.executeQuery();
        String temp = "";
        while (resultSet.next())
        {
            temp = resultSet.getString("msl");
        }
        if(!temp.equals("")) {
            sql = "update class set name=?, gvcn=? where msl=?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, aClass.getName());
            preparedStatement.setString(2, aClass.getGvcn());
            preparedStatement.setString(3, aClass.getMsl());
            return preparedStatement.execute();
        }
        else {
            return preparedStatement.execute();
        }
    }

    public boolean delete(Class aClass) throws SQLException {
        String sql = "delete from class where msl=?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, aClass.getMsl());
        return preparedStatement.execute();
    }

    public List<Class> findByProperty(Class aClass) throws SQLException {
        classList = new ArrayList<>();
        int check=1, search=1;
            String sqlAppend = "";
            StringBuilder sql = new StringBuilder("select * from class where ");

            if(!aClass.getMsl().equals("")){
                sqlAppend="msl like '%"+ aClass.getMsl()+"%'";
                sql.append(sqlAppend);
                if(!aClass.getGvcn().equals("")){
                    sqlAppend =" and gvcn like '%"+ aClass.getGvcn()+"%'";
                    sql.append(sqlAppend);
                }
                if(!aClass.getName().equals("")){
                    sqlAppend =" and name like '%"+ aClass.getName()+"%'";
                    sql.append(sqlAppend);
                }
                check=0;
                search=0;
            }

            if(!aClass.getName().equals("") && check==1){
                sqlAppend="name like '%"+ aClass.getName()+"%'";
                sql.append(sqlAppend);

                if(!aClass.getGvcn().equals("")){
                    sqlAppend =" and gvcn like '%"+ aClass.getGvcn()+"%'";
                    sql.append(sqlAppend);
                }
                check=0;
                search=0;
            }
            if(!aClass.getGvcn().equals("") && check==1){
                sqlAppend="gvcn like '%"+ aClass.getGvcn()+"%'";
                sql.append(sqlAppend);
                check=0;
                search=0;
            }
                if (search==1)
                {
                    sqlAppend="name like '%%'";
                    sql.append(sqlAppend);
                }
                PreparedStatement preparedStatement = connection.prepareStatement(String.valueOf(sql));
                ResultSet resultSet = preparedStatement.executeQuery();
                while (resultSet.next()){
                    Class class1 = new Class();
                    class1.setMsl(resultSet.getString("msl"));
                    class1.setName(resultSet.getString("name"));
                    class1.setGvcn(resultSet.getString("gvcn"));
                    classList.add(class1);
                }
        return classList;
    }
}
