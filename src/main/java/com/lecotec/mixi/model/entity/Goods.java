package com.lecotec.mixi.model.entity;

import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "mx_goods")
public class Goods {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty(hidden = true)
    private long id;

    @Column(name = "goods_name")
    private String goodsName;

    @Column(name = "goods_type")
    private String goodsType;

    @Column(name = "goods_tag")
    private String goodsTag;

    @Column(name = "goods_price")
    private double goodsPrice;

    @Column(name = "image_address")
    private String imageAddress;

    @Column(name = "is_active")
    private boolean isActive;

    private String description;

    @Column(name = "max_stock", columnDefinition = "int(11) DEFAULT NULL COMMENT '最大库存'")
    private int maxStock;

    @Column(name = "currentStock", columnDefinition = "int(11) DEFAULT NULL COMMENT '当前库存'")
    private int currentStock;

    @Column(name = "min_buy_number")
    private int minBuyNumber;

    @Column(name = "is_set_meal", columnDefinition = "BIT(1) DEFAULT NULL COMMENT '是否是套餐'")
    private boolean isSetMeal;

    @Column(name = "goods_standard", columnDefinition = "VARCHAR(255) DEFAULT NULL COMMENT '商品规格'")
    private String goodsStandard;

    @Column(name = "meal_box_price")
    private double mealBoxPrice;

    @Column(name = "goods_attribute")
    private String goodsAttribute;

    @Column(name = "goods_material")
    private String goodsMaterial;

    @Column(name = "selling_time")
    private Date sellingTime;

    @ApiModelProperty(hidden = true)
    @Column(name = "creation_time", insertable = false, columnDefinition = "TIMESTAMP DEFAULT NOW()")
    private Date creationTime;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public String getGoodsType() {
        return goodsType;
    }

    public void setGoodsType(String goodsType) {
        this.goodsType = goodsType;
    }

    public String getGoodsTag() {
        return goodsTag;
    }

    public void setGoodsTag(String goodsTag) {
        this.goodsTag = goodsTag;
    }

    public double getGoodsPrice() {
        return goodsPrice;
    }

    public void setGoodsPrice(double goodsPrice) {
        this.goodsPrice = goodsPrice;
    }

    public String getImageAddress() {
        return imageAddress;
    }

    public void setImageAddress(String imageAddress) {
        this.imageAddress = imageAddress;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getMaxStock() {
        return maxStock;
    }

    public void setMaxStock(int maxStock) {
        this.maxStock = maxStock;
    }

    public int getCurrentStock() {
        return currentStock;
    }

    public void setCurrentStock(int currentStock) {
        this.currentStock = currentStock;
    }

    public int getMinBuyNumber() {
        return minBuyNumber;
    }

    public void setMinBuyNumber(int minBuyNumber) {
        this.minBuyNumber = minBuyNumber;
    }

    public boolean isSetMeal() {
        return isSetMeal;
    }

    public void setSetMeal(boolean setMeal) {
        isSetMeal = setMeal;
    }

    public String getGoodsStandard() {
        return goodsStandard;
    }

    public void setGoodsStandard(String goodsStandard) {
        this.goodsStandard = goodsStandard;
    }

    public double getMealBoxPrice() {
        return mealBoxPrice;
    }

    public void setMealBoxPrice(double mealBoxPrice) {
        this.mealBoxPrice = mealBoxPrice;
    }

    public String getGoodsAttribute() {
        return goodsAttribute;
    }

    public void setGoodsAttribute(String goodsAttribute) {
        this.goodsAttribute = goodsAttribute;
    }

    public String getGoodsMaterial() {
        return goodsMaterial;
    }

    public void setGoodsMaterial(String goodsMaterial) {
        this.goodsMaterial = goodsMaterial;
    }

    public Date getSellingTime() {
        return sellingTime;
    }

    public void setSellingTime(Date sellingTime) {
        this.sellingTime = sellingTime;
    }

    public Date getCreationTime() {
        return creationTime;
    }

    public void setCreationTime(Date creation_time) {
        this.creationTime = creation_time;
    }
}
