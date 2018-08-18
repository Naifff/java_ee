package ru.geekbrains.enterprise.controller;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.geekbrains.enterprise.dao.CategoryDAO;
import ru.geekbrains.enterprise.dao.MerchDAO;
import ru.geekbrains.enterprise.dao.OrderDAO;
import ru.geekbrains.enterprise.entity.Category;
import ru.geekbrains.enterprise.entity.Merch;
import ru.geekbrains.enterprise.entity.Order;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import java.util.List;

@ViewScoped
@ManagedBean
public class AdminkaController {

    @Inject
    private CategoryDAO categoryDAO;

    @Inject
    private MerchDAO merchDAO;

    @Inject
    private OrderDAO orderDAO;

    @Nullable
    private String orderId;

    @Nullable
    private String merchId;

    @Nullable
    private String categoryId;

    @NotNull
    private Merch merch = new Merch();

    @NotNull
    private Order order = new Order();

    @NotNull
    private Category category = new Category();

    public void init() {
        @Nullable final Merch merch = merchDAO.getMerchById(merchId);
        if (merch != null) this.merch = merch;
        @Nullable final Order order = orderDAO.getOrderById(orderId);
        if (order != null) this.order = order;
        @Nullable final Category category = categoryDAO.getCategoryById(categoryId);
        if (category != null) this.category = category;
    }

    @NotNull
    public String save() {
//        if (orderId != null) merch.setOrder(orderDAO.getOrderById(orderId));
        if (categoryId != null) merch.setCategory(categoryDAO.getCategoryById(categoryId));
        merchDAO.merge(merch);
        return "adminka";
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getMerchId() {
        return merchId;
    }

    public void setMerchId(String merchId) {
        this.merchId = merchId;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public String getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(String categoryId) {
        this.categoryId = categoryId;
    }

    public Merch getMerch() {
        return merch;
    }

    public void setMerch(Merch merch) {
        this.merch = merch;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    @NotNull
    public List<Merch> getListMerchOrder() {
        if (orderId == null || orderId.isEmpty()) return merchDAO.getListMerch();
        return merchDAO.getListMerchByOrderId(orderId);
    }

    @NotNull
    public List<Merch> getListMerchCategory() {
        if (categoryId == null || categoryId.isEmpty()) return merchDAO.getListMerch();
        return merchDAO.getListMerchByCategoryId(categoryId);
    }

    public void removeMerchById(@Nullable final String merchId) {
        merchDAO.removeMerchById(merchId);
    }
}
