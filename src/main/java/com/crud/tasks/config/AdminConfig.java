package com.crud.tasks.config;

import lombok.Getter;

import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Value;

@Component
//@Getter
public class AdminConfig {

    @Value("${admin.mail}")
    private String adminMail;

    @Value("${admin.name}")
    private  String adminName;

    public String getAdminMail() {
        return adminMail;
    }

    public String getAdminName() {
        return adminName;
    }
}