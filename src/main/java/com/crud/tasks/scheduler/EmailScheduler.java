package com.crud.tasks.scheduler;

import com.crud.tasks.config.AdminConfig;
import com.crud.tasks.domain.Mail;
import com.crud.tasks.repository.TaskRepository;
import com.crud.tasks.service.SimpleEmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class EmailScheduler {

    private static final String SUBJECT = "Tasks: Once a day tasks count email.";

    @Autowired
    private SimpleEmailService simpleEmailService;

    @Autowired
    private TaskRepository taskRepository;

    @Autowired
    private AdminConfig adminConfig;


    public void sendInformationEmail() {

        long size = taskRepository.count();
        String message = "Currently in database you have "+ size +((size == 1) ? " task." : " tasks.");

        simpleEmailService.send(new Mail(
                adminConfig.getAdminMail(),
                SUBJECT,
                message, "")
        );

    }

}
