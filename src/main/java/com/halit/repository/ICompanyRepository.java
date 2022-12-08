package com.halit.repository;


import com.halit.repository.entity.Company;
import com.halit.repository.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ICompanyRepository extends JpaRepository<Company,Long> {
    Optional<Company> findOptionalById(Long companyId);

    Optional<Company> findOptionalByName(String name);
}