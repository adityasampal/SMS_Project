package edu.cjc.sms.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import edu.cjc.sms.app.model.Student;
import edu.cjc.sms.app.servicei.StudentServiceI;

@Controller
public class AdminController {
	@Autowired
	StudentServiceI ssi;

	@RequestMapping("/")
	public String preLogin() {
		return "login";
	}

	@RequestMapping("/login")
	public String onLogin(@RequestParam("username") String u, @RequestParam("password") String p, Model m) {
		if (u.equals("admin") && p.equals("admin")) {
			m.addAttribute("data", ssi.getAllStudents());
			return "adminscreen";
		} else {
			return "login";
		}
	}

	@RequestMapping("/enroll_student")
	public String addStudent(@ModelAttribute Student s, Model m) {
		List<Student> list = ssi.addStudent(s);
		m.addAttribute("data", list);
		return "adminscreen";
	}

	@RequestMapping("/search")
	public String getBatchStudent(@RequestParam String batchNumber, Model m) {

		List<Student> result = ssi.searchStudentByBatch(batchNumber);
		if (result.size() > 0) {
			m.addAttribute("data", result);
		} else {
			List<Student> students = ssi.getAllStudents();
			m.addAttribute("data", students);
			m.addAttribute("message", "No record are available for the Batch" + batchNumber);
		}

		return "adminscreen";
	}

	@RequestMapping("/fees")
	public String onFees(@RequestParam int id, Model m) {
		Student stu = ssi.getSinglStudent(id);
		m.addAttribute("st", stu);
		return "fees";

	}

	@RequestMapping("/payfees")
	public String PayFees(@RequestParam("studentid")int id,@RequestParam("amount") float amount,Model m) {
		List<Student> list= ssi.updateStudentFees(id,amount);
		m.addAttribute("data", list);
		return "adminscreen";

	}
	
	@RequestMapping("/remove")
	public String remove(@RequestParam int id, Model m) {
		
		ssi.removeStudent(id);
		
		List<Student> list= ssi.getAllStudents();
		m.addAttribute("data", list);
		return "adminscreen";

	}
	
	@RequestMapping("/paging")
	public String paging(@RequestParam("pageNo")int pageNo,Model m) {
		
		List<Student> list= ssi.paging(pageNo,2);
		m.addAttribute("data", list);
		return "adminscreen";

	}
	
	@RequestMapping("/batch")
	public String batch(@RequestParam int id,Model m) {
		
		Student s = ssi.getSinglStudent(id);
		m.addAttribute("st", s);
		return "batch";
	}
	
	@RequestMapping("/shiftbatch")
	public String BatchShifting(@RequestParam int studentId,@RequestParam String batch,@RequestParam String mode,Model m) {
		
		ssi.shiftStudentBatch(studentId,batch,mode);
		List<Student> students =ssi.getAllStudents();
		m.addAttribute("data", students);
		return "adminscreen";
		
	}
}
