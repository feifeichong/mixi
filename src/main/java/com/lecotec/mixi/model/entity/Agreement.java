package com.lecotec.mixi.model.entity;

import java.io.Serializable;

import javax.persistence.*;

@Entity
@Table(name = "mx_agreement")
public class Agreement implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name = "rule_name",columnDefinition = "varchar(255) DEFAULT NULL COMMENT '协议名称'")
	private String ruleName;
	
	@Column(name = "rule_location",columnDefinition = "varchar(255) DEFAULT NULL COMMENT '协议位置'")
	private String ruleLocation;
	
	@Column(name = "rule_context",columnDefinition = "varchar(255) DEFAULT NULL COMMENT '协议内容'")
	private String ruleContext;
	
	@Column(name = "commit_time",columnDefinition = "varchar(255) DEFAULT NULL COMMENT '提交时间'")
	private String commitDate;
	
	@Column(name = "is_active",columnDefinition = "varchar(255) DEFAULT NULL COMMENT '上线/下线'")
	private boolean isActive;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getRuleName() {
		return ruleName;
	}

	public void setRuleName(String ruleName) {
		this.ruleName = ruleName;
	}

	public String getRuleLocation() {
		return ruleLocation;
	}

	public void setRuleLocation(String ruleLocation) {
		this.ruleLocation = ruleLocation;
	}

	public String getRuleContext() {
		return ruleContext;
	}

	public void setRuleContext(String ruleContext) {
		this.ruleContext = ruleContext;
	}

	public String getCommitDate() {
		return commitDate;
	}

	public void setCommitDate(String commitDate) {
		this.commitDate = commitDate;
	}

	public boolean getIsActive() {
		return isActive;
	}

	public void setIsActive(boolean isActive) {
		this.isActive = isActive;
	}

	@Override
	public String toString() {
		return "Agreement [id=" + id + ", ruleName=" + ruleName + ", ruleLocation=" + ruleLocation + ", ruleContext="
				+ ruleContext + ", commitDate=" + commitDate + ", isActive=" + isActive + "]";
	}
}
