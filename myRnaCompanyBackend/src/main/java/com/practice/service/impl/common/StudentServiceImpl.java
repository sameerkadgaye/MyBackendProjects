/**
 * 
 */
package com.practice.service.impl.common;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.practice.dao.common.StudentRepository;
import com.practice.model.common.Student;
import com.practice.service.inf.common.StudentService;

/**
 * @author SAMEER KADGAYE
 * @version 0.1
 * 
 *          Created Date : 28/10/2021
 * 
 *          Updated Date :
 * 
 *          Updated By :
 *
 */
@Service
public class StudentServiceImpl implements StudentService{

	@Autowired
	private StudentRepository studentRepository;

	public Student saveStudent(Student student) {

		Student savedStudent = this.studentRepository.save(student);
		return savedStudent;
	}

	public List<Student> getStudents() {
		List<Student> studsAll = this.studentRepository.findAll();
		return studsAll;
	}

	public Student getStudentById(int studentId) {
		Student student= null;
		try {
			student = this.studentRepository.findById(studentId);
		} catch (Exception e) {
			e.printStackTrace();	
		}
		return student;
	}

	public void deleteStudent(Integer studentId) {
		this.studentRepository.deleteById(studentId);
	}

	public void updateStudent(Student student, int studentId) {
		student.setStudentId(studentId);
		this.studentRepository.save(student);
	}

}
