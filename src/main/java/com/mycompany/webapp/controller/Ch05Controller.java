package com.mycompany.webapp.controller;

import java.net.URLEncoder;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.log4j.Log4j2;

@Controller
@RequestMapping("/ch05")
@Log4j2
public class Ch05Controller {
	@RequestMapping("/content")
	public String content() {
		return "ch05/content";
	}
	
	@GetMapping("/getHeaderValue")
	public String getHeaderValue(HttpServletRequest request, @RequestHeader("User-Agent") String userAgent) {
		log.info("실행");
		log.info("Client IP : " + request.getRemoteAddr());
		log.info("Request Method :  " + request.getMethod());
		log.info("Context Path(Root) : " + request.getContextPath());
		log.info("Request URI : " + request.getRequestURI());
		log.info("Request URL : " + request.getRequestURL());
		log.info("Header User-Agent : " + request.getHeader("User-Agent"));
		log.info(userAgent);
		return "redirect:/ch05/content";
	}
	
	@GetMapping("/createCookie")
	public String createCookie(HttpServletResponse response) {
		log.info("실행");
		
		Cookie cookie = new Cookie("useremail", "blueskii@naver.com");
		cookie.setDomain("localhost");    //localhost 면 전송
		cookie.setPath("/");         //localhost/... 이면 모두 전송
		cookie.setMaxAge(30*60);      //이 시간동안에만 전송
		cookie.setHttpOnly(true);       //JavaScript에서 못 읽게함
		cookie.setSecure(false);       //https://만 전송
		response.addCookie(cookie);
		
		cookie = new Cookie("userid", "spring");
		cookie.setDomain("localhost");    //localhost 면 전송
		cookie.setPath("/");         //localhost/... 이면 모두 전송
		cookie.setMaxAge(30*60);      //이 시간동안에만 전송
		cookie.setHttpOnly(true);       //JavaScript에서 못 읽게함
		cookie.setSecure(false);       //https://만 전송
		response.addCookie(cookie);
		
		return "redirect:/ch05/content";
	}
	
	@GetMapping("/getCookie1")
	public String getCookie1(HttpServletRequest request) {
		log.info("실행");
		Cookie[] cookies = request.getCookies();
		for(Cookie cookie : cookies) {
			String cookieName = cookie.getName();
			String cookieValue = cookie.getValue();
			log.info(cookieName + " : " + cookieValue);
		}
		return "redirect:/ch05/content";
	}
	
	@GetMapping("/getCookie2")
	public String getCookie2(@CookieValue String userid, @CookieValue String useremail) {
		log.info("실행");
		log.info("userid : " + userid);
		log.info("useremail : " + useremail);
		
		return "redirect:/ch05/content";
	}
	
	@GetMapping("createJsonCookie")
	public String createJsonCookie(HttpServletResponse response) throws Exception {
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("username", "홍길동");
		jsonObject.put("useremail", "spring@mycompany.com");
		String json = jsonObject.toString();
		log.info(json);
		json = URLEncoder.encode(json, "UTF-8");
		log.info(json);
		
		Cookie cookie = new Cookie("user", json);
		response.addCookie(cookie);
		return "redirect:/ch05/content";
	}
	

	@GetMapping("getJsonCookie")
	public String getJsonCookie(@CookieValue String user){
		log.info(user);
		JSONObject jsonObject = new JSONObject(user);
		String username = jsonObject.getString("username");
		String useremail = jsonObject.getString("useremail");
		log.info("username : " + username);
		log.info("useremail : " + useremail);
		return "redirect:/ch05/content";
	}
}
