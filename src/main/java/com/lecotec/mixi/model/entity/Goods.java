package com.lecotec.mixi.model.entity;

import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;
import java.util.Date;

@Entity
@Table(name = "mx_goods")
public class Goods {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty(hidden = true)
    private long id;

    @Column(name = "goods_type_id")
    private long goodsTypeId;

    @NotBlank
    private String name;

    @NotBlank
    private String description;

    @Column(name = "image_path")
    @NotBlank
    private String imagePath;

    @Column(name = "min_purchase_count")
    @Positive
    private int minPurchaseCount;

    @Column(name = "set_meal_detail")
    @NotBlank
    private String setMealDetail;

    @NotBlank
    private String tag;

    @Column(columnDefinition = "TEXT NULL")
    private String specs;

    @Column(columnDefinition = "TEXT NULL")
    private String properties;

    private String material;

    @Column(name = "selling_config")
    private String sellingConfig;

    @Column(name = "is_active")
    @ApiModelProperty(hidden = true)
    private boolean isActive = true;

    @ApiModelProperty(hidden = true)
    @Column(name = "creation_time", insertable = false, columnDefinition = "TIMESTAMP DEFAULT NOW()")
    private Date creationTime;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getGoodsTypeId() {
        return goodsTypeId;
    }

    public void setGoodsTypeId(long goodsTypeId) {
        this.goodsTypeId = goodsTypeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public int getMinPurchaseCount() {
        return minPurchaseCount;
    }

    public void setMinPurchaseCount(int minPurchaseCount) {
        this.minPurchaseCount = minPurchaseCount;
    }

    public String getSetMealDetail() {
        return setMealDetail;
    }

    public void setSetMealDetail(String setMealDetail) {
        this.setMealDetail = setMealDetail;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public String getSpecs() {
        return specs;
    }

    public void setSpecs(String specs) {
        this.specs = specs;
    }

    public String getProperties() {
        return properties;
    }

    public void setProperties(String properties) {
        this.properties = properties;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public String getSellingConfig() {
        return sellingConfig;
    }

    public void setSellingConfig(String sellingConfig) {
        this.sellingConfig = sellingConfig;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public Date getCreationTime() {
        return creationTime;
    }

    public void setCreationTime(Date creationTime) {
        this.creationTime = creationTime;
    }
}
