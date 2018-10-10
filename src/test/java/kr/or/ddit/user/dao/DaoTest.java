package kr.or.ddit.user.dao;

import static org.junit.Assert.*;

import java.util.List;
import java.util.Map;

import kr.or.ddit.user.dao.UserDao;
import kr.or.ddit.user.model.UserVo;

import org.junit.Test;

public class DaoTest {

	// 테스트 메소드 명명 규칙(회사마다 다름)
	@Test
	public void selectUserAllTest() {
		/***Given : 주어진 상황***/
		UserDao userDao = new UserDao();

		/***When : 어떤 동작 수행(메소드)***/
		List<UserVo> userList = userDao.selectUserAll();
		System.out.println("userList : " + userList);
		
		/***Then : 결과가 어떠해야하는지 정의***/
		assertEquals(5, userList.size());
		
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

}
