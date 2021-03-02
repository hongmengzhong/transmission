/**
 * 
 */
package com.example.transmission.msdata.product.entity;

import org.hibernate.validator.constraints.Length;

/**
 * 商品型号Entity
 * 
 * @author liuluansha
 * @version 2017-09-20
 */
public class ProductModelNumber {

	private static final long serialVersionUID = 1L;
	private String id;
	private ProductBrand productBrand = new ProductBrand(); // 品牌
	private String name; // 名称
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	public ProductModelNumber() {
		super();
	}

	public ProductModelNumber(ProductBrand productBrand) {
		super();
		this.productBrand = productBrand;
	}


	public ProductBrand getProductBrand() {
		return productBrand;
	}

	public void setProductBrand(ProductBrand productBrand) {
		this.productBrand = productBrand;
	}

	@Length(min = 0, max = 64, message = "名称长度必须介于 0 和 64 之间")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}