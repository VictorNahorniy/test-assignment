package com.university.test.models;

import jakarta.persistence.*;

import java.util.Collection;
import java.util.Objects;

@Entity
public class Degree {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private Integer id;
    @Basic
    @Column(name = "name")
    private String name;
    @OneToMany(mappedBy = "degreeByDegreeId")
    private Collection<Lector> lectorsById;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Degree degree = (Degree) o;
        return Objects.equals(id, degree.id) && Objects.equals(name, degree.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }

    public Collection<Lector> getLectorsById() {
        return lectorsById;
    }

    public void setLectorsById(Collection<Lector> lectorsById) {
        this.lectorsById = lectorsById;
    }
}
