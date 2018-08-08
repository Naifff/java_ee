package ru.geekbrains.enterprise.controller;

import ru.geekbrains.enterprise.dao.TaskDAO;
import ru.geekbrains.enterprise.entity.Task;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import java.util.Collection;

@ViewScoped
@ManagedBean
public class TaskListController {

    @Inject
    private TaskDAO taskDAO;

    public Collection<Task> getListTask() {
        return taskDAO.getListTask();
    }

    public String hello() {
        return  "HELLO!!!";
    }

    public void removeTaskById(String taskId) {
        taskDAO.removeTaskById(taskId);
    }

}
