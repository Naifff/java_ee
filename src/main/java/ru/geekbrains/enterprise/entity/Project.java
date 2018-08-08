package ru.geekbrains.enterprise.entity;

import org.jetbrains.annotations.Nullable;
import ru.geekbrains.enterprise.api.WBS;

import java.util.Date;
import java.util.UUID;

public class Project implements WBS {

    @Nullable
    private String id = UUID.randomUUID().toString();

    @Nullable
    private String name = "";

    @Nullable
    private String description = "";

    @Nullable
    private Date dateBegin;

    @Nullable
    private Date dateEnd;

    @Nullable
    public Date getDateBegin() {
        return dateBegin;
    }

    public void setDateBegin(@Nullable final Date dateBegin) {
        this.dateBegin = dateBegin;
    }

    @Nullable
    public Date getDateEnd() {
        return dateEnd;
    }

    public void setDateEnd(@Nullable final Date dateEnd) {
        this.dateEnd = dateEnd;
    }

    public Project() {
    }

    public Project(@Nullable final String name) {
        this.name = name;
    }

    @Nullable
    public String getName() {
        return name;
    }

    public void setName(@Nullable final String name) {
        this.name = name;
    }

    @Nullable
    public String getDescription() {
        return description;
    }

    public void setDescription(@Nullable final String description) {
        this.description = description;
    }

    @Nullable
    public String getId() {
        return id;
    }

    public void setId(@Nullable final String id) {
        this.id = id;
    }

}
