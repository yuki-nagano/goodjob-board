package com.ynagano.board.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ynagano.board.bean.FormBean;
import com.ynagano.board.domain.GoodjobListModel;
import com.ynagano.board.mapper.GoodjobListRepository;
import com.ynagano.board.service.DisplayService;
import com.ynagano.board.service.SendingService;

/**
 * Main Controller
 * @author yukinagano
 */
@Controller
public class HomeController {
	
	@Autowired
	GoodjobListRepository goodjobListRepository;
	
	@Autowired
	SendingService sendingService;
	
	@Autowired
	DisplayService displayService;
	
	/**
	 * Top page control
	 * @return home.html
	 */
	@RequestMapping(value="/", method=RequestMethod.GET)
	public String Home() {
		return "home";
	}
	
	/**
	 * GOOD JOB Boardとは？
	 * Discription Page
	 * 
	 * @param model
	 * @param formBean
	 * @return
	 */
	@RequestMapping(value="/about", method=RequestMethod.GET)
	public String about() {
		return "about";
	}
	
	/**
	 * GOOD JOBを送る画面を表示
	 * 
	 * @param model
	 * @param formBean
	 * @return
	 */
	@RequestMapping(value="/create", method=RequestMethod.GET)
	public String create(Model model) {
		model.addAttribute("FormBean", new FormBean()); // th:object="${userRequest}
		return "send/create";
	}
	
	/**
	 * フォームから値を受け取りDBに格納し(Service内で実行)
	 * 一覧にリダイレクト
	 * 
	 * @param FormBean リクエストデータ
	 * @param model Model
	 * @return ユーザー情報一覧画面
	 */
	@RequestMapping(value="/create", method=RequestMethod.POST)
    public String create(@ModelAttribute FormBean formBean, Model model) {
		sendingService.execute(formBean);
		return "redirect:/"; // (とりあえず)homeにリダイレクト
	}
	
	
	/**
	 * 送ったGoodJobをDBから取得(Service内で実行)
	 * 一覧を表示
	 * 
	 * @param model Model
	 * @return 一覧画面
	 */
	@RequestMapping(value="/sent", method=RequestMethod.GET)
    public String sentList(Model model) {
		List<GoodjobListModel> goodjobListModelList = displayService.getSentList("Yuki");
		model.addAttribute("goodjobListModelList", goodjobListModelList);
		return "lists/sent"; 
	}
	
	/**
	 * もらったGoodJobをDBから取得(Service内で実行)
	 * 一覧を表示
	 * 
	 * @param model Model
	 * @return 一覧画面
	 */
	@RequestMapping(value="/received", method=RequestMethod.GET)
    public String receivedList(Model model) {
		List<GoodjobListModel> goodjobListModelList = displayService.displayReceivedList("Yuki");
		model.addAttribute("goodjobListModelList", goodjobListModelList);
		return "lists/received"; 
	}
	
//	@RequestMapping(value="/received", method=RequestMethod.POST)
//    public String receivedList(Model model) {
//		GoodjobListModel goodjobListModel = displayService.getSentList();
//		model.addAttribute("GOODJOB_LIST", goodjobListModel);
//		return "lists/received"; 
//	}

	
//	@RequestMapping("/confirm")
//	public String confirm(Model model, FormBean formBean) {
//		
//		GoodjobListModel goodjobListModel = sendServiceImpl.execute(formBean);
//		model.addAttribute("GOODJOB_LIST", goodjobListModel);
//		return "send/confirm";
//	}

	
}
