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
public class Order extends AbstractEntity implements WBS {

    @Nullable
    private String name = "";

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Merch> merches = new ArrayList<>();

    public List<Merch> getMerches() {
        return merches;
    }

    public void setMerches(List<Merch> merches) {
        this.merches = merches;
    }

    public Order(@Nullable String name) {
        this.name = name;
    }

    public Order() {
    }

    @Override
    public @Nullable String getName() {
        return null;
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
