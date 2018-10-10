package kr.or.ddit.user.service;

import java.util.List;

import kr.or.ddit.db.SqlFactoryBuilder;
import kr.or.ddit.user.dao.UserDao;
import kr.or.ddit.user.model.UserVo;
import kr.or.ddit.utill.model.pageVo.PageVo;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

public class UserService implements UserServiceInf{

	private UserDao dao;
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

	@Override
	public PageVo selectUserPageList(PageVo pageVo) {
		return dao.selectUserPageList(pageVo);
	}
	
	
	
}
