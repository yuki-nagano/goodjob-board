package com.ynagano.board.mapper;

import java.util.List;

import com.ynagano.board.domain.UserInfoModel;

public interface UserInfoRepository {
	
	/**
	 * 
	 * FIND USERNAME 
	 * FOR LOGIN
	 * 
	 * @return result of query
	 */
	List<UserInfoModel> findUsername();

}
