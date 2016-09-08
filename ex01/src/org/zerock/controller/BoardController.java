package org.zerock.controller;

import java.util.HashMap;
import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.zerock.domain.BoardVO;
import org.zerock.domain.Criteria;
import org.zerock.service.BoardService;
import org.zerock.service.pageAction;

@Controller
@RequestMapping("board/*")
public class BoardController {

	@Inject
	public BoardService service;
	
	@Inject
	public pageAction page;
	
	@RequestMapping(value="/register", method=RequestMethod.GET)
	public String register(){
		return "/board/register";
	}
	@RequestMapping(value="/register", method=RequestMethod.POST)
	public String register(BoardVO vo){
		try {
			service.regist(vo);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "redirect:/board/list";
	}
	
//	@RequestMapping(value="/list", method=RequestMethod.GET)
//	public void list(Model model) throws Exception{
//		List<BoardVO> list = service.listAll();
//		model.addAttribute("list",list);
//	}
	
	@RequestMapping(value="/read", method=RequestMethod.GET)
	public void read(@RequestParam("bno") int bno, Model model) throws Exception{
		model.addAttribute("read",service.read(bno));
	}
	
	@RequestMapping(value="/modify", method=RequestMethod.GET)
	public void modifyGET(int bno, Model model) throws Exception{
		model.addAttribute(service.read(bno)); 
	}
	
	@RequestMapping(value="/modify", method=RequestMethod.POST)
	public String modifyPOST(BoardVO board, RedirectAttributes ra) throws Exception{
		service.modify(board);
		ra.addFlashAttribute("msg","success");
		return "redirect:/board/list";
	}
	
	@RequestMapping(value="/remove", method=RequestMethod.POST)
	public String remove(@RequestParam("bno") int bno, RedirectAttributes ra) throws Exception{
		service.remove(bno);
		ra.addFlashAttribute("msg","success");
		return "redirect:/board/list";
	}
	
	@RequestMapping(value="/listCri", method=RequestMethod.GET)
	public void listAll(Criteria cri, Model model) throws Exception{
		List<BoardVO> list = service.listCriteria(cri);
		model.addAttribute("list",list);
	}
	
	@RequestMapping(value="/list", method=RequestMethod.GET)
	public void page(String pageNum,Model model) throws Exception{
		int pageSize=5;
		if(pageNum==null){
			pageNum="1";
		}
		int currentPage=Integer.parseInt(pageNum);
		
		HashMap<String,Integer> hm=new HashMap<String, Integer>();
		int count=service.getCount();//게시물 수 구하기
		int startRow=(currentPage-1)*pageSize+1;
		int endRow=startRow+pageSize-1;
		if(endRow>count) endRow=count;
		
		hm.put("startRow", startRow);
		hm.put("endRow", endRow);
		
		String pageHtml=page.paging(count,pageSize,currentPage);
		model.addAttribute("list",service.getList(hm));
		model.addAttribute("count",count);
		model.addAttribute("pageHtml",pageHtml);
		
		
	}
	
}













