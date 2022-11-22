package br.com.fiap.fintech.monkeys_money.infradb.repository.database.factory.postgres;

import java.sql.Connection;
import java.sql.SQLException;

import org.postgresql.ds.PGConnectionPoolDataSource;

public class PostgresFactory {

	private static Connection connection;
	private static PGConnectionPoolDataSource dataSource;
	
	private static void createConnectionPool() {
		PGConnectionPoolDataSource pool = new PGConnectionPoolDataSource();
		pool.setUrl("jdbc:postgresql://0.0.0.0/monkeysmoney");
		pool.setUser("monkeys");
		pool.setPassword("money");
		dataSource = pool;
	}

	public static Connection getConnection() throws SQLException {

		if (dataSource == null) {
			createConnectionPool();
		}

		if (connection == null || connection.isClosed()) {
			// connection = DriverManager.getConnection("jdbc:postgresql://0.0.0.0:5432/alura",
			// "postgres", "postgres");
			connection = dataSource.getConnection();
			connection.setAutoCommit(true);
		}

		return connection;

	}

}
