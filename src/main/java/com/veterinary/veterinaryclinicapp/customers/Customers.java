package com.veterinary.veterinaryclinicapp.customers;


import com.veterinary.veterinaryclinicapp.pets.Pets;
import lombok.NoArgsConstructor;

import javax.persistence.*;
//a
@Entity
@Table(name="customers")
public class Customers {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;
    String customer_name;
    String customer_surname;
    String customer_address;
    String customer_phone;
    String customer_email;
    Integer customer_type;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id", referencedColumnName = "pet_customer_id")
    private Pets pets;



    public Customers() {

    }

    public Customers(Integer id, String customerName, String customerSurname, String customerAddress, String customerPhone, String customerEmail, Integer customerType) {
        super();
        this.id = id;
        this.customer_name = customerName;
        this.customer_surname = customerSurname;
        this.customer_address = customerAddress;
        this.customer_phone = customerPhone;
        this.customer_email = customerEmail;
        this.customer_type = customerType;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCustomer_name() {
        return customer_name;
    }

    public void setCustomer_name(String customer_name) {
        this.customer_name = customer_name;
    }

    public String getCustomer_surname() {
        return customer_surname;
    }

    public void setCustomer_surname(String customer_surname) {
        this.customer_surname = customer_surname;
    }

    public String getCustomer_address() {
        return customer_address;
    }

    public void setCustomer_address(String customer_address) {
        this.customer_address = customer_address;
    }

    public String getCustomer_phone() {
        return customer_phone;
    }

    public void setCustomer_phone(String customer_phone) {
        this.customer_phone = customer_phone;
    }

    public String getCustomer_email() {
        return customer_email;
    }

    public void setCustomer_email(String customer_email) {
        this.customer_email = customer_email;
    }

    public Integer getCustomer_type() {
        return customer_type;
    }

    public void setCustomer_type(Integer customer_type) {
        this.customer_type = customer_type;
    }
}
