package com.kjoshi.assessment.servian.todoapp.controller;

import com.kjoshi.assessment.servian.todoapp.service.ToDoService;
import com.kjoshi.assessment.servian.todoapp.vo.TaskBean;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.hamcrest.core.Is.is;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@RunWith(SpringRunner.class)
@WebMvcTest
public class ToDoControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @InjectMocks
    private ToDoController toDoController;

    @MockBean
    private ToDoService toDoService;

    @Test
    public void testControllerSuccess() throws Exception{
        TaskBean taskBean = new TaskBean("T0001","This is my First Task",100);
        TaskBean taskBean2 = new TaskBean("T0001","This is my another Task",200);
        List<TaskBean> taskList = new ArrayList<>();
        taskList.add(taskBean);
        taskList.add(taskBean2);
        given(toDoService.fetchAllTasks()).willReturn(taskList);
        mockMvc.perform(get("/api/").contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$",hasSize(2)))
                .andExpect(jsonPath("$[0].id",is(taskBean.getId())));
    }

    @Test
    public void testControllerError() throws Exception{
        given(toDoService.fetchAllTasks()).willThrow(new RuntimeException());
        mockMvc.perform(get("/api/").contentType(MediaType.APPLICATION_JSON)).andExpect(status().is5xxServerError());
    }

}