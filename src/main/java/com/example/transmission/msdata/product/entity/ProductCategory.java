/**
 * Copyright &copy; 2012-2014 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.example.transmission.msdata.product.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;

import java.util.Date;
import java.util.List;

/**
 * 商品分类管理Entity
 * 
 * @author liuluansha
 * @version 2017-09-14
 */
public class ProductCategory {

	private static final long serialVersionUID = 1L;
	// private XlsProductCategory parent; // 父id
	// private String name; // 名称 父类已有
	private String id;
	private Date beginCreateDate; // 开始 创建时间
	private Date endCreateDate; // 结束 创建时间
	private Date beginUpdateDate; // 开始 更新时间
	private Date endUpdateDate; // 结束 更新时间

	private String ktypeid;// 仓库id，用于接口查询，数据库无此字段

	public ProductCategory() {
		super();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	// @Length(min=0, max=64, message="名称长度必须介于 0 和 64 之间")
	// public String getName() {
	// return name;
	// }
	//
	// public void setName(String name) {
	// this.name = name;
	// }

	public Date getBeginCreateDate() {
		return beginCreateDate;
	}

	public void setBeginCreateDate(Date beginCreateDate) {
		this.beginCreateDate = beginCreateDate;
	}

	public Date getEndCreateDate() {
		return endCreateDate;
	}

	public void setEndCreateDate(Date endCreateDate) {
		this.endCreateDate = endCreateDate;
	}

	public Date getBeginUpdateDate() {
		return beginUpdateDate;
	}

	public void setBeginUpdateDate(Date beginUpdateDate) {
		this.beginUpdateDate = beginUpdateDate;
	}

	public Date getEndUpdateDate() {
		return endUpdateDate;
	}

	public void setEndUpdateDate(Date endUpdateDate) {
		this.endUpdateDate = endUpdateDate;
	}


	public String getKtypeid() {
		return ktypeid;
	}

	public void setKtypeid(String ktypeid) {
		this.ktypeid = ktypeid;
	}

	// public String getParentId() {
	// return parent != null && parent.getId() != null ? parent.getId() : "0";
	// }
}