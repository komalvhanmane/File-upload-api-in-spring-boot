package com.example.upload.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.upload.helper.FileUploadHelper;

//as we are building rest api
@RestController
public class fileUploadController {
	
	@Autowired
	private FileUploadHelper file1;
	
	@PostMapping("/upload-file")
	public ResponseEntity<String> uploadFile(@RequestParam("file") MultipartFile file){
		try {
			if(file.isEmpty()) {
				return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Must contain file");
			}
			
			if(!file.getContentType().equals("video/mp4")) {
				return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Only video mp4 is allowed");
			}
			
			boolean f=file1.uploadFile(file);
			
			if(f) {
				return ResponseEntity.ok("File is uploaded successfully");
			}
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		
		
		System.out.println(file.getOriginalFilename());
		System.out.println(file.getContentType());
		System.out.println(file.getName());
		System.out.println(file.getSize());
		
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Something went wrong!! try again");
	}
}
