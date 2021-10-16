package com.kjoshi.assessment.servian.todoapp.repo;

import com.kjoshi.assessment.servian.todoapp.vo.TaskBean;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ToDoRepo extends JpaRepository<TaskBean,String> {
}
