package com.myMaven.mybatis.mapper;

import java.util.List;

import com.myMaven.mybatis.vo.MemberVO;

public interface MemberDAO {
	
	//��ü����
	List<MemberVO> getList1(String sqlid);
	
	//�߰�
	void insert(String sqlid, MemberVO user);
	
	//����
	void update(String sqlid, MemberVO user);
	
	//�󼼺���
	MemberVO findById(String sqlid, String id);
	
	//����
	void delete(String sqlid, String id);
	
	

}
