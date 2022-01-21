package com.pinhobrunodev.course.repositories;

import com.pinhobrunodev.course.models.CourseModel;
import com.pinhobrunodev.course.models.UserModel;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<UserModel,String> {
}
