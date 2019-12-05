package com.dy.h5jingbiao.service;

import com.dy.h5jingbiao.entity.Activity;
import com.dy.h5jingbiao.entity.Organize;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ActivityService {

    /*查询活动列表*/
    List<Activity> selectActivityList();

    /*根据id查询活动信息*/
    Activity selectActivityById(String activityId);

    /*添加活动*/
    int insertActivity(Activity activity, Integer[] organizeIds);

    /*修改活动信息*/
    int updateActivity(@Param("activity") Activity activity, Integer[] organizeIds);

    /*删除活动*/
    int deleteActivityById(String activityId);

    /*通过返回一个activity对象，获取参与竞标的支行*/
    Activity getActivityDetail(String activityId);
}
