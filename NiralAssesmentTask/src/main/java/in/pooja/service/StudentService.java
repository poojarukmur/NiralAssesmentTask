package in.pooja.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.pooja.model.Student;
import in.pooja.repo.StudentRepo;

@Service
public class StudentService {
	
	@Autowired
	private StudentRepo repo;
	
	public List<Student> getAllStudents(){
		return repo.findAll();
		
	}
	
	public Optional<Student> getStudentById(int id){
		return repo.findById(id);
		
	}
	
	public Student saveStudent(Student student) {
		return repo.save(student);
		
	}
	
	public Student updateStudent(int id, Student studentDetails) {
		return repo.findById(id).map(student ->{
			student.setName(studentDetails.getName());
			student.setAge(studentDetails.getAge());
			student.setEmail(studentDetails.getEmail());
			
			return repo.save(student);
		}).orElseThrow(()-> new RuntimeException("student not found"));
		
	}
	public void deleteStudent(int id) {
		 repo.deleteById(id);
	}
	

}
