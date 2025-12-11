package com.koreait.wms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.koreait.wms.dao.ProductDAO;
import com.koreait.wms.dto.DetailDTO;
import com.koreait.wms.dto.InoutDTO;
import com.koreait.wms.dto.ProductDTO;
import com.koreait.wms.dto.SalesDTO;

@Service
public class ProductService {
	@Autowired
	private ProductDAO dao;

	public List<ProductDTO> getProduct() {
		return dao.selectProductTbl();
	}
	public int getSumIncost() {
		return dao.selectSumIncost();
	}
	public int getSumOutcost() {
		return dao.selectSumOutcost();
	}
	
	public String getNextTno() {
		return dao.selectNextTno();
	}
	
	public void addInout(InoutDTO dto) {
		dao.insertInoutTbl(dto);
	}
	
	public List<DetailDTO> getDetailList() {
		return dao.selectJoinInout();
	}
	
	public List<SalesDTO> getSalesList() {
		return dao.selectInoutSales();
	}
	
	public int getSumOutCount() {
		return dao.selectSumOutCount();
	}
	
	public int getSumSalesCost() {
		return dao.selectSumSalesCost();
	}
}
