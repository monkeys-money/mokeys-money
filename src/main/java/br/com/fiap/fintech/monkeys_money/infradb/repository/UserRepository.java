package br.com.fiap.fintech.monkeys_money.infradb.repository;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import br.com.fiap.fintech.monkeys_money.cross.util.DateConverterHelper;
import br.com.fiap.fintech.monkeys_money.infradb.model.User;
import br.com.fiap.fintech.monkeys_money.infradb.repository.iface.AbstractRepository;

public class UserRepository extends AbstractRepository<User> {

    @Override
    public User save(User user) throws SQLException {
        try {

            StringBuffer sql = new StringBuffer("");

            sql.append("INSERT INTO SYSTEM_USER(email, password, enabled, created_at)");
            sql.append("VALUES(?,?,?,?)");

            preparedStatement = getPostgresConn().prepareStatement(sql.toString());
            preparedStatement.setString(1, user.getEmail());
            preparedStatement.setString(2, user.getPassword());
            preparedStatement.setBoolean(3, user.getEnabled());
            preparedStatement.setDate(4, new java.sql.Date(DateConverterHelper.convertToDateUtil(user.getCreateAt()).getTime()));
            
            preparedStatement.executeUpdate();
            

        } catch (SQLException e) {
            throw e;
        } finally {

            //close prepareStatement
            if (preparedStatement != null) {
                preparedStatement.close();
            }

            //close connection
            if (getPostgresConn() != null) {
            	getPostgresConn().close();
            }
        }
        
        Map<String, Object> query = new HashMap<>();
        query.put("email", user.getEmail());

        return findOne(query);
    }

    @Override
    public Boolean delete(final Long id) {
        return null;
    }

    @Override
    public User update(User user) {
        return null;
    }

    @Override
    public List<User> findMany(Map<String, Object> params) {
        throw new UnsupportedOperationException("This operation is not supported to Login");
    }

    @Override
    public User findOne(Map<String, Object> params) {
    	
    	 var user = new User();

         try {
             StringBuffer sql = new StringBuffer("SELECT * FROM system_user u WHERE u.email = ?");

             preparedStatement = getPostgresConn().prepareStatement(sql.toString());
             
             for (Map.Entry<String, Object> pair : params.entrySet()) {
            	 if (pair.getValue() instanceof String) {
                	 preparedStatement.setString(1, (String) pair.getValue()); 
            	 }
             }
             
             
             resultSet = preparedStatement.executeQuery();

             while (resultSet.next()) {
                 user.setId(resultSet.getLong("id"));
                 user.setEmail(resultSet.getString("email"));
                 user.setEnabled(resultSet.getBoolean("enabled"));
                 user.setCreateAt(DateConverterHelper.convertToLocalDateTime(resultSet.getDate("created_at").getTime()));
                 
                 if(resultSet.getDate("updated_at") != null){
                     user.setUpdatedAt(DateConverterHelper.convertToLocalDateTime(resultSet.getDate("updated_at").getTime()));
                 }
             }
         } catch (SQLException e) {
             e.printStackTrace();
         } finally {
             try {
                 //close resultSet
                 if(resultSet != null) {
                	 resultSet.close();
                 }

                 //close prepareStatement
                 if (preparedStatement != null) {
                	 preparedStatement.close();
                 }

                 //close connection
                 if (getPostgresConn() != null) {
                 	getPostgresConn().close();
                 }
             } catch (SQLException e) {
                 e.printStackTrace();
             } catch (Exception e) {
                 e.printStackTrace();
             }
         }

         return user;
    }
}
