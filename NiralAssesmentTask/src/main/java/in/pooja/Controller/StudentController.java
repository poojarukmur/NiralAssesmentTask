package in.pooja.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import in.pooja.model.Student;
import in.pooja.service.StudentService;

@RestController
@RequestMapping("/students")
public class StudentController {
	
	@Autowired
	private StudentService service;
	
	@GetMapping
	public List<Student> getAllStudents(){
		return service.getAllStudents();
		
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Student> getStudent(@PathVariable int id){
		return service.getStudentById(id)
				.map(ResponseEntity::ok)
				.orElse(ResponseEntity.notFound().build());
		
	}
	
	@PostMapping
	public Student createstudent(@RequestBody Student student)
	{
		return service.saveStudent(student);
		
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Student> updateStudent(@PathVariable int id, @RequestBody Student student){
		try {
			return ResponseEntity.ok(service.updateStudent(id, student));
		}catch(RuntimeException e) {
			return ResponseEntity.notFound().build();
			
		}
	
		
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteStudent(@PathVariable int id) {
		service.deleteStudent(id);
		return ResponseEntity.ok().build();
	}
}
