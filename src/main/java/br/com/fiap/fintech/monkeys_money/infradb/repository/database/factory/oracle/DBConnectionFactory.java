package br.com.fiap.fintech.monkeys_money.infradb.repository.database.factory.oracle;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

// Singleton DBConnectionFactory
public class DBConnectionFactory {

    private final String driverClassName = "oracle.jdbc.driver.OracleDriver";
    private final String connectionUrl = "jdbc:oracle:thin:@0.0.0.0:1521:orcl";
    private final String dbUser = "sys";
    private final String dbPwd = "My1passw";

    private static DBConnectionFactory dbConnectionFactory = null;

    private DBConnectionFactory() {
        try {
            Class.forName(driverClassName);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public Connection getConnection() throws SQLException {
        Connection conn = null;
        conn = DriverManager.getConnection(connectionUrl, dbUser, dbPwd);
        return conn;
    }

    public static DBConnectionFactory getInstance() {
        if (dbConnectionFactory == null) {
            dbConnectionFactory = new DBConnectionFactory();
        }
        return dbConnectionFactory;
    }
}
