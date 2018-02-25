package com.ros.controller;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import javax.mail.SendFailedException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.mybatis.spring.annotation.MapperScan;
import org.omg.CORBA.portable.ApplicationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttribute;

import com.alibaba.druid.sql.dialect.mysql.ast.statement.MySqlShowCreateProcedureStatement;
import com.alibaba.fastjson.JSONObject;
import com.ros.config.WebSecurityConfig;
import com.ros.entity.User;
import com.ros.service.MailService;
import com.ros.serviceimpl.LoginServiceImpl;
import com.ros.serviceimpl.MailServiceImpl;
import com.ros.util.DateUtil;
import com.ros.util.RandomUtil;

import ch.qos.logback.core.rolling.SizeAndTimeBasedRollingPolicy;

/**
 * @author 何婷婷
 *
 */
@EnableTransactionManagement
@MapperScan("com.ros.dao")
@Controller
public class LoginController {
	@Autowired
	LoginServiceImpl loginServiceImpl;
	@Autowired
	MailServiceImpl mailServiceImpl;

	private String message;
	private String msg;

	// @RequestMapping("/test")
	// public String test() {
	//// List<String> interests= new ArrayList<String>();
	//// interests=loginServiceImpl.getInterests();
	//// model.addAttribute("interests",interests);
	// return "test";
	// }
	@RequestMapping("/test")
	public String test() {
		return "test";
	}

	@RequestMapping(value = "/testPost", method = RequestMethod.POST)
	@ResponseBody
	public String testPost(HttpServletResponse response, HttpServletRequest request) {
		String str = "testpost";
		System.out.println(request.getParameter("interest"));
		return str;
	}
	@RequestMapping("/account")
	public String account(@SessionAttribute(WebSecurityConfig.SESSION_KEY) String username, Model model) {
		model.addAttribute("username", username);
		return "account";
	}
	@RequestMapping("/checkemail")
	public String checkemail(@SessionAttribute(WebSecurityConfig.SESSION_KEY) String username, Model model) {
		model.addAttribute("username", username);
		return "checkemail";
	}
	
	@RequestMapping(value="/sendPost",method= RequestMethod.POST)
	@ResponseBody
	public JSONObject sendCheckMail(HttpServletResponse response, HttpServletRequest request,HttpSession session) {
		JSONObject jsonObject = new JSONObject();
		String toName= request.getParameter("email");
		String content=RandomUtil.generateFourRandom();
		System.out.println(toName+content  );
		session.setAttribute("content", content);
		try {
			mailServiceImpl.sendMail(toName, content);
			jsonObject.put("发送成功 ", 0);
			session.setAttribute("email", toName);
			response.sendRedirect("/checkemail");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			jsonObject.put("发送失败", 1);
			e.printStackTrace();
		}
		return jsonObject;
	}

	@RequestMapping(value = "/accountPost", method = RequestMethod.POST)
	@ResponseBody
	public JSONObject accountPost(HttpSession session,HttpServletResponse response, HttpServletRequest request) {
		JSONObject jsonObject=new JSONObject();
		System.out.println(request.getParameter("email"));
		System.out.println(request.getParameter("checkCode"));
		return jsonObject;
	}

	@RequestMapping("/index")
	public String index() {
		return "index";
	}
	@RequestMapping("/developer")
	public String developer() {
		return "developer";
	}
	@RequestMapping("/operater")
	public String operater() {
		return "operater";
	}
	@RequestMapping("/course")
	public String course() {
		return "course";
	}
	@RequestMapping("/commodity")
	public String commodity() {
		return "commodity";
	}
	@RequestMapping("/carrer")
	public String carrer() {
		return "carrer";
	}
	@RequestMapping("/myfilter")
	public String myfilter(@SessionAttribute(WebSecurityConfig.SESSION_KEY) String username, Model model) {
		model.addAttribute("username", username);
		return "myfilter";
	}

