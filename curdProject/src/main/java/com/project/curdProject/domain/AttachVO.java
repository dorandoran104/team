package com.project.curdProject.domain;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AttachVO {
	
	private String fileName;
	private String filePath;
	private String uuid;
	private int boardno;
}
