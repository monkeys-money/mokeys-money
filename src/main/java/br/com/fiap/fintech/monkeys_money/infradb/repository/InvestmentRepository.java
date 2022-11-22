package br.com.fiap.fintech.monkeys_money.infradb.repository;

import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import br.com.fiap.fintech.monkeys_money.cross.util.DateConverterHelper;
import br.com.fiap.fintech.monkeys_money.infradb.model.Investment;
import br.com.fiap.fintech.monkeys_money.infradb.model.User;
import br.com.fiap.fintech.monkeys_money.infradb.repository.iface.AbstractRepository;

public class InvestmentRepository extends AbstractRepository<Investment> {

	@Override
	public Investment save(Investment investment) throws SQLException {
		try {

			StringBuffer sql = new StringBuffer("");

			sql.append("INSERT INTO investment(user_id, investment, description, amount, investment_at, created_at)");
			sql.append("VALUES(?,?,?,?,?,?)");

			preparedStatement = getPostgresConn().prepareStatement(sql.toString());
			preparedStatement.setLong(1, investment.getUser().getId());
			preparedStatement.setString(2, investment.getInvestment());
			preparedStatement.setString(3, investment.getDescription());
			preparedStatement.setBigDecimal(4, investment.getAmount());
			preparedStatement.setDate(5,
					new java.sql.Date(DateConverterHelper.convertToDateUtil(investment.getInvestmentAt()).getTime()));
			preparedStatement.setDate(6,
					new java.sql.Date(DateConverterHelper.convertToDateUtil(investment.getCreateAt()).getTime()));

			preparedStatement.executeUpdate();

		} catch (SQLException e) {
			throw e;
		} finally {

			// close prepareStatement
			if (preparedStatement != null) {
				preparedStatement.close();
			}

			// close connection
			if (getPostgresConn() != null) {
				getPostgresConn().close();
			}
		}

		return findLast();
	}

	@Override
	public Boolean delete(Long id) {
		return null;
	}

	@Override
	public Investment update(Investment investment) {
		return null;
	}

	@Override
	public List<Investment> findMany(Map<String, Object> params) {
		return null;
	}

	final Investment findLast() {

		var investment = new Investment();

		try {
			StringBuffer sql = new StringBuffer("SELECT * FROM investment r WHERE r.id = (SELECT max(id) FROM investment)");

			preparedStatement = getPostgresConn().prepareStatement(sql.toString());

			resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {

				investment.setId(resultSet.getLong("id"));
				investment.setInvestment(resultSet.getString("investment"));
				investment.setDescription(resultSet.getString("description"));
				investment.setInvestmentAt(
						DateConverterHelper.convertToLocalDateTime(resultSet.getDate("created_at").getTime()));
				investment.setCreateAt(
						DateConverterHelper.convertToLocalDateTime(resultSet.getDate("created_at").getTime()));

				if (resultSet.getDate("updated_at") != null) {
					investment.setUpdatedAt(
							DateConverterHelper.convertToLocalDateTime(resultSet.getDate("updated_at").getTime()));
				}

				var user = new User();
				user.setId(resultSet.getLong("user_id"));

				investment.setUser(user);

			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				// close resultSet
				if (resultSet != null) {
					resultSet.close();
				}

				// close prepareStatement
				if (preparedStatement != null) {
					preparedStatement.close();
				}

				// close connection
				if (getPostgresConn() != null) {
					getPostgresConn().close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		return investment;
	}

	@Override
	public Investment findOne(Map<String, Object> params) {
		return null;
	}

	public List<Investment> findByLast30Days(final Long userId) {
		
		List<Investment> investments = new ArrayList<>();

		try {

			StringBuffer sql = new StringBuffer(
					"SELECT * FROM investment r WHERE r.investment_at BETWEEN ? AND ? AND r.user_id = ? ORDER BY r.investment_at ");

			preparedStatement = getPostgresConn().prepareStatement(sql.toString());

			var dateMinus30 = LocalDateTime.now(ZoneId.of("America/Sao_Paulo")).minusDays(30);
			var today = LocalDateTime.now(ZoneId.of("America/Sao_Paulo"));

			preparedStatement.setDate(1, new java.sql.Date(DateConverterHelper.convertToDateUtil(dateMinus30).getTime()));
			preparedStatement.setDate(2, new java.sql.Date(DateConverterHelper.convertToDateUtil(today).getTime()));
			preparedStatement.setLong(3, userId);
			
			resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {

				var investment = new Investment();

				investment.setId(resultSet.getLong("id"));
				investment.setInvestment(resultSet.getString("investment"));
				investment.setDescription(resultSet.getString("description"));
				investment.setInvestmentAt(
						DateConverterHelper.convertToLocalDateTime(resultSet.getDate("created_at").getTime()));
				investment.setCreateAt(
						DateConverterHelper.convertToLocalDateTime(resultSet.getDate("created_at").getTime()));

				if (resultSet.getDate("updated_at") != null) {
					investment.setUpdatedAt(
							DateConverterHelper.convertToLocalDateTime(resultSet.getDate("updated_at").getTime()));
				}

				var user = new User();
				user.setId(resultSet.getLong("user_id"));

				investment.setUser(user);

				investments.add(investment);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				// close resultSet
				if (resultSet != null) {
					resultSet.close();
				}

				// close prepareStatement
				if (preparedStatement != null) {
					preparedStatement.close();
				}

				// close connection
				if (getPostgresConn() != null) {
					getPostgresConn().close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return investments;
	}
}
