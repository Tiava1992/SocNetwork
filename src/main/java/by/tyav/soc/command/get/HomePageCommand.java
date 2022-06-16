package by.tyav.soc.command.get;

import by.tyav.soc.Entity.User;
import by.tyav.soc.command.ICommand;
import by.tyav.soc.dao.DAOFactory;
import by.tyav.soc.dao.IUserDAO;
import com.mysql.cj.jdbc.MysqlConnectionPoolDataSource;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class HomePageCommand implements ICommand {

    private static IUserDAO userDAO;
    private static DAOFactory daoFactory;

    static {
        daoFactory=DAOFactory.getDAOFactory("MYSQL");
        userDAO=daoFactory.getUserDAO();
    }
    @Override
    public String execute(HttpServletRequest req, HttpServletResponse resp) {
        List<User> userList= null;
        try {
            userList = userDAO.findAll();
            userList.forEach(item -> System.out.println(item.getId() + " " + item.getName()));

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return "HomePage";
    }

    public static void main(String[] args) throws SQLException {


 /*       String username = "root";
		String password = "Vfvf2183102";
		String host = "localhost";
		String port = "3306";
		String dbName = "mydb";

		String url = String.format("jdbc:mysql://%s:%s/%s?characterEncoding=utf-8", host, port, dbName);

		MysqlConnectionPoolDataSource ds = new MysqlConnectionPoolDataSource();

		ds.setUrl(url);
		ds.setPassword(password);
		ds.setUser(username);

        Connection connection=ds.getConnection();
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
        userList.forEach(item -> System.out.println(item.getId() + " " + item.getName()));
*/

    }
}
