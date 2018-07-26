package com.taskmanager.repositories;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.taskmanager.models.Task;
import com.taskmanager.repositories.TasksRepository;


@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class TaskRepositoryTest {

    private static final String TASK_TITLE = "Test Task";
    private static final String TASK_DESCRIPTION = "Test Task Description";
    private static final String TASK_PRIORITY = "Test Task Descriptio";
    private static final String TASK_STATUS = "Test Task Descriptioj";


    @Autowired
    private TasksRepository tasksRepository;

    @Before
    public void setUp() throws Exception {

    }

    @Test
    public void testPersistence() {
        //given
        Task testTask = new Task(TASK_TITLE,TASK_DESCRIPTION,"dummy date");

        //when
        tasksRepository.save(testTask);

        //then
        Assert.assertNotNull(testTask.getId());
        Task newTask = tasksRepository.findById(testTask.getId()).orElse(null);
        Assert.assertEquals(TASK_TITLE, newTask.getTitle());
        Assert.assertEquals(TASK_DESCRIPTION, newTask.getDescription());
    }
}