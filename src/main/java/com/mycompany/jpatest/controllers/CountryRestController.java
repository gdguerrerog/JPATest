/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.jpatest.controllers;

import com.mycompany.jpatest.JPATest;
import com.mycompany.jpatest.entities.Country;
import com.mycompany.jpatest.services.CountryService;
import com.mycompany.model.CountryRequest;
import jakarta.validation.Valid;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author BDG-GGUERRERO
 */
@RequestMapping(CountryRestController.COUNTRIES_RESOURCE)
@RestController
@ResponseBody
public class CountryRestController {
      
    private static final Logger logger = LoggerFactory.getLogger(CountryRestController.class);
    public static final String COUNTRIES_RESOURCE = "/api/countries";
  
    private final CountryService countryService;
  
    public CountryRestController(CountryService countryService) {
        this.countryService = countryService;
    }
    
    @GetMapping("/all")
    public List<Country> getAll() {
        return countryService.findAll();
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Country> getById(@PathVariable("id") Long id) {
        return countryService
                .findById(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
    
    @PostMapping
    public ResponseEntity<Map<String, Object>> add(@RequestBody @Valid CountryRequest country) {
        Long id = countryService.create(country);
        return new ResponseEntity<>(Collections.singletonMap("id", id), HttpStatus.CREATED);
    }
    
    @PutMapping(value = "/{id}")
    public ResponseEntity<Void> update(@PathVariable Long id,
                                       @RequestBody @Valid CountryRequest countryRequest) {
        boolean wasUpdated = countryService.update(id, countryRequest);
        return wasUpdated ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
    }
    
}
