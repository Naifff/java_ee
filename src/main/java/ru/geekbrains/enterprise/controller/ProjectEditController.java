package ru.geekbrains.enterprise.controller;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import ru.geekbrains.enterprise.dao.ProjectDAO;
import ru.geekbrains.enterprise.entity.Project;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;

@ViewScoped
@ManagedBean
public class ProjectEditController {

    @Inject
    private ProjectDAO projectDAO;

    @Nullable
    private String id;

    @NotNull
    private Project project = new Project();

    public void init() {
        @Nullable final Project project = projectDAO.getProjectById(id);
        if (project != null) this.project = project;
    }

    @NotNull
    public String save() {
        projectDAO.merge(project);
        return "project-list";
    }

    @NotNull
    public Project getProject() {
        return project;
    }

    public void setProject(@NotNull final Project project) {
        this.project = project;
    }

    @Nullable
    public String getId() {
        return id;
    }

    public void setId(@Nullable final String id) {
        this.id = id;
    }

}
