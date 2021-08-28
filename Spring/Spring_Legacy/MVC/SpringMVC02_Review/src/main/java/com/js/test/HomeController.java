package com.js.test;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.js.test.biz.BoardBiz;
import com.js.test.dto.BoardDto;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	@Autowired
	private BoardBiz biz;
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@RequestMapping(value="/list.do")
	public String selectList(Model model) {
		List<BoardDto> list=biz.selectList();
		logger.info("[controller]select list "+list);
		model.addAttribute("list", list);
		
		return "selectList";
	}
	
	
	@RequestMapping(value="/detail.do")
	public String selectOne(Model model, int myNo) {
		BoardDto dto=biz.selectOne(myNo);
		logger.info("[controller]select one "+dto);
		model.addAttribute("target",dto);
		
		return "target";
	}
	
	@RequestMapping(value="/insertForm.do")
	public String insertForm() {
		logger.info("[controller]insertForm");
		return "insertForm";
	}
	
	@RequestMapping(value="/insert.do",method=RequestMethod.POST)
	public String insert(HttpServletResponse response, String myName,String myTitle,String myContent) {
		BoardDto dto=new BoardDto();
		
		logger.info("[controller]insert");
		
		dto.setMyName(myName);
		dto.setMyTitle(myTitle);
		dto.setMyContent(myContent);
		int resIns=biz.insert(dto);
		
		if(resIns>0) {
			return "redirect:list.do";
		}else {
			return "redirect:insertForm.do";
		}
	}
	
	@RequestMapping(value="/updateForm")
	public String updateForm(Model model,int myNo) {
		BoardDto dto=biz.selectOne(myNo);
		
		logger.info("[controller]updateForm-"+dto);
		
		model.addAttribute("update", dto);
		
		return "updateForm";
	}
	
	@RequestMapping(value="/update.do")
	public String update(BoardDto dto) {
		int resUp=biz.update(dto);
		int myNo=dto.getMyNo();
		
		logger.info("[controller]update-"+dto);
		
		
		if(resUp>0) {
			return "redirect:detail.do?myNo="+myNo;
		}else {
			return "redirect:updateForm.do?myNo="+myNo;
		}
	}
	
	
	@RequestMapping(value="/delete.do")
	public String delete(int myNo) {
		int resDel=biz.delete(myNo);
		
		if(resDel>0) {
			return "redirect:list.do";
		}else {
			return "redirect:detail.do?myNo="+myNo;
		}
	}
	
}
