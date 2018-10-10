package kr.or.ddit.db;

import static org.junit.Assert.*;

import java.util.List;
import java.util.Map;

import kr.or.ddit.user.dao.UserDao;
import kr.or.ddit.user.model.UserVo;

import org.junit.Test;

public class TempDaoTest {

	// 테스트 메소드 명명 규칙(회사마다 다름)
//	@Test
//	public void test() {
//		/***Given : 주어진 상황***/
//		UserDao userDao = new UserDao();
//
//		/***When : 어떤 동작 수행(메소드)***/
//		Map<String, Object> map = userDao.getTemp();
//		System.out.println("map : " + map);
//		
//		/***Then : 결과가 어떠해야하는지 정의***/
//		assertEquals("X", map.get("result"));
//	}
	
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

}
