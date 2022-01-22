package com.pinhobrunodev.course.consumers;

import com.pinhobrunodev.course.dtos.UserConsumerDto;
import com.pinhobrunodev.course.enums.ActionType;
import com.pinhobrunodev.course.services.UserService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.stereotype.Component;

import java.util.List;

@Log4j2
@Component
public class KafkaListening {


    @Autowired
    private UserService userService;


    @KafkaListener(topics = "user-topic", groupId = "group-1", containerFactory = "jsonKafkaListenerContainerFactory")
    public void userListen(List<UserConsumerDto> userConsumerDtos,
                           @Header(KafkaHeaders.RECEIVED_PARTITION_ID) int partition) {
        var actionType = userConsumerDtos.stream().findFirst().get().getActionType();
        var userModel = userConsumerDtos.stream().findFirst().map(x -> x.convertToUserModel()).orElseThrow(() -> new RuntimeException("Error during converting Dto to Model"));
        log.info("Partition : {} ", partition);
        log.info("Thread: {}", Thread.currentThread().getId());
        log.info("Message received : {} ", userConsumerDtos.toString());
        switch (ActionType.valueOf(actionType)) {
            case CREATE:
            case UPDATE:
                userService.saveUser(userModel);
                break;
        }
    }


}
