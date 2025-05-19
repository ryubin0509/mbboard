package com.example.mbboard.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.mbboard.dto.Member;
import com.example.mbboard.dto.Page;


public interface ILoginService {
	Member login(Member paramMember);
	List<Member> selectNotAdmnMembers(Page p);
	
	int countMemberList();
	Member selectMemberOne(String memberId);
	int updateMemberListOne(Member member);
	
	void changeMemberPwByAdmin(Member member);
	
	void updaterechangeMemberPw(Member member); // 비밀번호 사용자 변경
	
}
