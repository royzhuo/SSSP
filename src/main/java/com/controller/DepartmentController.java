package com.controller;

import com.entity.Department;
import com.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Map;

/**
 * @author roy.zhuo
 */
@Controller
public class DepartmentController {
    @Autowired
    DepartmentService departmentService;


}
