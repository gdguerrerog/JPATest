/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.jpatest.controllers;

import com.mycompany.jpatest.services.CountryService;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author BDG-GGUERRERO
 */
@Controller()
@RequestMapping("/pages")
public class PageController {
    
      
    private final CountryService countryService;
  
    public PageController(CountryService countryService) {
        this.countryService = countryService;
    }
    
    @GetMapping
    public String getPage(Model model) {
        model.addAttribute("countriesList", countryService.findAll());
        return "countriesList";
    }
    
    @GetMapping("/goPage1")
    public String getPage1(Model model) {
        return "page1";
    }
    
    @GetMapping("/goPage2")
    public String getPage2(Model model) {
        return "page2";
    }
    
    @GetMapping("/goPage3")
    public String getPage3(Model model) {
        return "page3";
    }
}
