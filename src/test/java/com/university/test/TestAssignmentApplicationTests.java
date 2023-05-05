package com.university.test;

import com.university.test.controllers.UniversityController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class TestAssignmentApplicationTests {
	@Autowired
	private UniversityController universityController;

	@Test
	void contextLoads() {
	}

}
