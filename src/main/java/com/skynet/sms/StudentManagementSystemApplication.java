package com.skynet.sms;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.skynet.sms.entity.Student;
import com.skynet.sms.repository.StudentRepository;

@SpringBootApplication()
public class StudentManagementSystemApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(StudentManagementSystemApplication.class, args);
	}
	
	@Autowired
	private StudentRepository studentRepository;

	@Override
	public void run(String... args) throws Exception {
		/*
		Student student1 = new Student("Jeremy", "Renner", "jeremy@hawkeye.com");
		studentRepository.save(student1);
		
		Student student2 = new Student("Natasha", "Romanov", "natasha@blackwidow.com");
		studentRepository.save(student2);
		
		Student student3 = new Student("Tony", "Stark", "tonystark@ironman.com");
		studentRepository.save(student3);
		*/
	}

}
