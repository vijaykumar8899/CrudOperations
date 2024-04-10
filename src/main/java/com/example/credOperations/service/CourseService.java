package com.example.credOperations.service;

import java.util.List;

import com.example.credOperations.binding.Course;

public interface CourseService {
	//Upset is a polymorphic method ; this method will be used for insertion as well as update; 
	//save + update; 
	public String upsert(Course course);
	
	
	public Course getById(Integer cid);
	
	public List<Course> getAllCourses();
	
	public String deleteById(Integer cid);

	public List<Course> getAllCoursesOfThisMonth();
}
