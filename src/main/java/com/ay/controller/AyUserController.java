package com.ay.controller;

import com.ay.model.AyUser;
import com.ay.service.AyUserService;
import com.ay.validator.AyUserValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.List;
/**
 * @author xiangwehao
 * create 2020/3/28
 */
@Controller
@RequestMapping(value = "/user")
public class AyUserController {
//    double
//    @Resource
//    private AyUserService ayUserService;
//    @RequestMapping("/save")
//    public String save(){
//        return "saveUser";
//    }
//    @PostMapping  ("/insert")
//    public String insert(@Valid AyUser ayUser, Model model, BindingResult result){
//        if(result.hasErrors()){
//            model.addAttribute("errors",result);
//            System.out.println("errors");
//            return "cnm";
//        }
//        int count = ayUserService.insert(ayUser);
//        System.out.println("ok");
//        return "hello";
//    }
//    @PostMapping("/insert")
//    public String insert(@ModelAttribute AyUser ayUser,Model model, Errors errors){
//        ayUserValidator.validate(ayUser, errors);
//        if(errors.hasErrors()){
//            model.addAttribute("errors", errors);
//            return "error";
//        }
//        int count = ayUserService.insert(ayUser);
//        return "hello";
//    }
    @Resource
    private AyUserService ayUserService;
    @GetMapping("/findAll")
    public String findAll(Model model){
        List<AyUser> ayUserList = ayUserService.findAll();
        for(AyUser ayUser : ayUserList){
            System.out.println("id: " + ayUser.getId());
            System.out.println("name: " + ayUser.getName());
            System.out.println("password：" + ayUser.getPassword());
        }
        model.addAttribute("users",ayUserList);
        return "cnm";
    }


}