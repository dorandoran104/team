package com.project.curdProject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.project.curdProject.domain.BoardVO;
import com.project.curdProject.service.BoardService;

@RestController
@RequestMapping("/boards")
public class BoardController {

	@Autowired
	private BoardService boardService;

	@GetMapping("")
	public ModelAndView boardList() {
		ModelAndView mv = new ModelAndView();
		int count = boardService.getCount();
		mv.setViewName("board/list");
		mv.addObject("count", count);
		return mv;
	}
	
	@GetMapping(value = "/list/{page}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<BoardVO>> getList(@PathVariable("page") int page) {
		List<BoardVO> list = boardService.getList(page);
		return ResponseEntity.ok(list);
	}

	@GetMapping("/new")
	public ModelAndView registerBoard() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("board/register");
		return mv;
	}

	@PostMapping(value = "/new", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> registerBoardAction(@RequestBody BoardVO boardVO) {
		int result = boardService.registerBoard(boardVO);
		return result == 0 ? ResponseEntity.status(HttpStatus.BAD_REQUEST).body("errer") : ResponseEntity.ok(boardVO); 
	}

	@GetMapping("/{id}")
	public ModelAndView getBoard(@PathVariable int id) {
		BoardVO boardVO = boardService.getBoard(id);

		ModelAndView mv = new ModelAndView();
		mv.setViewName("board/get");
		mv.addObject("board", boardVO);

		return mv;
	}

	@GetMapping("/modify/{id}")
	public ModelAndView modifyBoard(@PathVariable int id) {
		BoardVO boardVO = boardService.getBoard(id);
		
		ModelAndView mv = new ModelAndView();
		mv.addObject("board", boardVO);
		mv.setViewName("board/modify");
		return mv;
	}

	@PutMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> modifyBoardAction(@RequestBody BoardVO boardVO, @PathVariable("id") int id) {
		boardVO.setId(id);
		int result = boardService.modifyBoard(boardVO);
		return result == 0 ? new ResponseEntity<>(HttpStatus.BAD_GATEWAY) : new ResponseEntity<String>(HttpStatus.OK);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteBoard(@PathVariable int id) {
		int result = boardService.deleteBoard(id);
		return result == 0 ? new ResponseEntity<>(HttpStatus.BAD_GATEWAY) : new ResponseEntity<>(HttpStatus.OK);
	}
}
