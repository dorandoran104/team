package com.project.curdProject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.project.curdProject.domain.BoardVO;
import com.project.curdProject.service.BoardService;

@Controller
@RequestMapping("/boards")
public class BoardController {
	
	@Autowired
	private BoardService boardService;
	
	@GetMapping("")
	public String boardList(Model model) {
		List<BoardVO> list = boardService.getList();
		model.addAttribute("list",list);
		return "board/list";
	}
	
	@GetMapping("/new")
	public String registerBoard() {
		return "board/register";
	}
	
	@PostMapping("/new")
	public String registerBoardAction(BoardVO boardVO) {
		boardService.registerBoard(boardVO);
		return "redirect:/boards/"+boardVO.getId();
	}
	
	@GetMapping("/{id}")
	public String getBoard(Model model,@PathVariable int id) {
		BoardVO boardVO = boardService.getBoard(id);
		model.addAttribute("board",boardVO);
		return "board/get";	
	}
	
	@GetMapping("/modify/{id}")
	public String modifyBoard(Model model,@PathVariable int id) {
		BoardVO boardVO = boardService.getBoard(id);
		model.addAttribute("board", boardVO);
		return "board/modify";
	}
	
	@PostMapping("/modify")
	public String modifyBoardAction(BoardVO boardVO) {
		boardService.modifyBoard(boardVO);
		return "redirect:/boards/"+boardVO.getId();
	}
	
	@PostMapping("/delete/{id}")
	@ResponseBody
	public ResponseEntity<String> deleteBoard(@PathVariable int id) {
		int result = boardService.deleteBoard(id);
		return result == 0 ? new ResponseEntity<>(HttpStatus.BAD_GATEWAY):new ResponseEntity<>(HttpStatus.OK);
	}
}
