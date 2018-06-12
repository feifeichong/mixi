package com.lecotec.mixi.model.entity;

import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;

@Entity
@Table(name = "mx_goods_to_tag", uniqueConstraints = {@UniqueConstraint(name = "UK_googs_to_tag", columnNames = {"goods_id", "goods_tag_id"})})
public class GoodsToTag {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty(hidden = true)
    private long id;

    @ManyToOne
    @JoinColumn(name = "goods_id", referencedColumnName = "id")
    private Goods goods;

    @ManyToOne
    @JoinColumn(name = "goods_tag_id", referencedColumnName = "id")
    private GoodsTag goodsTag;
}
