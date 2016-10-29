package com.dao;

import com.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 * @author roy.zhuo
 */

public interface EmployeeDao extends JpaRepository<Employee, Integer> {

    @Query("from Employee where name=?1")
    Employee findEmployee(String name);
}
