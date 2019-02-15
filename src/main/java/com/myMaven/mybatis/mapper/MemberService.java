package com.myMaven.mybatis.mapper;

import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.myMaven.mybatis.vo.MemberVO;

@Service("mService") //Repository같은 존재임 - 여기는 Service인걸 알려주고 Service라 쓰고 나머지들은 Repository로 작성
public class MemberService {
	@Resource(name="mDao")
	private MemberDAOImpl mDao;
	
	//insert
	public void insert(MemberVO user) {
		mDao.insert("insertMember", user); //Service 단에서 이름을 먼저 정해주는거다
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
