package by.tyav.soc.dao.sql;

import by.tyav.soc.Entity.User;
import by.tyav.soc.dao.DAOFactory;
import by.tyav.soc.dao.IUserDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SqlUserDAO implements IUserDAO {

    private static SqlUserDAO instance;
    private static DAOFactory daoFactory;

    static {
        daoFactory=DAOFactory.getDAOFactory("MYSQL");
    }

    public static IUserDAO getInstance(){
        if(instance==null){
            instance=new SqlUserDAO();
        }
        return instance;
    }
    @Override
    public User findByName(String name) {
        return null;
    }

    @Override
    public List<User> findAll() throws SQLException {
        Connection connection=daoFactory.getConnection();
        List<User> userList=new ArrayList<>();
        PreparedStatement ps=null;
        ResultSet rs=null;
        try{
            ps=connection.prepareStatement("SELECT *FROM users");
            rs=ps.executeQuery();
            while(rs.next()){
                User user=new User();
                user.setId(rs.getInt("id"));
                user.setName(rs.getString("name"));
                userList.add(user);
            }
        } finally {
            ps.close();
            rs.close();
            connection.close();
        }
            return userList;
    }
}
