package inventory.it;

//Written by Emily Sublette for CBU Information Technology Dept
//Contact at emilyl.sublette@calbaptist.edu

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;

@Entity
@Table(name = "user")
@EntityListeners(AuditingEntityListener.class)

public class User {

    // user table mapping info

    @Id
    @Column(name="username", nullable = false)
    private String username;

    @Column(name = "name", nullable = false)
    private String fullName;

    @Column(name = "emailAddress", nullable = false)
    private String emailAddress;

    // if they do not have a phone, the department secretary's extension will be linked
    @Column(name = "PhoneExt", nullable = false)
    private int phoneExt;

    @Column(name = "location", nullable = false)
    private String location;

    @Column(name = "department", nullable = false)
    private String department;

    // constructors

    public User(String username, String fullName, String emailAddress, int phoneExt, String location, String department) {
        this.username = username;
        this.fullName = fullName;
        this.emailAddress = emailAddress;
        this.phoneExt = phoneExt;
        this.location = location;
        this.department = department;
    }

    // no arg - modify later if needed
    public User() {
    }

    // getters/setters

    public String getUsername(){
        return username;
    }

    public String getFullName() {
        return fullName;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public int getPhoneExt() {
        return phoneExt;
    }

    public String getLocation() {
        return location;
    }

    public String getDepartment() {
        return department;
    }

    public void setUsername(String username){
        this.username = username;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public void setPhoneExt(int phoneExt) {
        this.phoneExt = phoneExt;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setDepartment(String department) {
        this.department = department;
    }


}