	@RequestMapping("/")
	public String myIndex(@SessionAttribute(WebSecurityConfig.SESSION_KEY) String username, Model model) {
		model.addAttribute("username", username);
		return "myIndex";
	}

	@RequestMapping("/login")
	public String login() {

		return "login";

	}

	@RequestMapping("/loginPost")
	public @ResponseBody Map<String, Object> loginPost(HttpServletRequest request, HttpServletResponse response,
			HttpSession session) throws IOException, ApplicationException {
		Map<String, Object> map = new HashMap<>();
		String username = request.getParameter("username");
		String passwd = request.getParameter("passwd");
		String auto = request.getParameter("auto");
		boolean flag = false;
		try {
			flag = loginServiceImpl.getUser(username, passwd);
		} catch (ApplicationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (flag) {
			if (!auto.equals("-1")) {
				int day = Integer.parseInt(auto);// 1|7
				int seconds = 60 * 60 * 24 * day;
				// 声明cookie
				Cookie c = new Cookie("autoLogin", username);
				c.setMaxAge(seconds);
				c.setPath(request.getContextPath());
				// 保存cookie
				response.addCookie(c);
			}

			session.setAttribute(WebSecurityConfig.SESSION_KEY, username);
			map.put("success", true);
			map.put("message", "登录成功");
			// if (loginServiceImpl.getUserType(username) == 0)
			// response.sendRedirect("/");
			// else
			// response.sendRedirect("/teacherIndex");
			//
			response.sendRedirect("/myfilter");
			return map;
		} else {
			map.put("success", false);
			map.put("message", "密码或者用户名不争取");
			return map;
		}
	}

	@RequestMapping(value = "/register")
	public String register(Model model) {
		User user = new User();
		model.addAttribute("user", user);
		model.addAttribute("message", message);
		return "register";
	}

	@RequestMapping(value = "/registerPost", method = RequestMethod.POST)
	@ResponseBody
	public String registerPost(User user, String message, Model model, HttpServletResponse response)
			throws IOException {
		String str = "register";
		if (user.getPasswd().equals(user.getSecond())) {
			try {
				if (loginServiceImpl.addUser(user)) {
					response.sendRedirect("/index");
				}
			} catch (ApplicationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else {
			str = "密码不一致";
		}
		return str;
	}

	@RequestMapping("/my")
	public String my(@SessionAttribute(WebSecurityConfig.SESSION_KEY) String username, Model model,HttpSession session) {
		User user = new User();
		model.addAttribute("username", username);
	    session.setAttribute("username", username);
		return "my";
	}

	@RequestMapping(value = "/myPost", method = RequestMethod.POST)
	@ResponseBody
	public JSONObject myPost(Model model, HttpServletResponse response, HttpServletRequest request,HttpSession session) throws ApplicationException, ParseException, IOException, SQLException {
		JSONObject jsonObject=new JSONObject();
	    User user= new User();
	    String username=(String) session.getAttribute("username");
	    user.setSex(request.getParameter("sex") );
	    user.setBornTime(DateUtil.toDate(request.getParameter("bornTime")));
	    user.setCarrer(request.getParameter("carrer"));
	    user.setEducation(request.getParameter("education"));
	    user.setSchoolName(request.getParameter("schoolName"));
	    user.setProvince(request.getParameter("cmbProvince"));
	    user.setCity(request.getParameter("cmbCity"));
	    String country=request.getParameter("cmbArea") + request.getParameter("country");
	    user.setCountry(country);
	    user.setNote(request.getParameter("note"));
	    if (loginServiceImpl.modifyInfo(username,user)) {
			jsonObject.put("修改成功", 1);
			response.sendRedirect("/");
		}else {
			jsonObject.put("修改失败", 0);
		}
		return jsonObject;
	}

	@RequestMapping("/logout")
	public String logout(HttpSession session) {
		session.removeAttribute(WebSecurityConfig.SESSION_KEY);
		return "index";
	}
}
