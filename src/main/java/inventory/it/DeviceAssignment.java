package inventory.it;

//Written by Emily Sublette for CBU Information Technology Dept
//Contact at emilyl.sublette@calbaptist.edu

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;

@Entity
@Table(name = "DeviceAssignment")
@EntityListeners(AuditingEntityListener.class)

public class DeviceAssignment {

    // device assignment table mapping info

    @Id
    @Column(name = "CBUNumber", nullable = false)
    private String CBUNumber;

    @Column(name = "departmentNumber", nullable = false)
    private String departmentNumber;

    // device can be assigned to a department rather than a user, so this can be null
    @Column(name = "username")
    private String username;

    // getters/setters

    public String getCBUNumber() {
        return CBUNumber;
    }

    public String getDepartmentNumber() {
        return departmentNumber;
    }

    public String getUsername() {
        return username;
    }

    public void setCBUNumber(String CBUNumber) {
        this.CBUNumber = CBUNumber;
    }

    public void setDepartmentNumber(String departmentNumber) {
        this.departmentNumber = departmentNumber;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
