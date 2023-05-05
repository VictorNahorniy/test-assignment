package com.university.test.repositories;

import com.university.test.models.Department;
import com.university.test.models.Lector;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Integer> {
    @Query("select d.lectorByHeadOfDepartmentId from Department d where d.name = ?1")
    Lector findHeadOfDepartment(String departmentName);

    Boolean existsByName(String departmentName);

    @Query("select d.name from Department d where d.name like ?1")
    List<String> findDepartmentsByTemplate(String template);
}
