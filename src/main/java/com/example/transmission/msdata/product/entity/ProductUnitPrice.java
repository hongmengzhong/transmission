/**
 * 
 */
package com.example.transmission.msdata.product.entity;


/**
 * 商品单位价格Entity
 * 
 * @author 刘娈莎
 * @version 2018-01-31
 */
public class ProductUnitPrice {

	private static final long serialVersionUID = 1L;
	private String id;
	private Product product; // 商品
	private ProductSubUnit productSubUnit; // 副单位
	private double price; // 价格
	private double wholesalePrice;// 批发价

	public ProductUnitPrice() {
		super();
	}

	public ProductUnitPrice(Product product) {
		super();
		this.product = product;
	}



	public ProductUnitPrice(ProductSubUnit productSubUnit) {
		super();
		this.productSubUnit = productSubUnit;
	}

	public ProductUnitPrice(Product product, ProductSubUnit productSubUnit) {
		super();
		this.product = product;
		this.productSubUnit = productSubUnit;
	}


	public ProductUnitPrice(Product product, ProductSubUnit productSubUnit, double price) {
		super();
		this.product = product;
		this.productSubUnit = productSubUnit;
		this.price = price;
	}

	public ProductUnitPrice(Product product, ProductSubUnit productSubUnit, double price, double wholesalePrice) {
		super();
		this.product = product;
		this.productSubUnit = productSubUnit;
		this.price = price;
		this.wholesalePrice = wholesalePrice;
	}
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public ProductSubUnit getProductSubUnit() {
		return productSubUnit;
	}

	public void setProductSubUnit(ProductSubUnit productSubUnit) {
		this.productSubUnit = productSubUnit;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public double getWholesalePrice() {
		return wholesalePrice;
	}

	public void setWholesalePrice(double wholesalePrice) {
		this.wholesalePrice = wholesalePrice;
	}




}