package com.radis.radisCacheProject;

import com.radis.radisCacheProject.entity.Student;
import com.radis.radisCacheProject.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class RadisCacheProjectApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(RadisCacheProjectApplication.class, args);
	}

	@Autowired
	private StudentRepository studentRepository;
	@Override
	public void run(String... args) throws Exception {
		Student studentOne = new Student(1,"Din","Islam");
		studentRepository.save(studentOne);
		Student studentTwo = new Student(2,"Muaz","Hasan");
		studentRepository.save(studentTwo);
	}
}
