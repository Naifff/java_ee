package ru.geekbrains.enterprise.entity;

import org.jetbrains.annotations.Nullable;
import ru.geekbrains.enterprise.api.WBS;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import java.util.Date;

@Entity
public class Merch extends AbstractEntity implements WBS {
    @ManyToOne
    private Category category;

    @ManyToOne
    private Order order;

    public void setCategory(Category category) {
        this.category = category;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public Category getCategory() {
        return category;
    }

    public Order getOrder() {
        return order;
    }

    @Nullable
    private String name = null;

    @Nullable
    private String description = null;

    public Merch() {
    }

    public Merch(@Nullable String name) {
        this.name = name;
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
