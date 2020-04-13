package com.ay.controller;

import com.ay.dao.UserDao;
import com.ay.dto.MoodDTO;
import com.ay.model.Mood;
import com.ay.service.MoodService;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.Random;

/**
 * 说说控制层
 * @author xiangwehao
 * create 2020/4/8
 */
@Controller
@RequestMapping("/mood")
public class MoodController {
    @Resource
    private MoodService moodService;
//    @Resource
//    private MoodDTO moodDTO;
//    @Resource
//    private UserDao userDao;

    @GetMapping(value = "/{moodId}/praise")
    public String praise(Model model, @PathVariable(value="moodId") String moodId,
                                      @RequestParam(value="userId") String userId){
        System.out.println("here");
        System.out.println(moodId+"   "+userId);
        boolean isPraise = moodService.praisedMood(userId, moodId);
        List<MoodDTO> moodDTOList = moodService.findAll();
        model.addAttribute("moods",moodDTOList);
        model.addAttribute("isParise",isPraise);
        return "mood";
    }
    @RequestMapping("/findAll")
    public String findAll(Model model){
        List<MoodDTO> moodDTOList = moodService.findAll();
        System.out.println("length:"+moodDTOList.size());
        for(MoodDTO moodDTO:moodDTOList){
            System.out.println(moodDTO.getId()+"  " + moodDTO.getContent()+"  "+moodDTO.getPriseNum().toString());
        }
        model.addAttribute("moods",moodDTOList);
        return "mood";
    }

    @GetMapping(value = "/{moodId}/praiseForRedis")
    public String praiseForRedis(Model model,@PathVariable(value = "moodId") String moodId,
                                 @RequestParam(value = "userId") String userId){
//        Random random = new Random();
//        userId = random.nextInt(100) + "";
        boolean isPraise = moodService.praiseMoodForRedis(userId, moodId);
        List<MoodDTO> moodDTOList = moodService.findAllForRedis()  ;
        model.addAttribute("moods",moodDTOList);
        model.addAttribute("isPraise",isPraise);
//        System.out.println(moodDTOList.size());
        return "mood";
    }
}
