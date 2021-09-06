package com.example.springdatajpa.model;

import javax.persistence.*;

@Table(name = "store")
@Entity
public class Store
{
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    @Column(name = "store_id", nullable = false)
    private Long store_id;

    @OneToOne(optional = false)
    @JoinColumn(name = "staff_id", nullable = false)
    private Staff staff;

    public Staff getStaff() {
        return staff;
    }

    public void setStaff(Staff staff) {
        this.staff = staff;
    }

    public Long getStore_id() {
        return store_id;
    }

    public void setStore_id(Long store_id) {
        this.store_id = store_id;
    }
}