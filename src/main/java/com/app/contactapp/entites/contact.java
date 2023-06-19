package com.app.contactapp.entites;



import org.springframework.boot.autoconfigure.web.WebProperties.Resources.Chain.Strategy;

import jakarta.annotation.Generated;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class contact {
    @Id
    @GeneratedValue(strategy =GenerationType.AUTO)
     private int id;
     private String firstName;
     private String lastName;
     private String work;
     private String image;
     private String phone;
     @Column(length = 1000)
     private String description;
     @ManyToOne
     private user User;
     
    public contact() {
    }
    
    public contact(int id, String firstName, String lastName, String work, String image, String phone,
            String description, user user) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.work = work;
        this.image = image;
        this.phone = phone;
        this.description = description;
        User = user;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public String getWork() {
        return work;
    }
    public void setWork(String work) {
        this.work = work;
    }
    public String getImage() {
        return image;
    }
    public void setImage(String image) {
        this.image = image;
    }
    public String getPhone() {
        return phone;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public user getUser() {
        return User;
    }
    public void setUser(user user) {
        User = user;
    }

     

    
}
