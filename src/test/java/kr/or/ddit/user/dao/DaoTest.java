package kr.or.ddit.user.dao;

import static org.junit.Assert.*;

import java.util.List;
import java.util.Map;

import kr.or.ddit.user.dao.UserDao;
import kr.or.ddit.user.model.UserVo;
import kr.or.ddit.util.model.pageVo.PageVo;

import org.junit.Before;
import org.junit.Test;

public class DaoTest {
	
	private UserDaoInf userDao;

	@Before
	public void setup(){
		userDao = new UserDao();
	}
	
	// 테스트 메소드 명명 규칙(회사마다 다름)
	@Test
	public void selectUserAllTest() {
		/***Given : 주어진 상황***/
		UserDao userDao = new UserDao();

		/***When : 어떤 동작 수행(메소드)***/
		List<UserVo> userList = userDao.selectUserAll();
		System.out.println("userList : " + userList);
		
		/***Then : 결과가 어떠해야하는지 정의***/
		assertEquals(105, userList.size());
		
	}
	
	@Test
	public void selectUserAllTest2(){
		/***Given***/
		UserDao userDao = new UserDao();

		/***When***/
		UserVo userVo = userDao.selectUser("brown");

		/***Then***/
		assertEquals("브라운", userVo.getName());
		assertEquals("brown", userVo.getUserId());

	}
	
	@Test
	public void selectUserAllTest3(){
		/***Given***/
		UserDao userDao = new UserDao();

		/***When***/
		UserVo userVo = new UserVo();
		userVo.setUserId("brown");

		userDao.selectUser(userVo);
		/***Then***/
		assertEquals("brown", userVo.getUserId());

	}
	
	@Test
	public void selectUserPageList(){
		/***Given***/
		UserDaoInf userDao = new UserDao();

		/***When***/
		PageVo pageVo = new PageVo();
		pageVo.setPage(1);
		pageVo.setPageSize(10);
		
		List<UserVo> pageList = userDao.selectUserPageList(pageVo);

		/***Then***/
		assertEquals(10 , pageList.size());

	}
	
	/**
	* Method : getUserCntTest
	* 작성자 : pc23
	* 변경이력 :
	* Method 설명 : 사용자 전체 건수 조회 테스트
	*/
	@Test
	public void getUserCntTest(){
		/***Given***/
		
		/***When***/
		int totalUserCnt = userDao.getUserCnt();
		
		/***Then***/
		assertEquals(105, totalUserCnt);
		
	}

}
