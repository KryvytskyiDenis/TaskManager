package com.krivitskiy.controllers;

import com.krivitskiy.model.Task;
import com.krivitskiy.model.User;

import com.krivitskiy.service.TaskService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

@Controller
@RequestMapping("/task-manager")
public class TaskController {

//    private UserService userService;
//
//    private SecurityService securityService;
//
//    private UserValidator userValidator;

    private final TaskService taskService;

//    @Autowired
//    public TaskController(UserService userService, SecurityService securityService, UserValidator userValidator, TaskService taskService) {
//        this.userService = userService;
//        this.securityService = securityService;
//        this.userValidator = userValidator;
//        this.taskService = taskService;
//    }

    @Autowired
    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping("/tasks")
    public String home(HttpServletRequest request) {
        request.setAttribute("tasks", taskService.findAll());
        request.setAttribute("mode", "MODE_TASKS");
        return "index";
    }

    @GetMapping("/new-task")
    public String newTask(HttpServletRequest request) {
        request.setAttribute("mode", "MODE_NEW");
        return "index";
    }

    @PostMapping("/save-task")
    public String saveTask(@ModelAttribute Task task, BindingResult bindingResult, HttpServletRequest request) {
        task.setDateCreated(new Date());
        taskService.add(task);
        System.out.println(task.getName() + " " + task.getDescription());
        request.setAttribute("tasks", taskService.findAll());
        request.setAttribute("mode", "MODE_TASKS");
        return "redirect:/task-manager/tasks";
    }

    @GetMapping("/edit-task")
    public String editTask(@RequestParam int id, HttpServletRequest request) {
        request.setAttribute("task", taskService.find(id));
        request.setAttribute("mode", "MODE_EDIT");
        return "index";
    }

    @GetMapping("/delete-task")
    public String deleteTask(@RequestParam int id, HttpServletRequest request) {
        taskService.delete(id);
        request.setAttribute("tasks", taskService.findAll());
        request.setAttribute("mode", "MODE_TASKS");
        return "index";
    }


//    @GetMapping("/registration")
//    public String registration(Model model) {
//        model.addAttribute("userForm", new User());
//
//        return "registration";
//    }
//
//    @PostMapping(value = "/registration")
//    public String registration(@ModelAttribute("userForm") User userForm, BindingResult bindingResult, Model model) {
//        userValidator.validate(userForm, bindingResult);
//
//        if (bindingResult.hasErrors()) {
//            return "registration";
//        }
//
//        userService.save(userForm);
//
//        securityService.autoLogin(userForm.getUsername(), userForm.getConfirmPassword());
//
//        return "redirect:/task-manager/tasks";
//    }
//
//    @GetMapping("/login")
//    public String login(Model model, String error, String logout) {
//        if (error != null) {
//            model.addAttribute("error", "Username or password are incorrect.");
//        }
//
//        if (logout != null) {
//            model.addAttribute("message", "Logged out successfully.");
//        }
//
//        return "login";
//    }
}
