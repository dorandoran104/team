package com.project.curdProject.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.curdProject.domain.BoardVO;
import com.project.curdProject.mapper.BoardMapper;

import lombok.Setter;

@Service
public class BoardService {
	
	@Setter(onMethod_=@Autowired)
	private BoardMapper boardMapper;

	public List<BoardVO> getList() {
		List<BoardVO> list = boardMapper.getList();
		return list;
	}

	public BoardVO getBoard(int id) {
		BoardVO boardVO = boardMapper.getBoard(id);
		return boardVO;
	}

	public void registerBoard(BoardVO boardVO) {
		boardMapper.registerBoard(boardVO);
	}

	public void modifyBoard(BoardVO boardVO) {
		boardMapper.modifyBoard(boardVO);
	}

	public int deleteBoard(int id) {
		return boardMapper.deleteBoard(id);
		
	}

}
