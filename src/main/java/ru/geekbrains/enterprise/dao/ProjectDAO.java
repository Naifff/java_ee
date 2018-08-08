package ru.geekbrains.enterprise.dao;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.geekbrains.enterprise.entity.Project;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;

@ApplicationScoped
public class ProjectDAO {

    @NotNull
    private Map<String, Project> projects = new LinkedHashMap<>();

    @PostConstruct
    private void init() {
        merge(new Project("DEMO PROJECT"));
    }

    @NotNull
    public Collection<Project> getProjects() {
        return projects.values();
    }

    @Nullable
    public Project getProjectById(@Nullable final String projectId) {
        if (projectId == null || projectId.isEmpty()) return null;
        return projects.get(projectId);
    }

    @Nullable
    public Project merge(@Nullable final Project project) {
        if (project == null) return null;
        @Nullable final String id = project.getId();
        if (id == null || id.isEmpty()) return null;
        this.projects.put(id, project);
        return project;
    }

    public void removeProjectById(@Nullable final String projectId) {
        if (projectId == null || projectId.isEmpty()) return;
        if (!projects.containsKey(projectId)) return;
        projects.remove(projectId);
    }

}
