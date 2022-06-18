/**
 * 
 */
package com.restApi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.restApi.helper.FileUploadHelper;

/**
 * @author sameer
 *
 */
@RestController
public class FileUploadController {

	/**
	 * 
	 */
	public FileUploadController() {
	}

	@Autowired
	FileUploadHelper fileUploadHelper;

	@PostMapping("/upload-file")
	public ResponseEntity<String> uploadFile(@RequestParam("file") MultipartFile file) {
		try {
			if (file.isEmpty()) {
				return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Select File First For Uplaod");
			}
			if (!file.getContentType().equals("image/jpeg")) {
				return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Only image/jpeg Type Allowed");
			}
			// File Upload Code
			boolean status = fileUploadHelper.uploadFile(file);

			if (status) {
				return ResponseEntity.ok("File Is Uploading Successfully");
//				return ResponseEntity.ok(ServletUriComponentsBuilder.fromCurrentContextPath().path("/images/")
//						.path(file.getOriginalFilename()).toUriString());
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
				.body("Something Went To Wrong !! Please Try Again Letter");
	}

}
