package com.ynagano.board.domain;

import java.sql.Timestamp;

import lombok.Getter;
import lombok.Setter;


public class GoodjobListModel {

	@Setter
	@Getter
	public Long id;
	public Timestamp sendTime;
	public String sendName;
	public String receivedName;
	public String content;
	
}
