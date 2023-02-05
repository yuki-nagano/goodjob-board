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
	 * @param formBean フォームの値が入ったBean
	 */
	 public void execute(FormBean formBean) {
		 goodjobListRepository.insertForm(formBean);
		 
	 }
}
