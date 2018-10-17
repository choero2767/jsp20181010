package kr.or.ddit.prod.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import kr.or.ddit.db.SqlFactoryBuilder;
import kr.or.ddit.prod.model.ProdVo;
import kr.or.ddit.util.model.pageVo.PageVo;

public class ProdDao implements ProdDaoInf{

	/**
	* Method : selectProdPageList
	* 작성자 : pc23
	* 변경이력 :
	* @param pageVo
	* @return
	* Method 설명 : 상품 페이지 리스트
	*/
	@Override
	public List<ProdVo> selectProdPageList(PageVo pageVo) {
		SqlSessionFactory factory = SqlFactoryBuilder.getSqlSessionFactory();
		SqlSession session = factory.openSession();
		
		List<ProdVo> pageList = session.selectList("prod.selectProdPageList");
		
		session.commit();
		session.close();
		
		return pageList;
	}

	@Override
	public int getProdCnt() {
		SqlSessionFactory factory = SqlFactoryBuilder.getSqlSessionFactory();
		SqlSession session = factory.openSession();
		
		int totalUserCnt = session.selectOne("prod.getProdCnt");
		
		session.close();
		
		return totalUserCnt;
	}

	@Override
	public ProdVo selectProdDetail(String prod_id) {
		SqlSessionFactory factory = SqlFactoryBuilder.getSqlSessionFactory();
		SqlSession session = factory.openSession();
		
		ProdVo prodVo = session.selectOne("prod.selectProdDetail");
		
		session.close();
		
		return prodVo;
	}
	
}
