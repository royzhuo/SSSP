package com.controller;

import com.entity.Department;
import com.entity.Employee;
import com.service.DepartmentService;
import com.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
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
    public Map<String, Object> testJson() {
        String value = "aa";
        Map<String, Object> maps = new HashMap<String, Object>();
        maps.put("name", "roy");
        maps.put("value", value);
        return maps;
    }

    @RequestMapping(value = "/testJson1", method = RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> testJson2() {
        String value = "aa";
        Map<String, Object> maps = new HashMap<String, Object>();
        maps.put("name", "roy");
        maps.put("value", value);
        return maps;
    }


    @RequestMapping(value = "/emp", method = RequestMethod.POST)
    public String addEmployee(Employee employee) {
        employee.setCreateTime(new Date());
        employeeService.addEmployee(employee);
        return "redirect:/emps";
    }

    @ModelAttribute()
    public void put(Map<String, Object> map, @RequestParam(value = "id", required = false) Integer id) {
        System.out.println("ModelAttribute");
        if (id != null) {
            Employee employee = employeeService.findEmployeeById(id);
            employee.setDept(null);
            map.put("employee", employee);

        }


    }

    @RequestMapping(value = "/emp/{id}", method = RequestMethod.GET)
    public String findEmployee(@PathVariable("id") Integer id, Map<String, Object> map) {
        Employee employee = employeeService.findEmployeeById(id);
        List<Department> departments = departmentService.findAllDepartments();
        map.put("employee", employee);
        map.put("dept", departments);
        return "/inputEmployee";
    }

    @RequestMapping(value = "/emp/{id}", method = RequestMethod.PUT)
    public String updateEmployee(@PathVariable("id") Integer id, Employee employee) {
        //if (id!=null||employee.getId()!=null)
        employeeService.updateEmp(employee);
        return "redirect:/emps";
    }

    @RequestMapping(value = "emp/{id}", method = RequestMethod.DELETE)
    public String deleteEmployee(@PathVariable("id") Integer id) {
        employeeService.deleteEmployee(id);
        return "redirect:/emps";
    }


    @RequestMapping(value = "/emp/find", method = RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> findEmployeeById(@RequestParam(value = "id", required = false) Integer id, Map<String, Object> map) {
        Employee employee = employeeService.findEmployeeById(id);
        map.put("emp", employee);
        map.put("aa", "aaa");
        return map;
    }

    @RequestMapping(value = "/testEmp", method = RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> testEmp(@RequestParam(value = "id") Integer id) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("name", "roy");
        Employee employee = employeeService.findEmployeeById(id);
        map.put("emp", employee);
        return map;

    }

    @RequestMapping(value = "/testEmpList", method = RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> testFindAllEmps() {
        Map<String, Object> map = new HashMap<String, Object>();
        List<Employee> employees = new ArrayList<Employee>();
        Employee employee = new Employee();
        employee.setId(1);
        employee.setName("roy");
        employee.setBirthDay(new Date());
        employee.setCreateTime(new Date());
        Employee employee2 = new Employee();
        employee2.setId(2);
        employee2.setName("alan");
        employee2.setBirthDay(new Date());
        employee2.setCreateTime(new Date());

        employees.add(employee);
        employees.add(employee2);
        map.put("emps", employees);
        return map;


    }

}
