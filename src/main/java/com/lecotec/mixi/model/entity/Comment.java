package com.lecotec.mixi.model.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;

import io.swagger.annotations.ApiModelProperty;


/**
 * 评论
 * @author XINGYI
 *
 */
@Entity
@Table(name = "mx_comment")
public class Comment implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Column(name = "order_id",columnDefinition = "BIGINT(20) DEFAULT NULL COMMENT '订单的ID'")
	private long orderId;

	@Column(name = "user_name",columnDefinition = "varchar(255) DEFAULT NULL COMMENT '用户昵称'")
	private String userName;

	@Column(name = "ip_address",columnDefinition = "varchar(255) DEFAULT NULL COMMENT 'ip地址'")
	private String ipAddress;

	@Column(name = "reply_state",columnDefinition = "varchar(255) DEFAULT NULL COMMENT '回复状态'")
	private String replyState;

	@Column(name = "is_show",columnDefinition = "BIT DEFAULT NULL COMMENT '是否显示(0是，1否)'")
	private boolean isShow;

	@Column(name = "station_name",columnDefinition = "varchar(255) DEFAULT NULL COMMENT '站点名称'")
	private String stationName;

	@Column(name = "station_id",columnDefinition = "varchar(255) DEFAULT NULL COMMENT '站点ID'")
	private String stationId;

	@Column(name = "rider_id",columnDefinition = "varchar(255) DEFAULT NULL COMMENT '骑手ID'")
	private long riderId;

	@Column(name = "rider_name",columnDefinition = "varchar(255) DEFAULT NULL COMMENT '骑手昵称'")
	private String riderName;

	@Column(name = "rider_level",columnDefinition = "int DEFAULT NULL COMMENT '骑手等级'")
	private String riderLevel;

	@Column(name = "rider_satisfaction",columnDefinition = "int DEFAULT NULL COMMENT '骑手满意程度(满意/不满意)'")
	private String riderSatisfaction;

	@Column(name = "shop_id",columnDefinition = "varchar(255) DEFAULT NULL COMMENT '店铺ID'")
	private long shopId;

	@Column(name = "shop_name",columnDefinition = "varchar(255) DEFAULT NULL COMMENT '店铺名称'")
	private String shopName;

	@Column(name = "shop_level",columnDefinition = "int DEFAULT NULL COMMENT '店铺星级'")
	private int shopLevel;

	@Column(name = "taste_level",columnDefinition = "int DEFAULT NULL COMMENT '口味等级'")
	private int tasteLevel;

	@Column(name = "package_level",columnDefinition = "int DEFAULT NULL COMMENT '包装等级'")
	private int packageLevel;

	@Column(name = "comment_description",columnDefinition = "LONGTEXT DEFAULT NULL COMMENT '评论描述'")
	private String commentDescription;

	@Column(columnDefinition = "varchar(255) DEFAULT NULL COMMENT '图片地址'")
	private String image;

	@ApiModelProperty(hidden = true)
	@Column(name = "creation_time", insertable = false, columnDefinition = "TIMESTAMP DEFAULT NOW()")
	private Date creationTime;
}
