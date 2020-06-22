package inventory.it;

//Written by Emily Sublette for CBU Information Technology Dept
//Contact at em.sublette@gmail.com

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;

@Entity
@Table(name = "MonitorAssignment")
@EntityListeners(AuditingEntityListener.class)

// monitors are less important to the org, so just keeping track of how many of each model a department has
public class MonitorAssignment {

    // monitorAssignment table mapping info

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "model", nullable = false)
    private String model;

    @Column(name = "departmentNumber", nullable = false)
    private String departmentNumber;

    @Column(name = "count", nullable = false)
    private int count;

    // constructors

    public MonitorAssignment(int id, String model, String departmentNumber, int count) {
        this.id = id;
        this.model = model;
        this.departmentNumber = departmentNumber;
        if (count < 1){
            this.count = 0;
        }
        else{
            this.count = count;
        }
    }

    // no arg - modify later if needed
    public MonitorAssignment() {
    }


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
