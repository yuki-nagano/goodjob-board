package com.ynagano.board.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ynagano.board.bean.FormBean;
//import com.ynagano.board.domain.GoodjobListModel;
import com.ynagano.board.mapper.GoodjobListRepository;

@Service
public class SendingService {
	
	@Autowired
	GoodjobListRepository goodjobListRepository;
	
	/**
	 * 新規GOOD JOBの内容をDBに登録する
	 * @param FormBean フォームの値が入ったBean
	 */
	 public void execute(FormBean formBean) {
//		 GoodjobListModel goodjobListModel = new GoodjobListModel();
//		 goodjobListModel.setSendName(formBean.());
		 goodjobListRepository.insertForm(formBean);
		 
		 System.out.println();
		 System.out.println("Sent name: " + formBean.sendName);
		 System.out.println("Received name: " + formBean.receivedName);
		 System.out.println("Content: " + formBean.content);
		 
		 
		 
	 }
}
