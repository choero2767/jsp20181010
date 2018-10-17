package kr.or.ddit.prod.service;

import java.util.Map;

import kr.or.ddit.prod.model.ProdVo;
import kr.or.ddit.util.model.pageVo.PageVo;

public interface ProdServiceInf {
	
	public Map<String, Object> selectProdPageList(PageVo pageVo);
	
	public ProdVo selectProdDetail(String prod_id);

}
