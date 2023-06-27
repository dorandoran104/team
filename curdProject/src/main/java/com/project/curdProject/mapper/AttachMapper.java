package com.project.curdProject.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.project.curdProject.domain.AttachVO;

@Mapper
public interface AttachMapper {

	void uploadImage(AttachVO attachVO);

}
