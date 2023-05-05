package com.university.test.models;

import jakarta.persistence.*;

import java.util.Collection;
import java.util.Objects;

@Entity
public class Department {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private Integer id;
    @Basic
    @Column(name = "name")
    private String name;
    @Basic
    @Column(name = "head_of_department_id")
    private Integer headOfDepartmentId;
    @ManyToOne
    @JoinColumn(name = "head_of_department_id",
            referencedColumnName = "id",
            nullable = false,
            insertable = false,
            updatable = false)
    private Lector lectorByHeadOfDepartmentId;
    @OneToMany(mappedBy = "departmentByDepartmentId")
    private Collection<DepartmentLector> departmentLectorsById;

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

    public Integer getHeadOfDepartmentId() {
        return headOfDepartmentId;
    }

    public void setHeadOfDepartmentId(Integer headOfDepartmentId) {
        this.headOfDepartmentId = headOfDepartmentId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Department that = (Department) o;
        return Objects.equals(id, that.id) && Objects.equals(name, that.name) && Objects.equals(headOfDepartmentId, that.headOfDepartmentId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, headOfDepartmentId);
    }

    public Lector getLectorByHeadOfDepartmentId() {
        return lectorByHeadOfDepartmentId;
    }

    public void setLectorByHeadOfDepartmentId(Lector lectorByHeadOfDepartmentId) {
        this.lectorByHeadOfDepartmentId = lectorByHeadOfDepartmentId;
    }

    public Collection<DepartmentLector> getDepartmentLectorsById() {
        return departmentLectorsById;
    }

    public void setDepartmentLectorsById(Collection<DepartmentLector> departmentLectorsById) {
        this.departmentLectorsById = departmentLectorsById;
    }

}
