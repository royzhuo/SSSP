package com.controller;

import com.entity.Employee;
import com.service.DepartmentService;
import com.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;
import java.util.Map;

/**
 * @author roy.zhuo
 */
@Controller
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;
    @Autowired
    private DepartmentService departmentService;

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

    @RequestMapping("/inputEmployee")
    public String findAllDepartments(Map<String, Object> map, Employee employee) {
        map.put("employee", employee);
        map.put("dept", departmentService.findAllDepartments());
        return "/inputEmployee";
    }

    @RequestMapping(value = "/valiateEmployeeName", method = RequestMethod.POST)
    @ResponseBody
    public String validateName(@RequestParam(name = "name", required = true) String name) {
        String status = "0";
        System.out.println("name" + name);
        Employee employee = employeeService.findEmployee(name);
        if (employee == null || employee.getName() == null) status = status;
        else if (employee != null || employee.getName() != null) status = "1";
        else status = "3";
        System.out.println("status:" + status);
        return status;
    }

    @RequestMapping(value = "/testJson", method = RequestMethod.POST)
    @ResponseBody
    public String testJson() {
        String value = "aa";
        return value;
    }

    @RequestMapping(value = "/emp", method = RequestMethod.POST)
    public String addEmployee(Employee employee) {
        employee.setCreateTime(new Date());
        employeeService.addEmployee(employee);
        return "redirect:/emps";
    }

    /*@ModelAttribute("emp")
    public Employee put(Map<String, Employee> map) {
        System.out.println("ModelAttribute");
       *//* Employee employee = new Employee();
        map.put("emp", employee);*//*
        return new Employee();
    }*/

}
