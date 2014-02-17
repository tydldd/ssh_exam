package com.ru.ssh.hibernate.entity;
// default package

import java.util.HashSet;
import java.util.Set;


/**
 * Address entity. @author MyEclipse Persistence Tools
 */

public class Address  implements java.io.Serializable {


    // Fields    

     private Integer addressid;
     private String addressdetail;
     private Set persons = new HashSet(0);


    // Constructors

    /** default constructor */
    public Address() {
    }

    
    /** full constructor */
    public Address(String addressdetail, Set persons) {
        this.addressdetail = addressdetail;
        this.persons = persons;
    }

   
    // Property accessors

    public Integer getAddressid() {
        return this.addressid;
    }
    
    public void setAddressid(Integer addressid) {
        this.addressid = addressid;
    }

    public String getAddressdetail() {
        return this.addressdetail;
    }
    
    public void setAddressdetail(String addressdetail) {
        this.addressdetail = addressdetail;
    }

    public Set getPersons() {
        return this.persons;
    }
    
    public void setPersons(Set persons) {
        this.persons = persons;
    }
}