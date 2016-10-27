package com.dao;

import com.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.QueryHints;

import javax.persistence.QueryHint;
import java.util.List;

/**
 * @author roy.zhuo
 */
public interface DepartmentDao extends JpaRepository<Department, Integer> {

    @QueryHints({@QueryHint(name = org.hibernate.jpa.QueryHints.HINT_CACHEABLE, value = "true")})
    @Query(value = "from Department")
    List<Department> findAllDepartments();
}
