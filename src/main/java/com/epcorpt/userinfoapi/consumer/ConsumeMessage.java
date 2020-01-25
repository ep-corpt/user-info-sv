package com.epcorpt.userinfoapi.consumer;

import com.epcorpt.userinfoapi.dao.entity.UserInfoEntity;
import com.epcorpt.userinfoapi.dao.repository.UserInfoRepository;
import com.epcorpt.userinfoapi.model.MessageModel;
import com.epcorpt.userinfoapi.model.UserDetail;
import com.google.gson.Gson;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class ConsumeMessage {

    @Autowired
    private UserInfoRepository userInfoRepository;

    @KafkaListener(topics = "${config.kafka.topic}", groupId = "${spring.kafka.consumer.group-id}")
    public void consumer(String message) {
        try {
            log.debug("message: {}", message);
            MessageModel messageModel = new Gson().fromJson(message, MessageModel.class);
            UserDetail userDetail = messageModel.getUserDetail();
            userInfoRepository.save(UserInfoEntity.builder()
                    .username(messageModel.getCredentialDetail().getUsername())
                    .firstName(userDetail.getFirstName())
                    .lastName(userDetail.getLastName())
                    .build());
        } catch (Exception e) {
            log.error("Exception occurred while saving register message", e);
        }
    }
}
