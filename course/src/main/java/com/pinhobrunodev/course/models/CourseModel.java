package com.pinhobrunodev.course.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.time.Instant;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Document(collection = "courses")
public class CourseModel implements Serializable {

    @Id
    private String id;
    private String courseName;
    private String courseDescription;
    @CreatedDate
    @JsonFormat(shape = JsonFormat.Shape.STRING,pattern = "dd/MM/yyyy hh:MM:ss",timezone = "UTC")
    private Instant criadoEm;
    @LastModifiedDate
    private LocalDateTime atualizadoEm;
    @DBRef(lazy = true)
    public Set<UserModel> students = new HashSet<>();

}
