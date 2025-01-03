package edu.cjc.sms.app.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import edu.cjc.sms.app.model.Student;
import edu.cjc.sms.app.repositary.StudentRepo;
import edu.cjc.sms.app.servicei.StudentServiceI;
@Service
public class StudentServiceImpl implements StudentServiceI{

	@Autowired
	StudentRepo sr;
	
	@Override
	public List<Student> addStudent(Student s) {
		  sr.save(s);		
		return sr.findAll();
	}

	@Override
	public List<Student> getAllStudents() {
		
		return sr.findAll();
	}

	@Override
	public List<Student> searchStudentByBatch(String batchNumber) {
		List<Student> batchStudent=sr.findAllByBatchNumber(batchNumber);
		return batchStudent;
	}

	@Override
	public Student getSinglStudent(int id) {
	Optional<Student> op=	sr.findById(id);
	
		return op.get();
	}

	@Override
	public List<Student> updateStudentFees(int id, float amount) {
		Optional<Student> op =sr.findById(id);
		if(op.isPresent()) {
			Student s = op.get();
			s.setFeesPaid(s.getFeesPaid()+amount);
			sr.save(s);
		}
		return sr.findAll();
	}

	@Override
	public void removeStudent(int id) {
		sr.deleteById(id);
		
	}

	@Override
	public List<Student> paging(int pageNo, int i) {

		Pageable p = PageRequest.of(pageNo, i,Sort.by("studentFullName").ascending());
		List<Student> list =sr.findAll(p).getContent();		
		return list;
	}

	@Override
	public void shiftStudentBatch(int studentId, String batch, String mode) {
		Optional<Student> opStudent = sr.findById(studentId);
		Student st= opStudent.get();
		st.setBatchNumber(batch);
		st.setBatchMode(mode);
		sr.save(st);
		
	}

	
}
