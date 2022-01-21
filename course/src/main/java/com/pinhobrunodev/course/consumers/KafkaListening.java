package com.pinhobrunodev.course.consumers;

import com.pinhobrunodev.course.dtos.UserConsumerDto;
import com.pinhobrunodev.course.enums.ActionType;
import com.pinhobrunodev.course.models.UserModel;
import com.pinhobrunodev.course.services.UserService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.stereotype.Component;

@Log4j2
@Component
public class KafkaListening {


    @Autowired
    private UserService userService;


    @KafkaListener(topics = "user-topic", groupId = "group-1", containerFactory = "jsonKafkaListenerContainerFactory")
    public void createUser(UserConsumerDto userConsumerDto,
                           @Header(KafkaHeaders.RECEIVED_PARTITION_ID) int partition) {
        log.info("Partition : {} ", partition);
        log.info("Thread: {}", Thread.currentThread().getId());
        log.info("Message received : {} ",userConsumerDto.toString());
        var userModel = userConsumerDto.convertToUserModel();
        switch (ActionType.valueOf(userConsumerDto.getActionType())) {
            case CREATE:
            case UPDATE:
                userService.saveUser(userModel);
                break;
        }
    }


}
