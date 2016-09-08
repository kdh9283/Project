package org.zerock.persistence;

import java.util.HashMap;
import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;
import org.zerock.domain.BoardVO;

@Repository
public class BoardDAOImpl implements BoardDAO{
	
	@Inject
	private SqlSession session;
	

	public void create(BoardVO vo) throws Exception {
		session.insert("insertBoard",vo);
		session.commit();
	}


	public BoardVO read(Integer bno) throws Exception {
		// TODO Auto-generated method stub
		return session.selectOne("read",bno);
	}


	public void update(BoardVO vo) throws Exception {
		// TODO Auto-generated method stub
		session.update("update",vo);
	}


	public void delete(Integer bno) throws Exception {
		// TODO Auto-generated method stub
		session.delete("delete",bno);
	}


	public List<BoardVO> listAll() throws Exception {
		List<BoardVO> vo = session.selectList("listAll");
		return vo;
	}


	public List<BoardVO> listPage(int page) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}


	public int count() {
		// TODO Auto-generated method stub
		int count=session.selectOne("countData");
		
		return count;
	}


	public List<BoardVO> getList(HashMap<String, Integer> hm) {
		// TODO Auto-generated method stub
		List<BoardVO> vo = session.selectList("listPage",hm);
		return vo;
		
	}

}
