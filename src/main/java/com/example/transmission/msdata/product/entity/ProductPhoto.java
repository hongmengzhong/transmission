/**
 * 
 */
package com.example.transmission.msdata.product.entity;

import org.hibernate.validator.constraints.Length;

import java.util.Date;

/**
 * 商品图片Entity
 * @author 刘娈莎
 * @version 2018-06-28
 */
public class ProductPhoto {

	private static final long serialVersionUID = 1L;
	private String id;
	private Product product; // 商品
	private String name; // 名称
	private String url; // 图片地址
	private String photoType; // 图片类型
	private String isMain; // 是否主图
	private String order; // 图片顺序
	private String key; // 图片key
	private Date beginCreateDate; // 开始 创建时间
	private Date endCreateDate; // 结束 创建时间
	private Date beginUpdateDate; // 开始 更新时间
	private Date endUpdateDate; // 结束 更新时间

	public ProductPhoto() {
		super();
	}
	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	@Length(min = 0, max = 64, message = "名称长度必须介于 0 和 64 之间")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Length(min = 0, max = 256, message = "图片地址长度必须介于 0 和 256 之间")
	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	@Length(min = 0, max = 64, message = "图片类型长度必须介于 0 和 64 之间")
	public String getPhotoType() {
		return photoType;
	}

	public void setPhotoType(String photoType) {
		this.photoType = photoType;
	}

	@Length(min = 0, max = 64, message = "是否主图长度必须介于 0 和 64 之间")
	public String getIsMain() {
		return isMain;
	}

	public void setIsMain(String isMain) {
		this.isMain = isMain;
	}

	@Length(min = 0, max = 11, message = "图片顺序长度必须介于 0 和 11 之间")
	public String getOrder() {
		return order;
	}

	public void setOrder(String order) {
		this.order = order;
	}

	@Length(min = 0, max = 64, message = "图片key长度必须介于 0 和 64 之间")
	public String getKey() {
		return key;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setKey(String key) {
		this.key = key;
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