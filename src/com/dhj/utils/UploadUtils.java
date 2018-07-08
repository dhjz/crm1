package com.dhj.utils;

import java.util.UUID;

public class UploadUtils {

	public static String getUUIDName(String filename){
		int index = filename.lastIndexOf(".");
		String lastname = filename.substring(index, filename.length());
		String uuid = UUID.randomUUID().toString().replace("-", "");
		return uuid+lastname;
	}
}
