package com.koreait.wms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.koreait.wms.dto.DetailDTO;
import com.koreait.wms.dto.InoutDTO;
import com.koreait.wms.dto.ProductDTO;
import com.koreait.wms.dto.SalesDTO;
import com.koreait.wms.service.ProductService;

@Controller
public class ProductController {
	@Autowired
	private ProductService service;
	
	@GetMapping("/")
	public String index() {
		return "index";
	}
	
	@GetMapping("/product") 
	public String getProduct(Model model) {
		List<ProductDTO> list = service.getProduct();
		int sumIncost = service.getSumIncost();
		int sumOutcost = service.getSumOutcost();
		model.addAttribute("list",list);
		model.addAttribute("sumIncost",sumIncost);
		model.addAttribute("sumOutcost",sumOutcost);
		return "product";
	}
	
	@GetMapping("/inout")
	public String viewInoutFrm(Model model) {
		String t_no = service.getNextTno();
		model.addAttribute("t_no",String.valueOf(t_no));
		return "inout";
	}
	
	@PostMapping("/addInout")
	public String addInout(InoutDTO dto) {
		service.addInout(dto);
		return "redirect:/";
	}
	
	@GetMapping("/detail")
	public String getDetail(Model model) {
		List<DetailDTO> list = service.getDetailList();
		model.addAttribute("list",list);
		return "detail";
	}
	
	@GetMapping("/sales")
	public String getSales(Model model) {
		List<SalesDTO> list = service.getSalesList();
		int sumOutCount = service.getSumOutCount();
		int sumSalesCost = service.getSumSalesCost();
		model.addAttribute("list",list);
		model.addAttribute("sumOutCount",sumOutCount);
		model.addAttribute("sumSalesCost",sumSalesCost);
		return "sales";
	}
}
