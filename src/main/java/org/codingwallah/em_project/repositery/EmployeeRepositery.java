package org.codingwallah.em_project.repositery;

import org.codingwallah.em_project.entity.EmployeeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepositery extends JpaRepository<EmployeeEntity, Long> {
    // custom method
    // List<EmployeeEntity> findByName(String name);
    // save, delete, findById, findAll

}
