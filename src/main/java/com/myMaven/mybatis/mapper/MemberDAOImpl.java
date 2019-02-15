package com.myMaven.mybatis.mapper;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.myMaven.mybatis.vo.MemberVO;

@Repository("mDao")
public class MemberDAOImpl implements MemberDAO{
	
//	@Autowired
//	private SqlSessionFactory sqlMapper;
	
	@Autowired
	private SqlSession sqlMap;
	
	
	//전체보기
	@Override
	public List<MemberVO> getList1(String sqlid) { //페이징에서 전체보기 같이해서 죽은 코드임
		// TODO Auto-generated method stub
//		SqlSession sqlMap = sqlMapper.openSession(ExecutorType.REUSE);
//		List<MemberVO> vo = sqlMap.selectList(sqlid);
//		return vo;
		return null;
	}
	
	//전체보기(페이징 포함)
	public List<MemberVO> getList(String sqlid, HashMap<String, Integer> hm) {
		// TODO Auto-generated method stub
//		SqlSession sqlMap = sqlMapper.openSession(ExecutorType.REUSE);
		List<MemberVO> vo = sqlMap.selectList(sqlid, hm);
		return vo;
	}
	
	
	//추가하기
	@Override
	public void insert(String sqlid, MemberVO user) {
		// TODO Auto-generated method stub
//		SqlSession sqlMap = sqlMapper.openSession(ExecutorType.REUSE);
		sqlMap.insert(sqlid,user);
//		sqlMap.commit();
	}

	//수정
	@Override
	public void update(String sqlid, MemberVO user) {
		// TODO Auto-generated method stub
//		SqlSession sqlMap = sqlMapper.openSession(ExecutorType.REUSE);
		sqlMap.update(sqlid, user);
		
	}
	
	//상세보기
	@Override
	public MemberVO findById(String sqlid, String id) {
		// TODO Auto-generated method stub
//		SqlSession sqlMap = sqlMapper.openSession(ExecutorType.REUSE);
		MemberVO vo = sqlMap.selectOne(sqlid, id);
		return vo;
	}
	
	//삭제하기
	@Override
	public void delete(String sqlid, String id) {
		// TODO Auto-generated method stub
//		SqlSession sqlMap = sqlMapper.openSession(ExecutorType.REUSE);
		sqlMap.delete(sqlid, id);
//		sqlMap.commit();
	}
	//count
	public int getCount(String sqlid) {
//		SqlSession sqlMap = sqlMapper.openSession(ExecutorType.REUSE);
		return sqlMap.selectOne(sqlid);
	}

}
