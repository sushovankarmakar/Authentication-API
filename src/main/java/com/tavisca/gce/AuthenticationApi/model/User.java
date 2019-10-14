package com.tavisca.gce.AuthenticationApi.model;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "userlist")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    //@Column(name = "id", updatable = false, nullable = false)
    private int eid;

    private String name;
    private Date dob;
    private String company;
    private Date doj;
    private String role;
    private String createdBy;
    private Date creationDate;
    private String username;
    private String password;


    public int getEid() {
        return eid;
    }

    public void setEid(int eid) {
        this.eid = eid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public Date getDoj() {
        return doj;
    }

    public void setDoj(Date doj) {
        this.doj = doj;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "User{" +
                "eid=" + eid +
                ", name='" + name + '\'' +
                ", dob='" + dob + '\'' +
                ", company='" + company + '\'' +
                ", doj='" + doj + '\'' +
                ", createdBy='" + createdBy + '\'' +
                ", creationDate='" + creationDate + '\'' +
                ", userName='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
