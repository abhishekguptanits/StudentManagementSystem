package com.skynet.sms.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.skynet.sms.entity.Student;

public interface StudentRepository extends JpaRepository<Student, Long> {

}
