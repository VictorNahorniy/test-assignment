package com.university.test.repositories;

import com.university.test.models.Degree;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DegreeRepository extends JpaRepository<Degree, Integer> {
    @Query("select d.name from Degree d where d.name like ?1")
    List<String> findNameByTemplate(String template);
}
