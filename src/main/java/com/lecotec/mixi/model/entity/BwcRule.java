package com.lecotec.mixi.model.entity;

import java.io.Serializable;

import javax.persistence.*;

@Entity
@Table(name = "mx_bwc_rule")
public class BwcRule implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name = "zhima_score",columnDefinition = "INT DEFAULT NULL COMMENT '芝麻信誉分'")
	private int zmScore;
	
	@Column(name = "repay_deadline_days",columnDefinition = "INT DEFAULT NULL COMMENT '还款天数'")
	private int rePayDays;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public int getZmScore() {
		return zmScore;
	}

	public void setZmScore(int zmScore) {
		this.zmScore = zmScore;
	}

	public int getRePayDays() {
		return rePayDays;
	}

	public void setRePayDays(int rePayDays) {
		this.rePayDays = rePayDays;
	}

	@Override
	public String toString() {
		return "BwcRule [id=" + id + ", zmScore=" + zmScore + ", rePayDays=" + rePayDays + "]";
	}
}
