
package com.example.credOperations.service;
 
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.credOperations.binding.Course;
import com.example.credOperations.binding.Laptop;
import com.example.credOperations.repo.CourseRepository;
import com.fasterxml.jackson.databind.ObjectMapper;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

//to represent this service class as a spring Bean we use annotaion service.

@Service
public class CourseServiceImpl implements CourseService {

	// here service shoude communicate with repository : service class methods can
	// communicate with repository methods
//dependency injection : seter injection, 2. constructor injection , 3.field injection

	@Autowired
	private CourseRepository courseRepo;
	
	@PersistenceContext
	private EntityManager entityManger;

	@Override
	@Transactional
	public String upsert(@RequestBody Course course) {
		try {
			ObjectMapper objectMapper = new ObjectMapper();
			String requestBody = objectMapper.writeValueAsString(course);
			System.out.println("Request body : "+requestBody);
		}
		catch(Exception e) {
			System.out.println("error print req body : "+e.getMessage());
		}
 		Laptop laptop = new Laptop();
 		 String laptopName = course.getLaptop().getLaptopName(); 
		laptop.setLaptopName(laptopName);
		entityManger.persist(laptop);
		course.setLaptop(laptop);
		courseRepo.save(course);
		return "Success";
	}

	@Override
	public Course getById(Integer cid) {
		Optional<Course> findById = courseRepo.findById(cid);
		if (findById.isPresent()) {
			return findById.get();
		}
		return null;
	}

	@Override
	public List<Course> getAllCourses() {

		return courseRepo.findAll();
	}

	@Override
	public List<Course> getAllCoursesOfThisMonth() {
//		Calendar calendar = Calendar.getInstance();
//        calendar.set(Calendar.DAY_OF_MONTH, 1);
//        Date startOfMonth = calendar.getTime();
//
//        // Get the end date of the current month
//        calendar.add(Calendar.MONTH, 1);
//        calendar.add(Calendar.DATE, -1);
//        Date endOfMonth = calendar.getTime();
//
//
//		return courseRepo.findByCourseDateBetween(startOfMonth,endOfMonth);
		
		return null;
	}

	@Override
	public String deleteById(Integer cid) {
		if (courseRepo.existsById(cid)) {
			courseRepo.deleteById(cid);
			return "Delete success";
		} else {
			return "No Record found";
		}
	}

}