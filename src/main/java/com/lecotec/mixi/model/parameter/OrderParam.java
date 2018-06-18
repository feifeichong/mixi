package com.lecotec.mixi.model.parameter;

import com.lecotec.mixi.model.entity.Customer;
import com.lecotec.mixi.model.entity.Goods;
import com.lecotec.mixi.model.entity.Order;
import com.lecotec.mixi.model.entity.Rider;

import java.util.ArrayList;
import java.util.List;

public class OrderParam extends Order {
    private long customerId;
    private long riderId;

    public long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(long customerId) {
        this.customerId = customerId;
        super.setCustomer(new Customer() {
            {
                setId(customerId);
            }
        });
    }

    public long getRiderId() {
        return riderId;
    }

    public void setRiderId(long riderId) {
        this.riderId = riderId;
        super.setRider(new Rider() {
            {
                setId(riderId);
            }
        });
    }
}
