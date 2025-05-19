package com.example.mbboard.service;

import java.lang.reflect.MalformedParameterizedTypeException;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.mbboard.dto.ConnectCount;
import com.example.mbboard.mapper.ConnectCounterMapper;

import lombok.extern.slf4j.Slf4j;


@Slf4j
@Transactional
@Service
public class RootService implements IRootService {
	@Autowired ConnectCounterMapper connectCountMapper;
	
	// MeMBER, ADMIN -> login 성공시 
	// ANONYMOUS ->  클라이언트 세션이 서버에 생성될때(특정 브라우저에서 처음 접속했을 떄)
	@Override
	public String getConnectDateByKey(ConnectCount cc) {
	 return connectCountMapper.selectConnectDateByKey(cc);
		
	}
	
	@Override
	public int addConnectCount(ConnectCount cc) {
		
		return connectCountMapper.insertConnectCount(cc);
	}

	@Override
	public int modifyConnectCount(ConnectCount cc) {
	
		return connectCountMapper.updateConnectCount(cc);
	}
	
	
	@Override
	public Map<String, Integer> getConnectCountAll(){
		 return connectCountMapper.selectConnectCountAll();
	}
	
	@Override
	public Map<String, Integer> getConnectCountToday(){
		return connectCountMapper.selectConnectCountToday();
	}




	
}
