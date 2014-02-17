package com.ru.ssh.hibernate.entity;
// default package

import com.ru.ssh.hibernate.entity.Address;;


/**
 * Person entity. @author MyEclipse Persistence Tools
 */

public class Person  implements java.io.Serializable {


     private Integer id;
     private Address address;
     private String name;
     private String age;



    /** default constructor */
    public Person() {
    }

    
    public Person(String name, String age) {
		super();
		this.name = name;
		this.age = age;
	}


	/** full constructor */
    public Person(Address address, String name, String age) {
        this.address = address;
        this.name = name;
        this.age = age;
    }

   
    // Property accessors

    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }

    public Address getAddress() {
        return this.address;
    }
    
    public void setAddress(Address address) {
        this.address = address;
    }

    public String getName() {
        return this.name;
    }
    
    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return this.age;
    }
    
    public void setAge(String age) {
        this.age = age;
    }
   

}