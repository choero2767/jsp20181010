package kr.or.ddit.user.dao;

import java.util.List;

import kr.or.ddit.user.model.UserVo;
import kr.or.ddit.utill.model.pageVo.PageVo;

public interface UserDaoInf {
	
	public List<UserVo> selectUserAll();
	
	public UserVo selectUser(String userName);
	
	public UserVo selectUser(UserVo userVo);
	
	public UserVo selectedUser(UserVo userPw);
	
	public PageVo selectUserPageList(PageVo pageVo);
}
