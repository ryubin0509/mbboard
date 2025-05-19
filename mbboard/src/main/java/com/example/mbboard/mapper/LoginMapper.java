package com.example.mbboard.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.mbboard.dto.Member;
import com.example.mbboard.dto.Page;

@Mapper
public interface LoginMapper {
	Member login(Member paramMember); // 로그인 조회 출력
	List<Member> selectNotAdminMembers(Page p); // 멤버리스트 페이지 출력
	int countMemberList(); // 멤버리스트의 갯수
	Member selectMemberOne(String memberId); // 한개의 멤버리스트 출력
	int updateMemberListOne(Member member); // 업데이트 출력
	
	int updateMemberPwByAdmin(Member member); // 관리자 비밀번호 변경
	int updateMemberPw(Member member); // 임시비밀번호 발급및 비밀번호 변경 
}
