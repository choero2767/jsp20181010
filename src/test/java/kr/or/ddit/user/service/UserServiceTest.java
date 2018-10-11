package kr.or.ddit.user.service;

import static org.junit.Assert.*;

import java.util.List;
import java.util.Map;

import kr.or.ddit.user.dao.UserDao;
import kr.or.ddit.user.dao.UserDaoInf;
import kr.or.ddit.user.model.UserVo;
import kr.or.ddit.util.model.pageVo.PageVo;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class UserServiceTest {

	// jUnit 실행주기
	// @BeforeClass 어노테이션이 적용된 메서드 실행(최초 1회)
	// @Before 어노테이션이 적용된 메서드 실행(테스트 메서드 실행전 실행)
	// @Test
	// @After 어노테이션이 적용된 메서드 실행(테스트 메서드 실행후 실행)
	// @AfterClass 어노테이션이 적용된 메서드 실행(최초 1회), 단 static 메서드로 선언

	// beforeClass
	// before --> selectUserAll --> after -->
	// before --> selectUser(String) --> after
	// before --> selectUser(UserVo) --> after
	// afterClass
	private String test = "";
	
	private UserServiceInf userService;

	@BeforeClass
	public static void beforeClass() {
		System.out.println("beforeClass");
	}

	@AfterClass
	public static void afterClass() {
		System.out.println("afterClass");
	}

	@Before
	public void before() {
		System.out.println("before");
		// userService = new UserService();
	}

	@After
	public void after() {
		System.out.println("after");
	}

	@Test
	public void selectUserAllTest() {
		/*** Given : 주어진 상황 ***/
		UserServiceInf userService = new UserService();

		/*** When : 어떤 동작 수행(메소드) ***/
		List<UserVo> userList = userService.selectUserAll();
		System.out.println("userList : " + userList);

		/*** Then : 결과가 어떠해야하는지 정의 ***/
		assertEquals(105, userList.size());

	}

	@Test
	public void selectUserAllTest2() {
		/*** Given ***/
		UserServiceInf userService = new UserService();

		/*** When ***/
		UserVo userVo = userService.selectUser("brown");

		/*** Then ***/
		assertEquals("브라운", userVo.getName());
		assertEquals("brown", userVo.getUserId());

	}

	@Test
	public void selectUserAllTest3() {
		/*** Given ***/
		UserServiceInf userService = new UserService();

		/*** When ***/
		UserVo userVo = new UserVo();
		userVo.setUserId("brown");

		userService.selectUser(userVo);
		/*** Then ***/
		assertEquals("brown", userVo.getUserId());

	}

	@Test
	public void selectUserPageList() {
		/*** Given ***/

		/*** When ***/
		PageVo pageVo = new PageVo();
		pageVo.setPage(1);
		pageVo.setPageSize(10);

		Map<String, Object> pageList = userService.selectUserPageList(pageVo);
		
		List<UserVo> userList = (List<UserVo>) pageList.get("userList");

		int pageCnt = (Integer)pageList.get("pageCnt");
		
		/*** Then ***/
		assertEquals(10, userList.size());
		assertEquals(11, pageCnt);

	}

}
