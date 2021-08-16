package com.example.demo.Supplier;

import javax.persistence.*;

//<@Transient is used when we want to get periods. So, if we have
//say dob and we want to get the age, we can use it.
//When we do this, in our class with constructors i.e. our API layer, we will use <period.between(this.dob, LocalDate.now()).getYears()
//to get the amount of time between the Dob and now.
//Helps to get rid of columns such as age that may need to be updated from time to time.

@Entity// for hibernate
@Table//Helps us create tables in our database. We have mapped the Supplier class to a table in our db with this.
public class Supplier {

    @Id
    @SequenceGenerator(
            name = "supplier_sequence",
            sequenceName = "supplier_sequence",
            allocationSize = 1
            //creates sequence supplier_sequence start 1 increment 1
    )
    @GeneratedValue(
          strategy = GenerationType.SEQUENCE,
          generator =  "supplier_sequence"
    )

    //Variable declaration.
    //Supplier also happens to be a table in our database. Information they provide dictates the variables we make.

    private long supplierId;
    private String name;
    private String location;
    private String email;
    private int telephoneNumber;
    private String postalAddress;
    private long productId;

    //Constructors

    public Supplier() {
    }

    public Supplier(long supplierId,
                    String name,
                    String location,
                    String email,
                    int telephoneNumber,
                    String postalAddress,
                    long productId) {
        this.supplierId = supplierId;
        this.name = name;
        this.location = location;
        this.email = email;
        this.telephoneNumber = telephoneNumber;
        this.postalAddress = postalAddress;
        this.productId = productId;
    }

    public Supplier(String name,
                    String location,
                    String email,
                    int telephoneNumber,
                    String postalAddress,
                    long productId) {
        this.name = name;
        this.location = location;
        this.email = email;
        this.telephoneNumber = telephoneNumber;
        this.postalAddress = postalAddress;
        this.productId = productId;
    }

    //Getters and setters
    //They query for information stored in the variable.
    //Setters are used to set information in the variables.

    public long getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(long supplierId) {
        this.supplierId = supplierId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getTelephoneNumber() {
        return telephoneNumber;
    }

    public void setTelephoneNumber(int telephoneNumber) {
        this.telephoneNumber = telephoneNumber;
    }

    public String getPostalAddress() {
        return postalAddress;
    }

    public void setPostalAddress(String postalAddress) {
        this.postalAddress = postalAddress;
    }

    public long getProductId() {
        return productId;
    }

    public void setProductId(long productId) {
        this.productId = productId;
    }

    @Override
    //Converts everything to string
    public String toString() {
        return "Supplier{" +
                "supplierId=" + supplierId +
                ", name='" + name + '\'' +
                ", location='" + location + '\'' +
                ", email='" + email + '\'' +
                ", telephoneNumber=" + telephoneNumber +
                ", postalAddress='" + postalAddress + '\'' +
                ", productId=" + productId +
                '}';
    }
}
