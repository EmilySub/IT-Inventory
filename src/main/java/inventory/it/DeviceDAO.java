package inventory.it;

//Written by Emily Sublette for CBU Information Technology Dept
//Contact at emilyl.sublette@calbaptist.edu

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCallback;
import org.springframework.stereotype.Repository;
import javax.transaction.Transactional;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@Repository
@Transactional
public class DeviceDAO {

    JdbcTemplate jdbcTemplate = new JdbcTemplate();

    // CRUD functions

    public boolean addDevice(Device newDevice){

        String add = "INSERT INTO Device VALUES (?,?,?,?,?,?)";

        return jdbcTemplate.execute(add, new PreparedStatementCallback<Boolean>() {
            @Override
            // map attributes of the new device object to parameters in the sql statement
            public Boolean doInPreparedStatement(PreparedStatement statement)  throws SQLException, DataAccessException {
                setStatement(newDevice, statement);
                return statement.execute();
            }
        });
    }


    public ResultSet getDeviceByCBUNumber(String CBUNumber){

        String get = "SELECT * FROM Device WHERE CBUNumber = ?";

        return jdbcTemplate.execute(get, new PreparedStatementCallback<ResultSet>() {
            @Override
            public ResultSet doInPreparedStatement(PreparedStatement statement) throws SQLException, DataAccessException {
                statement.setString(1, CBUNumber);
                return statement.executeQuery();
            }
        });
    }


    // reduce duplicate code
    private void setStatement (Device device, PreparedStatement statement) throws SQLException, DataAccessException{
        statement.setString(1, device.getCBUNumber());
        statement.setString(2, device.getSerialNumber());
        statement.setString(3, device.getMake());
        statement.setString(4, device.getModel());
        statement.setDate(5, device.getWarrantyExpDate());
        statement.setDate(6, device.getPurchaseDate());
    }





    public ResultSet updateDevice(Device updatedDevice){

        String update = "UPDATE Device SET CBUNumber = ?, serialNumber = ?, make = ?, " +
                "model = ?, warrantyExpDate = ?, purchaseDate = ? WHERE CBUNumber = ?";


        jdbcTemplate.execute(update,new PreparedStatementCallback<Boolean>(){
            @Override
            public Boolean doInPreparedStatement(PreparedStatement statement) throws SQLException, DataAccessException {
                setStatement(updatedDevice, statement);
                statement.setString(7, updatedDevice.getCBUNumber());
                return statement.execute();
            }
        });

        return getDeviceByCBUNumber(updatedDevice.getCBUNumber());

    }

    public boolean deleteDevice(String CBUNumber) throws SQLException {
        if (CBUNumber.length() > 10){
            return false;
        }

        // resultSet.next returns false if pointer is after last element
        // shows if resultSet is empty or not
        if(!getDeviceByCBUNumber(CBUNumber).next()){
            return false;
        }

        String delete = "DELETE FROM Device WHERE CBUNumber = ?";

        // will return true if successfully deleted
        return jdbcTemplate.execute(delete, new PreparedStatementCallback<Boolean>() {
            @Override
            public Boolean doInPreparedStatement(PreparedStatement statement) throws SQLException, DataAccessException{
                statement.setString(1, CBUNumber);
                return statement.execute();
            }
        });


    }










}
