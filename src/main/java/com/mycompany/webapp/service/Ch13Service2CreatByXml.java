package com.mycompany.webapp.service;

import org.springframework.stereotype.Service;

import lombok.extern.log4j.Log4j2;

@Log4j2
public class Ch13Service2CreatByXml {
	public Ch13Service2CreatByXml() {
		log.info("실행");
	}
	
	public static Ch13Service2CreatByXml getInstance1() {
		log.info("실행");
		Ch13Service2CreatByXml obj = new Ch13Service2CreatByXml();
		return obj;
	}
	
	public Ch13Service2CreatByXml getInstance2() {
		log.info("실행");
		Ch13Service2CreatByXml obj = new Ch13Service2CreatByXml();
		return obj;
	}
}
