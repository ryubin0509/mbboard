package com.example.mbboard.service;

import java.util.Map;

import com.example.mbboard.dto.ConnectCount;

public interface IRootService {
	
	
	String getConnectDateByKey(ConnectCount cc);
	// 오늘 
	int addConnectCount(ConnectCount cc); 
	
	int modifyConnectCount(ConnectCount cc);
	
	Map<String, Integer> getConnectCountAll();
	
	Map<String, Integer> getConnectCountToday();
}
