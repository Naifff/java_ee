package ru.geekbrains.enterprise.dao;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import ru.geekbrains.enterprise.entity.Task;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;

@ApplicationScoped
public class TaskDAO {

    @NotNull
    private Map<String, Task> tasks = new LinkedHashMap<>();

    @NotNull
    public Collection<Task> getListTask() {
        return tasks.values();
    }

    @PostConstruct
    private void init() {
        merge(new Task("FIRST TASK"));
        merge(new Task("SECOND TASK"));
        merge(new Task("THIRD TASK"));
    }

    @Nullable
    public Task getTaskById(@Nullable final String taskId) {
        if (taskId == null || taskId.isEmpty()) return null;
        return tasks.get(taskId);
    }

    @Nullable
    public Task merge(@Nullable final Task task) {
        if (task == null) return null;
        @Nullable final String id = task.getId();
        if (id == null || id.isEmpty()) return null;
        this.tasks.put(id, task);
        return task;
    }

    public void removeTaskById(@Nullable final String taskId) {
        if (taskId == null || taskId.isEmpty()) return;
        tasks.remove(taskId);
    }

}
