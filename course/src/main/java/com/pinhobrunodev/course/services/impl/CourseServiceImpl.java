package com.pinhobrunodev.course.services.impl;

import com.pinhobrunodev.course.dtos.CourseDto;
import com.pinhobrunodev.course.models.CourseModel;
import com.pinhobrunodev.course.models.UserModel;
import com.pinhobrunodev.course.repositories.CourseRepository;
import com.pinhobrunodev.course.repositories.UserRepository;
import com.pinhobrunodev.course.services.CourseService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CourseServiceImpl implements CourseService {


    @Autowired
    private CourseRepository courseRepository;
    @Autowired
    private UserRepository userRepository;

    @Override
    public CourseDto saveCourse(CourseDto courseDto) {
        var course = new CourseModel();
        BeanUtils.copyProperties(courseDto, course);
        return new CourseDto(courseRepository.save(course));
    }

    @Override
    public void saveSubscriptionUserInCourse(String courseId, String userId) {
        Optional<CourseModel> courseModelOptional = courseRepository.findById(courseId);
        var courseModel = courseModelOptional.isPresent() ? courseModelOptional.get() : courseModelOptional.orElseThrow(() -> new RuntimeException("courseId not found"));
        Optional<UserModel> userModelOptional = userRepository.findById(userId);
        var userMModel = courseModelOptional.isPresent() ? userModelOptional.get() : userModelOptional.orElseThrow(() -> new RuntimeException("userId not found"));
        courseModel.getStudents().add(userMModel);
        courseRepository.save(courseModel);
    }
}
