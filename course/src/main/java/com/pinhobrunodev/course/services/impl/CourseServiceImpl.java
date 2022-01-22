package com.pinhobrunodev.course.services.impl;

import com.pinhobrunodev.course.dtos.CourseDto;
import com.pinhobrunodev.course.models.CourseModel;
import com.pinhobrunodev.course.repositories.CourseRepository;
import com.pinhobrunodev.course.services.CourseService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

@Service
public class CourseServiceImpl implements CourseService {


    @Autowired
    private CourseRepository courseRepository;

    @Override
    public CourseDto saveCourse(CourseDto courseDto) {
        var course = new CourseModel();
        BeanUtils.copyProperties(courseDto, course);
        return new CourseDto(courseRepository.save(course));
    }
}
