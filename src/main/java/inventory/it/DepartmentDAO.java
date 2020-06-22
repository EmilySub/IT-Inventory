package inventory.it;

//Written by Emily Sublette for CBU Information Technology Dept
//Contact at em.sublette@gmail.com

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCallback;
import org.springframework.stereotype.Repository;
import javax.transaction.Transactional;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@Repository
@Transactional
public class DepartmentDAO {

    private final JdbcTemplate jdbcTemplate = new JdbcTemplate();


    // CRUD functions

    public boolean addDepartment(Department newDept){
        String add = "INSERT INTO Department VALUES (?,?,?)";

        // returns true if successfully inserted
        return jdbcTemplate.execute(add, new PreparedStatementCallback<Boolean>() {
            @Override
            // map attributes of the new department object to parameters in the sql statement
            public Boolean doInPreparedStatement(PreparedStatement statement)  throws SQLException, DataAccessException {
                    setStatement(newDept, statement);
                    return statement.execute();
            }
        });
    }

    // reduce duplicate code
    private void setStatement (Department dept, PreparedStatement statement) throws SQLException, DataAccessException {
        statement.setString(1, dept.getDepartmentNumber());
        statement.setString(2, dept.getDepartmentName());
        statement.setString(3, dept.getLocation());
    }

    public ResultSet getDepartmentByNumber(String departmentNumber){
        // no department number should be longer than 10
        if (departmentNumber.length() > 10){
            return null;
        }
        String get = "SELECT * FROM Department WHERE DepartmentNumber = ?";

        // the result set should only have 1 element at most
        return jdbcTemplate.execute(get, new PreparedStatementCallback<ResultSet>() {
            @Override
            public ResultSet doInPreparedStatement(PreparedStatement statement) throws SQLException, DataAccessException{
                statement.setString(1,departmentNumber);
                return statement.executeQuery();
            }
        });
    }


    public ResultSet getDepartmentByName(String departmentName){
        String get = "SELECT * FROM Department WHERE DepartmentName LIKE '%?%'";

        // all rows that contain some part of the searched string
        return jdbcTemplate.execute(get, new PreparedStatementCallback<ResultSet>() {
            @Override
            public ResultSet doInPreparedStatement(PreparedStatement statement) throws SQLException, DataAccessException{
                statement.setString(1, departmentName);
                return statement.executeQuery();

            }
        });
    }


    public ResultSet updateDepartment(Department updatedDept){
        String update = "UPDATE Department Set departmentName = ?, location = ? WHERE departmentNumber = ?";

        jdbcTemplate.execute(update, new PreparedStatementCallback<Boolean>() {
            @Override
            public Boolean doInPreparedStatement(PreparedStatement statement) throws SQLException, DataAccessException {
                setStatement(updatedDept, statement);
                return statement.execute();
            }
        });

        // return the updated info to make sure it was successful
        return getDepartmentByNumber(updatedDept.getDepartmentNumber());

    }

    public boolean deleteDepartment(String departmentNumber) throws SQLException {
        // no department number should be longer than 10
        if (departmentNumber.length() > 10){
            return false;
        }

        // if the department can't be found, don't try to delete it
        //resultSet.next() returns false if the pointer is after the last element
        if(!getDepartmentByNumber(departmentNumber).next()){
            return false;
        }

        String delete = "DELETE FROM Department WHERE departmentNumber = ?";

        // will return true if successfully deleted
        return jdbcTemplate.execute(delete, new PreparedStatementCallback<Boolean>() {
            @Override
            public Boolean doInPreparedStatement(PreparedStatement statement) throws SQLException, DataAccessException{
                statement.setString(1, departmentNumber);
                return statement.execute();
            }
        });

    }
}
