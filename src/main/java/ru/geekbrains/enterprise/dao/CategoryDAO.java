package ru.geekbrains.enterprise.dao;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.geekbrains.enterprise.entity.Category;

import javax.ejb.Stateless;
import java.util.List;

@Stateless
public class CategoryDAO extends AbstractDAO{

    public Category findOne(String id) {
        return em.find(Category.class, id);
    }

    @NotNull
    public List<Category> getCategories() {
        return em.createQuery("SELECT e FROM Category e ORDER BY e.created DESC", Category.class).getResultList();
    }

    @Nullable
    public Category getCategoryById(@Nullable final String categoryId) {
        if (categoryId == null || categoryId.isEmpty()) return null;
        return getEntity(em.createQuery("SELECT e FROM Category e WHERE e.id = :id", Category.class)
                .setParameter("id", categoryId)
                .setMaxResults(1));
    }

    @Nullable
    public Category persist(@Nullable final Category category) {
        if (category == null) return null;
        em.persist(category);
        return category;
    }

    @Nullable
    public Category merge(@Nullable final Category category) {
        if (category == null) return null;
        return em.merge(category);
    }

    public void removeCategoryById(@Nullable final String categoryId) {
        @Nullable final Category category = getCategoryById(categoryId);
        if (category == null) return;
        em.remove(category);
    }
}
