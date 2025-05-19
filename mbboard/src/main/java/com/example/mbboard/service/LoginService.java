package com.example.mbboard.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.mbboard.dto.Member;
import com.example.mbboard.dto.Page;
import com.example.mbboard.mapper.LoginMapper;

import lombok.extern.slf4j.Slf4j;

@Service
@Transactional
@Slf4j
public class LoginService implements ILoginService{
	@Autowired LoginMapper loginMapper;
	@Autowired private JavaMailSender mailSender;
	
	
	@Override
	public void insertId(Member paramMember) {
		int row = loginMapper.insertId(paramMember);
		if( row == 1) {
			log.info("회원가입 성공");
		} 
		else { 
			log.info("회원가입 실패");
		}
		
		
	}

	
	
	@Override
	public boolean countCheckId(String memberId) {
		int row = loginMapper.countCheckId(memberId);
		if(row != 1) {
			 return true;
		}else {
			return false;
		}
	}
	
	@Override
	public void updaterechangeMemberPw(Member member) {
		// 새로운 패스워드 삽입 
		int row = loginMapper.updateMemberPw(member);
		if( row == 1) {
			log.info("비밀번호 변경 성공");
		} 
		else { 
			log.info("비밀번호 변경 실패");
		}
		
	}
	
	@Override
	public void changeMemberPwByAdmin(Member member) {
		// 새로운 패스워드를 생성
		String randomPw = UUID.randomUUID().toString().replace("-", "").substring(0, 8);
		member.setMemberPw(randomPw);
		int row = loginMapper.updateMemberPwByAdmin(member);
		if (row == 1) {
		    log.info("비밀번호 변경 성공");
		    
		    SimpleMailMessage msg = new SimpleMailMessage();
		    msg.setFrom("yubin4050@gmail.com");
		    msg.setTo(member.getEmail());
		    msg.setSubject("10분안에 수정하셔야 합니다.");
		    msg.setText("임시 비밀번호는: " + randomPw);
		 
		 mailSender.send(msg);
		    
		} else {
		    log.warn("비밀번호 변경 실패: 조건 불일치");
		}
		
	}
	
	@Override
	public Member login(Member paramMember) {
		Member member = loginMapper.login(paramMember);
		
		return member;
	}
	
	@Override
	public List<Member> selectNotAdmnMembers(Page p) {
		List<Member> list = loginMapper.selectNotAdminMembers(p);
		
		return list;
		
	}
	
	@Override
	public int countMemberList() {
		return loginMapper.countMemberList();
	}
	
	@Override
	public Member selectMemberOne(String memberId) {
		Member member = loginMapper.selectMemberOne(memberId);
		
		return member;
	}
	
	@Override
	public int updateMemberListOne(Member member) {
		return loginMapper.updateMemberListOne(member);
	}







}
