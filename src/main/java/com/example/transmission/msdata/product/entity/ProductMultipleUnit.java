/**
 * 
 */
package com.example.transmission.msdata.product.entity;

import org.hibernate.validator.constraints.Length;

import java.util.Date;
import java.util.List;

/**
 * 多单位管理Entity
 * 
 * @author 刘娈莎
 * @version 2018-01-29
 */
public class ProductMultipleUnit {

	private static final long serialVersionUID = 1L;
	private String id;
	private String name; // 名称
	private String conversion; // 各单位换算关系（只是做显示使用）
	private Date beginCreateDate; // 开始 创建时间
	private Date endCreateDate; // 结束 创建时间
	private Date beginUpdateDate; // 开始 更新时间
	private Date endUpdateDate; // 结束 更新时间
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	public ProductMultipleUnit() {
		super();
	}

	@Length(min = 1, max = 64, message = "名称长度必须介于 1 和 64 之间")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Length(min = 0, max = 64, message = "各单位换算关系（只是做显示使用）长度必须介于 0 和 64 之间")
	public String getConversion() {
		return conversion;
	}

	public void setConversion(String conversion) {
		this.conversion = conversion;
	}

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

}