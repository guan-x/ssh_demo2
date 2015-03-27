package cn.gx.domain.view;

import java.io.InputStream;
import java.io.Serializable;

public class DownloadFile implements Serializable{

	
	/** 下载的文件类�? */
	private String downloadContentType;
	/** 下载的文件名�? */
	private String downloadFileName;
	/** 下载输入�? */
	private InputStream downloadStream;
	
	
	
	
	public DownloadFile() {
		super();
		// TODO Auto-generated constructor stub
	}
	public DownloadFile(String downloadContentType, String downloadFileName,
			InputStream downloadStream) {
		super();
		this.downloadContentType = downloadContentType;
		this.downloadFileName = downloadFileName;
		this.downloadStream = downloadStream;
	}
	public String getDownloadContentType() {
		return downloadContentType;
	}
	public void setDownloadContentType(String downloadContentType) {
		this.downloadContentType = downloadContentType;
	}
	public String getDownloadFileName() {
		return downloadFileName;
	}
	public void setDownloadFileName(String downloadFileName) {
		this.downloadFileName = downloadFileName;
	}
	public InputStream getDownloadStream() {
		return downloadStream;
	}
	public void setDownloadStream(InputStream downloadStream) {
		this.downloadStream = downloadStream;
	}
	
	
	
	
}
