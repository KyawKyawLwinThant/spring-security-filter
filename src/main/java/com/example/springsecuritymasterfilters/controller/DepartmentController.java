package com.example.springsecuritymasterfilters.controller;

import com.example.springsecuritymasterfilters.dao.DepartmentDao;
import com.example.springsecuritymasterfilters.entity.Department;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller

@RequiredArgsConstructor
public class DepartmentController {
    private final DepartmentDao departmentDao;
    @GetMapping("/department/list-departments")
    public String listDepartment(Model model){
        model.addAttribute("departments",
                departmentDao.findAll());
        return "departments";
    }
    @GetMapping("/department/create-department")
    public String createDepartment(Model model){
        model.addAttribute("department",new Department());
        return "departmentForm";
    }
    @PostMapping("/department/save-department")
    public String saveDepartment(@Valid Department department,
                                 BindingResult result){
        if(result.hasErrors()){
            return  "departmentForm";
        }
        departmentDao.save(department);
        return "redirect:/department/list-departments";
    }
    @GetMapping("/department/delete")
    public String deleteDepartment(@RequestParam("id")int id){
        departmentDao.deleteById(id);
        return "redirect:/department/list-departments";
    }

}
