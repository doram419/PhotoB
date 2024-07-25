package himedia.photobook.controllers;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import org.springframework.web.multipart.MultipartFile;

public class FileModule {
	
	/**
	 * Param1 : MultipartFile multipartFile - 저장할 파일
	 * Param2 : String path - 저장할 경로
	 * Param3 : String saveFilename - 저장할 파일의 이름
	 * myPortal에서 들고 온 소스
	 * String : 서버에 파일이 저장된 경로
	 * */
	public String saveFile(MultipartFile multipartFile, String path, String saveFilename) 
			throws IOException {
		byte[] fileData = multipartFile.getBytes();
		File saveFile = new File(path);
		if(!saveFile.exists())
			saveFile.mkdirs();
		
		int number = 1;
		String extName = saveFilename.substring(saveFilename.lastIndexOf(".")); 
		String finalFileName = number + extName;
		String finalPath = saveFile.getPath();
		
		FileOutputStream fos = new FileOutputStream(finalPath + "/" + finalFileName);
		fos.write(fileData);
		fos.flush();
		fos.close();
		
		return finalPath;
	}
}
