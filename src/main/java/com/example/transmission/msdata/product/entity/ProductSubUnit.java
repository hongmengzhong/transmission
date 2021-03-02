/**
 * 
 */
package com.example.transmission.msdata.product.entity;

import org.hibernate.validator.constraints.Length;

import java.util.Date;

/**
 * 多单位管理Entity
 * 
 * @author 刘娈莎
 * @version 2018-01-29
 */
public class ProductSubUnit{

	private static final long serialVersionUID = 1L;
	private String id;
	private ProductMultipleUnit productMultipleUnit; // 父类 多单位
	private String name; // 名称
	private double count; // 和主单位的换算关系（1：?）
	private String mainUnitFlag; // 是否主单位（1是，0否）
	private ProductUnitPrice productUnitPrice;// 副单位价格
	private int showOrder;// 显示顺序

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

	public ProductSubUnit(ProductMultipleUnit productMultipleUnit) {
		this.productMultipleUnit = productMultipleUnit;
	}

	@Length(min = 1, max = 64, message = "主键长度必须介于 1 和 64 之间")
	public ProductMultipleUnit getProductMultipleUnit() {
		return productMultipleUnit;
	}

	public void setProductMultipleUnit(ProductMultipleUnit productMultipleUnit) {
		this.productMultipleUnit = productMultipleUnit;
	}

	@Length(min = 1, max = 64, message = "名称长度必须介于 1 和 64 之间")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getCount() {
		return count;
	}

	public void setCount(double count) {
		this.count = count;
	}

	@Length(min = 0, max = 1, message = "是否主单位（1是，0否）长度必须介于 0 和 1 之间")
	public String getMainUnitFlag() {
		return mainUnitFlag;
	}

	public void setMainUnitFlag(String mainUnitFlag) {
		this.mainUnitFlag = mainUnitFlag;
	}

	public ProductUnitPrice getProductUnitPrice() {
		return productUnitPrice;
	}

	public void setProductUnitPrice(ProductUnitPrice productUnitPrice) {
		this.productUnitPrice = productUnitPrice;
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

	public int getShowOrder() {
		return showOrder;
	}

	public void setShowOrder(int showOrder) {
		this.showOrder = showOrder;
	}

}