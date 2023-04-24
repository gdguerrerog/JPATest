/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.jpatest.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

/**
 *
 * @author BDG-GGUERRERO
 */
@Entity
@Table(name = "countries")
public class Country {
      
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
  
    @Column(nullable = false, unique = true)
    private String name;
  
    @Column(nullable = false)
    private Integer population;
    
    
    public Country() {}
 
    public Country(String name, Integer population) {
        this.id = id;
        this.population = population;
    }

    
    @Override
    public String toString() {
        return String.format("Country{id: %d, name: %s, population: %d}", getId(), getName(), getPopulation());
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPopulation() {
        return population;
    }

    public void setPopulation(Integer population) {
        this.population = population;
    }
}
