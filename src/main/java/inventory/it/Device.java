package inventory.it;

//Written by Emily Sublette for CBU Information Technology Dept
//Contact at emilyl.sublette@calbaptist.edu

import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import sun.security.x509.SerialNumber;

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
    private String serialNumber;

    @Column(name = "Make", nullable = false)
    private String make;

    @Column(name = "Model", nullable = false)
    private String model;

    @Column(name = "WarrantyExpDate")
    private Date warrantyExpDate;

    @Column(name = "PurchaseDate", nullable = false)
    private Date purchaseDate;

    // constructors

    // has a warrantyExpDate
    public Device(String CBUNumber, String serialNumber, String make, String model, Date warrantyExpDate, Date purchaseDate){
        this.CBUNumber = CBUNumber;
        this.serialNumber = serialNumber;
        this.make = make;
        this.model = model;
        this.warrantyExpDate = warrantyExpDate;
        this.purchaseDate = purchaseDate;
    }

    // no warrantyExpDate
    public Device(String CBUNumber, String serialNumber, String make, String model, Date purchaseDate){
        this.CBUNumber = CBUNumber;
        this.serialNumber = serialNumber;
        this.make = make;
        this.model = model;
        this.purchaseDate = purchaseDate;
    }

    // no arg - modify later if needed.
    public Device() {
    }

    // getters/setters

    public String getCBUNumber() {
        return CBUNumber;
    }

    public String getSerialNumber() {
        return serialNumber;
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

    public void setSerialnumber(String serialNumber) {
        this.serialNumber = serialNumber;
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
