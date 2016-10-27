package com.dao;

import com.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author roy.zhuo
 */
@Repository
public interface EmployeeDao extends JpaRepository<Employee, Integer> {
}
