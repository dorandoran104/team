package com.project.curdProject.service;

import java.io.File;
import java.net.URLDecoder;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.project.curdProject.domain.AttachVO;
import com.project.curdProject.mapper.AttachMapper;
import com.project.curdProject.util.FileInfo;

@Service
public class AttachService {
	
	@Autowired
	private AttachMapper attachMapper;

	public List<AttachVO> uploadImage(MultipartFile[] files) {
		List<AttachVO> list = new ArrayList<>();
		
		String filePath = FileInfo.filePath();
		
		String datePath = mkdir();
		
		File uploadPath = new File(filePath,datePath);
		
		if(!uploadPath.exists()) {
			uploadPath.mkdirs();
		}
		
		for(MultipartFile file: files) {
			if(file.isEmpty()) {
				return null;
			}
			AttachVO attachVO = AttachVO.builder()
					.uuid(UUID.randomUUID().toString())
					.fileName(file.getOriginalFilename())
					.filePath(datePath)
					.build();

			File uploadFile = new File(uploadPath.toString(), attachVO.getUuid() + "-" + attachVO.getFileName());
			
			try {
				file.transferTo(uploadFile);
//				attachMapper.uploadImage(attachVO);
				list.add(attachVO);
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return list;
	}
	
	public int deleteImage(String fileUrl){
		
		String filePath = FileInfo.filePath();
		File file = null;
		int result = 0;
		try {
			file = new File(filePath,URLDecoder.decode(fileUrl,"UTF-8"));
			
			file.delete();
			result = 1;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
	private String mkdir() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy\\MM\\dd");
		Date date = new Date();
		String filedir = sdf.format(date);
		return filedir.replace("\\", File.separator);
	}
}
