package com.dbjpa.sprongboot.jpa.pojo;

import org.hibernate.annotations.Proxy;

import javax.persistence.*;
import java.util.Date;



@Table(name = "emp")
@Entity
@Proxy(lazy = false)
public class Emp {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private  Integer id ;
    private  String name;
    private  int age ;
    @Temporal(TemporalType.DATE)
    private Date cdate;

    public Emp(){}

    public Emp(String name, int age, Date cdate) {
        this.name = name;
        this.age = age;
        this.cdate = cdate;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public Date getCdate() {
        return cdate;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setCdate(Date cdate) {
        this.cdate = cdate;
    }

    @Override
    public String toString() {
        return "Emp{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", cdate=" + cdate +
                '}';
    }
}
