package br.com.fiap.fintech.monkeys_money.infradb.repository.iface;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.com.fiap.fintech.monkeys_money.infradb.repository.database.factory.postgres.PostgresFactory;

public abstract class AbstractRepository<T> implements Repository<T> {

    protected PreparedStatement preparedStatement = null;
    protected ResultSet resultSet = null;

    public Connection getPostgresConn() throws SQLException {
    	return PostgresFactory.getConnection();
    }
    
}
