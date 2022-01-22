package com.pinhobrunodev.course.controllers;

import com.fasterxml.jackson.annotation.JsonView;
import com.pinhobrunodev.course.dtos.CourseDto;
import com.pinhobrunodev.course.services.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/courses")
public class CourseController {


    @Autowired
    private CourseService courseService;


    @PostMapping
    public ResponseEntity<?> saveCourse(@RequestBody  @JsonView(CourseDto.CourseView.CourseRegister.class) CourseDto courseDto){
        return ResponseEntity.status(HttpStatus.CREATED).body(courseService.saveCourse(courseDto));
    }
}
