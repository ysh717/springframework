package com.mycompany.webapp.service;

import javax.inject.Qualifier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mycompany.webapp.dao.Ch13Dao1CreateByAnno;

import lombok.extern.log4j.Log4j2;

@Service
@Log4j2
public class Ch13Service3InjectAnno {
	public Ch13Service3InjectAnno() {
		log.info("실행");
	}
	
	//타입으로 주입
	@Autowired
	private Ch13Dao1CreateByAnno ch13Dao1;
	
	@Autowired
	public Ch13Service3InjectAnno(Ch13Dao1CreateByAnno ch13Dao1) {
		log.info("실행 : 타입으로 주입");
		this.ch13Dao1 = ch13Dao1;
	}
	
	@Autowired
	public void setCh13Dao1(Ch13Dao1CreateByAnno ch13Dao1) {
		log.info("실행 : 타입으로 주입");
		this.ch13Dao1 = ch13Dao1;
	}
	
	//이름으로 주입
	/*@Autowired @org.springframework.beans.factory.annotation.Qualifier("ch13Dao1")
	private Ch13Dao1CreateByAnno ch13Da01;
	
	@Autowired
	public Ch13Service3InjectAnno(@Qualifier("ch13Dao1") Ch13Dao1CreateByAnno ch13Dao) {
		log.info("실행 : 이름으로 주입");
		this.ch13Dao1 = ch13Dao1;
	}
	
	@Autowired
	public void setCh13Dao1(@Qualifier("ch13Dao1") Ch13Dao1CreateByAnno ch13Dao) {
		log.info("실행 : 타입으로 주입");
		this.ch13Dao1 = ch13Dao1;
	}*/
}
