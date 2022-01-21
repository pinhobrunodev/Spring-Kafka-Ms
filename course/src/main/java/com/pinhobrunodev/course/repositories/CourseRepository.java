package com.pinhobrunodev.course.repositories;

import com.pinhobrunodev.course.models.CourseModel;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CourseRepository extends MongoRepository<CourseModel,String> {
}
