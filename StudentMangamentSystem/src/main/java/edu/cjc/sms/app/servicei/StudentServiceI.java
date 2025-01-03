package edu.cjc.sms.app.servicei;

import java.util.List;

import edu.cjc.sms.app.model.Student;

public interface StudentServiceI {

	List<Student> addStudent(Student s);
	List<Student> getAllStudents();
	List<Student> searchStudentByBatch(String batchNumber);
	Student getSinglStudent(int id);
	List<Student> updateStudentFees(int id, float amount);
	void removeStudent(int id);
	List<Student> paging(int pageNo, int i);
	void shiftStudentBatch(int studentId, String batch, String mode);
	
	

}
