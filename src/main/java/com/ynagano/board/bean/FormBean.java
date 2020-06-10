package com.ynagano.board.bean;

import lombok.Getter;
import lombok.Setter;

/**
 * フォームの値格納用Bean
 * 
 * @author yukinagano
 *
 */
public class FormBean {
	
	@Getter
	@Setter
	public String sendName;
	
	@Getter
	@Setter
	public String receivedName;
	
	@Getter
	@Setter
	public String content;

}


//よび	
//	private String sendName;
//	private Integer id;
//	private String sendTime;
