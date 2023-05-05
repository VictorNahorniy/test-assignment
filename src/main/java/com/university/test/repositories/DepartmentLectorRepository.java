package com.university.test.repositories;

import com.university.test.models.DepartmentLector;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentLectorRepository extends JpaRepository<DepartmentLector, Integer> {

    @Query(value = "select avg(l.salary) " +
            "from lector l " +
            "join department_lector dl " +
            "on l.id = dl.lector_id " +
            "join department d " +
            "where d.name = ?1",
            nativeQuery = true)
    Float findAverageSalary(String departmentName);

    @Query("select count(dl.lectorByLectorId) " +
            "from DepartmentLector dl " +
            "where dl.departmentByDepartmentId.name = ?1")
    Integer countEmployeesByDepartmentName(String departmentName);


    @Query("select count (distinct dl.lectorByLectorId) " +
            "from DepartmentLector dl " +
            "where dl.departmentByDepartmentId.name = ?1 " +
            "and dl.lectorByLectorId.degreeByDegreeId.name = ?2")
    String countAllByDepartmentNameAndDegree(String departmentName, String degreeName);
}
