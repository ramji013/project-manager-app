package com.project.manager.repository;

import com.project.manager.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
public interface TaskRepository extends JpaRepository<Task, Long> {

    @Query(value = "select * from task where project_id = :projectId and status = 'Y'",nativeQuery = true)
    List<Task> findByProjectId(@Param("projectId") String projectId);
}
