package inventory.it;

//Written by Emily Sublette for CBU Information Technology Dept
//Contact at emilyl.sublette@calbaptist.edu

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;

@Entity
@Table(name = "Department")
@EntityListeners(AuditingEntityListener.class)

public class Department {

    // department table mapping info

    @Id
    @Column(name = "departmentNumber", nullable = false)
    private String departmentNumber;

    @Column(name = "departmentName", nullable = false)
    private String departmentName;

    // will refer to the location of te department secretary desk
    @Column(name = "location", nullable = false)
    private String location;

    // getters and setters

    public String getDepartmentNumber() {
        return departmentNumber;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public String getLocation() {
        return location;
    }

    public void setDepartmentNumber(String departmentNumber) {
        this.departmentNumber = departmentNumber;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}

