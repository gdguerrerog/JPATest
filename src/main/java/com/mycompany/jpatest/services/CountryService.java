/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.jpatest.services;

import com.mycompany.jpatest.entities.Country;
import com.mycompany.model.CountryRequest;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;

/**
 *
 * @author BDG-GGUERRERO
 */
public interface CountryService {
    
    List<Country> findAll();
    Optional<Country> findById(Long id);
    Long create(CountryRequest newCountry);
    boolean update(Long id, CountryRequest countryRequest);
    void delete(Long id);
}
