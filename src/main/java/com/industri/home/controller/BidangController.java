package com.industri.home.controller;

import com.industri.home.model.Bidang;
import com.industri.home.security.service.services.BidangServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("http://localhost:8080")
@RestController
@RequestMapping("api")
public class BidangController {

    @Autowired
    private BidangServices services;

    @GetMapping("/bidangs")
    public List<Bidang> findAll() {
        return services.findAll();
    }

    @GetMapping("/bidangs/{id}")
    public Bidang findById(@PathVariable("id") Long id) {
        return services.findById(id);
    }

    @PostMapping("/bidangs")
    public Bidang create(@RequestBody Bidang bidang) {
        return services.create(bidang);
    }

    @PutMapping("/bidangs/{id}")
    public Bidang edit(@PathVariable("id") Long id, @RequestBody Bidang bidang) {

        return services.edit(bidang, id);
    }

    @DeleteMapping("/bidangs/{id}")
    public void deleteById(@PathVariable("id") Long id) {
        services.deleteById(id);
    }


}
