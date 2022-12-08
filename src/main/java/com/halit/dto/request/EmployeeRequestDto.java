package com.halit.dto.request;

import com.halit.repository.entity.Company;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class EmployeeRequestDto {

    private String name;
    private String surname;
    private Integer age;
    private Long companyId;
}
