package com.lecotec.mixi.model.entity;

import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.Date;

@Entity
@Table(name = "mx_merchant_user_type")
public class MerchantUserType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty(hidden = true)
    private long id;

    @NotBlank
    @Column(unique = true)
    private String name;

    @NotBlank
    @ApiModelProperty("管理权限，传参方式：['商家入驻','骑手入驻',...]，如果选择某一个大类的‘全部’，请填写当前大类的所有条目")
    private String permissionJson = "[]";

    @ApiModelProperty(hidden = true)
    private Date creationTime = new Date();

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getCreationTime() {
        return creationTime;
    }

    public void setCreationTime(Date creationTime) {
        this.creationTime = creationTime;
    }

    public String getPermissionJson() {
        return permissionJson;
    }

    public void setPermissionJson(String permissionJson) {
        this.permissionJson = permissionJson;
    }
}
