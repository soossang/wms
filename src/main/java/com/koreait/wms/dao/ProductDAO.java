package com.koreait.wms.dao;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.dao.DataAccessException;

import com.koreait.wms.dto.DetailDTO;
import com.koreait.wms.dto.InoutDTO;
import com.koreait.wms.dto.ProductDTO;
import com.koreait.wms.dto.SalesDTO;

@Mapper
public interface ProductDAO {
	@Select("select * from product_tbl")
	public List<ProductDTO> selectProductTbl() throws DataAccessException;
	@Select("select sum(product_incost) from product_tbl")
	public int selectSumIncost() throws DataAccessException;
	@Select("select sum(product_outcost) from product_tbl")
	public int selectSumOutcost() throws DataAccessException;
	@Select("select cast(max(t_no) + 1 as char) tno from inout_tbl")
	public String selectNextTno() throws DataAccessException;
	@Insert("insert into inout_tbl values (#{t_no},#{product_code},#{t_type},#{t_count},#{t_date},#{company_code})")
	public void insertInoutTbl(InoutDTO dto) throws DataAccessException;
	@Select("select i.t_no, i.product_code, p.product_name, i.t_type, i.t_count, c.company_name, i.t_date "
			+ "from inout_tbl i join product_tbl p on i.product_code = p.product_code "
			+ "join company_tbl c on i.company_code = c.company_code")
	public List<DetailDTO> selectJoinInout() throws DataAccessException;
	@Select("select i.product_code, p.product_name, sum(i.t_count) out_count, "
			+ "sum(i.t_count) * (p.product_outcost - p.product_incost) as sales_cost from inout_tbl i "
			+ "join product_tbl p on i.product_code = p.product_code where i.t_type = 'O' "
			+ "group by i.product_code, p.product_name")
	public List<SalesDTO> selectInoutSales() throws DataAccessException;
	@Select("select sum(t_count) from inout_tbl where t_type = 'O'")
	public int selectSumOutCount() throws DataAccessException;
	@Select("select sum( i.t_count * (p.product_outcost - p.product_incost) ) "
			+ "from inout_tbl i join product_tbl p on i.product_code = p.product_code where i.t_type = 'O'")
	public int selectSumSalesCost() throws DataAccessException;
}
