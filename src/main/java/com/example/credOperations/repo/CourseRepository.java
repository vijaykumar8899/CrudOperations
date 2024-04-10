package com.example.credOperations.repo;
 
import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.credOperations.binding.Course;
  

// at the time of project start jpa repositories will be scanned by springBoot and they will provide implementation class for our interface in the runtime by using proxy
@Repository
 public interface CourseRepository extends JpaRepository<Course, Serializable> {

 
}
