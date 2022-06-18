/**
 * 
 */
package com.practice.service.inf.common;

import java.util.List;

import com.practice.model.common.Student;

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
public interface StudentService {
	public Student saveStudent(Student student);
	public List<Student> getStudents();
	public Student getStudentById(int studentId);
	public void deleteStudent(Integer studentId);
	public void updateStudent(Student student, int studentId);

}
