package com.lecotec.mixi.model.entity;

import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "mx_customer_collection")
public class CustomerCollection {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty(hidden = true)
    private long id;

    @Column(name = "collected_issue_id")
    private long collectedIssueId;

    @Column(name = "issue_type")
    private String issueType;

    @Column(name = "customer_id")
    private long customerId;

    @ApiModelProperty(hidden = true)
    @Column(name = "creation_time", insertable = false, columnDefinition = "TIMESTAMP DEFAULT NOW()")
    private Date creationTime;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getCollectedIssueId() {
        return collectedIssueId;
    }

    public void setCollectedIssueId(long collectedIssueId) {
        this.collectedIssueId = collectedIssueId;
    }

    public String getIssueType() {
        return issueType;
    }

    public void setIssueType(String issueType) {
        this.issueType = issueType;
    }

    public long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(long customerId) {
        this.customerId = customerId;
    }

    public Date getCreationTime() {
        return creationTime;
    }

    public void setCreationTime(Date creationTime) {
        this.creationTime = creationTime;
    }
}
