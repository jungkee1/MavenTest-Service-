package com.myMaven.mybatis.mapper;

import java.util.List;

import com.myMaven.mybatis.vo.MemberVO;

public interface MemberDAO {
	
	//전체보기
	List<MemberVO> getList1(String sqlid);
	
	//추가
	void insert(String sqlid, MemberVO user);
	
	//수정
	void update(String sqlid, MemberVO user);
	
	//상세보기
	MemberVO findById(String sqlid, String id);
	
	//삭제
	void delete(String sqlid, String id);
	
	

}
