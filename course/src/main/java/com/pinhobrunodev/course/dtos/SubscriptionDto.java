package com.pinhobrunodev.course.dtos;

import com.fasterxml.jackson.annotation.JsonView;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SubscriptionDto {
    public interface CourseUserView {
        public static interface SubscribeUser {
        }
    }
    @JsonView(SubscriptionDto.CourseUserView.SubscribeUser.class)
    private String userId;


}
