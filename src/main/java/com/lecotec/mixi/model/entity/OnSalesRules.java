package com.lecotec.mixi.model.entity;

import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "mx_on_sales_rules")
public class OnSalesRules {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty(hidden = true)
    private long id;

    @Column(name = "price_on_sales")
    private double priceOnSales;

    @Column(name = "count_on_sales")
    private int countOnSales;

    @Column(name = "is_active", columnDefinition = "BIT(1) DEFAULT true")
    private boolean isActive;

    @Column(name = "goods_id")
    private long goodsId;

    @ApiModelProperty(hidden = true)
    @Column(name = "creation_time", insertable = false, columnDefinition = "TIMESTAMP DEFAULT NOW()")
    private Date creationTime;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public double getPriceOnSales() {
        return priceOnSales;
    }

    public void setPriceOnSales(double priceOnSales) {
        this.priceOnSales = priceOnSales;
    }

    public int getCountOnSales() {
        return countOnSales;
    }

    public void setCountOnSales(int countOnSales) {
        this.countOnSales = countOnSales;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public long getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(long goodsId) {
        this.goodsId = goodsId;
    }

    public Date getCreationTime() {
        return creationTime;
    }

    public void setCreationTime(Date creationTime) {
        this.creationTime = creationTime;
    }
}
