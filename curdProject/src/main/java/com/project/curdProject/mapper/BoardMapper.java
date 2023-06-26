package com.project.curdProject.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.project.curdProject.domain.BoardVO;

@Mapper
public interface BoardMapper {

	List<BoardVO> getList();

	BoardVO getBoard(int id);

	int registerBoard(BoardVO boardVO);

	int modifyBoard(BoardVO boardVO);

	int deleteBoard(int id); 

}
