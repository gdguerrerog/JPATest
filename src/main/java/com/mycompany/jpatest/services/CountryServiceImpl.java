/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.jpatest.services;

import com.mycompany.jpatest.entities.Country;
import com.mycompany.jpatest.repositories.CountryRepository;
import com.mycompany.model.CountryRequest;
import jakarta.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;

/**
 *
 * @author BDG-GGUERRERO
 */
@Service
public class CountryServiceImpl implements CountryService {
        
    private final CountryRepository countryRepository;
  
    public CountryServiceImpl(CountryRepository countryRepository) {
        this.countryRepository = countryRepository;
    }
  
    @Override
    public List<Country> findAll() {
        return countryRepository.findAll();
    }
      
    @Override
    public Optional<Country> findById(Long id) {
        return countryRepository.findById(id);
    }
    
    @Override
    public Long create(CountryRequest newCountry) {
        Country countryEntity = new Country(newCountry.getName(), newCountry.getPopulation());
        return countryRepository.save(countryEntity).getId();
    }

    @Override
    @Transactional
    public boolean update(Long id, CountryRequest countryRequest) {
        return countryRepository.findById(id)
                .map(country -> {
                    copy(countryRequest, country);
                    return true;
                })
                .orElse(false);
    }

    private void copy(CountryRequest countryRequest, Country country) {
        country.setName(countryRequest.getName());
        country.setPopulation(countryRequest.getPopulation());
    }

    @Override
    public void delete(Long id) {
        if (countryRepository.existsById(id)) {
            countryRepository.deleteById(id);
        }
    }
    
}
