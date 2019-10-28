package com.project.manager.repository;

import com.project.manager.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.transaction.Transactional;

@Transactional
public interface TaskRepository extends JpaRepository<Task, Long> {
}
