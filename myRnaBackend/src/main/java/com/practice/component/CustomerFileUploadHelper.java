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
 * @author SUMIT KANASKAR
 * @version 0.1
 * 
 *          Created Date : 07/12/2021
 * 
 *          Updated Date :
 * 
 *          Updated By :
 *
 */

@Component
public class CustomerFileUploadHelper {

	public CustomerFileUploadHelper() throws IOException {
		// TODO Auto-generated constructor stub
	}

	public final String DOCUMENT_UPLOAD_DIR = new ClassPathResource("static/documents/customerDocuments/").getFile()
			.getAbsolutePath();
	public final String SIGNATURE_UPLOAD_DIR = new ClassPathResource("static/documents/customerSignature/").getFile()
			.getAbsolutePath();
	public final String PHOTO_UPLOAD_DIR = new ClassPathResource("static/documents/customerPhoto/").getFile()
			.getAbsolutePath();

	public boolean uploadDocument(MultipartFile multipartFile) {
		boolean f = false;
		try {

			// New Way in With Boot Start
			Files.copy(multipartFile.getInputStream(),
					Paths.get(DOCUMENT_UPLOAD_DIR + File.separator + multipartFile.getOriginalFilename()),
					StandardCopyOption.REPLACE_EXISTING);
			// New Way in With Boot End
			f = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return f;
	}

	public boolean uploadSignature(MultipartFile multipartFile) {
		boolean f = false;
		try {

			// New Way in With Boot Start
			Files.copy(multipartFile.getInputStream(),
					Paths.get(SIGNATURE_UPLOAD_DIR + File.separator + multipartFile.getOriginalFilename()),
					StandardCopyOption.REPLACE_EXISTING);
			// New Way in With Boot End
			f = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return f;
	}

	public boolean uploadPhoto(MultipartFile multipartFile) {
		boolean f = false;
		try {

			// New Way in With Boot Start
			Files.copy(multipartFile.getInputStream(),
					Paths.get(PHOTO_UPLOAD_DIR + File.separator + multipartFile.getOriginalFilename()),
					StandardCopyOption.REPLACE_EXISTING);
			// New Way in With Boot End
			f = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return f;
	}

//	public boolean uploadNewFile(File file) {
//		boolean f = false;
//		try {
//
//			// New Way in With Boot Start
//			Files.copy(file.getInputStream(),
//					Paths.get(UPLOAD_DIR + File.separator + file.getOriginalFilename()),
//					StandardCopyOption.REPLACE_EXISTING);
//			// New Way in With Boot End
//			f = true;
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		return f;
//	}

}
