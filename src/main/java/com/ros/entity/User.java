package com.ros.entity;

import java.util.Date;

import org.omg.CosNaming.NamingContextExtPackage.StringNameHelper;

/**
 * @author 何婷婷
 *
 */

public class User {

	private int id;
	private String username;
	private String passwd;
	private String second;
	private int tel;
	private String sex;
	private String email;
	private String qq;
	private String wechat;
	private Date registerTime;
	private int loginTime;// 登陆次数
	private String headImage;
	private String userSign;
	private String carrer;
	private String userLabel;
	private String userClassify;
	private Date bornTime;
	private String province;
	private String city;
	private String country;
	private int accountId;
	private int isBlog;
	private String department;
	private String schoolName;
	private int type;
	private String interest;
	private double longitude;
	private double latitude;
	private String note;
	private String education;
	/**
	 * 注册页面的提示信息
	 */
	private String message;

	
	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getEducation() {
		return education;
	}

	public void setEducation(String education) {
		this.education = education;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getSchoolName() {
		return schoolName;
	}

	public void setSchoolName(String schoolName) {
		this.schoolName = schoolName;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getSecond() {
		return second;
	}

	public void setSecond(String second) {
		this.second = second;
	}

	public int getTel() {
		return tel;
	}

	public void setTel(int tel) {
		this.tel = tel;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getQq() {
		return qq;
	}

	public void setQq(String qq) {
		this.qq = qq;
	}

	public String getWechat() {
		return wechat;
	}

	public void setWechat(String wechat) {
		this.wechat = wechat;
	}

	public Date getRegisterTime() {
		return registerTime;
	}

	public void setRegisterTime(Date registerTime) {
		this.registerTime = registerTime;
	}

	public int getLoginTime() {
		return loginTime;
	}

	public void setLoginTime(int loginTime) {
		this.loginTime = loginTime;
	}

	public String getHeadImage() {
		return headImage;
	}

	public void setHeadImage(String headImage) {
		this.headImage = headImage;
	}

	public String getUserSign() {
		return userSign;
	}

	public void setUserSign(String userSign) {
		this.userSign = userSign;
	}

	public String getCarrer() {
		return carrer;
	}

	public void setCarrer(String carrer) {
		this.carrer = carrer;
	}

	public String getUserLabel() {
		return userLabel;
	}

	public void setUserLabel(String userLabel) {
		this.userLabel = userLabel;
	}

	public String getUserClassify() {
		return userClassify;
	}

	public void setUserClassify(String userClassify) {
		this.userClassify = userClassify;
	}

	public Date getBornTime() {
		return bornTime;
	}

	public void setBornTime(Date bornTime) {
		this.bornTime = bornTime;
	}

	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public int getAccountId() {
		return accountId;
	}

	public void setAccountId(int accountId) {
		this.accountId = accountId;
	}

	public int getIsBlog() {
		return isBlog;
	}

	public void setIsBlog(int isBlog) {
		this.isBlog = isBlog;
	}



	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public String getInterest() {
		return interest;
	}

	public void setInterest(String interest) {
		this.interest = interest;
	}

	public double getLongitude() {
		return longitude;
	}

	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}

	public double getLatitude() {
		return latitude;
	}

	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPasswd() {
		return passwd;
	}

	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}

}
