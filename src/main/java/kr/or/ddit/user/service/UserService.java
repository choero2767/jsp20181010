package kr.or.ddit.user.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import kr.or.ddit.db.SqlFactoryBuilder;
import kr.or.ddit.user.dao.UserDao;
import kr.or.ddit.user.model.UserVo;
import kr.or.ddit.util.model.pageVo.PageVo;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

public class UserService implements UserServiceInf{

	private UserDao dao = new UserDao();
    private static UserService service;
	
	@Override
	public List<UserVo> selectUserAll() {
		return dao.selectUserAll();
	}

	@Override
	public UserVo selectUser(String userName) {
		return dao.selectUser(userName);
	}

	@Override
	public UserVo selectUser(UserVo userVo) {
		return dao.selectUser(userVo);
	}

	@Override
	public UserVo selectedUser(UserVo userPw) {
		return dao.selectedUser(userPw);
	}

	/**
	* Method : selectUserPageList
	* 작성자 : pc23
	* 변경이력 :
	* @param pageVo
	* @return
	* Method 설명 : 사용자 페이징 조회
	*/
	@Override
	public Map<String, Object> selectUserPageList(PageVo pageVo) {
		
		// 페이지에 해당하는 유저 리스트(1~10건 사이)
		List<UserVo> userList = dao.selectUserPageList(pageVo);
		
		// 페이지 내비게이션을 위한 전체 유저 리스트 조회
		int totalUserCnt = dao.getUserCnt();
		
		// 결과를 담는 map
		Map<String, Object> resultMap = new HashMap<String, Object>();
		resultMap.put("userList", userList);
		resultMap.put("pageCnt", (int)Math.ceil((double)totalUserCnt / pageVo.getPageSize()));
		
//		(int)Math.ceil((double)totalUserCnt / pageVo.getPageSize());
		
		return resultMap;
	}

	@Override
	public int insertUser(UserVo userVo) {
		return dao.insertUser(userVo);
	}

	@Override
	public int deleteUser(String userId) {
		return dao.deleteUser(userId);
	}

	@Override
	public int updateUser(UserVo userVo) {
		return dao.updateUser(userVo);
	}
	
	
	
}
