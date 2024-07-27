package himedia.photobook.tools;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.PosixFilePermission;
import java.util.HashSet;
import java.util.Set;

import org.springframework.web.multipart.MultipartFile;

public class FileModule {
	/**
	 * Param1 : MultipartFile multipartFile - 저장할 파일
	 * Param2 : String path - 저장할 경로
	 * Param3 : String saveFilename - 저장할 파일의 이름
	 * myPortal에서 들고 온 소스
	 * String : 서버에 파일이 저장된 경로
	 * */
	public String saveFile(MultipartFile multipartFile, String path, String filename, String extName) 
			throws IOException {
		byte[] fileData = multipartFile.getBytes();
		File saveFile = new File(path);
		
		if(!saveFile.exists())
			saveFile.mkdirs();
		if(!extName.equals(".jpg"))
			extName = ".jpg";
		String finalFileName = filename + extName;
		String finalPath = saveFile.getPath() + "\\";
		Path filePath = Paths.get(finalPath, finalFileName);
		//TODO : 문제 있으면 exception처리
		Files.write(filePath, fileData);

		String os = System.getProperty("os.name").toLowerCase();
		 if (os.contains("nix") || os.contains("nux") || os.contains("mac")) {
	         Set<PosixFilePermission> perms = new HashSet<>();
	         perms.add(PosixFilePermission.OWNER_READ);
	         perms.add(PosixFilePermission.OWNER_EXECUTE);
	         perms.add(PosixFilePermission.GROUP_READ);
	         perms.add(PosixFilePermission.GROUP_EXECUTE);
	         perms.add(PosixFilePermission.OTHERS_READ);
	         perms.add(PosixFilePermission.OTHERS_EXECUTE);
	        
	         Files.setPosixFilePermissions(filePath, perms);
	      }
		
		return finalPath + finalFileName;
	}
}
