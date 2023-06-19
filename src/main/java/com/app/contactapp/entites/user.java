package com.app.contactapp.entites;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.validator.constraints.Length;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

@Entity
public class user {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @NotBlank(message="Please Enter Name")
    private String name;
    @Column(unique = true)
    @Length(min=5,max=50,message="minimum value is 5 and maximum value is 50")
    @Email(message="Please Enter Email")
    private String email;
    @NotBlank(message="Please Enter Password")
    @Length(min=8,message="password is very short minimum password length is 8")
    private String password;
    private String role;
    private boolean enable;
    private String imageUrl;
    @Column(length = 1000)
    @Length(min=10,max=200,message="minimum value is 5 and maximum value is 50")
    private String about;
    @OneToMany(cascade = CascadeType.ALL ,mappedBy="User")
    private List<contact> Contacts=new ArrayList<>();

    
    public user() {
    }

   

   
    public int getId() {
        return id;
    }




    public void setId(int id) {
        this.id = id;
    }




    public String getName() {
        return name;
    }




    public void setName(String name) {
        this.name = name;
    }




    public String getEmail() {
        return email;
    }




    public void setEmail(String email) {
        this.email = email;
    }




    public String getRole() {
        return role;
    }




    public void setRole(String role) {
        this.role = role;
    }




    public boolean isEnable() {
        return enable;
    }




    public void setEnable(boolean enable) {
        this.enable = enable;
    }




    public String getImageUrl() {
        return imageUrl;
    }




    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }




    public String getAbout() {
        return about;
    }




    public void setAbout(String about) {
        this.about = about;
    }




    public List<contact> getContacts() {
        return Contacts;
    }




    public void setContacts(List<contact> contacts) {
        Contacts = contacts;
    }

    
    public String getPassword() {
        return password;
    }




    public void setPassword(String password) {
        this.password = password;
    }


    




    public user(int id, String name, String email, String password, String role, boolean enable, String imageUrl,
            String about, List<contact> contacts) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.role = role;
        this.enable = enable;
        this.imageUrl = imageUrl;
        this.about = about;
        Contacts = contacts;
    }




    @Override
    public String toString() {
        return "user [id=" + id + ", name=" + name + ", email=" + email + ", password=" + password + ", role=" + role
                + ", enable=" + enable + ", imageUrl=" + imageUrl + ", about=" + about + ", Contacts=" + Contacts + "]";
    }













    
    

    
}
