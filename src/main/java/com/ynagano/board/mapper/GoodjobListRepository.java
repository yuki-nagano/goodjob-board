package com.ynagano.board.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import com.ynagano.board.bean.FormBean;
import com.ynagano.board.domain.GoodjobListModel;

@Mapper
public interface GoodjobListRepository {
	
	/**
	 * 
	 * SELECT ALL (for test)
	 * 
	 * @return result(s) of query
	 */
	GoodjobListModel getAll();
	
	/**
	 * 
	 * STORE CONTENTS FROM FORM
	 * 
	 * @return result(s) of query
	 */
	void insertForm(FormBean formBean);
	
	/**
	 * 
	 * SELECT SENT LIST
	 * 
	 * @param send name 送信者
	 * @return result(s) of query
	 */
	List<GoodjobListModel> getSentAll(String sendName);
	
	/**
	 * 
	 * SELECT RECEIVED LIST
	 * 
	 * @param received name 受信者
	 * @return result(s) of query
	 */
	List<GoodjobListModel> getReceivedAll(String receivedName);
	
}
