package com.crud.tasks.service;

import com.crud.tasks.domain.Task;
import com.crud.tasks.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class DbService {
    @Autowired
    TaskRepository repository;

    public List<Task> getAllTask(){
        return repository.findAll();
    }

    public Optional<Task> getOneTask(Long id){
        return repository.findById(id);
    }

    public Task saveTask(final Task task) {
        return repository.save(task);
    }

    public Task deleteTask(final Long id) {
        return repository.delete(id);
    }
}
