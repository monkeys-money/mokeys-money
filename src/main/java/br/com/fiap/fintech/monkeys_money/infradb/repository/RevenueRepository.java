package br.com.fiap.fintech.monkeys_money.infradb.repository;

import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import br.com.fiap.fintech.monkeys_money.cross.util.DateConverterHelper;
import br.com.fiap.fintech.monkeys_money.infradb.model.Revenue;
import br.com.fiap.fintech.monkeys_money.infradb.model.User;
import br.com.fiap.fintech.monkeys_money.infradb.repository.iface.AbstractRepository;

public class RevenueRepository extends AbstractRepository<Revenue> {

	@Override
	public Revenue save(Revenue revenue) throws SQLException {
		try {

			StringBuffer sql = new StringBuffer("");

			sql.append("INSERT INTO REVENUE(user_id, revenue, description, amount, revenue_at, created_at)");
			sql.append("VALUES(?,?,?,?,?,?)");

			preparedStatement = getPostgresConn().prepareStatement(sql.toString());
			preparedStatement.setLong(1, revenue.getUser().getId());
			preparedStatement.setString(2, revenue.getRevenue());
			preparedStatement.setString(3, revenue.getDescription());
			preparedStatement.setBigDecimal(4, revenue.getAmount());
			preparedStatement.setDate(5,
					new java.sql.Date(DateConverterHelper.convertToDateUtil(revenue.getRevenueAt()).getTime()));
			preparedStatement.setDate(6,
					new java.sql.Date(DateConverterHelper.convertToDateUtil(revenue.getCreateAt()).getTime()));

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
	public Revenue update(Revenue revenue) {
		return null;
	}

	@Override
	public List<Revenue> findMany(Map<String, Object> params) {
		return null;
	}

	final Revenue findLast() {

		var revenue = new Revenue();

		try {
			StringBuffer sql = new StringBuffer("SELECT * FROM revenue r WHERE r.id = (SELECT max(id) FROM revenue)");

			preparedStatement = getPostgresConn().prepareStatement(sql.toString());

			resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {

				revenue.setId(resultSet.getLong("id"));
				revenue.setRevenue(resultSet.getString("revenue"));
				revenue.setDescription(resultSet.getString("description"));
				revenue.setRevenueAt(
						DateConverterHelper.convertToLocalDateTime(resultSet.getDate("created_at").getTime()));
				revenue.setCreateAt(
						DateConverterHelper.convertToLocalDateTime(resultSet.getDate("created_at").getTime()));

				if (resultSet.getDate("updated_at") != null) {
					revenue.setUpdatedAt(
							DateConverterHelper.convertToLocalDateTime(resultSet.getDate("updated_at").getTime()));
				}

				var user = new User();
				user.setId(resultSet.getLong("user_id"));

				revenue.setUser(user);

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

		return revenue;
	}

	@Override
	public Revenue findOne(Map<String, Object> params) {
		return null;
	}

	public List<Revenue> findByLast30Days(final Long userId) {
		List<Revenue> revenues = new ArrayList<>();

		try {

			StringBuffer sql = new StringBuffer(
					"SELECT * FROM revenue r WHERE r.revenue_at BETWEEN ? AND ? AND r.user_id = ? ORDER BY r.revenue_at ");

			preparedStatement = getPostgresConn().prepareStatement(sql.toString());

			var dateMinus30 = LocalDateTime.now(ZoneId.of("America/Sao_Paulo")).minusDays(30);
			var today = LocalDateTime.now(ZoneId.of("America/Sao_Paulo"));

			preparedStatement.setDate(1, new java.sql.Date(DateConverterHelper.convertToDateUtil(dateMinus30).getTime()));
			preparedStatement.setDate(2, new java.sql.Date(DateConverterHelper.convertToDateUtil(today).getTime()));
			preparedStatement.setLong(3, userId);
			
			resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {

				var revenue = new Revenue();

				revenue.setId(resultSet.getLong("id"));
				revenue.setRevenue(resultSet.getString("revenue"));
				revenue.setDescription(resultSet.getString("description"));
				revenue.setRevenueAt(
						DateConverterHelper.convertToLocalDateTime(resultSet.getDate("created_at").getTime()));
				revenue.setCreateAt(
						DateConverterHelper.convertToLocalDateTime(resultSet.getDate("created_at").getTime()));

				if (resultSet.getDate("updated_at") != null) {
					revenue.setUpdatedAt(
							DateConverterHelper.convertToLocalDateTime(resultSet.getDate("updated_at").getTime()));
				}

				var user = new User();
				user.setId(resultSet.getLong("user_id"));

				revenue.setUser(user);

				revenues.add(revenue);
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
		return revenues;
	}
}
