package br.com.fiap.fintech.monkeys_money.infradb.repository;

import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import br.com.fiap.fintech.monkeys_money.cross.util.DateConverterHelper;
import br.com.fiap.fintech.monkeys_money.infradb.model.Expenditure;
import br.com.fiap.fintech.monkeys_money.infradb.model.User;
import br.com.fiap.fintech.monkeys_money.infradb.repository.iface.AbstractRepository;

public class ExpenditureRepository extends AbstractRepository<Expenditure> {

	@Override
	public Expenditure save(Expenditure expenditure) throws SQLException {
		try {

			StringBuffer sql = new StringBuffer("");

			sql.append("INSERT INTO expenditure(user_id, expenditure, description, amount, expenditure_at, created_at)");
			sql.append("VALUES(?,?,?,?,?,?)");

			preparedStatement = getPostgresConn().prepareStatement(sql.toString());
			preparedStatement.setLong(1, expenditure.getUser().getId());
			preparedStatement.setString(2, expenditure.getExpenditure());
			preparedStatement.setString(3, expenditure.getDescription());
			preparedStatement.setBigDecimal(4, expenditure.getAmount());
			preparedStatement.setDate(5,
					new java.sql.Date(DateConverterHelper.convertToDateUtil(expenditure.getExpenditureAt()).getTime()));
			preparedStatement.setDate(6,
					new java.sql.Date(DateConverterHelper.convertToDateUtil(expenditure.getCreateAt()).getTime()));

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
	public Expenditure update(Expenditure expenditure) {
		return null;
	}

	@Override
	public List<Expenditure> findMany(Map<String, Object> params) {
		return null;
	}

	final Expenditure findLast() {

		var expenditure = new Expenditure();

		try {
			StringBuffer sql = new StringBuffer("SELECT * FROM expenditure r WHERE r.id = (SELECT max(id) FROM expenditure)");

			preparedStatement = getPostgresConn().prepareStatement(sql.toString());

			resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {

				expenditure.setId(resultSet.getLong("id"));
				expenditure.setExpenditure(resultSet.getString("expenditure"));
				expenditure.setDescription(resultSet.getString("description"));
				expenditure.setExpenditureAt(
						DateConverterHelper.convertToLocalDateTime(resultSet.getDate("created_at").getTime()));
				expenditure.setCreateAt(
						DateConverterHelper.convertToLocalDateTime(resultSet.getDate("created_at").getTime()));

				if (resultSet.getDate("updated_at") != null) {
					expenditure.setUpdatedAt(
							DateConverterHelper.convertToLocalDateTime(resultSet.getDate("updated_at").getTime()));
				}

				var user = new User();
				user.setId(resultSet.getLong("user_id"));

				expenditure.setUser(user);

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

		return expenditure;
	}

	@Override
	public Expenditure findOne(Map<String, Object> params) {
		return null;
	}

	public List<Expenditure> findByLast30Days(final Long userId) {
		
		List<Expenditure> expenditures = new ArrayList<>();

		try {

			StringBuffer sql = new StringBuffer(
					"SELECT * FROM expenditure r WHERE r.expenditure_at BETWEEN ? AND ? AND r.user_id = ? ORDER BY r.expenditure_at ");

			preparedStatement = getPostgresConn().prepareStatement(sql.toString());

			var dateMinus30 = LocalDateTime.now(ZoneId.of("America/Sao_Paulo")).minusDays(30);
			var today = LocalDateTime.now(ZoneId.of("America/Sao_Paulo"));

			preparedStatement.setDate(1, new java.sql.Date(DateConverterHelper.convertToDateUtil(dateMinus30).getTime()));
			preparedStatement.setDate(2, new java.sql.Date(DateConverterHelper.convertToDateUtil(today).getTime()));
			preparedStatement.setLong(3, userId);
			
			resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {

				var expenditure = new Expenditure();

				expenditure.setId(resultSet.getLong("id"));
				expenditure.setExpenditure(resultSet.getString("expenditure"));
				expenditure.setDescription(resultSet.getString("description"));
				expenditure.setExpenditureAt(
						DateConverterHelper.convertToLocalDateTime(resultSet.getDate("created_at").getTime()));
				expenditure.setCreateAt(
						DateConverterHelper.convertToLocalDateTime(resultSet.getDate("created_at").getTime()));

				if (resultSet.getDate("updated_at") != null) {
					expenditure.setUpdatedAt(
							DateConverterHelper.convertToLocalDateTime(resultSet.getDate("updated_at").getTime()));
				}

				var user = new User();
				user.setId(resultSet.getLong("user_id"));

				expenditure.setUser(user);

				expenditures.add(expenditure);
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
		return expenditures;
	}
}
