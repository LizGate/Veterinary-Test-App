package com.veterinary.veterinaryclinicapp.pets;


import com.veterinary.veterinaryclinicapp.customers.Customers;

import javax.persistence.*;

@Entity
@Table(name = "pets")
public class Pets {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;
    Integer pet_customer_id;
    String pet_name;
    Integer pet_age;
    String pet_sex;
    String pet_type;

    @OneToOne(mappedBy = "pets")
    private Customers customers;


    public Pets(){

    }

    public Pets(Integer id, Integer petCustomerId, String petName, Integer petAge, String petSex, String petType){

        super();
        this.id = id;
        this.pet_customer_id = petCustomerId;
        this.pet_name = petName;
        this.pet_age = petAge;
        this.pet_sex = petSex;
        this.pet_type = petType;

    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPet_customer_id() {
        return pet_customer_id;
    }

    public void setPet_customer_id(Integer pet_customer_id) {
        this.pet_customer_id = pet_customer_id;
    }

    public String getPet_name() {
        return pet_name;
    }

    public void setPet_name(String pet_name) {
        this.pet_name = pet_name;
    }

    public Integer getPet_age() {
        return pet_age;
    }

    public void setPet_age(Integer pet_age) {
        this.pet_age = pet_age;
    }

    public String getPet_sex() {
        return pet_sex;
    }

    public void setPet_sex(String pet_sex) {
        this.pet_sex = pet_sex;
    }

    public String getPet_type() {
        return pet_type;
    }

    public void setPet_type(String pet_type) {
        this.pet_type = pet_type;
    }
}
