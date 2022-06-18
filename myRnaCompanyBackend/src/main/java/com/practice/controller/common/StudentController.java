/**
 * 
 */
package com.practice.controller.common;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.practice.constants.Constants;
import com.practice.model.common.RequestResponse;
import com.practice.model.common.Student;
import com.practice.service.inf.common.StudentService;

/**
 * @author Sameer Kadgaye
 *
 */
@RestController
@CrossOrigin
public class StudentController {

	@Autowired
	private StudentService studentService;

	@GetMapping("/students")
	public ResponseEntity<RequestResponse> getStudents() {
		List<Student> students = this.studentService.getStudents();
		if (students.size() <= 0) {
			return RequestController.getBaseResponse(Constants.ErrorCode, Constants.DataListNotFound,
					HttpStatus.NOT_FOUND, null);
		} else {
			return RequestController.getBaseResponse(Constants.SuccessCode, Constants.DataListFetchSuccess,
					HttpStatus.ACCEPTED, students);
		}
	}

	@GetMapping("/student/{studentId}")
	public ResponseEntity<RequestResponse> getStudentById(@PathVariable("studentId") int studentId) {
		Student student = this.studentService.getStudentById(studentId);
		if (student == null) {
			return RequestController.getBaseResponse(Constants.ErrorCode, Constants.DataNotFound, HttpStatus.NOT_FOUND,
					student);
		}
		return RequestController.getBaseResponse(Constants.SuccessCode, Constants.DataFetchSuccess, HttpStatus.ACCEPTED,
				student);
	}

	@PostMapping("/student")
	public ResponseEntity<RequestResponse> saveStudent(@RequestBody Student student) {
		Student saveStudent = this.studentService.saveStudent(student);
		return RequestController.getBaseResponse(Constants.SuccessCode, Constants.DataSaveSuccess, HttpStatus.CREATED,
				saveStudent);
	}

	@DeleteMapping("/student/{studentId}")
	public ResponseEntity<RequestResponse> deleteStudent(@PathVariable("studentId") Integer studentId) {
		System.out.println("Delete Mapping Heated ===>>" + studentId);
		this.studentService.deleteStudent(studentId);
		return RequestController.getBaseResponse(Constants.SuccessCode, Constants.DataDeleteSuccess,
				HttpStatus.NO_CONTENT, null);
	}

	@PutMapping("/student/{studentId}")
	public ResponseEntity<RequestResponse> updateStudent(@RequestBody Student student,
			@PathVariable("studentId") Integer studentId) {
		this.studentService.updateStudent(student, studentId);
		return RequestController.getBaseResponse(Constants.SuccessCode, Constants.DataUpdateSuccess, HttpStatus.CREATED,
				student);
	}

}
