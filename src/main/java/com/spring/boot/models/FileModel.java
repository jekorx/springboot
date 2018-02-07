package com.spring.boot.models;

import org.springframework.web.multipart.MultipartFile;

/**
 * 文件上传
 * @author wang_donggang
 */
public class FileModel {
	
	private int num;
	private String name;
	private MultipartFile file;
	private MultipartFile[] files;
	public FileModel() {
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public MultipartFile getFile() {
		return file;
	}
	public void setFile(MultipartFile file) {
		this.file = file;
	}
	public MultipartFile[] getFiles() {
		return files;
	}
	public void setFiles(MultipartFile[] files) {
		this.files = files;
	}
	
}
