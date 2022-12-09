package com.halit.service;

import com.halit.repository.IEmployeeRepository;
import com.halit.repository.entity.Company;
import com.halit.repository.entity.Employee;
import com.halit.repository.entity.Status;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class EmployeeService {
    @Autowired
    private IEmployeeRepository employeeRepository;

    public Employee save(Employee employee){
        return employeeRepository.save(employee);
    }

    public List<Employee> findAll() {
        return  employeeRepository.findAllByStatus(Status.ACTIVE);
    }

    public Boolean updateEmployee(Employee employee) {
        Optional<Employee> employee1 = findById(employee.getId());
        if(employee1.isPresent()){
            employee1.get().setName(employee.getName());
            employee1.get().setSurname(employee.getSurname());
            employee1.get().setAge(employee.getAge());
            employee1.get().setCompany(employee.getCompany());
            employeeRepository.save(employee1.get());
            return true;
        }else{
            return false;
        }
    }

    public Boolean deleteEmployee(Employee employee) {
        Optional<Employee> employee1 = findById(employee.getId());
        if(employee1.isPresent() && employee1.get().getStatus().equals(Status.ACTIVE)){
            employee1.get().setStatus(Status.DELETED);
            employeeRepository.save(employee1.get());
            return true;
        }else{
            return false;
        }
    }
    public Optional<Employee> findById(Long employeeId) {

        return  employeeRepository.findOptionalById(employeeId);
    }
}
