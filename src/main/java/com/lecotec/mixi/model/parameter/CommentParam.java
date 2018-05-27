package com.lecotec.mixi.model.parameter;

import com.lecotec.mixi.model.entity.Comment;
import com.lecotec.mixi.model.entity.Customer;
import com.lecotec.mixi.model.entity.Order;

public class CommentParam extends Comment {
    private long orderId;
    private long customerId;

    public long getOrderId() {
        return orderId;
    }

    public void setOrderId(long orderId) {
        this.orderId = orderId;
        Order order = new Order();
        order.setId(orderId);
        super.setOrder(order);
    }

    public long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(long customerId) {
        this.customerId = customerId;
        Customer customer = new Customer();
        customer.setId(customerId);
        super.setCustomer(customer);
    }
}
