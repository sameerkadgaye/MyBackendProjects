/**
 * 
 */
package com.restApi.helper;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author sameer
 *
 */
@Component
public class FileUploadHelper {

	public FileUploadHelper() throws IOException {
	}

	public final String UPLOAD_DIR = new ClassPathResource("static/images/").getFile().getAbsolutePath();
//	public final String UPLOAD_DIR = "/media/sameer/E-DRIVE/MY_STS_WORKSPACES/LockDown_Implementations/Spring(BOOT)_Projects_workspace/restApiWithFileUploadWithDyanmicPath/src/main/resources/static/images";

	public boolean uploadFile(MultipartFile multipartFile) {
		boolean f = false;
		try {
			// Old Way in servlet & MVC START
//			InputStream is = multipartFile.getInputStream();
//			byte data[] = new byte[is.available()];
//			is.read(data);
//			// Write to our path
//			FileOutputStream fos = new FileOutputStream(
//					UPLOAD_DIR + File.separator + multipartFile.getOriginalFilename());
//			fos.write(data);
//			fos.flush();
//			fos.close();
			// Old Way in servlet & MVC END

			// New Way in With Boot Start
			Files.copy(multipartFile.getInputStream(),
					Paths.get(UPLOAD_DIR + File.separator + multipartFile.getOriginalFilename()),
					StandardCopyOption.REPLACE_EXISTING);
			// New Way in With Boot End
			f = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return f;
	}
}
