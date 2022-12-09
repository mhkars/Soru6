package com.halit.repository;

import com.halit.repository.entity.Employee;
import com.halit.repository.entity.Status;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface IEmployeeRepository extends JpaRepository<Employee,Long> {
    Optional<Employee> findOptionalById(Long employeeId);

    List<Employee> findAllByStatus(Status status);
}