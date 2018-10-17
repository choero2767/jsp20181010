package kr.or.ddit.prod.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import kr.or.ddit.prod.dao.ProdDao;
import kr.or.ddit.prod.model.ProdVo;
import kr.or.ddit.util.model.pageVo.PageVo;

public class ProdService implements ProdServiceInf{
	
	private ProdDao dao = new ProdDao();
	private static ProdService service;
	

	@Override
	public Map<String, Object> selectProdPageList(PageVo pageVo) {
		
		// 페이지에 해당하는 상품 리스트(1~10건 사이)
		List<ProdVo> prodList = dao.selectProdPageList(pageVo);

		// 페이지 내비게이션을 위한 상품리스트 조회
		int totalUserCnt = dao.getProdCnt();

		// 결과를 담는 map
		Map<String, Object> resultMap = new HashMap<String, Object>();
		resultMap.put("prodList", prodList);
		resultMap.put("pageCnt",
				(int) Math.ceil((double) totalUserCnt / pageVo.getPageSize()));

		return resultMap;
	}

	@Override
	public ProdVo selectProdDetail(String prod_id) {
		
		ProdVo prodVo = dao.selectProdDetail(prod_id);
		
		return prodVo;
	}

}
