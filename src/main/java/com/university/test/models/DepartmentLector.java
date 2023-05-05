package com.university.test.models;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "department_lector", schema = "university", catalog = "")
public class DepartmentLector {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private Integer id;
    @Basic
    @Column(name = "department_id")
    private Integer departmentId;
    @Basic
    @Column(name = "lector_id")
    private Integer lectorId;
    @ManyToOne
    @JoinColumn(name = "department_id", referencedColumnName = "id", insertable = false, updatable = false)
    private Department departmentByDepartmentId;
    @ManyToOne
    @JoinColumn(name = "lector_id", referencedColumnName = "id", insertable = false, updatable = false)
    private Lector lectorByLectorId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(Integer departmentId) {
        this.departmentId = departmentId;
    }

    public Integer getLectorId() {
        return lectorId;
    }

    public void setLectorId(Integer lectorId) {
        this.lectorId = lectorId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DepartmentLector that = (DepartmentLector) o;
        return Objects.equals(id, that.id) && Objects.equals(departmentId, that.departmentId) && Objects.equals(lectorId, that.lectorId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, departmentId, lectorId);
    }

    public Department getDepartmentByDepartmentId() {
        return departmentByDepartmentId;
    }

    public void setDepartmentByDepartmentId(Department departmentByDepartmentId) {
        this.departmentByDepartmentId = departmentByDepartmentId;
    }

    public Lector getLectorByLectorId() {
        return lectorByLectorId;
    }

    public void setLectorByLectorId(Lector lectorByLectorId) {
        this.lectorByLectorId = lectorByLectorId;
    }
}
