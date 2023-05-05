package com.university.test.models;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.Objects;

@Entity
public class Lector {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private Integer id;
    @Basic
    @Column(name = "name")
    private String name;
    @Basic
    @Column(name = "degree_id")
    private Integer degreeId;
    @Basic
    @Column(name = "salary")
    private BigDecimal salary;
    @OneToMany(mappedBy = "lectorByHeadOfDepartmentId")
    private Collection<Department> departmentsById;
    @OneToMany(mappedBy = "lectorByLectorId")
    private Collection<DepartmentLector> departmentLectorsById;
    @ManyToOne
    @JoinColumn(name = "degree_id", referencedColumnName = "id", insertable = false, updatable = false)
    private Degree degreeByDegreeId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getDegreeId() {
        return degreeId;
    }

    public void setDegreeId(Integer degreeId) {
        this.degreeId = degreeId;
    }

    public BigDecimal getSalary() {
        return salary;
    }

    public void setSalary(BigDecimal salary) {
        this.salary = salary;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Lector lector = (Lector) o;
        return Objects.equals(id, lector.id) && Objects.equals(name, lector.name) && Objects.equals(degreeId, lector.degreeId) && Objects.equals(salary, lector.salary);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, degreeId, salary);
    }

    public Collection<Department> getDepartmentsById() {
        return departmentsById;
    }

    public void setDepartmentsById(Collection<Department> departmentsById) {
        this.departmentsById = departmentsById;
    }

    public Collection<DepartmentLector> getDepartmentLectorsById() {
        return departmentLectorsById;
    }

    public void setDepartmentLectorsById(Collection<DepartmentLector> departmentLectorsById) {
        this.departmentLectorsById = departmentLectorsById;
    }

    public Degree getDegreeByDegreeId() {
        return degreeByDegreeId;
    }

    public void setDegreeByDegreeId(Degree degreeByDegreeId) {
        this.degreeByDegreeId = degreeByDegreeId;
    }
}
