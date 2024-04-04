
package com.example.credOperations.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.credOperations.binding.Course;
import com.example.credOperations.repo.CourseRepository;

//to represent this service class as a spring Bean we use annotaion service.

@Service
public class CourseServiceImpl implements CourseService {

	// here service shoude communicate with repository : service class methods can
	// communicate with repository methods
//dependency injection : seter injection, 2. constructor injection , 3.field injection

	@Autowired
	private CourseRepository courseRepo;

	@Override
	public String upsert(Course course) {
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
	public String deleteById(Integer cid) {
		if (courseRepo.existsById(cid)) {
			courseRepo.deleteById(cid);
			return "Delete success";
		} else {
			return "No Record found";
		}
	}

}