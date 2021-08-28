package com.js.file;

import org.springframework.web.multipart.MultipartFile;

public class UploadFile {
	
	private String fileName;
	private String desc;
	private MultipartFile file;
	
	public UploadFile() {
		super();
		// TODO Auto-generated constructor stub
	}

	public UploadFile(String fileName, String desc, MultipartFile file) {
		super();
		this.fileName = fileName;
		this.desc = desc;
		this.file = file;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public MultipartFile getFile() {
		return file;
	}

	public void setFile(MultipartFile file) {
		this.file = file;
	}

	@Override
	public String toString() {
		return "UploadFile [fileName=" + fileName + ", desc=" + desc + ", file=" + file + "]";
	}
	
	
	
	
}
