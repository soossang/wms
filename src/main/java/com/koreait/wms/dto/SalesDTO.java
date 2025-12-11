package com.koreait.wms.dto;

public class SalesDTO {
	private String product_code;
	private String product_name;
	private int out_count;
	private int sales_cost;
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
	public int getOut_count() {
		return out_count;
	}
	public void setOut_count(int out_count) {
		this.out_count = out_count;
	}
	public int getSales_cost() {
		return sales_cost;
	}
	public void setSales_cost(int sales_cost) {
		this.sales_cost = sales_cost;
	}
}
