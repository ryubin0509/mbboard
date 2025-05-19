package com.example.mbboard.mapper;

import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.example.mbboard.dto.ConnectCount;

@Mapper
public interface ConnectCounterMapper {
	Map<String, Integer> selectConnectCountAll();
	Map<String, Integer> selectConnectCountToday();
	
	// 오늘날짜의 카운팅 있는지 없는지
	String selectConnectDateByKey(ConnectCount cc); // cc.getMemberRole()

	// selectConnectDateByKey
	int insertConnectCount(ConnectCount cc);
	
	int updateConnectCount(ConnectCount cc);
}
