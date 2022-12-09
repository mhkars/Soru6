package com.halit.service;

import com.halit.repository.ICompanyRepository;
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
public class CompanyService {
    @Autowired
    private ICompanyRepository companyRepository;

    public Company save(Company company){
        return companyRepository.save(company);
    }

    public List<Company> findAll() {
        return  companyRepository.findAllByStatus(Status.ACTIVE);
    }

    public Boolean updateCompany(Company company) {
        Optional<Company> company1 = findById(company.getId());
        if(company1.isPresent()&&company1.get().getStatus().equals(Status.ACTIVE)){
            company1.get().setCity(company.getCity());
            company1.get().setName(company.getName());
            company1.get().setSector(company.getSector());
            companyRepository.save(company1.get());
            return true;
        }else{
            return false;
        }
    }
    public Optional<Company> findById(Long companyId) {

        return  companyRepository.findOptionalById(companyId);
    }


    public Boolean deleteCompany(Company company) {
        Optional<Company> company1 = findById(company.getId());
        System.out.println();
        if(company1.isPresent() && company1.get().getStatus().equals(Status.ACTIVE)){
            company1.get().setStatus(Status.DELETED);
            companyRepository.save(company1.get());
            return true;
        }else{
            return false;
        }
    }
}
