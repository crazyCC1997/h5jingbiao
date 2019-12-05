package com.dy.h5jingbiao.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.dy.h5jingbiao.entity.Activity;
import org.apache.ibatis.annotations.Mapper;


@Mapper
public interface ActivityMapper extends BaseMapper<Activity> {

    Activity getActivityDetail(String activityId);
}