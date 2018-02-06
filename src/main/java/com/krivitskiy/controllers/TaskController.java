package com.krivitskiy.controllers;

import com.krivitskiy.model.Task;


import com.krivitskiy.model.User;
import com.krivitskiy.service.SecurityService;
import com.krivitskiy.service.TaskService;

import com.krivitskiy.service.UserService;

import com.krivitskiy.validator.UserValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;

@Controller
@RequestMapping("/task-manager")
public class TaskController {

    private UserService userService;

    private SecurityService securityService;

    private UserValidator userValidator;

    private final TaskService taskService;

    @Autowired
    public TaskController(UserService userService, SecurityService securityService, UserValidator userValidator, TaskService taskService) {
        this.userService = userService;
        this.securityService = securityService;
        this.userValidator = userValidator;
        this.taskService = taskService;
    }

    @GetMapping("/tasks")
    public String home(HttpServletRequest request) {
        String username = securityService.findLoggedInUsername();
        User user = userService.findByName(username);
        request.setAttribute("username",user.getUsername());
        request.setAttribute("tasks", taskService.findAllByUserId(user.getId()));
        request.setAttribute("mode", "MODE_TASKS");
        return "index";
    }

    @GetMapping("/new-task")
    public String newTask(HttpServletRequest request) {
        request.setAttribute("mode", "MODE_NEW");
        return "index";
    }

    @PostMapping("/save-task")
    public String saveTask(@ModelAttribute Task task, BindingResult bindingResult) {
        String username = securityService.findLoggedInUsername();
        User user = userService.findByName(username);
        task.setUser(user);
        task.setDateCreated(new Date());
        taskService.add(task);
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
        return "redirect:/task-manager/tasks";
    }


    @GetMapping("/registration")
    public String registration(Model model) {
        model.addAttribute("userForm", new User());

        return "registration";
    }

    @PostMapping(value = "/registration")
    public String registration(@ModelAttribute("userForm") User userForm, BindingResult bindingResult, Model model) {
        userValidator.validate(userForm, bindingResult);

        if (bindingResult.hasErrors()) {
            return "registration";
        }

        userService.save(userForm);

        securityService.autoLogin(userForm.getUsername(), userForm.getConfirmPassword());

        return "redirect:/task-manager/tasks";
    }

    @GetMapping({"/","/login"})
    public String login(Model model, String error, String logout) {
        if (error != null) {
            model.addAttribute("error", "Username or password are incorrect.");
        }

        if (logout != null) {
            model.addAttribute("message", "Logged out successfully.");
        }

        return "login";
    }

    @GetMapping("/logout")
    public String logoutPage (HttpServletRequest request, HttpServletResponse response) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null){
            new SecurityContextLogoutHandler().logout(request, response, auth);
        }
        return "redirect:/task-manager/login?logout";
    }
}
