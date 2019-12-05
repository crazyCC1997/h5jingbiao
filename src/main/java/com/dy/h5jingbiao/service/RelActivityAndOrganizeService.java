package com.dy.h5jingbiao.service;

import com.dy.h5jingbiao.entity.RelActivityAndOrganize;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public interface RelActivityAndOrganizeService {

    /* 插入参与活动对应的支行 */
    int insertOrganizeDetail(RelActivityAndOrganize relActivityAndOrganize);

    /*删除参与活动的对应支行*/
    int deleteByMap(Map<String, Object> organizeDetailMap);
}
