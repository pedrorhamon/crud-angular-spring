package com.starking.crudspring.services;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.starking.crudspring.exceptions.RecordNotFoundException;
import com.starking.crudspring.model.Course;
import com.starking.crudspring.repositories.CourseRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CourseService {

	private final CourseRepository courseRepository;
	
	public List<Course> findAll() {
		return this.courseRepository.findAll();
	}
	
	@Transactional
	public Course save(Course course) {
		return this.courseRepository.save(course);
	}
	
	public Optional<Course> update(@NotNull @Positive Long id, @Valid Course course) {
		return courseRepository.findById(id).map(recordFound -> {
			recordFound.setName(course.getName());
			recordFound.setCategory(course.getCategory());
			return courseRepository.save(recordFound);
		});
	}
	
	public Optional<Course> getById(Long id) {
		return this.courseRepository.findById(id);
	}
	
	public void delete(@PathVariable @NotNull @Positive Long id) {
		courseRepository.delete(courseRepository.findById(id)
				.orElseThrow(() -> new RecordNotFoundException(id)));
	}
}
