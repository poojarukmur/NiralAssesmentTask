package in.pooja.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import in.pooja.model.Student;

public interface  StudentRepo  extends JpaRepository<Student, Integer>{
	

}
