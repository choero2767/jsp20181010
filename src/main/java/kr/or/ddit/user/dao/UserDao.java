package kr.or.ddit.user.dao;

import java.util.List;

import kr.or.ddit.db.SqlFactoryBuilder;
import kr.or.ddit.user.model.UserVo;
import kr.or.ddit.utill.model.pageVo.PageVo;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

public class UserDao implements UserDaoInf{
	public List<UserVo> selectUserAll(){
		SqlSessionFactory factory = SqlFactoryBuilder.getSqlSessionFactory();
		SqlSession session = factory.openSession();
		
		// selectOne : 데이터가 한건일때
		// selectList : 여러건의 데이터를 조회
		// 메서드 인자 : 문자열 = 네임스페이스(모듈명).쿼리아이디
		return session.selectList("user.selectUserAll");
	}
	
	public UserVo selectUser(String userName){
		SqlSessionFactory factory = SqlFactoryBuilder.getSqlSessionFactory();
		SqlSession session = factory.openSession();
		
		return session.selectOne("user.selectUser", userName);
	}
	
	public UserVo selectUser(UserVo userVo){
		SqlSessionFactory factory = SqlFactoryBuilder.getSqlSessionFactory();
		SqlSession session = factory.openSession();
		
		return session.selectOne("user.selectUserByVo", userVo);
	}

	@Override
	public UserVo selectedUser(UserVo userPw) {
		SqlSessionFactory factory = SqlFactoryBuilder.getSqlSessionFactory();
		SqlSession session = factory.openSession();
		
		return session.selectOne("user.selectedUser", userPw);
	}
	
	
	@Override
	public PageVo selectUserPageList(PageVo pageVo) {
		SqlSessionFactory factory = SqlFactoryBuilder.getSqlSessionFactory();
		SqlSession session = factory.openSession();
		
		return session.selectOne("user.selectUserPageList", pageVo);
	}
	
}
