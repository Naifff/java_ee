package ru.geekbrains.enterprise.dao;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.geekbrains.enterprise.entity.Merch;

import javax.ejb.Stateful;
import java.util.Collections;
import java.util.List;

@Stateful
public class MerchDAO extends AbstractDAO{

    @NotNull
    public List<Merch> getListMerch() {
        return em.createQuery("SELECT e FROM Merch e ORDER BY e.created DESC ", Merch.class).getResultList();
    }



    @NotNull
    public List<Merch> getListMerchByCategoryId(
            @Nullable final String caregoryId
    ) {
        if (caregoryId == null || caregoryId.isEmpty()) return Collections.emptyList();
        return em.createQuery("SELECT e FROM Merch e WHERE e.category.id = :caregoryId ORDER BY e.created", Merch.class)
                .setParameter("caregoryId", caregoryId).getResultList();
    }

    @NotNull
    public List<Merch> getListMerchByOrderId(
            @Nullable final String orderId
    ) {
        if (orderId == null || orderId.isEmpty()) return Collections.emptyList();
        return em.createQuery("SELECT e FROM Merch e WHERE e.order.id = :orderId ORDER BY e.created", Merch.class)
                .setParameter("orderId", orderId).getResultList();
    }

    @Nullable
    public Merch getMerchById(@Nullable final String merchId) {
        if (merchId == null || merchId.isEmpty()) return null;
        return getEntity(em.createQuery("SELECT e FROM Merch e WHERE e.id =:id", Merch.class)
                .setParameter("id", merchId));
    }

    @Nullable
    public Merch persist(@Nullable final Merch merch) {
        if (merch == null) return null;
        em.persist(merch);
        return merch;
    }

    @Nullable
    public Merch merge(@Nullable final Merch merch) {
        if (merch == null) return null;
        return em.merge(merch);
    }

    public void removeMerchById(@Nullable final String merchId) {
        if (merchId == null || merchId.isEmpty()) return;
        final Merch merch = getMerchById(merchId);
        em.remove(merch);
    }









}
