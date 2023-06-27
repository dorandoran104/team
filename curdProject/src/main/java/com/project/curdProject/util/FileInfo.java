package com.project.curdProject.util;

public class FileInfo {
	
	public static String filePath() {
		StringBuilder sb = new StringBuilder();
		sb.append(System.getProperty("user.dir"))
		.append("\\src\\main\\webapp\\resources\\image");
		return sb.toString();
	}
}
