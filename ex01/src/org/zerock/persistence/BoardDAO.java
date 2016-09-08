package org.zerock.persistence;

import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Repository;
import org.zerock.domain.BoardVO;
@Repository
public interface BoardDAO {
	
	public void create(BoardVO vo) throws Exception;
	public BoardVO read(Integer bno) throws Exception;
	public void update(BoardVO vo) throws Exception;
	public void delete(Integer bno) throws Exception;
	public List<BoardVO> listAll() throws Exception;
	public List<BoardVO> listPage(int page) throws Exception;
	public int count();
	public List<BoardVO> getList(HashMap<String, Integer> hm);
	
	
}
