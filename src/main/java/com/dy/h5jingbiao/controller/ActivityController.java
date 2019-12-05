package com.dy.h5jingbiao.controller;

import com.dy.h5jingbiao.entity.Activity;
import com.dy.h5jingbiao.entity.RelActivityAndOrganize;
import com.dy.h5jingbiao.service.ActivityService;
import com.dy.h5jingbiao.service.OrganizeService;
import com.dy.h5jingbiao.service.RelActivityAndOrganizeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashMap;
import java.util.Map;

/**
 * 活动controller
 */
@Controller
@RequestMapping("/activity")
public class ActivityController {

    @Autowired
    private ActivityService activityService;

    @Autowired
    private OrganizeService organizeService;

    @Autowired
    private RelActivityAndOrganizeService relActivityAndOrganizeService;

    /**
     * 活动列表页面
     * @param model
     * @return
     */
    @RequestMapping("/allActivity")
    public String allActivity(Model model){
        model.addAttribute("activityList", activityService.selectActivityList());
        return "index";
    }

    /**
     * 跳转到添加活动页面
     * @param model
     * @return
     */
    @RequestMapping("/toAdd")
    public String toAddActivity(Model model){
        model.addAttribute("organizes", organizeService.selectOrganizeList());
        return "addActivity";
    }

    /**
     * 添加活动功能
     * @param activity 活动
     * @param organizeIds 支行ids
     * @return
     */
    @RequestMapping("/addActivity")
    public String addActivity(Activity activity, Integer[] organizeIds){
        activityService.insertActivity(activity, organizeIds);
        return "redirect:/activity/allActivity";
    }

    /**
     * 跳转到发布活动页面
     * @param model
     * @param activityId 活动id
     * @return
     */
    @RequestMapping("/toPublish")
    public String toPublishActivity(Model model, String activityId){
        model.addAttribute("activity", activityService.getActivityDetail(activityId));
        model.addAttribute("orgs",organizeService.selectOrganizeList());
        return "publishActivity";
    }

    /**
     * 跳转到修改活动页面
     * @param model
     * @param activityId 活动id
     * @return
     */
    @RequestMapping("/toUpdate")
    public String toUpdateActivity(Model model, String activityId){
        model.addAttribute("activity", activityService.getActivityDetail(activityId));
        model.addAttribute("organizes",organizeService.selectOrganizeList());
        return "updateActivity";
    }

    /**
     * 修改活动信息
     * @param activity 活动
     * @param organizeIds 支行ids
     * @return
     */
    @RequestMapping("/updateActivity")
    public String updateActivity(Activity activity, Integer[] organizeIds){
        activityService.updateActivity(activity, organizeIds);
        return "redirect:/activity/allActivity";
    }

    /**
     * 删除活动信息
     * @param activityId 活动id
     * @return
     */
    @RequestMapping("/delete")
    public String deleteActivity(String activityId){
        activityService.deleteActivityById(activityId);
        return "redirect:/activity/allActivity";
    }
}
