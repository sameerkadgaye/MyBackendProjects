/**
 * 
 */
package com.practice.component;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author Anurag Ninawe
 *
 */
@Component
public class FileUploadHelper {

	public FileUploadHelper() throws IOException {
	}

	public final String UPLOAD_DIR = new ClassPathResource("static/images/userImages").getFile().getAbsolutePath();
//	public final String UPLOAD_DIR = new ClassPathResource("sameer/Pictures").getFile().getAbsolutePath();
	public boolean uploadFile(MultipartFile multipartFile) {
		boolean f = false;
		try {

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
