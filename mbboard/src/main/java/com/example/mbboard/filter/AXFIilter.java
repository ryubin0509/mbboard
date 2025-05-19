package com.example.mbboard.filter;

import java.io.IOException;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@WebFilter("/a/x")
public class AXFIilter implements Filter{

@Override
public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
		throws IOException, ServletException {
	log.info("/a/x 선행코드");
	chain.doFilter(request, response);
	log.info("/a/x gn행코드");
	
}
}
