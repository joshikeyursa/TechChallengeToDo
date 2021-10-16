package com.kjoshi.assessment.servian.todoapp.service;

import com.kjoshi.assessment.servian.todoapp.repo.ToDoRepo;
import com.kjoshi.assessment.servian.todoapp.vo.TaskBean;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class ToDoServiceTest {
    @InjectMocks
    ToDoService toDoService;

    @Mock
    ToDoRepo repo;

    @Test
    public void testFetchAllRecordService(){
        List<TaskBean> taskList = new ArrayList<>();
        taskList.add(new TaskBean("T0001","First Priority Task",1));
        taskList.add(new TaskBean("T0002","Second Priority Task",2));
        when(repo.findAll()).thenReturn(taskList);
        List<TaskBean> actualResponse = toDoService.fetchAllTasks();
        assertNotNull(actualResponse);
        assertFalse(actualResponse.isEmpty());
        assertEquals(actualResponse.get(0).getId(),"T0001");
        assertEquals(actualResponse.get(0).getDescription(),"First Priority Task");
        assertEquals(actualResponse.get(0).getPriority(),1);
    }
}