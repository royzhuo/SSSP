package com.service;

import com.dao.DepartmentDao;
import com.entity.Department;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author roy.zhuo
 */
@Service
public class DepartmentService {

    @Autowired
    DepartmentDao departmentDao;

    @Transactional
    public List<Department> findAllDepartments() {
        return departmentDao.findAllDepartments();
    }


}
