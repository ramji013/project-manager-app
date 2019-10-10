package com.project.manager.repository;

import com.project.manager.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public interface UserRepository extends JpaRepository<User, Long> {

    @Query(value = "select * from user where employee_id = :empId and is_active = 'Y'",nativeQuery = true)
    public User getUserByEmployeeId(@Param("empId") String empId);

    @Modifying
    @Query(value = "update user set is_active = 'N' where employee_id = :empId", nativeQuery = true)
    public void deleteEmployee(@Param("empId") String empId);

    @Query(value = "select * from user where is_active='Y'", nativeQuery = true)
    public List<User> getAllActiveUser();
}
