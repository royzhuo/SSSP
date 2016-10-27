package com.controller;

import com.entity.Employee;
import com.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

/**
 * @author roy.zhuo
 */
@Controller
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @RequestMapping(value = "/emps", method = RequestMethod.GET)
    public String findAllEmployees(@RequestParam(value = "pageNo", defaultValue = "1", required = false) String pageNo, Map<String, Page<Employee>> employeeMap) {

        Integer pageN = null;
        Page<Employee> page = null;
        try {
            pageN = Integer.parseInt(pageNo);
            if (pageN < 1) {
                pageN = 1;
            }
            page = employeeService.findEmps(pageN - 1, 5);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        employeeMap.put("page", page);


        return "list";
    }
}
