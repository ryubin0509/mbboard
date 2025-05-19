package com.example.mbboard.listener;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.mbboard.dto.ConnectCount;
import com.example.mbboard.service.IRootService;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.annotation.WebListener;
import jakarta.servlet.http.HttpSessionEvent;
import jakarta.servlet.http.HttpSessionListener;
import lombok.extern.slf4j.Slf4j;

/**
 * Application Lifecycle Listener implementation class ConnectCountListener
 *
 */

@Slf4j
@Component
public class ConnectCountListener implements HttpSessionListener, ServletContextListener {
    @Autowired IRootService rootService;


    public void sessionCreated(HttpSessionEvent se)  { 
       log.info("새로운 세션생성");
       
       ServletContext context = se.getSession().getServletContext();
       Object countObj = context.getAttribute("currentConnectCount");
       
       int count = 0;
       if (countObj instanceof Integer) {
    	   count = (Integer) countObj;
       }
       
       context.setAttribute("currentConnectCount", count + 1);
       log.info("현재 접속자 수: {}", count + 1);

    	// 처음 세션이 만들어 졌을때
    	 // 클라이언트(쿠키) - 서버(세션)
    	 // 처음 - 쿠키(empty) - new세션.id - response함께 클라이언트에 전송
    	 // 두번쨰 - 쿠키(세션.id) - 세션연결
    	ConnectCount cc = new ConnectCount();
    	cc.setMemberRole("ANONYMOUS");
    	if(rootService.getConnectDateByKey(cc) == null) {
    		rootService.addConnectCount(cc);
    	} else {
    		rootService.modifyConnectCount(cc);
    	}
    }


    public void sessionDestroyed(HttpSessionEvent se)  { 
         // session.invalidate() or timeout 시 
    	 // currentConnectCount-- 
    	
        ServletContext context = se.getSession().getServletContext();
        Object countObj = context.getAttribute("currentConnectCount");
        
        int count = 0;
        if (countObj instanceof Integer) {
     	   count = (Integer) countObj;
        }
        
        context.setAttribute("currentConnectCount", count - 1);
        log.info("현재 접속자 수: {}", count - 1);


    }


 

}
