package org.zerock.service;

import java.util.HashMap;
import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.zerock.domain.BoardVO;
import org.zerock.domain.Criteria;
import org.zerock.persistence.BoardDAO;

@Service
public class BoardServiceImpl implements BoardService{
	@Inject
	private BoardDAO dao;
	

	public void regist(BoardVO board) throws Exception {
		dao.create(board);
	}

	
	public BoardVO read(Integer bno) throws Exception {
		// TODO Auto-generated method stub
		return dao.read(bno);
	}

	public void modify(BoardVO board) throws Exception {
		// TODO Auto-generated method stub
		dao.update(board);
	}


	public void remove(Integer bno) throws Exception {
		// TODO Auto-generated method stub
		dao.delete(bno);
	}


	public List<BoardVO> listAll() throws Exception {
		return dao.listAll();
	}


	public List<BoardVO> listCriteria(Criteria cri) {
		// TODO Auto-generated method stub
		return null;
	}


	public int getCount() {
		// TODO Auto-generated method stub
		return dao.count();
	}


	public List<BoardVO> getList(HashMap<String, Integer> hm) {
		// TODO Auto-generated method stub
		return dao.getList(hm);
	}

}
