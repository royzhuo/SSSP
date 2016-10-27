package com.service;

import com.dao.EmployeeDao;
import com.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

/**
 * @author roy.zhuo
 */

@Service
public class EmployeeService {

    @Autowired
    private EmployeeDao employeeDao;

    //获取所有员工
    public Page<Employee> findEmps(Integer pageNo, Integer pageSize) {
        Page<Employee> employeePage = null;
        Sort.Order order = new Sort.Order(Sort.Direction.DESC, "id");
        Sort sort = new Sort(order);
        PageRequest pageRequest = new PageRequest(pageNo, pageSize, sort);
        employeePage = employeeDao.findAll(pageRequest);
        return employeePage;

    }
}
