package com.ay.controller;

import com.ay.model.AyUser;
import com.ay.service.AyUserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;


@Controller
@RequestMapping("/user")
public class AyTestController {

    @RequestMapping("/hello")
    public String ak(){
        return "hello";

    }
   // @ResponseBody
//    public List<String> hello(){
//        List<String> list = new ArrayList<>();
//        list.add("xiangwenhao");
//        list.add("向文浩");
//        return list;
//    }
//    @ModelAttribute("name")
//    public AyUser init(@RequestParam("id") Integer id,
//                       @RequestParam("name")String name){
//        AyUser ayUser = new AyUser();
//        ayUser.setId(id);
//        ayUser.setName(name);
//        return ayUser;
//    }
//    @RequestMapping("/hello")
//    public String hello(@ModelAttribute("ayUser2") AyUser ayUser){
//        return "hello";
//    }



//    @ModelAttribute
//    public void init(Model model){
//         AyUser ayUser = new AyUser();
//         ayUser.setName("abcd");
//         ayUser.setId(1);
//         ayUser.setPassword("da");
//         model.addAttribute("user",ayUser);
//    }
//    @ModelAttribute
//    public void intit(){
//        System.out.println("111111111111");
//    }
//    @GetMapping("/hello")
//    public String hello(){
//        return "hello";
//    }
}
