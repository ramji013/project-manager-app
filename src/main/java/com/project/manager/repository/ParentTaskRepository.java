package com.project.manager.repository;

import com.project.manager.entity.ParentTask;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.transaction.Transactional;

@Transactional
public interface ParentTaskRepository extends JpaRepository<ParentTask, Long> {

}
