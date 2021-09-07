package com.example.springdatajpa;

import com.example.springdatajpa.service.InitDB;
import com.example.springdatajpa.service.TestDB;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;

@SpringBootApplication
public class SpringDataJpaApplication
{
    @Autowired
    InitDB initDB;

    @Autowired
    TestDB testDB;

    public static void main(String[] args) {
        SpringApplication.run(SpringDataJpaApplication.class, args);

    }

    @PostConstruct
    public void initDB()
    {
        initDB.initDB();
        testDB.testingDB();
    }




}
