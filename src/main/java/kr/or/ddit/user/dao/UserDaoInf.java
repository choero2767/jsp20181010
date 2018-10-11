package kr.or.ddit.user.dao;

import java.util.List;

import kr.or.ddit.user.model.UserVo;
import kr.or.ddit.util.model.pageVo.PageVo;

public interface UserDaoInf {
	
	public List<UserVo> selectUserAll();
	
	public UserVo selectUser(String userName);
	
	public UserVo selectUser(UserVo userVo);
	
	public UserVo selectedUser(UserVo userPw);
	
	public List<UserVo> selectUserPageList(PageVo pageVo);
	
	/**
	* Method : getUserCnt
	* 작성자 : pc23
	* 변경이력 :
	* @return
	* Method 설명 : 사용자 전체 건수 조회
	*/
	int getUserCnt();
}
