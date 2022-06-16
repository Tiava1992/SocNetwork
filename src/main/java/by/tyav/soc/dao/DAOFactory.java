package by.tyav.soc.dao;

import by.tyav.soc.dao.sql.SqlDAOFactory;

import java.sql.Connection;

public abstract class DAOFactory {

    public static DAOFactory getDAOFactory(String db){
        switch (db){
            case "MYSQL":
                return SqlDAOFactory.getInstance();
            default:
                throw new IllegalArgumentException();
        }
    }

    public abstract IUserDAO getUserDAO();
  //  public abstract IMessageDAO getMessageDAO();
    public abstract Connection getConnection();
}
