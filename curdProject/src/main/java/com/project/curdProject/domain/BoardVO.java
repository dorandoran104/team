package com.project.curdProject.domain;

import java.util.Date;

import lombok.Data;

@Data
public class BoardVO {
	
	private int id;
	private String title;
	private String body;
	private Date regDate;
	private Date updateDate;

}
