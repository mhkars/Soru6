package com.halit.controller;

import com.halit.dto.request.EmployeeRequestDto;
import com.halit.repository.entity.Employee;
import com.halit.service.CompanyService;
import com.halit.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.halit.constants.EndPoints.*;


@Controller
@RequestMapping(VERSION + WEB + EMPLOYEE)
@RequiredArgsConstructor
public class EmployeeMvcController {
    private final EmployeeService employeeService;
    private final CompanyService companyService;
    @PostMapping(SAVE)
    public ResponseEntity<Employee> save(@RequestBody EmployeeRequestDto dto) {
        try {
            Employee employee=Employee.builder()
                    .name(dto.getName())
                    .surname(dto.getSurname())
                    .age(dto.getAge())
                    .company(companyService.findById(dto.getCompanyId()).get())
                    .build();
            employeeService.save(employee);
            System.out.println("Calisan kaydi basarili.");
            return ResponseEntity.ok(employee);
        }catch (Exception e){
            System.out.println(e.getMessage());
            throw  new RuntimeException();
        }
    }
    @PutMapping(UPDATE)
    public ResponseEntity<Employee> updateEmployee(@RequestBody Employee employee) {
        try {
            employeeService.updateEmployee(employee);
            System.out.println("Calisan guncelleme başarılı.");
            return ResponseEntity.ok(employee);
        }catch (Exception e){
            System.out.println("Calisan guncelleme basarisiz.");
            throw  new RuntimeException();
        }
    }

    @DeleteMapping(DELETE)
    public ResponseEntity<String> deleteEmployee(@PathVariable Long id) {
        try {
            employeeService.deleteEmployee(id);
            return ResponseEntity.ok("Calisan silme başarılı.");
        }catch (Exception e){
            System.out.println("Calisan silme basarisiz.");
            throw  new RuntimeException();
        }

    }

    @GetMapping(GETALL)
    public ResponseEntity<List<Employee>> findAllEmployee() {
        return ResponseEntity.ok(employeeService.findAll());
    }

}
