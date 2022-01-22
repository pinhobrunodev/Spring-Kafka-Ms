package com.pinhobrunodev.course.dtos;

import com.fasterxml.jackson.annotation.JsonView;
import com.pinhobrunodev.course.models.CourseModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.Instant;
import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class CourseDto implements Serializable {


    public interface CourseView {
        public static interface CourseRegister {
        }
    }


    private String id;
    @JsonView(CourseView.CourseRegister.class)
    private String courseName;
    @JsonView(CourseView.CourseRegister.class)
    private String courseDescription;
    private Instant criadoEm;
    private LocalDateTime atualizadoEm;



    public CourseDto(CourseModel courseModel) {
        id = courseModel.getId();
        courseName = courseModel.getCourseName();
        courseDescription = courseModel.getCourseDescription();
        criadoEm = courseModel.getCriadoEm();
        atualizadoEm = courseModel.getAtualizadoEm();
    }
}
