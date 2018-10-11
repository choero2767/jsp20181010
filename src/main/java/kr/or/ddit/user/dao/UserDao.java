package kr.or.ddit.user.dao;

import java.util.List;

import kr.or.ddit.db.SqlFactoryBuilder;
import kr.or.ddit.user.model.UserVo;
import kr.or.ddit.util.model.pageVo.PageVo;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

public class UserDao implements UserDaoInf{
	public List<UserVo> selectUserAll(){
		SqlSessionFactory factory = SqlFactoryBuilder.getSqlSessionFactory();
		SqlSession session = factory.openSession();
		
		// selectOne : 데이터가 한건일때
		// selectList : 여러건의 데이터를 조회
		// 메서드 인자 : 문자열 = 네임스페이스(모듈명).쿼리아이디
		
		List<UserVo> userList = session.selectList("user.selectUserAll");
//		session.rollback();
		session.commit();
		session.close();
		
		return userList;
	}
	
	public UserVo selectUser(String userName){
		SqlSessionFactory factory = SqlFactoryBuilder.getSqlSessionFactory();
		SqlSession session = factory.openSession();
		
		UserVo userList1 = session.selectOne("user.selectUser", userName);
		
		session.commit();
		session.close();
		
		return userList1;
	}
	
	public UserVo selectUser(UserVo userVo){
		SqlSessionFactory factory = SqlFactoryBuilder.getSqlSessionFactory();
		SqlSession session = factory.openSession();
		
		UserVo userList2 = session.selectOne("user.selectUser");
		
		session.commit();
		session.close();
		
		return userList2;
	}

	@Override
	public UserVo selectedUser(UserVo userPw) {
		SqlSessionFactory factory = SqlFactoryBuilder.getSqlSessionFactory();
		SqlSession session = factory.openSession();
		
		UserVo userList3 = session.selectOne("user.selectUserByVo", userPw);
		
		session.commit();
		session.close();
		
		return userList3;
	}
	
	
	@Override
	public List<UserVo> selectUserPageList(PageVo pageVo) {
		SqlSessionFactory factory = SqlFactoryBuilder.getSqlSessionFactory();
		SqlSession session = factory.openSession();
		
		List<UserVo> pageList = session.selectList("user.selectUserPageList", pageVo);
		
		session.commit();
		session.close();
		
		return pageList;
	}

	/**
	* Method : getUserCnt
	* 작성자 : pc23
	* 변경이력 :
	* @return
	* Method 설명 : 사용자 전체 건수 조회
	*/
	@Override
	public int getUserCnt() {
		SqlSessionFactory factory = SqlFactoryBuilder.getSqlSessionFactory();
		SqlSession session = factory.openSession();
		
		int totalUserCnt = session.selectOne("user.getUserCnt");
		
		session.close();
		
		return totalUserCnt;
	}
	
}
