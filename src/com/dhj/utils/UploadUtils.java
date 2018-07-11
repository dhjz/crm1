package com.dhj.utils;

import java.util.UUID;

public class UploadUtils {

	public static String getUUIDName(String filename){
		int index = filename.lastIndexOf(".");
		String lastname = filename.substring(index, filename.length());
		String uuid = UUID.randomUUID().toString().replace("-", "");
		return uuid+lastname;
	}
	
	/**
	 * 目录分离的方法
	 * @param args
	 */
	public static String getPath(String uuidFileName){
		int code1 = uuidFileName.hashCode();
		int d1 = code1 & 0xf; // 作为一级目录
		int code2 = code1 >>> 4;
		int d2 = code2 & 0xf; // 作为二级目录
		return "/"+d1+"/"+d2;
	}
}
