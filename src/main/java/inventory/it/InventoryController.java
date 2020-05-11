package inventory.it;

//Written by Emily Sublette for CBU Information Technology Dept
//Contact at emilyl.sublette@calbaptist.edu

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@RestController
public class InventoryController {

    // DAOs
    private final DepartmentDAO department = new DepartmentDAO();


    // Requests

    // Department
    @RequestMapping(value = "/addDepartment", method = RequestMethod.POST)
    public boolean addDepartment(@RequestBody Department newDepartment) {
        return department.addDepartment(newDepartment);
    }

    @RequestMapping(value = "/getDepartmentByNumber", method = RequestMethod.GET)
    public Department getDepartmentByNumber(@RequestBody String departmentNumber) {
        ResultSet result = department.getDepartmentByNumber(departmentNumber);
        try{
            // if the resultSet is empty
            if(!result.next()){
                return null;
            }
            // verify pointer is at the beginning of the resultSet
            result.beforeFirst();
            return new Department(result.getString("departmentNumber"), result.getString("departmentName"),
                    result.getString("location"));
        } catch(SQLException e){
            return null;
        }
    }

    @RequestMapping(value = "/getDepartmentByName", method = RequestMethod.GET)
    public List<Department> getDepartmentByName(@RequestBody String departmentName) {
        ResultSet results = department.getDepartmentByName(departmentName);
        List<Department> departments = new ArrayList<>();
        try{
            // if resultSet is empty
            if(!results.next()){
                return null;
            }
            // verify pointer is at the beginning
            results.beforeFirst();
            while(results.next()){
                departments.add(new Department(results.getString("departmentNumber"),results.getString("departmentName"),
                        results.getString("location")));
            }
            return departments;
        }catch (SQLException e){
            return null;
        }
    }

    @RequestMapping(value = "/updateDepartment", method = RequestMethod.PUT)
    public Department updateDepartment(@RequestBody Department newDept) {
        ResultSet result = department.updateDepartment(newDept);

        try{
            // if the result set is empty
            if(!result.next()){
                return null;
            }
            // verify pointer is at the beginning
            return new Department(result.getString("departmentNumber"), result.getString("departmentName"),
                    result.getString("location"));
        } catch (SQLException e){
            return null;
        }
    }

    @RequestMapping(value = "/deleteDepartment", method = RequestMethod.DELETE)
    public boolean deleteDepartment(@RequestBody String departmentNumber) {
        try {
            return department.deleteDepartment(departmentNumber);
        } catch (SQLException e){
            return false;
        }

    }




}
