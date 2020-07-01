package com.example.consumer;

import com.example.contracts.controllers.dto.UserDto;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class UserClient {
    private String url;

    public UserClient(String url) {
        this.url = url;
    }

    public UserDto callProducer() {
        ResponseEntity<UserDto> responseEntity = new RestTemplate().getForEntity(this.url, UserDto.class);
        return responseEntity.getBody();
    }
}
