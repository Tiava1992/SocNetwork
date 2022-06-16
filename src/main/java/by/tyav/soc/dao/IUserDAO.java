package by.tyav.soc.dao;

import by.tyav.soc.Entity.User;

import java.sql.SQLException;
import java.util.List;

public interface IUserDAO {
    User findByName (String name) throws SQLException;
    List<User> findAll() throws SQLException;

}
