package com.project.manager.repository;

import com.project.manager.entity.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public interface ProjectRepository extends JpaRepository<Project, Long> {

    @Query(value = "select * from project where project_id = :projectId",nativeQuery = true)
    Project getProjectById(@Param("projectId") int projectId);

    @Modifying
    @Query(value = "update project set is_active = 'N' where project_id = :projectId", nativeQuery = true)
    void suspendProject(@Param("projectId") String projectId);

    @Query(value = "select * from project where is_active='Y'", nativeQuery = true)
    List<Project> getAllActiveProject();
}
