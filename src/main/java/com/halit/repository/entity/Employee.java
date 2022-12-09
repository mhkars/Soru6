package com.halit.repository.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "tbl_employee")
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length = 64)
    private String name;
    @Column(length = 64)
    private String surname;
    private Integer age;
    @Enumerated(EnumType.STRING)
    @Builder.Default
    private Status status=Status.ACTIVE;
    @ManyToOne
    @JoinColumn(name = "company_id" ,referencedColumnName = "id")
    private Company company;
}