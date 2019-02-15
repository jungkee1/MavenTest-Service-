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
	
	
	//��ü����
	@Override
	public List<MemberVO> getList1(String sqlid) { //����¡���� ��ü���� �����ؼ� ���� �ڵ���
		// TODO Auto-generated method stub
//		SqlSession sqlMap = sqlMapper.openSession(ExecutorType.REUSE);
//		List<MemberVO> vo = sqlMap.selectList(sqlid);
//		return vo;
		return null;
	}
	
	//��ü����(����¡ ����)
	public List<MemberVO> getList(String sqlid, HashMap<String, Integer> hm) {
		// TODO Auto-generated method stub
//		SqlSession sqlMap = sqlMapper.openSession(ExecutorType.REUSE);
		List<MemberVO> vo = sqlMap.selectList(sqlid, hm);
		return vo;
	}
	
	
	//�߰��ϱ�
	@Override
	public void insert(String sqlid, MemberVO user) {
		// TODO Auto-generated method stub
//		SqlSession sqlMap = sqlMapper.openSession(ExecutorType.REUSE);
		sqlMap.insert(sqlid,user);
//		sqlMap.commit();
	}

	//����
	@Override
	public void update(String sqlid, MemberVO user) {
		// TODO Auto-generated method stub
//		SqlSession sqlMap = sqlMapper.openSession(ExecutorType.REUSE);
		sqlMap.update(sqlid, user);
		
	}
	
	//�󼼺���
	@Override
	public MemberVO findById(String sqlid, String id) {
		// TODO Auto-generated method stub
//		SqlSession sqlMap = sqlMapper.openSession(ExecutorType.REUSE);
		MemberVO vo = sqlMap.selectOne(sqlid, id);
		return vo;
	}
	
	//�����ϱ�
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
