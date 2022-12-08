package com.halit.controller;

import com.halit.repository.entity.Company;
import com.halit.service.CompanyService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.halit.constants.EndPoints.*;
import static com.halit.constants.EndPoints.WEB;


@Controller
@RequestMapping(VERSION + WEB + COMPANY)
@RequiredArgsConstructor
public class CompanyMvcController {

    private final CompanyService companyService;

    @PostMapping(SAVE)
    public ResponseEntity<Company> save(@RequestBody Company company) {
        try {
            Company company1=Company.builder()
                    .name(company.getName())
                    .sector(company.getSector())
                    .city(company.getCity()).build();
            companyService.save(company1);
            System.out.println("Şirtket kaydı başarılı");
            return ResponseEntity.ok(company1);
        }catch (Exception e){
            System.out.println(e.getMessage());
            throw  new RuntimeException();
        }
    }

    @PutMapping(UPDATE)
    public ResponseEntity<Company> updateCompany(@RequestBody Company company) {
        try {
            companyService.updateCompany(company);
            System.out.println("Şirtket kaydı başarılı");
        return ResponseEntity.ok(company);
        }catch (Exception e){
            System.out.println(e.getMessage());
            throw  new RuntimeException();
        }
    }

    @DeleteMapping(DELETE)
    public ResponseEntity<Boolean> deleteCompany(@PathVariable Long id) {

        return ResponseEntity.ok(companyService.deleteCompany(id));
    }

    @GetMapping(GETALL)
    public ResponseEntity<List<Company>> findAll() {
        return ResponseEntity.ok(companyService.findAll());
    }
}