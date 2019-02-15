package com.myMaven.mybatis.mapper;

import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.myMaven.mybatis.vo.MemberVO;

@Service("mService") //Repository���� ������ - ����� Service�ΰ� �˷��ְ� Service�� ���� ���������� Repository�� �ۼ�
public class MemberService {
	@Resource(name="mDao")
	private MemberDAOImpl mDao;
	
	//insert
	public void insert(MemberVO user) {
		mDao.insert("insertMember", user); //Service �ܿ��� �̸��� ���� �����ִ°Ŵ�
	}
	
	//list
//	public List<MemberVO> getList() {
//		List<MemberVO> vo = mDao.getList("listMember");
//		return vo;
//	}
	
	public List<MemberVO> getList(HashMap<String, Integer> hm) {
		List<MemberVO> vo = mDao.getList("listMember", hm);
		return vo;
	}
	
	//delete
	public void delete(String id) {
		mDao.delete("deleteMember", id);
	}
	
	//detail
	public MemberVO findById(String id) {
		MemberVO vo = mDao.findById("detailMember", id);
		return vo;
		
	}
	
	//update
	public void update(MemberVO vo) {
		mDao.update("updateMember", vo);
	}
	
	//count
	public int getCount() {
		return mDao.getCount("countMember");
	}

}
