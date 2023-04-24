/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.jpatest.repositories;
import com.mycompany.jpatest.entities.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author BDG-GGUERRERO
 */
@Repository
public interface CountryRepository extends JpaRepository<Country, Long> {
    
}
