package inventory.it;

//Written by Emily Sublette for CBU Information Technology Dept
//Contact at emilyl.sublette@calbaptist.edu

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "Device")
@EntityListeners(AuditingEntityListener.class)

public class Device {

    // device table mapping info

    @Id
    @Column(name = "CBUNumber", nullable = false)
    private String CBUNumber;

    @Column(name = "SerialNumber", nullable = false)
    private String Serialnumber;

    @Column(name = "Make", nullable = false)
    private String make;

    @Column(name = "Model", nullable = false)
    private String model;

    @Column(name = "WarrantyExpDate")
    private Date warrantyExpDate;

    @Column(name = "PurchaseDate", nullable = false)
    private Date purchaseDate;

    // getters/setters

    public String getCBUNumber() {
        return CBUNumber;
    }

    public String getSerialnumber() {
        return Serialnumber;
    }

    public String getMake() {
        return make;
    }

    public String getModel() {
        return model;
    }

    public Date getWarrantyExpDate() {
        return warrantyExpDate;
    }

    public Date getPurchaseDate() {
        return purchaseDate;
    }

    public void setCBUNumber(String CBUNumber) {
        this.CBUNumber = CBUNumber;
    }

    public void setSerialnumber(String serialnumber) {
        Serialnumber = serialnumber;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setWarrantyExpDate(Date warrantyExpDate) {
        this.warrantyExpDate = warrantyExpDate;
    }

    public void setPurchaseDate(Date purchaseDate) {
        this.purchaseDate = purchaseDate;
    }
}
