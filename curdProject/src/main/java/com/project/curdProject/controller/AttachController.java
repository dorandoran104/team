package com.project.curdProject.controller;

import java.net.MalformedURLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.project.curdProject.domain.AttachVO;
import com.project.curdProject.service.AttachService;
import com.project.curdProject.util.FileInfo;

@RestController
@RequestMapping("/attach")
public class AttachController {
	
	@Autowired
	private AttachService attachService;
	
	@PostMapping(value = "/upload", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<AttachVO>> uploadImage(@RequestBody MultipartFile[] files){
		List<AttachVO> list = attachService.uploadImage(files);
		return ResponseEntity.ok(list);
	}
	
	@GetMapping("")
	public Resource displayImage(String fileUrl) throws MalformedURLException {
		StringBuilder sb = new StringBuilder();
		sb.append(FileInfo.filePath())
		.append("\\")
		.append(fileUrl);
		return new UrlResource("file:"+sb.toString());
	}
	
	@DeleteMapping(value = "", produces = MediaType.TEXT_PLAIN_VALUE)
	public ResponseEntity<String> deleteImage(@RequestBody String fileUrl){
		int result = attachService.deleteImage(fileUrl);
		return result == 0? ResponseEntity.badRequest().body("error") : ResponseEntity.ok("success");
	}
}
