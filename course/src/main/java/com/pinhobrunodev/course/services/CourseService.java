package com.pinhobrunodev.course.services;

import com.pinhobrunodev.course.dtos.CourseDto;

public interface CourseService {


    CourseDto saveCourse(CourseDto courseDto);
    void saveSubscriptionUserInCourse(String courseId,String userId);
}
