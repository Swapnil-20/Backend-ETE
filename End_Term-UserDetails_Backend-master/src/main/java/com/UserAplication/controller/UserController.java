package com.UserAplication.controller;

import com.UserAplication.model.UserDetails;
import com.UserAplication.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;
import java.util.Optional;

@Controller
public class UserController {

    @Autowired
    UserService userService;

    @RequestMapping("/")
    public String index(Model model){
        model.addAttribute("user",new UserDetails());
        return "index";
    }

    @RequestMapping(method = RequestMethod.POST, value = "/save")
    public String saveUser(UserDetails user){
        userService.addUser(user);
        return "redirect:/show";
    }

    @RequestMapping("/show")
    public String showData(Model model){
        List<UserDetails> list = userService.getAllUsers();
        model.addAttribute("list", list);
        return "showdata";
    }

    @RequestMapping("/update/{id}")
    public String update(@PathVariable("id") Integer id, Model model) {
        Optional<UserDetails> user = userService.getUserByID(id);
        UserDetails data = user.get();
        model.addAttribute("data", data);
        return "update";
    }

    @RequestMapping("delete/{id}")
    public String delete(@PathVariable("id") Integer id) {
        userService.deleteUser(id);
        return "redirect:/show";
    }

    @RequestMapping( "/find")
    public String find(@Param("keyword") String keyword, Model model){
        List<UserDetails> u = userService.findByUserName(keyword);
        model.addAttribute("u",u);
        return "showdata";
    }

}
