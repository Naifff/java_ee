package ru.geekbrains.enterprise.entity;

import org.jetbrains.annotations.Nullable;
import ru.geekbrains.enterprise.api.WBS;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
public class Category extends AbstractEntity implements WBS {

    @Nullable
    private String name = "";

    @Nullable
    private String description = "";

    @OneToMany(mappedBy = "category", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Merch> merches = new ArrayList<>();

    public Category() {
    }

    public Category(@Nullable String name) {
        this.name = name;
    }


    @Override
    public @Nullable String getName() {
        return null;
    }

    public List<Merch> getMerches() {
        return merches;
    }

    public void setMerches(List<Merch> merches) {
        this.merches = merches;
    }

    @Override
    public void setName(@Nullable String name) {

    }

    @Override
    public @Nullable String getDescription() {
        return null;
    }

    @Override
    public void setDescription(@Nullable String description) {

    }

    @Override
    public Date getDateBegin() {
        return null;
    }

    @Override
    public void setDateBegin(@Nullable Date dateBegin) {

    }

    @Override
    public Date getDateEnd() {
        return null;
    }

    @Override
    public void setDateEnd(@Nullable Date dateEnd) {

    }
}
