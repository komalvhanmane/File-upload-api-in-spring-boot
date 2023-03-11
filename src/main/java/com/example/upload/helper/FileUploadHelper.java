package com.example.upload.helper;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;


import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

//autowire karta yayla pahije
@Component
public class FileUploadHelper {
	
	public final String UPLOAd_DIR="C:\\Users\\admin\\Documents\\workspace-spring-tool-suite-4-4.16.1.RELEASE\\File-Upload\\src\\main\\resources\\static\\image";
	
	public boolean uploadFile(MultipartFile f) {
		boolean f1=false;
		
		try {
			
//			InputStream is=f.getInputStream();
//			byte data[]=new byte[is.available()];
//			is.read(data);
//			
//			FileOutputStream fos=new FileOutputStream(UPLOAd_DIR+File.separator+f.getOriginalFilename());
//			fos.write(data);
//			
//			fos.flush();
//			fos.close();
			
			Files.copy(f.getInputStream(),Paths.get(UPLOAd_DIR+File.separator+f.getOriginalFilename()),StandardCopyOption.REPLACE_EXISTING);
			f1=true;
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return f1;
	}
}
