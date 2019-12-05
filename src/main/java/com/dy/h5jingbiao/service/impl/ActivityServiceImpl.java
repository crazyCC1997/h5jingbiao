package com.dy.h5jingbiao.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.dy.h5jingbiao.entity.Activity;
import com.dy.h5jingbiao.entity.RelActivityAndOrganize;
import com.dy.h5jingbiao.mapper.ActivityMapper;
import com.dy.h5jingbiao.mapper.RelActivityAndOrganizeMapper;
import com.dy.h5jingbiao.service.ActivityService;
import com.dy.h5jingbiao.service.RelActivityAndOrganizeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ActivityServiceImpl implements ActivityService {

    @Autowired
    private ActivityMapper activityMapper;

    @Autowired
    private RelActivityAndOrganizeMapper relActivityAndOrganizeMapper;

    @Override
    public List<Activity> selectActivityList() {
        return activityMapper.selectList(new QueryWrapper<Activity>());
    }

    @Override
    public Activity selectActivityById(String activityId) {
        return activityMapper.selectById(activityId);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public int insertActivity(Activity activity, Integer[] organizeIds) {
        int insert = activityMapper.insert(activity);
        //将参与该活动的对应支行信息存入关联表
        for (int i = 0; i < organizeIds.length; i++) {
            RelActivityAndOrganize relActivityAndOrganize = new RelActivityAndOrganize();
            relActivityAndOrganize.setaId(activity.getActivityId());
            relActivityAndOrganize.setoId(organizeIds[i]);
            relActivityAndOrganizeMapper.insert(relActivityAndOrganize);
        }
        return insert;
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public int updateActivity(Activity activity, Integer[] organizeIds) {
        Map<String, Object> map = new HashMap<>();
        map.put("a_id", activity.getActivityId());
        //删除参与该活动的对应支行信息
        relActivityAndOrganizeMapper.deleteByMap(map);
        //将修改后该活动对应的支行信息存入关联表
        for (int i = 0; i < organizeIds.length; i++) {
            RelActivityAndOrganize relActivityAndOrganize = new RelActivityAndOrganize();
            relActivityAndOrganize.setaId(activity.getActivityId());
            relActivityAndOrganize.setoId(organizeIds[i]);
            relActivityAndOrganizeMapper.insert(relActivityAndOrganize);
        }
        return activityMapper.updateById(activity);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public int deleteActivityById(String activityId) {
        Map<String, Object> map = new HashMap<>();
        map.put("a_id", activityId);
        //删除活动对应的关联表中的信息
        relActivityAndOrganizeMapper.deleteByMap(map);
        return activityMapper.deleteById(activityId);
    }

    @Override
    public Activity getActivityDetail(String activityId) {
        return activityMapper.getActivityDetail(activityId);
    }


}
