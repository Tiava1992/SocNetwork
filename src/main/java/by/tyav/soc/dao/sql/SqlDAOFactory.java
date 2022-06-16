package by.tyav.soc.dao.sql;

import by.tyav.soc.Entity.User;
import by.tyav.soc.dao.DAOFactory;
import by.tyav.soc.dao.IUserDAO;
import com.mysql.cj.jdbc.MysqlConnectionPoolDataSource;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SqlDAOFactory extends DAOFactory {

    private static SqlDAOFactory instance;
    private  MysqlConnectionPoolDataSource ds = new MysqlConnectionPoolDataSource();

    private SqlDAOFactory(){
        String username = "root";
        String password = "Vfvf2183102";
        String host = "localhost";
        String port = "3306";
        String dbName = "mydb";

        String url = String.format("jdbc:mysql://%s:%s/%s?characterEncoding=utf-8", host, port, dbName);
        ds.setUrl(url);
        ds.setPassword(password);
        ds.setUser(username);
    }


    public static DAOFactory getInstance() {
        if(instance==null){
            instance=new SqlDAOFactory();
        }
        return instance;
    }

    @Override
    public IUserDAO getUserDAO() {
        return SqlUserDAO.getInstance();
    }

/*    @Override
    public IMessageDAO getMessageDAO() {
        return null;
    }*/

    @Override
    public Connection getConnection() {
        try{
            return ds.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
}
