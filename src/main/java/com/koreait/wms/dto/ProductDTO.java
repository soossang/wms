package com.koreait.wms.dto;

public class ProductDTO {
	private String product_code;
	private String product_name;
	private int product_size;
	private int product_incost;
	private int product_outcost;
	public String getProduct_code() {
		return product_code;
	}
	public void setProduct_code(String product_code) {
		this.product_code = product_code;
	}
	public String getProduct_name() {
		return product_name;
	}
	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}
	public int getProduct_size() {
		return product_size;
	}
	public void setProduct_size(int product_size) {
		this.product_size = product_size;
	}
	public int getProduct_incost() {
		return product_incost;
	}
	public void setProduct_incost(int product_incost) {
		this.product_incost = product_incost;
	}
	public int getProduct_outcost() {
		return product_outcost;
	}
	public void setProduct_outcost(int product_outcost) {
		this.product_outcost = product_outcost;
	}
}
