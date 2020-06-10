package com.ynagano.board.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ynagano.board.bean.FormBean;
import com.ynagano.board.domain.GoodjobListModel;
//import com.ynagano.board.domain.GoodjobListModel;
import com.ynagano.board.mapper.GoodjobListRepository;

@Service
public class DisplayService {
	
	@Autowired
	GoodjobListRepository goodjobListRepository;
	
	/**
	 * 自分が送ったGOOD JOBを表示
	 * @param sendName 送信者
	 */
	 public List<GoodjobListModel> getSentList(String sendName) {
		 List<GoodjobListModel> goodjobListModelList = goodjobListRepository.getSentAll(sendName);
//		 System.out.println(goodjobListModelList[0].content);
		 return goodjobListModelList;
	 }
	 
	/**
	 * 自分が受け取ったGOOD JOBを表示
	 * @param receivedName 受信者
	 */
	 public List<GoodjobListModel> displayReceivedList(String receivedName) {
		 List<GoodjobListModel> goodjobListModelList = goodjobListRepository.getReceivedAll(receivedName);
		 return goodjobListModelList;
	 }
}
