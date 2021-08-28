package com.js.file;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Writer;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.util.WebUtils;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@Autowired
	private FileValidator validator;
	
	@RequestMapping(value="/form")
	public String form() {
		return "uploadForm";
	}
	
	@RequestMapping(value="/upload")
	public String upload(HttpServletRequest request, 
			Model model, UploadFile fileUpload, BindingResult bindingResult) {
		//유효성 검사
		validator.validate(fileUpload, bindingResult);
		
		if(bindingResult.hasErrors()) {
			return "uploadForm";
		}
		
		//UploadFile내에 MultipartRequest로 받아온 내용들이 다 접근 가능
		//1.파일 가져오기
		MultipartFile file=fileUpload.getFile();
		//업로드 파일의 원본이름
		String origin=file.getOriginalFilename();
		
		//2.설명가져오기
		String desc=fileUpload.getDesc();
		
		//inputstream을 이용해서 원하는 위치에 저장
		//outputstream을 이용해서 출력
		InputStream inputStream=null;
		OutputStream outputStream=null;
		ServletContext context=null;
		UploadFile toSave=new UploadFile();
		
		toSave.setFile(file);
		toSave.setFileName(origin);
		toSave.setDesc(desc);
		
		//원하는 위치에 저장
		try {
			
			inputStream=file.getInputStream();//바이트단위로 읽어올것
			context=request.getSession().getServletContext();
			//업로드할 경로
			String path=WebUtils.getRealPath(context, "/storage");
			
			logger.info("업로드될 실제 경로: {}",path);
			
			//폴더 생성
			File folder=new File(path);
			
			//경로가 없다면 생성
			if(!folder.exists()) {
				folder.mkdirs();
			}
			
			//폴더 위치 하위에 파일 저장
			File realSave=new File(path+"/"+origin);
			
			if(!realSave.exists()) {
				realSave.createNewFile();
			}else {
				Writer writer=new FileWriter(path+"/"+origin,false);//overwrite
			}
			
			//===
			//파일 정보 저장
			outputStream=new FileOutputStream(realSave);
			
			int read =0;
			byte[] arr=new byte[(int)file.getSize()];
			
			while((read=inputStream.read())!=-1) {
				outputStream.write(arr, 0, read);
			}
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				inputStream.close();
				outputStream.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		model.addAttribute("fileObj",toSave);	
		
		return "uploadFile";
	}
	
}
