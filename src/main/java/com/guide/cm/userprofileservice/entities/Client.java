package com.guide.cm.userprofileservice.entities;

import org.hibernate.validator.constraints.UniqueElements;

import javax.persistence.*;

@Entity
public class Client {

    @Id
    @GeneratedValue
    private long id;

    private String name;

    @Column(unique = true)
    private String gstNo;

    private String scheme;

    private String comments;


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGstNo() {
        return gstNo;
    }

    public void setGstNo(String gstNo) {
        this.gstNo = gstNo;
    }

    public String getScheme() {
        return scheme;
    }

    public void setScheme(String scheme) {
        this.scheme = scheme;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }
}
