package com.kjoshi.assessment.servian.todoapp;

import com.kjoshi.assessment.servian.todoapp.controller.ToDoControllerTest;
import com.kjoshi.assessment.servian.todoapp.service.ToDoService;
import com.kjoshi.assessment.servian.todoapp.service.ToDoServiceTest;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.springframework.boot.test.context.SpringBootTest;

@RunWith(Suite.class)
@Suite.SuiteClasses({
		ToDoControllerTest.class,
		ToDoServiceTest.class
})
class ToDoAppApplicationTests {

	@Test
	void contextLoads() {
	}

}
