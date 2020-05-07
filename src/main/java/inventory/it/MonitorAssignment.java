package inventory.it;

//Written by Emily Sublette for CBU Information Technology Dept
//Contact at emilyl.sublette@calbaptist.edu

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;

@Entity
@Table(name = "MonitorAssignment")
@EntityListeners(AuditingEntityListener.class)

// monitors are less important to the org, so just keeping track of how many of each model a department has
public class MonitorAssignment {

    // monitoraAssignment table mapping info

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "model")
    private String model;

    @Column(name = "departmentNumber")
    private String departmentNumber;

    @Column(name = "count")
    private int count;

    // getters/setters

    public int getId() {
        return id;
    }

    public String getModel() {
        return model;
    }

    public String getDepartmentNumber() {
        return departmentNumber;
    }

    public int getCount() {
        return count;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setDepartmentNumber(String departmentNumber) {
        this.departmentNumber = departmentNumber;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
