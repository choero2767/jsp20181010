package kr.or.ddit.user.model;

import java.util.Date;

import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionBindingListener;

public class UserVo implements HttpSessionBindingListener{
	private String userId;
	private String name;
	private String alias;
	private Date birth;
	private String pass;
	private String add1;
	private String add2;
	private String zipcd;
	private String email;
	private String tel;
	private String profile;
	private int rnum;
	
	
	
	public int getRnum() {
		return rnum;
	}

	public void setRnum(int rnum) {
		this.rnum = rnum;
	}

	public UserVo() {
		super();
	}
	
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAlias() {
		return alias;
	}
	public void setAlias(String alias) {
		this.alias = alias;
	}
	public Date getBirth() {
		return birth;
	}
	public void setBirth(Date birth) {
		this.birth = birth;
	}
	
	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public String getAdd1() {
		return add1;
	}

	public void setAdd1(String add1) {
		this.add1 = add1;
	}

	public String getAdd2() {
		return add2;
	}

	public void setAdd2(String add2) {
		this.add2 = add2;
	}

	public String getZipcd() {
		return zipcd;
	}

	public void setZipcd(String zipcd) {
		this.zipcd = zipcd;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getProfile() {
		return profile;
	}

	public void setProfile(String profile) {
		this.profile = profile;
	}

	@Override
	public String toString() {
		return "UserVo [userId=" + userId + ", name=" + name + ", alias="
				+ alias + ", birth=" + birth + ", pass=" + pass + ", add1="
				+ add1 + ", add2=" + add2 + ", zipcd=" + zipcd + ", email="
				+ email + ", tel=" + tel + ", profile=" + profile + "]";
	}

	@Override
	public void valueBound(HttpSessionBindingEvent event) {
		System.out.println("userVo : " + event.getName());
		
	}

	@Override
	public void valueUnbound(HttpSessionBindingEvent event) {
		
	}

	
	
}
