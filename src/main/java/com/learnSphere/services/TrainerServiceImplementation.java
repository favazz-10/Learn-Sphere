package com.learnSphere.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.learnSphere.entities.Course;
import com.learnSphere.entities.Lesson;
import com.learnSphere.repositories.CourseRepository;
import com.learnSphere.repositories.LessonRepository;

@Service
public class TrainerServiceImplementation implements TrainerService{
  
	
	@Autowired
	CourseRepository repo1;
	@Override
	public String addCourse(Course course) {
		repo1.save(course);
		return "course added";
	}
	
	
	
	@Override
	public List<Course> viewCourse() {
		return repo1.findAll();
	}
	
	
	
	@Autowired
	LessonRepository repo2;
	@Override
	public String addLesson(Lesson lesson) {
		repo2.save(lesson);
		return "lesson added";
	}



	@Override
	public String saveCourse(Course course) {
		repo1.save(course);
		return "course updated";
	}

	
	
}
