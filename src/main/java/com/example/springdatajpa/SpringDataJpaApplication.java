package com.example.springdatajpa;

import com.example.springdatajpa.repo.ActorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;

@SpringBootApplication
public class SpringDataJpaApplication
{


    public static void main(String[] args) {
        SpringApplication.run(SpringDataJpaApplication.class, args);
    }




}
