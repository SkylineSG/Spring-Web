package com.crud.tasks.service;

import com.crud.tasks.config.AdminConfig;
import com.crud.tasks.config.CompanyConfig;
import com.crud.tasks.domain.Mail;
import com.crud.tasks.domain.Task;
import com.crud.tasks.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import java.util.ArrayList;
import java.util.List;


@Service
public class MailCreatorService {

    @Autowired
    private AdminConfig adminConfig;

    @Autowired
    private CompanyConfig companyConfig;

    @Autowired
    private TaskRepository taskRepository;

    @Autowired
    @Qualifier("templateEngine")
    private TemplateEngine templateEngine;

    public String buildTrelloCardEmail(String message) {
        List<String> functionality = new ArrayList<>();
        functionality.add("You can manage your task");
        functionality.add("Provides connection with Trello Account");
        functionality.add("Application allows sending tasks to Trello");

        Context context = new Context();
        context.setVariable("message", message);
        context.setVariable("tasks_url","http://localhost:8888/tasks_frontend/");
        context.setVariable("button","Visit website");
        context.setVariable("admin_name",adminConfig.getAdminName());
        context.setVariable("company_name", companyConfig.getName());
        context.setVariable("company_phone", companyConfig.getPhone());
        context.setVariable("company_email", companyConfig.getEmail());
        context.setVariable("company_goal", companyConfig.getGoal());
        context.setVariable("goodbye_message", "Thank you!");
        context.setVariable("show_button", false);
        context.setVariable("is_friend", true);
        context.setVariable("admin_config", adminConfig);
        context.setVariable("application_functionality", functionality);
        return templateEngine.process("mail/created-trello-card-mail", context);
    }

    public String buildTasksQuantityDailyEmail(String message) {
        long size = taskRepository.count();
        String taskOrTasks = size >=0 ? " tasks" : " task";
        String tasksQuantity = "Currently in database you got: " + size + taskOrTasks;

        ArrayList<Task> tasksList = new ArrayList<>(taskRepository.findAll());

        Context context = new Context();
        context.setVariable("message", message);
        context.setVariable("tasks_url","http://localhost:8888/tasks_frontend/");
        context.setVariable("button","Visit website");
        context.setVariable("admin_name",adminConfig.getAdminName());
        context.setVariable("company_name", companyConfig.getName());
        context.setVariable("company_phone", companyConfig.getPhone());
        context.setVariable("company_email", companyConfig.getEmail());
        context.setVariable("company_goal", companyConfig.getGoal());
        context.setVariable("goodbye_message", "Thank you!");
        context.setVariable("tasks_quantity", tasksQuantity);
        context.setVariable("tasks_list", tasksList);


        return templateEngine.process("mail/tasks-number-daily-email", context);
    }
}